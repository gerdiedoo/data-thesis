// Sondierungssequenz gemäß doppelter Streuung.
class DoubleHashing extends AbstractHashSequence {
  // Zweite Streuwertfunktion.
  private final HashFunction func2;
  private Object key;
  //"Index" in der Hash Sequence
  private int j;
  
  // Doppelte Streuung mit Streuwertfunktionen f1 und f2.
  public DoubleHashing(HashFunction f1, HashFunction f2) {
    super(f1);
    func2 = f2;
  }
  
  @Override
  public int first(Object key) {
    j = 0;
    this.key = key;
    return func.compute(key);
  }
  
  @Override
  public int next() {
    return (func.compute(key) + ++j * func2.compute(key)) % size();
  }
}