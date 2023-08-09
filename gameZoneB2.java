package p1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;



public class gameZoneB2 extends JPanel{
	//the Members
	static JFrame frame;
	private static int LEV_MIN = 2; // in pixels
   private static int LEV_SEC = 40; // in pixels
    private static final int IMG_WIDTH = 110; // in pixels
    private static final int IMG_HEIGHT = 122; // in pixels
    private static final int PANEL_WIDTH = 784; // in pixels
    private static final int PANEL_HEIGHT = 511; // in pixels
    private static final int HIT_MISS_LABEL_WIDTH = 100; // in pixels
    private static final int HIT_MISS_LABEL_HEIGHT = 20; // in pixels
    private static final int MAX_IMG_POSITION_X = PANEL_WIDTH -IMG_WIDTH;
   private static final int MAX_IMG_POSITION_Y = PANEL_HEIGHT - IMG_HEIGHT;
    private static final Random RANDOM = new Random();
    private int imgPositionX;
    private int imgPositionY;
    private static int hitCount;
    private static int HIT_TARGET = 30;
    private static int missCount;
    private static int Max_MISSES = 60;
    private static int totalTime = LEV_MIN * 60 + LEV_SEC;
    private static int totalClicks = 0;
    private double Y = 0.0;
    private double performance2 = 0.0;
    static Font pixelMplus;
    private Image imgd = new ImageIcon(this.getClass().getResource("/Images/DEMON_1 _reZ.png")).getImage();
    private static JLabel hitmissLabel;
    private static Boolean flag1 = true, flag2 = true;
    private static final StartStopTimer phone = new StartStopTimer();
    private static JButton pauseResumeButton ;
    static pauseResumeHandler pRHandler = new  pauseResumeHandler();
    
    //The popup related components
    private static JFrame popupframe = new JFrame();
    private static JLabel incompleteLabel;
    private static JButton retryButton, mainMenuButton;
    static retryHandler rHandler = new  retryHandler();
    static mainMenuHandler mHandler = new  mainMenuHandler();

    //The main class
    public static void main(String[] args) {
    	//Setting up Font 
		try {
			InputStream font = gameZoneB1.class.getResourceAsStream("/Font/PixelMplus10-Regular.ttf");//Imports the font file
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, font);
		}catch(FontFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("Font error");
			e.printStackTrace();
		}
		//frame
		frame = new JFrame("Hit-Miss Game");
		frame.setSize(800, 600);
		frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//panels
		//setting up gamePanel()
		gameZoneB2 gamePanel = new  gameZoneB2();
		gamePanel.setBounds(0,50,PANEL_WIDTH, PANEL_HEIGHT);
		frame.add(gamePanel);        

		//Setting up dashboardPanel
		JPanel dashPanel = new JPanel();
		dashPanel.setBounds(0,0,PANEL_WIDTH, 50);
		dashPanel.setBackground(Color.black);
		dashPanel.setLayout(null);
		frame.add(dashPanel);

		//Adding components into the panel

		//Setting up the pauseResumeButton
		pauseResumeButton = new JButton();
		Image img1 = new ImageIcon( gameZoneB2.class.getResource("/Images/pause.png")).getImage(); // removed that .getClass part from the previous buttons
		pauseResumeButton.setIcon(new ImageIcon(img1));
		pauseResumeButton.setBounds(PANEL_WIDTH - 70, 10 , 40 ,40);
		pauseResumeButton.setBackground(Color.black);
		pauseResumeButton.setFont(pixelMplus);
		pauseResumeButton.setFont( pauseResumeButton.getFont().deriveFont(Font.PLAIN, 20f));
		pauseResumeButton.setBorderPainted(false);
		pauseResumeButton.setFocusPainted(false);
		pauseResumeButton.addActionListener(pRHandler);
		dashPanel.add( pauseResumeButton);
 

		//Setting up the hitmisscountLabel
		hitmissLabel = new JLabel();
		hitmissLabel.setBounds(PANEL_WIDTH - 300, 10,220,40);
		hitmissLabel.setForeground(Color.yellow);
		hitmissLabel.setOpaque(true);
		hitmissLabel.setBackground(Color.black);
		hitmissLabel.setFont(pixelMplus);
		hitmissLabel.setFont( hitmissLabel.getFont().deriveFont(Font.BOLD, 22f));
		dashPanel.add(hitmissLabel);

