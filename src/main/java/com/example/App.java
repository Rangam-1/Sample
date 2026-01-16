package com.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Create some sample products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("Mouse", 29.99));
        products.add(new Product("Keyboard", 49.99));
        products.add(new Product("Monitor", 199.99));
        products.add(new Product("Headphones", 79.99));

        // Create GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            DefaultListModel<Product> model = new DefaultListModel<>();
            for (Product p : products) {
                model.addElement(p);
            }
            JList<Product> list = new JList<>(model);

            JButton addButton = new JButton("Add Product");
            addButton.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(frame, "Enter product name:");
                if (name != null && !name.trim().isEmpty()) {
                    String priceStr = JOptionPane.showInputDialog(frame, "Enter price:");
                    try {
                        double price = Double.parseDouble(priceStr);
                        model.addElement(new Product(name, price));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid price. Please enter a number.");
                    }
                }
            });

            JButton removeButton = new JButton("Remove Selected");
            removeButton.addActionListener(e -> {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    model.remove(index);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a product to remove.");
                }
            });

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(list), BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);
            frame.add(panel);
            frame.setVisible(true);
        });

    }

}