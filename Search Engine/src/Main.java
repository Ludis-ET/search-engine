import engine.SearchManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private SearchManager searchManager;
    private JTextArea resultsArea;
    private JTextField searchField;

    public void SearchEngineSwing(SearchManager searchManager) {
        this.searchManager = searchManager;

        // Set up the frame
        setTitle("Search Engine");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up UI components
        initUI();
    }

    public Main(SearchManager searchManager) {
        this.searchManager = searchManager;
    }

    private void initUI() {
        setLayout(new BorderLayout());

        searchField = new JTextField(30);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                String results = searchManager.search(query);
                displayResults(results);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter your search query: "));
        panel.add(searchField);
        panel.add(searchButton);

        add(panel, BorderLayout.NORTH);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void displayResults(String results) {
        resultsArea.setText(results);
        if (!results.isEmpty()) {
            String indexInput = JOptionPane.showInputDialog(this, "Enter the index of the file to view its full content:");
            try {
                int index = Integer.parseInt(indexInput);
                String fileContent = searchManager.getFileContentByIndex(index);
                JOptionPane.showMessageDialog(this, fileContent, "File Content", JOptionPane.PLAIN_MESSAGE);
            } catch (NumberFormatException | NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Invalid index entered or no index provided.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No results found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
