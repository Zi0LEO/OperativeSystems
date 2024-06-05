package Esercitazione03.Seminario;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final int threadToCreate = Runtime.getRuntime().availableProcessors();
        final int numberOfValuesForThread = (Integer.MAX_VALUE) / threadToCreate;
        final int extraValuesToAssign = (Integer.MAX_VALUE) % threadToCreate;

        File inputFile = new File("./src/Esercitazione03/Seminario/document2024_A.encrypted");
        File outputFile = new File("./src/Esercitazione03/Seminario/solution.txt");

        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile))){
            BruteForceDecrypter.inputBytes = inputStream.readAllBytes();
        } catch (Exception ignored){}

        Thread[] threadArray = startThreads(threadToCreate, extraValuesToAssign, numberOfValuesForThread);

        for (Thread thread : threadArray) {
            try {
                thread.join();
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }

        long end = System.currentTimeMillis();
        int seconds = (int) (end - start) / 1000;
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile))){
            os.write(BruteForceDecrypter.solution);
            os.write(System.lineSeparator().getBytes());
            os.write("La chiave corretta è: ".getBytes());
            os.write(BruteForceDecrypter.rightKey);
            os.write(System.lineSeparator().getBytes());
            os.write(("Tempo impiegato: " + seconds / 60 + " minuti e " + seconds % 60 + " secondi").getBytes());

        }catch(Exception e){
            System.out.println("Something went wrong again");
        }
    }

    private static Thread[] startThreads(int threadToCreate, int extraValuesToAssign, int numberOfValuesForThread) {
        int index = 0;
        Thread[] threadArray = new Thread[threadToCreate];
        int timesAdded = 0;
        while(index < threadToCreate){
            int threadStartingPoint = (numberOfValuesForThread * index) + timesAdded;
            int toAdd = 0;
            if(extraValuesToAssign > 0) {
                extraValuesToAssign--;
                toAdd = 1;
                timesAdded++;
            }
            int threadEndingPoint = threadStartingPoint + numberOfValuesForThread + toAdd;

            BruteForceDecrypter bfd = new BruteForceDecrypter(threadStartingPoint, threadEndingPoint);
            threadArray[index] = new Thread(bfd);
            threadArray[index].start();
            index++;
        }
        return threadArray;
    }
}