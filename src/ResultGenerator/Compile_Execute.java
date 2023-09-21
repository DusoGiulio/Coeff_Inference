package ResultGenerator;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Classe per la compilazione ed esecuzione del codice sorgente MiniJava risultante.
 */
public class Compile_Execute {

    /**
     * Costruttore della classe.
     *
     * @param codiceSorgente   Il codice sorgente MiniJava da scrivere nel file.
     * @param percorsoCompleto Il percorso completo del file in cui scrivere il codice sorgente.
     * @param sep              Il separatore di sistema.
     */
    public Compile_Execute(String codiceSorgente, String percorsoCompleto, String sep) {
        // Creazione del file e scrittura del codice
        try (PrintWriter writer = new PrintWriter(new FileWriter(percorsoCompleto))) {
            writer.println(codiceSorgente);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Compilazione ed esecuzione del file creato
        try {
            Process processoCompilazione = Runtime.getRuntime().exec("javac " + percorsoCompleto);
            int exitCode = processoCompilazione.waitFor();
            if (exitCode != 0) {
                System.out.println("Compilazione fallita.");
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(processoCompilazione.getErrorStream()));
                String str;
                while ((str = errorReader.readLine()) != null) {
                    System.err.println(str);
                }
            }
            
            Process processoEsecuzione = Runtime.getRuntime().exec("java -cp " + "src" + sep + " ResultGenerator.CoeffectResult");
            exitCode = processoEsecuzione.waitFor();
            if (exitCode == 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(processoEsecuzione.getInputStream()));
                String st;
                while ((st = reader.readLine()) != null) {
                    System.out.println(st);
                }
            } else {
                System.out.println("Esecuzione fallita.");
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(processoEsecuzione.getErrorStream()));
                String s;
                while ((s = errorReader.readLine()) != null) {
                    System.err.println(s);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

