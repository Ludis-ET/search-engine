package gui;

import engine.localdb.FileHandler;
import engine.localdb.Indexer;
import java.awt.*;
import java.io.File;
import java.util.List;
import javax.swing.*;

public class SearchEngineUI {
    private static final String DB_PATH = "db";

    public static void launchUI() {
        JFrame frame = new JFrame("Search Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        // Set modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Custom colors
        Color primaryColor = new Color(45, 52, 54);
        Color accentColor = new Color(116, 185, 255);
        Color textColor = Color.WHITE;
        Color buttonColor = new Color(0, 184, 148);

        // Top Panel with title and search bar
        JPanel topPanel = new JPanel();
        topPanel.setBackground(primaryColor);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Search Engine");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(accentColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.setBackground(primaryColor);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        searchField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        clearButton.setBackground(buttonColor);
        clearButton.setForeground(textColor);
        clearButton.setFocusPainted(false);
        clearButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        searchBarPanel.add(searchField, BorderLayout.CENTER);
        searchBarPanel.add(clearButton, BorderLayout.EAST);

        topPanel.add(searchBarPanel, BorderLayout.SOUTH);

        // Center Panel for search results
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(39, 60, 117));

        JTextArea resultsArea = new JTextArea();
        resultsArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        resultsArea.setBackground(primaryColor);
        resultsArea.setForeground(textColor);
        resultsArea.setLineWrap(true);
        resultsArea.setWrapStyleWord(true);
        resultsArea.setEditable(false);

        JScrollPane resultsScrollPane = new JScrollPane(resultsArea);
        resultsScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(accentColor),
                "Search Results",
                0,
                0,
                new Font("SansSerif", Font.BOLD, 16),
                accentColor));
        centerPanel.add(resultsScrollPane, BorderLayout.CENTER);

        // Status Bar at the bottom
        JLabel statusLabel = new JLabel("Welcome to the Search Engine!");
        statusLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Layout of frame
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        // Add action listeners
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            void performSearch() {
                String query = searchField.getText();
                resultsArea.setText("");

                if (query.isEmpty()) {
                    statusLabel.setText("Type something to search...");
                    return;
                }

                SwingUtilities.invokeLater(() -> {
                    FileHandler fileHandler = new FileHandler(DB_PATH);
                    Indexer indexer = new Indexer();
                    List<File> files = fileHandler.listFiles(".txt");
                    indexer.indexFiles(files, fileHandler);

                    List<String> results = indexer.search(query);

                    if (results.isEmpty()) {
                        resultsArea.setText("No Results Found!");
                        statusLabel.setText("No results found.");
                    } else {
                        StringBuilder resultText = new StringBuilder();
                        for (int i = 0; i < results.size(); i++) {
                            String result = results.get(i);
                            String fileName = "file" + (i + 1) + ".txt";
                            resultText.append("Result ").append(i + 1).append(": ").append(result).append("\n");

                            // Clickable file buttons
                            JButton fileButton = new JButton(fileName);
                            fileButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
                            fileButton.setBackground(buttonColor);
                            fileButton.setForeground(textColor);
                            fileButton.setFocusPainted(false);
                            fileButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                            fileButton.addActionListener(ev -> {
                                File targetFile = fileHandler.getFile(fileName);
                                if (targetFile != null) {
                                    List<String> content = fileHandler.readFileContent(targetFile);
                                    JTextArea fileContentArea = new JTextArea(String.join("\n", content));
                                    fileContentArea.setEditable(false);
                                    fileContentArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
                                    JScrollPane fileScrollPane = new JScrollPane(fileContentArea);

                                    JOptionPane.showMessageDialog(frame, fileScrollPane, "File Content: " + fileName,
                                            JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(frame, "File not found: " + fileName,
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            });

                            resultText.append(" - ").append(fileButton.getText()).append("\n\n\n");
                        }
                        resultsArea.setText(resultText.toString());
                        statusLabel.setText(results.size() + " results found.");
                    }
                });
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                performSearch();
            }
        });

        clearButton.addActionListener(e -> {
            searchField.setText("");
            resultsArea.setText("");
            statusLabel.setText("Welcome to the Search Engine!");
        });

        frame.setVisible(true);
    }
}
