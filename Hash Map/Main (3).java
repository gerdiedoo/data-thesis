public class Main {
    public static void main(String[] args) {
        ChainHashMap chainHashMap = new ChainHashMap(10000);
        ChainHashMap chainHashMap2 = new ChainHashMap(100);

        for (int i = 0; i < 1000000; i += 2) {
            String[] pares = { "a" + i, "" + (i + 1) };
            chainHashMap.put(pares[0], pares[1]);
        }

        for (int i = 0; i < 1000000; i += 2) {
            String[] pares = { "b" + i, "" + (i + 1) };
            chainHashMap2.put(pares[0], pares[1]);
        }

        System.out.println(chainHashMap.getLoadFactor());
        System.out.println(chainHashMap2.getLoadFactor());

        System.out.println(chainHashMap.get("a999998"));
        System.out.println(chainHashMap2.get("b999998"));
    }
}
