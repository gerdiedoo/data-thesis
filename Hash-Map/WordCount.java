import java.util.Random;

class WordCount {
  public static void main(String[] args) throws java.io.IOException {
    java.io.BufferedReader r = new java.io.BufferedReader(
            new java.io.InputStreamReader(System.in));
    args = r.readLine().split(" ");
    int Np = Integer.parseInt(args[2]);
    
    HashFunction f;
    switch (args[1]) {
      case "d":
        f = new DivisionMethod(Np);
        break;
      case "m":
        int s = Integer.parseInt(args[3]);
        f = new MultiplicationMethod(Np, s);
        break;
      default:
        return;
    }
    
    HashTable tab;
    if (args[0].equals("c")) {
      tab = new HashTableChaining(f);
    }else {
      HashSequence s;
      switch (args[0]) {
        case "l":
          s = new LinearProbing(f);
          break;
        case "q":
          s = new QuadraticProbing(f);
          break;
        case "d":
          class HashFunction2 extends AbstractHashFunction {
            public HashFunction2(int N) {
              super(N);
            }
            
            public int compute(Object key) {
              int h = Math.abs(key.hashCode()) % (size - 1);
              if (h % 2 == 0) h++;
              return h;
            }
          }
          s = new DoubleHashing(f, new HashFunction2(f.size()));
          break;
        default:
          return;
      }
      tab = new HashTableOpenAddressing(s);
    }
    
    // Standardeingabestrom System.in als InputStreamReader
    // und diesen wiederum als BufferedReader "verpacken",
    // damit man bequem zeilenweise lesen kann.
    
    // Standardeingabe zeilenweise lesen
    // (Annahme: ein Wort pro Zeile).
    // (readLine kann java.io.IOException werfen.)
    int currentDataType = 0;
    while (true) {
      String word = r.readLine();
      
      if (word == null) break;
      String[] input = word.split(" ");
      switch (input[0]) {
        case "add":
          if (currentDataType == 0)
            tab.put(input[1], input[2]);
          if (currentDataType == 1)
            tab.put(Integer.parseInt(input[1]), input[2]);
          if (currentDataType == 2)
            tab.put(Float.parseFloat(input[1]), input[2]);
          if (currentDataType == 3)
            tab.put(new TestClass(Integer.parseInt(input[1]), Integer.parseInt(input[2])), input[3]);
          break;
        case "get":
          String out = "";
          if (currentDataType == 0)
            System.out.println(tab.get(input[1]));
          if (currentDataType == 1)
            System.out.println(tab.get(Integer.parseInt(input[1])));
          if (currentDataType == 2)
            System.out.println(tab.get(Float.parseFloat(input[1])));
          if (currentDataType == 3)
            System.out.println(tab.get(new TestClass(Integer.parseInt(input[1]), Integer.parseInt(input[2]))));
          break;
        case "remove":
          if (currentDataType == 0)
            tab.remove(input[1]);
          if (currentDataType == 1)
            tab.remove(Integer.parseInt(input[1]));
          if (currentDataType == 2)
            tab.remove(Float.parseFloat(input[1]));
          if (currentDataType == 3)
            tab.remove(new TestClass(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
          break;
        case "dump":
          tab.dump();
          break;
        case "int":
          currentDataType = 1;
          break;
        case "String":
          currentDataType = 0;
          break;
        case "float":
          currentDataType = 2;
          break;
        case "Object":
          currentDataType = 3;
          break;
        default:
          return;
      }
    }
  }
}
  
  class TestClass {
    
    private int x;
    private int y;
    
    public TestClass(int x, int y) {
      Random r = new Random();
      this.x = x;
      this.y = y;
    }
    
    public void setX(int x) {
      this.x = x;
    }
    
    public void setY(int y) {
      this.y = y;
    }
    
    public int add() {
      return x + y;
    }
  
    @Override
    public int hashCode() {
      return x + y;
    }
  
    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof TestClass))
        return false;
      if (((TestClass) obj).add() == this.add())
        return true;
      return false;
    }
    
    @Override
    public String toString() {
      return "x + y = " + x + y;
    }
  }

