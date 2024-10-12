
package javaapplication339;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaApplication339 extends JFrame {
    private JTextField ekran;
    private double sayi1, sayi2, sonuc;
    private String islem;

    public JavaApplication339() {
        setTitle("Hesap Makinesi");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ekran = new JTextField();
        ekran.setEditable(false);
        add(ekran, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] butonlar = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String buton : butonlar) {
            JButton button = new JButton(buton);
            button.setBackground(Color.black); 
            button.setForeground(Color.WHITE);
            button.addActionListener(new ButonDinleyici());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButonDinleyici implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String komut = e.getActionCommand();

            if (komut.charAt(0) >= '0' && komut.charAt(0) <= '9') {
                ekran.setText(ekran.getText() + komut);
            } else if (komut.charAt(0) == 'C') {
                ekran.setText("");
                sayi1 = sayi2 = sonuc = 0;
                islem = "";
            } else if (komut.charAt(0) == '=') {
                sayi2 = Double.parseDouble(ekran.getText());
                switch (islem) {
                    case "+":
                        sonuc = sayi1 + sayi2;
                        break;
                    case "-":
                        sonuc = sayi1 - sayi2;
                        break;
                    case "*":
                        sonuc = sayi1 * sayi2;
                        break;
                    case "/":
                        sonuc = sayi1 / sayi2;
                        break;
                }
                ekran.setText(String.valueOf(sonuc));
                islem = "";
            } else {
                if (!islem.isEmpty()) return; 
                islem = komut;
                sayi1 = Double.parseDouble(ekran.getText());
                ekran.setText("");
            }
        }
    }
        public static void main(String[] args) {
    JavaApplication339 hesapMakinesi = new JavaApplication339();
    hesapMakinesi.setVisible(true);
    }
}
