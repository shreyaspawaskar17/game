package p1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class StageCatalogue {
    // Components
    JFrame frame;
    public String shareName;
    private JLabel pnLabel, sel_st_image;
    public JTextField playerName;
    private Image demoIcon;
    private JButton begButton, interButton, expButton, homebutton, submitButton;
    private beginnerHandler bHandler = new beginnerHandler();
    private intermediateHandler iHandler = new intermediateHandler();
    private expertHandler eHandler = new expertHandler();
    private homeHandler h_Handler = new homeHandler();
    private submitHandler s_Handler = new submitHandler();
    Font pixelMplus;

    // The main class
    public static void main(String args[]) {
        new StageCatalogue();
    }

    // the Constructor
    public StageCatalogue() {
        frame = new JFrame("ByteSquad");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Setting up the icon
        demoIcon = new ImageIcon(this.getClass().getResource("/Images/DEMON_1 _reZ.png")).getImage();
        frame.setIconImage(demoIcon);

        // Setting up Font
        try {
            InputStream font = getClass().getResourceAsStream("/Font/PixelMplus10-Regular.ttf");
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, font);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Font error");
            e.printStackTrace();
        }

        // the pLabelPlayerName
        pnLabel = new JLabel("PLAYER NAME");
        pnLabel.setBounds(300, 100, 250, 70);
        pnLabel.setBackground(Color.red);
        pnLabel.setForeground(Color.red);
        pnLabel.setFont(pixelMplus);
        pnLabel.setFont(pnLabel.getFont().deriveFont(Font.PLAIN, 36f));
        frame.add(pnLabel);

        // setting up textfeildPlayerName
        playerName = new JTextField();
        playerName.setBounds(270, 170, 250, 40);
        playerName.setBorder(new MatteBorder(4, 4, 4, 4, Color.red));
        playerName.setBackground(Color.gray);
        playerName.setForeground(Color.yellow);
        playerName.setFont(pixelMplus);
        playerName.setFont(playerName.getFont().deriveFont(Font.BOLD, 20f));
        frame.add(playerName);

        // Setting up the selectStage image
        sel_st_image = new JLabel();
        Image img = new ImageIcon(this.getClass().getResource("/Images/selectstage.png")).getImage();
        sel_st_image.setIcon(new ImageIcon(img));
        sel_st_image.setBounds(315, 300, 200, 20);
        frame.add(sel_st_image);

        // the buttons
        // Setting up beginner Button
        begButton = new JButton("BEGINNER");
        begButton.setBounds(270, 350, 250, 35);
        begButton.setForeground(Color.yellow);
        begButton.setBackground(Color.red);
        begButton.setFont(pixelMplus);
        begButton.setFont(begButton.getFont().deriveFont(Font.PLAIN, 20f));
        begButton.setBorderPainted(false);
        begButton.setFocusPainted(false);
        begButton.addActionListener(bHandler);
        frame.add(begButton);

        // Setting up intermediate Button
        interButton = new JButton("INTERMEDIATE");
        interButton.setBounds(270, 410, 250, 35);
        interButton.setForeground(Color.yellow);
        interButton.setBackground(Color.red);
        interButton.setFont(pixelMplus);
        interButton.setFont(interButton.getFont().deriveFont(Font.PLAIN, 20f));
        interButton.setBorderPainted(false);
        interButton.setFocusPainted(false);
        interButton.addActionListener(iHandler);
        frame.add(interButton);

        // setting up expert Button
        expButton = new JButton("EXPERT");
        expButton.setBounds(270, 470, 250, 35);
        expButton.setForeground(Color.yellow);
        expButton.setBackground(Color.red);
        expButton.setFont(pixelMplus);
        expButton.setFont(expButton.getFont().deriveFont(Font.PLAIN, 20f));
        expButton.setBorderPainted(false);
        expButton.setFocusPainted(false);
        expButton.addActionListener(eHandler);
        frame.add(expButton);

        // setting up home Button icon
        homebutton = new JButton();
        Image img1 = new ImageIcon(this.getClass().getResource("/Images/homeIcon.png")).getImage();
        homebutton.setIcon(new ImageIcon(img1));
        homebutton.setForeground(Color.yellow);
        homebutton.setBackground(Color.black);
        homebutton.setBorderPainted(false);
        homebutton.setFocusPainted(false);
        homebutton.setBounds(720, 10, 40, 40);
        homebutton.addActionListener(h_Handler);
        frame.add(homebutton);

        // Setting up the "Submit" button
        submitButton = new JButton("Submit");
        submitButton.setBounds(530, 170, 100, 40);
        submitButton.setForeground(Color.yellow);
        submitButton.setBackground(Color.red);
        submitButton.setFont(pixelMplus);
        submitButton.setFont(submitButton.getFont().deriveFont(Font.BOLD, 20f));
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(s_Handler);
        frame.add(submitButton);
    }

    public class beginnerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new beg_lev1_info();
        }
    }

    public class intermediateHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform any action when the "Intermediate" button is clicked
        }
    }

    public class expertHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform any action when the "Expert" button is clicked
        }
    }

    public class homeHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform any action when the "Home" button is clicked
        }
    }
    public class submitHandler implements ActionListener {
    	public String name1=" ";
    	
        @Override
        public void actionPerformed(ActionEvent e) {
             String name =playerName.getText().trim();// Trim to remove leading/trailing spaces
          
            this.name1=name;
            System.out.print(name1);

            if (!name.isEmpty()) { // Check if the name is not empty before proceeding
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root",
                            "shreyas@45");
                    Statement stm = con.createStatement();

                    // Update the SQL query to insert the name into the database
                    String sql = "INSERT INTO scoreboard (name) VALUES ('" + name + "')";
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(submitButton, "Player Record Inserted", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(submitButton, "Please enter a valid name", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
