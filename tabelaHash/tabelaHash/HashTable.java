import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class HashTable {
    protected List<LinkedList<String>> table;
    protected int size;
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.collisions = 0;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    protected abstract int hashFunction(String key);

    public void insert(String key) {
        int index = hashFunction(key);
        LinkedList<String> list = table.get(index);

        if (!list.isEmpty()) {
            collisions++;
        }
        list.add(key);
    }

    // Método de busca
    public boolean search(String key) {
        int index = hashFunction(key);
        LinkedList<String> list = table.get(index);
        return list.contains(key);
    }

    public int getCollisions() {
        return collisions;
    }

    public void printTable() {
        for (int i = 0; i < table.size(); i++) {
            System.out.println("Posição " + i + ": " + table.get(i).size() + " chave(s)");
        }
    }

    public void generateReport(long insertTime, long searchTime) {
        System.out.println("*** Relatório da Tabela Hash ***");
        System.out.println("Número de colisões: " + getCollisions());
        System.out.println("Tempo total de inserção: " + insertTime + " ms");
        System.out.println("Tempo total de busca: " + searchTime + " ms");
        System.out.println("Distribuição das chaves:");
        printTable();
    }
}
