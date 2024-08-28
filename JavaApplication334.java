
package javaapplication334;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

         public class JavaApplication334 extends JFrame {
   private int randomNumber;
    private JTextField guessField;
    private JLabel resultLabel;
    private JButton guessButton;

    public JavaApplication334() {
        // Random sayı üret
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1; // 1 ile 100 arasında bir sayı

        // JFrame oluştur
        JFrame frame = new JFrame("Sayı Tahmin Oyunu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Tahmin girişi için JTextField oluştur
        guessField = new JTextField();
        guessField.setBounds(50, 30, 200, 30);
        frame.add(guessField);

        // Sonuçları göstermek için JLabel oluştur
        resultLabel = new JLabel("Tahmininizi girin:");
        resultLabel.setBounds(50, 70, 200, 30);
        frame.add(resultLabel);

        // Tahmin butonu oluştur
        guessButton = new JButton("Tahmin Et");
        guessButton.setBounds(100, 110, 100, 30);
        frame.add(guessButton);

        // Butona tıklama olay dinleyicisi ekle
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());
                    if (userGuess < randomNumber) {
                        resultLabel.setText("Daha yüksek bir sayı tahmin edin.");
                    } else if (userGuess > randomNumber) {
                        resultLabel.setText("Daha düşük bir sayı tahmin edin.");
                    } else {
                        resultLabel.setText("Tebrikler! Doğru tahmin.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Geçerli bir sayı girin.");
                }
            }
        });

        // JFrame'i görünür yap
        frame.setVisible(true);
    }

    public static void main(String[] args) {
         JavaApplication334 tmp = new JavaApplication334();
        tmp.setVisible(true);
    }
}
