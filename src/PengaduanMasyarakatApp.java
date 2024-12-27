import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PengaduanMasyarakatApp {

    static class Pengaduan {
        private final String nama;
        private final String deskripsi;
        private final ImageIcon gambar;

        public Pengaduan(String nama, String deskripsi, ImageIcon gambar) {
            this.nama = nama;
            this.deskripsi = deskripsi;
            this.gambar = gambar;
        }

        public String getNama() {
            return nama;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public ImageIcon getGambar() {
            return gambar;
        }
    }

    private final ArrayList<Pengaduan> daftarPengaduan = new ArrayList<>();

    public PengaduanMasyarakatApp() {
        JFrame frame = new JFrame("Aplikasi Pengaduan Masyarakat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Agar aplikasi muncul di tengah layar

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240)); // Warna latar belakang panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNama = new JLabel("Nama Pengadu:");
        JTextField fieldNama = new JTextField(20);

        JLabel labelDeskripsi = new JLabel("Deskripsi:");
        JTextArea areaDeskripsi = new JTextArea(5, 20);
        areaDeskripsi.setLineWrap(true);
        areaDeskripsi.setWrapStyleWord(true);
        areaDeskripsi.setBackground(new Color(255, 255, 255)); // Warna latar belakang areaDeskripsi

        JLabel labelGambar = new JLabel("Unggah Gambar (Opsional):");
        JButton buttonUnggah = new JButton("Unggah Gambar");
        JLabel labelPreview = new JLabel("Preview Gambar: Tidak Ada");
        labelPreview.setHorizontalAlignment(SwingConstants.CENTER);
        labelPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labelPreview.setPreferredSize(new Dimension(200, 200));

        JButton buttonTambah = new JButton("Tambah Pengaduan");
        JButton buttonLihat = new JButton("Lihat Pengaduan");

        // Set button colors
        buttonTambah.setBackground(new Color(34, 139, 34)); // Green
        buttonTambah.setForeground(Color.WHITE);
        buttonLihat.setBackground(new Color(30, 144, 255)); // Dodger Blue
        buttonLihat.setForeground(Color.WHITE);

        // Tambah Pengaduan
        buttonTambah.addActionListener(e -> {
            try {
                String nama = fieldNama.getText().trim();
                String deskripsi = areaDeskripsi.getText().trim();

                if (nama.isEmpty() || deskripsi.isEmpty()) {
                    throw new IllegalArgumentException("Nama dan Deskripsi tidak boleh kosong.");
                }

                ImageIcon gambar = (labelPreview.getIcon() instanceof ImageIcon) ? (ImageIcon) labelPreview.getIcon() : null;
                daftarPengaduan.add(new Pengaduan(nama, deskripsi, gambar));

                // Show success message with green color
                JOptionPane.showMessageDialog(frame, "Pengaduan berhasil ditambahkan.", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Reset form
                fieldNama.setText("");
                areaDeskripsi.setText("");
                labelPreview.setIcon(null);
                labelPreview.setText("Preview Gambar: Tidak Ada");
                fieldNama.requestFocus();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Lihat Pengaduan
        buttonLihat.addActionListener(e -> {
            JFrame viewFrame = new JFrame("Daftar Pengaduan");
            viewFrame.setSize(800, 600);
            viewFrame.setLocationRelativeTo(null);

            JPanel viewPanel = new JPanel();
            viewPanel.setLayout(new BorderLayout());
            viewPanel.setBackground(new Color(4, 215, 241));

            // Create table model
            String[] columnNames = {"Nama", "Deskripsi", "Gambar"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            for (Pengaduan p : daftarPengaduan) {
                Object[] row = {p.getNama(), p.getDeskripsi(), p.getGambar()};
                model.addRow(row);
            }

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            viewPanel.add(scrollPane, BorderLayout.CENTER);

            // Hapus Pengaduan Button in "Lihat Pengaduan"
            JButton buttonHapus = new JButton("Hapus Pengaduan");
            buttonHapus.setBackground(new Color(255, 69, 0)); // Red Orange
            buttonHapus.setForeground(Color.WHITE);
            buttonHapus.addActionListener(ev -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String namaToDelete = (String) table.getValueAt(selectedRow, 0);
                    daftarPengaduan.removeIf(p -> p.getNama().equalsIgnoreCase(namaToDelete));
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(viewFrame, "Pengaduan berhasil dihapus.");
                } else {
                    JOptionPane.showMessageDialog(viewFrame, "Silakan pilih pengaduan yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            viewPanel.add(buttonHapus, BorderLayout.SOUTH);

            viewFrame.add(viewPanel);
            viewFrame.setVisible(true);
        });

        // Unggah Gambar
        buttonUnggah.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    ImageIcon gambar = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
                    Image scaledImage = gambar.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    labelPreview.setIcon(new ImageIcon(scaledImage));
                    labelPreview.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal memuat gambar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tambahkan komponen ke panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNama, gbc);

        gbc.gridx = 1;
        panel.add(fieldNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelDeskripsi, gbc);

        gbc.gridx = 1;
        panel.add(new JScrollPane(areaDeskripsi), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelGambar, gbc);

        gbc.gridx = 1;
        panel.add(buttonUnggah, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(labelPreview, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonTambah, gbc);

        gbc.gridx = 1;
        panel.add(buttonLihat, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PengaduanMasyarakatApp::new);
    }
}