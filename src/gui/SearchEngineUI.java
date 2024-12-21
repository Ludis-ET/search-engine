package gui;

import engine.localdb.FileHandler;
import engine.localdb.Indexer;
import engine.core.AdvancedSearchEngine;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

public class SearchEngineUI {
    private static final String DB_PATH = "db";
    private JFrame frame;
    private JTextField searchField;
    private JTextArea resultsArea;
    private JLabel statusLabel;
    private AdvancedSearchEngine searchEngine = new AdvancedSearchEngine();
    private Color primaryColor = new Color(45, 52, 54);
    private Color accentColor = new Color(116, 185, 255);
    private Color textColor = Color.WHITE;
    private Color buttonColor = new Color(0, 184, 148);

    public static void launchUI() {
        new SearchEngineUI().createUI();
    }

    private void createUI() {
        frame = new JFrame("Search Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        setLookAndFeel();

        JPanel topPanel = createTopPanel();
        JPanel centerPanel = createCenterPanel();
        statusLabel = createStatusLabel();

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);
        frame.setVisible(true);

        initializeSearchEngine();
    }

    private void initializeSearchEngine() {
        FileHandler fileHandler = new FileHandler(DB_PATH);
        searchEngine.setFileHandler(fileHandler);
        searchEngine.indexFiles(fileHandler.listFiles(".txt"));
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(primaryColor);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Search Engine");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(accentColor);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.setBackground(primaryColor);

        searchField = new JTextField();
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        searchField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchField.getDocument().addDocumentListener(createSearchFieldListener());

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        clearButton.setBackground(buttonColor);
        clearButton.setForeground(textColor);
        clearButton.setFocusPainted(false);
        clearButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        clearButton.addActionListener(e -> clearSearch());

        searchBarPanel.add(searchField, BorderLayout.CENTER);
        searchBarPanel.add(clearButton, BorderLayout.EAST);
        topPanel.add(searchBarPanel, BorderLayout.SOUTH);

        return topPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(39, 60, 117));

        resultsArea = new JTextArea();
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

        return centerPanel;
    }

    private JLabel createStatusLabel() {
        JLabel label = new JLabel("Welcome to the Search Engine!");
        label.setFont(new Font("SansSerif", Font.ITALIC, 14));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private DocumentListener createSearchFieldListener() {
        return new javax.swing.event.DocumentListener() {
            void performSearch() {
                String query = searchField.getText();
                resultsArea.setText("");

                if (query.isEmpty()) {
                    statusLabel.setText("Type something to search...");
                    return;
                }

                SwingUtilities.invokeLater(() -> search(query));
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
        };
    }

    private void search(String query) {
        List<String> results = searchEngine.search(query);

        if (results.isEmpty()) {
            resultsArea.setText("No Results Found!");
            statusLabel.setText("0 results found.");
        } else {
            resultsArea.setText("");
            statusLabel.setText(results.size() + " results found.");
            for (String result : results) {
                JButton resultButton = createResultButton(result);
                resultsArea.insert(result + "\n", resultsArea.getCaretPosition());
                resultButton.addActionListener(e -> showFileDetails(result.split(" ")[2]));
            }
        }
    }

    private JButton createResultButton(String fileName) {
        JButton button = new JButton(fileName);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.setBackground(buttonColor);
        button.setForeground(textColor);
        return button;
    }

    private void showFileDetails(String fileName) {
        File file = searchEngine.getFileHandler().getFile(fileName);
        if (file != null) {
            List<String> content = searchEngine.getFileHandler().readFileContent(file);
            JOptionPane.showMessageDialog(frame, String.join("\n", content), "File Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearSearch() {
        searchField.setText("");
        resultsArea.setText("");
        statusLabel.setText("Welcome to the Search Engine!");
    }
}
