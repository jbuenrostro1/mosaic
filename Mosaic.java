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

	// mosaic circle and square class to implement them in interface
	class MosaicCircle extends Circle {
		public MosaicCircle() {
			super();
		}
	}

	class MosaicSquare extends Rectangle {
		public MosaicSquare() {
			super();
		}
	}

	class MosaicShapes extends JPanel {
		private MosaicCircle circle;
		private MosaicSquare square;
		private int red, blue, green;
		private String alphabet;
		
		// constructor method
		MosaicShapes() {
			super();
			SetValueAtRandom();
		}
		
		final public void SetValueAtRandom() {
			red = GetInbetweenValue(0,255);
			blue = GetInbetweenValue(0,255);
			green = GetInbetweenValue(0,255);
			
			alphabet = "A";
			if (GetInbetweenValue(1,26) == 2) {
				alphabet = "B";
			} else if (GetInbetweenValue(1,26) == 3){
				alphabet = "C";
			} else if (GetInbetweenValue(1,26) == 4){
				alphabet = "D";
			} else if (GetInbetweenValue(1,26) == 5){
				alphabet = "E";
			} else if (GetInbetweenValue(1,26) == 6){
				alphabet = "F";
			} else if (GetInbetweenValue(1,26) == 7){
				alphabet = "G";
			} else if (GetInbetweenValue(1,26) == 8){
				alphabet = "H";
			} else if (GetInbetweenValue(1,26) == 9){
				alphabet = "I";
			} else if (GetInbetweenValue(1,26) == 10){
				alphabet = "J";
			} else if (GetInbetweenValue(1,26) == 11){
				alphabet = "K";
			} else if (GetInbetweenValue(1,26) == 12){
				alphabet = "L";
			} else if (GetInbetweenValue(1,26) == 13){
				alphabet = "M";
			} else if (GetInbetweenValue(1,26) == 14){
				alphabet = "N";
			} else if (GetInbetweenValue(1,26) == 15){
				alphabet = "O";
			} else if (GetInbetweenValue(1,26) == 16){
				alphabet = "P";
			} else if (GetInbetweenValue(1,26) == 17){
				alphabet = "Q";
			} else if (GetInbetweenValue(1,26) == 18){
				alphabet = "R";
			} else if (GetInbetweenValue(1,26) == 19){
				alphabet = "S";
			} else if (GetInbetweenValue(1,26) == 20){
				alphabet = "T";
			} else if (GetInbetweenValue(1,26) == 21){
				alphabet = "U";
			} else if (GetInbetweenValue(1,26) == 22){
				alphabet = "V";
			} else if (GetInbetweenValue(1,26) == 23){
				alphabet = "W";
			} else if (GetInbetweenValue(1,26) == 24){
				alphabet = "X";
			} else if (GetInbetweenValue(1,26) == 25){
				alphabet = "Y";
			} else if (GetInbetweenValue(1,26) == 26){
				alphabet = "Z";
				
				}
			
			}
	
	public static int GetInbetweenValue(int min, int max) {
		Random myRandomValue = new Random();
		return min + myRandomValue.nextInt(max-min+1);
	}
	
	public static char GetInbetweenValueTwo(int min, int max) {
		Random myRandomValue = new Random();
		return (char)(min + myRandomValue.nextInt(max-min+1));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int widthOfPanel = getWidth();
		int heightOfPanel = getHeight();
		
		g.setColor(new Color(red, blue, green));
		
		if (GetInbetweenValue(0,1) == 1) {
			g.fillRect(5, 5, widthOfPanel-2, heightOfPanel-2);
			//g.fillOval(5, 5, widthOfPanel-5, heightOfPanel-5);
		} else {
			g.fillOval(5, 5, widthOfPanel-5, heightOfPanel-5);
			//g.fillRect(10, 10, widthOfPanel-2, heightOfPanel-2);
		
		g.setColor(new Color(GetOpposingColor(red), GetOpposingColor(blue), GetOpposingColor(green)));
		
		// get font
		final int sizeOfFont = 20;
		g.setFont(new Font("Times Roman", Font.PLAIN, sizeOfFont));
		int stringJ = (widthOfPanel) - 50;
		int stringK = (heightOfPanel) - 25;
		
		//g.drawString(String.valueOf(GetInbetweenValueTwo(65,90)), stringJ, stringK);
		g.drawString(alphabet, stringJ, stringK);
	}
}
	
	public static int GetOpposingColor(int color) {
		return ((color+128)%256);
	}
	
}
	
	class MosaicFrame extends JFrame implements ActionListener {
		private ArrayList<MosaicShapes>shapesList;
		
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
			
			shapesList = new ArrayList<MosaicShapes>();
			for (int i = 1; i < 144; i++) {
				MosaicShapes shapes = new MosaicShapes();
				shapesList.add(shapes);
				mosaicGridPanel.add(shapes);
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			for (MosaicShapes shapes:shapesList) {
				shapes.SetValueAtRandom();
			}
			
			repaint();
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
