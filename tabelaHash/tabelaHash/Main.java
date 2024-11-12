import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int size = 970;

        HashTable hashTable1 = new HashTableFunction1(size);
        HashTable hashTable2 = new HashTableFunction2(size);

        //  tempo de inserção para a Função Hash 1
        long startInsertTime1 = System.currentTimeMillis();
        File file = new File(System.getProperty("user.dir") + File.separator + "tabelaHash" + File.separator + "female_names.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashTable1.insert(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endInsertTime1 = System.currentTimeMillis();
        long insertTime1 = endInsertTime1 - startInsertTime1;

        //tempo de inserção para a Função Hash 2
        long startInsertTime2 = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashTable2.insert(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endInsertTime2 = System.currentTimeMillis();
        long insertTime2 = endInsertTime2 - startInsertTime2;

        // medindo o tempo de busca para a Função Hash 1
        long startSearchTime1 = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashTable1.search(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endSearchTime1 = System.currentTimeMillis();
        long searchTime1 = endSearchTime1 - startSearchTime1;

        // medindo o tempo de busca para a Função Hash 2
        long startSearchTime2 = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashTable2.search(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endSearchTime2 = System.currentTimeMillis();
        long searchTime2 = endSearchTime2 - startSearchTime2;

       // Relatório Comparativo
        System.out.println("---> Relatório Comparativo <---");
        System.out.printf("%-35s %-35s\n", "==== Função Hash 1 ====", "==== Função Hash 2 ====");
        System.out.printf("%-35s %-35s\n", "*** Relatório da Tabela Hash ***", "*** Relatório da Tabela Hash ***");
        System.out.printf("Número de colisões: %-17d Número de colisões: %d\n", hashTable1.getCollisions(), hashTable2.getCollisions());
        System.out.printf("Tempo total de inserção: %-10d ms Tempo total de inserção: %d ms\n", insertTime1, insertTime2);
        System.out.printf("Tempo total de busca: %-13d ms Tempo total de busca: %d ms\n", searchTime1, searchTime2);

        System.out.println("\nDistribuição das chaves:");
        System.out.printf("%-15s %-15s %-15s\n", "Posição", "Hash 1", "Hash 2");

        for (int i = 0; i < size; i++) {
            System.out.printf("Posição %-5d %-15s %-15s\n", i, hashTable1.table.get(i).size() + " chave(s)", hashTable2.table.get(i).size() + " chave(s)");
        }

    }
}
