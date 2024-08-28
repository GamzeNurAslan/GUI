
package javaapplication334;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

         public class JavaApplication334 extends JFrame {
    private JPanel panel;
    private JButton buton;
    private Random rastgele;

    public JavaApplication334() {
        setTitle("Renk Değiştirici Oyun");
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 300);

        panel = new JPanel();
        buton = new JButton("Renk Değiştir");

        rastgele = new Random();

        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Color yeniRenk = new Color(rastgele.nextInt(256), rastgele.nextInt(256), rastgele.nextInt(256));
               
                panel.setBackground(yeniRenk);
            }
        });

        panel.add(buton);
        getContentPane().add(panel);

        //setLocationRelativeTo(null);
    }
 
    public static void main(String[] args) {
      JavaApplication334 tmp = new JavaApplication334();
        tmp.setVisible(true);          
    }
}