		//Setting up the timer
		phone.timedisplayer.setForeground(Color.yellow);
		phone.timedisplayer.setOpaque(true);
		phone.timedisplayer.setBackground(Color.black);
		phone.timedisplayer.setBounds(20,10,300,40);
		phone.timedisplayer.setFont(pixelMplus);
		phone.timedisplayer.setFont(phone.timedisplayer.getFont().deriveFont(Font.BOLD, 22f));
		dashPanel.add(phone.timedisplayer);
		phone.startRinging();

 
		while (true) { // Continuously repaint the panel with a delay of 1 second
			//	System.out.println("Oh I can be here too" + phone.min + ":" + phone.sec);
			gamePanel.imgPositionX = 0;
			gamePanel.imgPositionY = 0;
			gamePanel.repaint();
    
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    
			//to avoid stop of thread 
			while(flag2 == false) {
				System.out.println("The while loop");
				System.out.println("hey");
			}  // infinite loop
    
    
			if(flag2 == true && flag1 == false) { 
				break;
			}
            
		}//End of while loop
		 System.out.println("Total Time: " + totalTime + " seconds");
	       System.out.println("Total Clicks: " + totalClicks);
	       System.out.println("Y (missCount / totalClicks): " + gamePanel.getYRatio());
	       System.out.println("Performance (Total Time / Y): " + gamePanel.getPerformance());
    }//end of main method
    
    public double getYRatio() {
        if (totalClicks > 0) {
            Y = (double) missCount / totalClicks;
        }
        return Y;
    }
    public double getPerformance() {
        if (Y > 0) {
            performance2 = (double) totalTime / Y;
        }
        return performance2;
    }

    
    
    public gameZoneB2() {
    	phone.min = LEV_MIN;
    	phone.sec = LEV_SEC;
    	setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                if (point.x >= imgPositionX && point.x <= imgPositionX + IMG_WIDTH
                        && point.y >= imgPositionY && point.y <= imgPositionY + IMG_HEIGHT) {
                	if(flag1 == true) {
                    hitCount++;
                    totalClicks++;
                	}
                } else {
                	if(flag1 == true) {
                    missCount++;
                    totalClicks++;
                	}
                }
                repaint();
            }
        });
        
    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the box60
            if (imgPositionX == 0 && imgPositionY == 0) { 
                imgPositionX = RANDOM.nextInt(MAX_IMG_POSITION_X + 1);
                imgPositionY = RANDOM.nextInt(MAX_IMG_POSITION_Y + 1);
            }
            
            hitmissLabel.setText("Hit: " + hitCount + "   Miss: " + (Max_MISSES - missCount));
              
            if((phone.min == 0 && phone.sec == 0) || hitCount == HIT_TARGET ||   (Max_MISSES - missCount  == 0) ) {
            	phone.timer.cancel();
            	flag1 =false;
            	frame.setEnabled(false);
            	popup();
            }
            g.drawImage(imgd, imgPositionX,  imgPositionY, getFocusCycleRootAncestor());

        }


        public static class pauseResumeHandler implements ActionListener{
        	
        	boolean flag3 = true;
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			Image img2 = new ImageIcon(gameZoneB2.class.getResource("/Images/play.png")).getImage();  // removed that .getClass part from the previous buttons
    			System.out.println("hi");
    			if(flag3 == true) {
    			pauseResumeButton.setIcon(new ImageIcon(img2));
    	        flag3 = false;
    	        //pausing the hit and miss counter
    	        flag1 = false;
    	        //making the main while loop to fall into infinite loop
    	        flag2 = false;
    	        //Pause the timer
    	        phone.pauseTimer();
    	        
    			}
    				else {
    			Image img1 = new ImageIcon(gameZoneB2.class.getResource("/Images/pause.png")).getImage();;
    			pauseResumeButton.setIcon(new ImageIcon(img1 ));
    			flag3 = true;
    			//playing the hit and miss counter
    	        flag1 = true;
    	        //helping the main while loop to come up from the infinite loop
    	        flag2 = true;
    	        //Resume the timer
    	        phone.resumeTimer();
    			}
    		}//End of actionPerformed method 
    	}//End of pauseResumeHandler 
        
        public void popup(){
        	//the frame
        	popupframe.setUndecorated(true);
        	popupframe.setSize(400, 200);
        	popupframe.getContentPane().setBackground(Color.red);
        	popupframe.setVisible(true);
        	popupframe.setLayout(null);
        	popupframe.setLocationRelativeTo(null);
        	
        	//The level incomplete Label 
        	incompleteLabel =new JLabel("Level Incomplete!!!");
        	incompleteLabel.setBounds(50, 30, 350, 40);
        	incompleteLabel.setForeground(Color.black);
        	incompleteLabel.setFont(pixelMplus);
        	incompleteLabel.setFont(incompleteLabel.getFont().deriveFont(Font.BOLD, 30f));
        	popupframe.add(incompleteLabel);
        	
        	//Setting up the Buttons
        	//Retry button
        	retryButton =  new JButton("RETRY");
        	retryButton.setBounds(150,110,120,40);
        	retryButton.setForeground(Color.black);
        	retryButton.setBackground(Color.white);
        	retryButton.setFont(pixelMplus);
        	retryButton.setFont(retryButton.getFont().deriveFont(Font.BOLD, 20f));
        	retryButton.setBorder(new MatteBorder(4, 4, 4, 4, Color.black));
//        	retryButton.setBorderPainted(false);
        	retryButton.setFocusPainted(false);
        	retryButton.addActionListener(rHandler);
        	popupframe.add(retryButton);
        	
        	//MainMenu Button
        	mainMenuButton =  new JButton("MAIN MENU");
        	mainMenuButton.setBounds(270,170,130,30);
        	mainMenuButton.setForeground(Color.black);
        	mainMenuButton.setBackground(Color.red);
        	mainMenuButton.setFont(pixelMplus);
        	mainMenuButton.setFont(mainMenuButton.getFont().deriveFont(Font.BOLD, 20f));
        	mainMenuButton.setBorderPainted(false);
        	mainMenuButton.setFocusPainted(false);
        	mainMenuButton.addActionListener(mHandler);
        	popupframe.add(mainMenuButton);
        	
        }
        
        public static class retryHandler implements ActionListener{

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			
    		}
    		
    	}
        
        public static class mainMenuHandler implements ActionListener{

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    		}
    		
    	}
        
        
}//End of class
