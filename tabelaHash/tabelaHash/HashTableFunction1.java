public class HashTableFunction1 extends HashTable {
    public HashTableFunction1(int size) {
        super(size);
    }

    @Override
    protected int hashFunction(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return hash % size;
    }
}
