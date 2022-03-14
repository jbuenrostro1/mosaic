import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

/*
 * Jazmin Buenrostro
 * Mosaic
 * Credit: ShapesLibrary
 */ 

	class MosaicTiles extends JPanel {
		private int red, blue, green, randLetter, randShape;
		private String[] alphabetArrayList = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		private String letters;
		
		public String getLetters() {
			return letters;
		}
	
		public void setRandLetters() {
			this.letters = letters;
		}
		
		public int getRandShape() {
			return randShape;
		}
		
		public void setRandShape() {
			this.randShape = randShape;
		}
		
		// constructor method
		MosaicTiles() {
			super();
			SetValueAtRandom();
		}
		
		final public void SetValueAtRandom() {
			red = GetInbetweenValue(0,255);
			blue = GetInbetweenValue(0,255);
			green = GetInbetweenValue(0,255);
			
			randLetter = GetInbetweenValue(0,25);
			letters = alphabetArrayList[randLetter];
			randShape = GetInbetweenValue(0,1);
			
		}
	
	public static int GetInbetweenValue(int min, int max) {
		Random myRandomValue = new Random();
		return min + myRandomValue.nextInt(max-min+1);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int widthOfPanel = getWidth();
		int heightOfPanel = getHeight();
		
		g.setColor(new Color(red, blue, green));
		
		/*if (GetInbetweenValue(0,1) == 1) {
		g.fillRect(5, 5, widthOfPanel-2, heightOfPanel-2);	
		} else { 
			g.fillOval(5, 5, widthOfPanel-5, heightOfPanel-5);*/
		if (randShape == 0) {
			g.fillRect(5, 5, widthOfPanel-2, heightOfPanel-2);
		} else {
			g.fillOval(5, 5, widthOfPanel-5, heightOfPanel-5);
		}
		g.setColor(new Color(GetOpposingColor(red), GetOpposingColor(blue), GetOpposingColor(green)));
		
		// get font
		final int sizeOfFont = 20;
		g.setFont(new Font("Times Roman", Font.PLAIN, sizeOfFont));
		int stringJ = (widthOfPanel) - 50;
		int stringK = (heightOfPanel) - 25;
		
		//g.drawString(String.valueOf(GetInbetweenValueTwo(65,90)), stringJ, stringK);
		g.drawString(letters, stringJ, stringK);
		System.out.println(toString());
	}

	
	public String toString() {
		String string;
		if (randShape == 0) {
			string = "Oval";
		} else {
			string = "Square";
			
		return String.format("Shape: " + string + "\nLetters: " + letters + "\nColor of shapes: " + red, blue, green);
		
		}
		return string;
	}
	
	public static int GetOpposingColor(int color) {
		return ((color+128)%256);
	}
	
}
	
	class MosaicFrame extends JFrame implements ActionListener {
		private ArrayList<MosaicTiles>tilesList;
		
		// constructor method
		public MosaicFrame() { // creating window on interface
			setBounds(500,500,1200,800);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container paneContents = getContentPane();
			paneContents.setLayout(new BorderLayout());
			
			JPanel buttonPanel = new JPanel();
			paneContents.add(buttonPanel, BorderLayout.SOUTH); //north, south, east, west; button is on the south of j panel
			
			JButton randomizeButton = new JButton ("Randomize");
			buttonPanel.add(randomizeButton);
			randomizeButton.addActionListener(this);
			
			JPanel mosaicGridPanel = new JPanel();
			paneContents.add(mosaicGridPanel, BorderLayout.CENTER);
			mosaicGridPanel.setLayout(new GridLayout(12,12));
			
			tilesList = new ArrayList<MosaicTiles>();
			for (int i = 0; i < 144; i++) {
				MosaicTiles tiles = new MosaicTiles();
				tilesList.add(tiles);
				mosaicGridPanel.add(tiles);
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			for (MosaicTiles tiles:tilesList) {
				tiles.SetValueAtRandom();
			}
			
			repaint();
			System.out.print("Start paint...");
		}	
		
	}
	
	
	public class Mosaic {
	
		public static void main(String[] args) {
			System.out.println("Starting Mosaic...");
			
			// display window on interface
			MosaicFrame myMosaicFrame = new MosaicFrame();
			myMosaicFrame.setVisible(true);		
	
		}
	}
