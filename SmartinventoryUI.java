package javainternship;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SmartinventoryUI extends JFrame {

    DefaultTableModel tableModel;
    JTable table;

    JTextField id, name, qty, price, search;
    JComboBox<String> categoryBox;
    JLabel totalLabel;

    public SmartinventoryUI() {

        // ===== FRAME SETTINGS =====
        setTitle("Smart Inventory System");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== TOP =====
        totalLabel = new JLabel("Total Inventory Value: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(totalLabel, BorderLayout.NORTH);

        // ===== TABLE =====
        tableModel = new DefaultTableModel(
                new String[]{"ID", "Name", "Category", "Qty", "Price", "Total"}, 0);

        table = new JTable(tableModel);
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== FORM (RIGHT SIDE) =====
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Product Details"));
        form.setPreferredSize(new Dimension(350, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        id = new JTextField();
        name = new JTextField();
        qty = new JTextField();
        price = new JTextField();
        search = new JTextField();

        categoryBox = new JComboBox<>(new String[]{"Food", "Cosmetics", "Stationary"});

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Row 1
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        form.add(id, gbc);

        // Row 2
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        form.add(name, gbc);

        // Row 3
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        form.add(categoryBox, gbc);

        // Row 4
        gbc.gridx = 0; gbc.gridy = 3;
        form.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        form.add(qty, gbc);

        // Row 5
        gbc.gridx = 0; gbc.gridy = 4;
        form.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        form.add(price, gbc);

        // Buttons
        gbc.gridx = 0; gbc.gridy = 5;
        form.add(addBtn, gbc);
        gbc.gridx = 1;
        form.add(updateBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        form.add(deleteBtn, gbc);

        // Search
        gbc.gridx = 0; gbc.gridy = 7;
        form.add(new JLabel("Search ID:"), gbc);
        gbc.gridx = 1;
        form.add(search, gbc);

        add(form, BorderLayout.EAST);

        // ===== BUTTON LOGIC =====

        // ADD
        addBtn.addActionListener(e -> {
            try {
                int q = Integer.parseInt(qty.getText());
                double p = Double.parseDouble(price.getText());

                if (q < 0) {
                    JOptionPane.showMessageDialog(this, "Stock cannot be negative!");
                    return;
                }

                double total = q * p;

                tableModel.addRow(new Object[]{
                        id.getText(),
                        name.getText(),
                        categoryBox.getSelectedItem(),
                        q, p, total
                });

                if (q < 5) {
                    JOptionPane.showMessageDialog(this, "⚠ Low Stock Alert!");
                }

                clear();
                updateTotal();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid data!");
            }
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int q = Integer.parseInt(qty.getText());
                double p = Double.parseDouble(price.getText());

                tableModel.setValueAt(id.getText(), row, 0);
                tableModel.setValueAt(name.getText(), row, 1);
                tableModel.setValueAt(categoryBox.getSelectedItem(), row, 2);
                tableModel.setValueAt(q, row, 3);
                tableModel.setValueAt(p, row, 4);
                tableModel.setValueAt(q * p, row, 5);

                updateTotal();
                clear();
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
                updateTotal();
            }
        });

        // SEARCH
        search.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String key = search.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).toString().contains(key)) {
                        table.setRowSelectionInterval(i, i);
                        break;
                    }
                }
            }
        });

        // CLICK TABLE → FILL FORM
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();

                id.setText(tableModel.getValueAt(row, 0).toString());
                name.setText(tableModel.getValueAt(row, 1).toString());
                categoryBox.setSelectedItem(tableModel.getValueAt(row, 2));
                qty.setText(tableModel.getValueAt(row, 3).toString());
                price.setText(tableModel.getValueAt(row, 4).toString());
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void updateTotal() {
        double sum = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += Double.parseDouble(tableModel.getValueAt(i, 5).toString());
        }
        totalLabel.setText("Total Inventory Value: " + sum);
    }

    void clear() {
        id.setText("");
        name.setText("");
        qty.setText("");
        price.setText("");
    }

    public static void main(String[] args) {
        new SmartinventoryUI();
    }
}