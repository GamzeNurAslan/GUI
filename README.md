Temel GUI Bileşenleri
JFrame: Pencerenin ana çerçevesini oluşturur.
JPanel: Diğer bileşenleri gruplamak için kullanılan bir kapsayıcıdır.
JButton: Kullanıcının bir eylemi tetiklemesi için kullanılan butondur.
JLabel: Metin veya görsel içerik göstermek için kullanılır.
JTextField: Kullanıcının metin girmesini sağlar.
JTextArea: Çok satırlı metin girdisi için kullanılır.
JCheckBox: Evet/hayır veya birden fazla seçenekten seçim yapmak için kullanılır.
JRadioButton: Bir grup seçenekten sadece birini seçmek için kullanılır.

____________JOptionPane____________
1. Basit Bir Mesaj Kutusu
import javax.swing.JOptionPane;
public class JOptionPaneOrnek {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Merhaba, bu bir mesaj kutusu örneği!", "Başlık", JOptionPane.INFORMATION_MESSAGE);
    }
}

2. Kullanıcıdan Onay Alma
int cevap = JOptionPane.showConfirmDialog(null, "Devam etmek istiyor musunuz?", "Onay", JOptionPane.YES_NO_OPTION);
if (cevap == JOptionPane.YES_OPTION) {
    System.out.println("Evet seçildi.");
} else {
    System.out.println("Hayır seçildi.");
}

3. Kullanıcıdan Bir Değer Alma
String isim = JOptionPane.showInputDialog(null, "Adınızı giriniz:");
System.out.println("Merhaba, " + isim + "!");

4. Seçenekli Bir Diyalog
String[] secenekler = {"Kırmızı", "Yeşil", "Mavi"};
String secim = (String) JOptionPane.showInputDialog(
    null,
    "En sevdiğiniz renk nedir?",
    "Renk Seçimi",
    JOptionPane.QUESTION_MESSAGE,
    null,
    secenekler,
    secenekler[0]);
System.out.println("Seçilen renk: " + secim);

5. Hata Mesajı
JOptionPane.showMessageDialog(null, "Bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
JDialog Kullanarak Özel Bir Diyalog Kutusu Oluşturma(code)

import javax.swing.*;
import java.awt.event.*;

public class JDialogOrnek extends JFrame {
    public JDialogOrnek() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JDialog dialog = new JDialog(this, "Kayıt Formu", true);
        dialog.setSize(300, 150);

        JLabel labelAd = new JLabel("Adınız:");
        JTextField textFieldAd = new JTextField(20);
        JLabel labelYas = new JLabel("Yaşınız:");
        JTextField textFieldYas = new JTextField(5);
        JButton buttonKaydet = new JButton("Kaydet");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(labelAd);
        panel.add(textFieldAd);
        panel.add(labelYas);
        panel.add(textFieldYas);
        panel.add(buttonKaydet);

        dialog.add(panel);

        buttonKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ad = textFieldAd.getText();
                int yas = Integer.parseInt(textFieldYas.getText());
                JOptionPane.showMessageDialog(null, "Kayıt başarıyla oluşturuldu!\nAd: " + ad + "\nYaş: " + yas);
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JDialogOrnek();
        });
    }
}

![image](https://github.com/user-attachments/assets/8437c8f1-7c08-4152-ac04-7f576c42af2b)
