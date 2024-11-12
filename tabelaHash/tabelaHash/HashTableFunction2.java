public class HashTableFunction2 extends HashTable {
    public HashTableFunction2(int size) {
        super(size);
    }

    @Override
    protected int hashFunction(String key) {
        int hash = 0;
        int primeMultiplier = 31;

        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i) * primeMultiplier;
            primeMultiplier *= 31;
        }

        return Math.abs(hash % size);
    }
}