package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 *
 * @author Malgorzata
 */
public class MainJFrame extends JFrame implements PropertyChangeListener {

    private Image image;
    private File file;
    private JButton jButton1;
    private JButton jButtonFilter;
    private JLabel jLabel1;
    private JProgressBar jProgressBar1;
    private Filter filter;

    public MainJFrame() {
        initComponents();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        int progress = filter.getProgress();
        jProgressBar1.setValue(progress);
    }

    private void initComponents() {

        jButton1 = new JButton();
        jButtonFilter = new JButton();
        jLabel1 = new JLabel();
        jProgressBar1 = new JProgressBar(0,100);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ImageChanger");
        setMinimumSize(new Dimension(650, 650));

        jButton1.setText("Wczytaj plik");
        jButton1.setMinimumSize(new Dimension(89, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, BorderLayout.WEST);

        jLabel1.setText("<tu będzie wczytany obraz>");
        jLabel1.setMaximumSize(new Dimension(140, 50));
        jLabel1.setMinimumSize(new Dimension(140, 50));
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentResized(evt);
            }
        });
        getContentPane().add(jLabel1, BorderLayout.CENTER);

        jButtonFilter.setText("Nałóż filtr");
        jButtonFilter.setEnabled(false);
        jButtonFilter.setMaximumSize(new Dimension(140, 50));
        jButtonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonFilterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFilter, BorderLayout.EAST);

        jProgressBar1.setMaximumSize(new Dimension(140, 50));
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, BorderLayout.AFTER_LAST_LINE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFilterActionPerformed(ActionEvent evt) {
        jButtonFilter.setEnabled(false);

        filter = new Filter(file, this.jLabel1, jLabel1.getWidth(), jLabel1.getHeight());
        filter.addPropertyChangeListener(this);
        filter.execute();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        FileLoader loader = new FileLoader(this);
        file = loader.OpenDialog();

        try {
            image = loader.GetFileAsImage(file);

            jLabel1.setText("");
            int labelWidth = jLabel1.getWidth();
            int labelHeight = jLabel1.getHeight();
            Image imageTemp = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageTemp);

            jLabel1.setIcon(imageIcon);
            jButtonFilter.setEnabled(true);
            jProgressBar1.setValue(0);
        } catch(Exception ex) {
            System.out.println("Brak pliku lub plik w złym formacie: " + ex.getMessage());
        }
    }

    private void jLabel1ComponentResized(java.awt.event.ComponentEvent evt) {
        if(image!=null)
        {
            int labelWidth = jLabel1.getWidth();
            int labelHeight = jLabel1.getHeight();
            Image imageTemp= image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageTemp);
            jLabel1.setIcon(imageIcon);
        }
    }
}
