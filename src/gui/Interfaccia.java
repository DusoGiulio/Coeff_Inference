package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Interfaccia extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<File> fileList;
    private JTextArea outputTextArea;

    public Interfaccia() {
        fileList = new ArrayList<>();

        // Impostazioni del frame
        setTitle("Analisi coeffetti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Pannello principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Lista dei file
        DefaultListModel<File> listModel = new DefaultListModel<>();
        JList<File> fileListUI = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(fileListUI);

        // Pulsante per aggiungere file
        JButton addButton = new JButton("Aggiungi File");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);

                // Aggiungi un filtro per permettere solo file con estensione .txt o .java
                FileNameExtensionFilter filter = new FileNameExtensionFilter("File di testo e file Java", "txt", "java");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(Interfaccia.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                    for (File file : selectedFiles) {
                        listModel.addElement(file);
                        fileList.add(file);
                    }
                }
            }
        });

        // Pulsante per salvare la lista di file
        JButton saveButton = new JButton("Avvia Analisi");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aggiungi gli output alla JTextArea
                for (File file : fileList) {
                    outputTextArea.append(file.getAbsolutePath() + "\n");
                }
            }
        });

        // Area di testo per visualizzare gli output
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        // Aggiungi componenti al pannello principale
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(addButton, BorderLayout.NORTH);
        mainPanel.add(saveButton, BorderLayout.SOUTH);

        // Aggiungi il pannello principale al frame
        add(mainPanel, BorderLayout.NORTH);
        add(outputScrollPane, BorderLayout.CENTER);

        // Rendi il frame visibile
        setVisible(true);

        // Reindirizza System.out.println all'area di testo
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputTextArea));
        System.setOut(printStream);
    }

}

class CustomOutputStream extends OutputStream {
    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
