package com.searchengine;

import com.searchengine.engine.SearchManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the SearchManager with the path to the db folder
        SearchManager searchManager = new SearchManager("db");

        // Create and display the GUI
        SwingUtilities.invokeLater(() -> new SearchEngineSwing(searchManager).setVisible(true));
    }
}
