package p1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPage {
	//the components
	JFrame frame;
	private JLabel menutitle;
	private JButton startButton, scoreButton, settButton, homeButton, exitButton;
	private startHandler sHandler = new startHandler();
	private scoreboardHandler scoHandler = new scoreboardHandler();
	private settingsHandler stHandler = new settingsHandler();
	private homeHandler h_Handler = new homeHandler();
	private exitHandler eHandler = new exitHandler();
	private Image demoIcon;
	Font pixelMplus;
	
	//The main class
	public static void main(String args[]) {
		new MenuPage();
	
	}

	//the constructor
	public MenuPage() {
		
		//Setting up the frame	
		frame = new JFrame("ByteSquad");
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//Setting up the icon
		demoIcon = new ImageIcon(this.getClass().getResource("/Images/DEMON_1 _reZ.png")).getImage();//Imports the font file
		frame.setIconImage(demoIcon);
		
		//Setting up Font 
		try {
			InputStream font = getClass().getResourceAsStream("/Font/PixelMplus10-Regular.ttf");//Imports the font file
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, font);
		}catch(FontFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("Font error");
		e.printStackTrace();
		}
		
		//the title
		menutitle = new JLabel("HIT-ME");
		menutitle.setBounds(270, 100, 250, 70);
		menutitle.setBackground(Color.red);
		menutitle.setForeground(Color.red);
//		menutitle.setOpaque(true);
		menutitle.setFont(pixelMplus);
		menutitle.setFont(menutitle.getFont().deriveFont(Font.BOLD,76f));
		frame.add(menutitle);
		
	//the buttons
		//Setting up startButton
		startButton = new JButton("START");
		startButton.setBounds(310,270,150,35);
		startButton.setForeground(Color.yellow);
		startButton.setBackground(Color.red);
		startButton.setFont(pixelMplus);
		startButton.setFont(startButton.getFont().deriveFont(Font.PLAIN, 20f));
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		startButton.addActionListener(sHandler);
		frame.add(startButton);
		
		//Setting up scoreButton
		scoreButton = new JButton("SCOREBOARD");
		scoreButton.setBounds(310,330,150,35);
		scoreButton.setForeground(Color.yellow);
		scoreButton.setBackground(Color.red);
		scoreButton.setFont(pixelMplus);
		scoreButton.setFont(scoreButton.getFont().deriveFont(Font.PLAIN, 20f));
		scoreButton.setBorderPainted(false);
		scoreButton.setFocusPainted(false);
		scoreButton.addActionListener(scoHandler);
		frame.add(scoreButton);
		
		//setting up settButton
		settButton = new JButton("SETTINGS");
		settButton.setBounds(310,390,150,35);
		settButton.setForeground(Color.yellow);
		settButton.setBackground(Color.red);
		settButton.setFont(pixelMplus);
		settButton.setFont(settButton.getFont().deriveFont(Font.PLAIN, 20f));
		settButton.setBorderPainted(false);
		settButton.setFocusPainted(false);
		settButton.addActionListener(stHandler);
		frame.add(settButton);
	
		//setting up home Button icon
		homeButton= new JButton("HOME");
		Image img1 = new ImageIcon(this.getClass().getResource("/Images/homeIcon.png")).getImage();
		homeButton.setIcon(new ImageIcon(img1));
		homeButton.setBounds(310,450,150,35);
		homeButton.setFont(pixelMplus);
		homeButton.setFont(homeButton.getFont().deriveFont(Font.PLAIN, 22f));
		homeButton.setForeground(Color.red);
		homeButton.setBackground(Color.black);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(h_Handler);
		frame.add(homeButton);
		
		//setting up exitButton
		exitButton = new JButton("EXIT");
		exitButton.setBounds(600,510,90,35);
		exitButton.setForeground(Color.yellow);
		exitButton.setBackground(Color.red);
		exitButton.setFont(pixelMplus);
		exitButton.setFont(exitButton.getFont().deriveFont(Font.PLAIN, 20f));
		//Setting the border curve try 1
//		exitButton.setBorder(new RoundedBorder(10));
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(eHandler);
		frame.add(exitButton);
	}
	
	
	public class startHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new StageCatalogue();
		}
		
	}
	public class scoreboardHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	
		}
		
	}
	public class settingsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class homeHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class exitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
}
