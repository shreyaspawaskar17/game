package p1;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TheBaseClass {
    // The components
    JFrame frame;
    private JLabel title, demon1;
    private JButton enterButton;
    Font pixelMplus;
    private Image demonIcon;
    private titleScreenHandler tHandler = new titleScreenHandler();

    public static void main(String[] args) {
        new TheBaseClass();
    }

    // The Constructor
    public TheBaseClass() {

        // Setting up Font
     try {
          InputStream font = getClass().getResourceAsStream("/Font/PixelMplus10-Regular.ttf");
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, font);
           font.close(); // Close the input stream after loading the font
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Font error: " + e.getMessage());
       }
       frame = new JFrame("ByteSquad");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Setting up the title image
        title = new JLabel();
        Image img0 = new ImageIcon(this.getClass().getResource("/Images/Title.png")).getImage();
        title.setIcon(new ImageIcon(img0));
        title.setBounds(295, 270, 400, 100);
        frame.add(title);
      // Adding enter Button
        enterButton = new JButton("ENTER");
        enterButton.setBounds(350, 420, 110, 30);
        enterButton.setForeground(Color.yellow);
        enterButton.setBackground(Color.red);
        enterButton.setFont(pixelMplus);
        enterButton.setFont(enterButton.getFont().deriveFont(Font.BOLD, 20f));
        enterButton.setBorderPainted(false);
        enterButton.setFocusPainted(false);
        enterButton.addActionListener(tHandler);
        frame.add(enterButton);
        // Setting up the icon
        demonIcon = new ImageIcon(this.getClass().getResource("/Images/DEMON_1 _reZ.png")).getImage();
        frame.setIconImage(demonIcon);
       // Adding the Image to the Home page
        demon1 = new JLabel();
        Image img1 = new ImageIcon(this.getClass().getResource("/Images/DEMON_1 _reZ.png")).getImage();
        demon1.setIcon(new ImageIcon(img1));
        demon1.setBounds(350, 140, 110, 122); // Image sizes are crucial
        frame.add(demon1);
    }

    public class titleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            MenuPage try1 = new MenuPage();
        }
    }
}
