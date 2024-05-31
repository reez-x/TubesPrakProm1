package TUBES.TUBES2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankQueueGUI extends JFrame {
    private StrukturQueue queue;
    private JTextArea displayArea;
    private JTextField nameField, phoneField, emailField;

    public BankQueueGUI(StrukturQueue queue) {
        this.queue = queue;
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistem Antrian Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nama Nasabah:");
        nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JButton addButton = new JButton("Tambah Antrian");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String noTelp = phoneField.getText();
                String email = emailField.getText();
                queue.enqueue(nama, noTelp, email);
                updateDisplay();
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
        });

        JButton serveButton = new JButton("Layani Antrian");
        serveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeQueue servedCustomer = queue.dequeue();
                if (servedCustomer != null) {
                    JOptionPane.showMessageDialog(null,
                            "Melayani nasabah dengan nomor antrian: " + servedCustomer.getData() +
                                    "\nNama: " + servedCustomer.getnamaCustomer() +
                                    "\nNomor Telepon: " + servedCustomer.getnoTelp() +
                                    "\nEmail: " + servedCustomer.getEmail());
                } else {
                    JOptionPane.showMessageDialog(null, "Antrian kosong!");
                }
                updateDisplay();
            }
        });

        JButton viewQueueButton = new JButton("Lihat Antrian");
        viewQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(queue.getQueueDisplay());
            }
        });

        JButton exitButton = new JButton("Keluar");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(addButton);
        inputPanel.add(serveButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewQueueButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateDisplay() {
        displayArea.setText(queue.getQueueDisplay());
    }

    public void displayGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
}
