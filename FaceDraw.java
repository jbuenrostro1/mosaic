
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import java.awt.Graphics;
	import java.awt.Color;
	import java.util.ArrayList;
	import java.util.Random;
	
	/*
	 * Jazmin Buenrostro
	 * FaceDraw
	 * Credit: FaceDraw Lite, HelloGoodbye, ShapesLibrary, ShapesStep2
	 */ 
	

	
	class OvalShape extends Oval {
		private Boolean fillOvalBlue;
		public void setFillOvalBlue() { // setter
			fillOvalBlue = true;
		}
	
		//default constructor
		public OvalShape () {
			super(0,0,0,0); // default coordinates
			fillOvalBlue = false;
		}
	
		public OvalShape(int positionX, int positionY, int widthOval, int heightOval) {
			super(positionX, positionY, widthOval, heightOval);
			fillOvalBlue = false;
		}
	
		public void paintComponent(Graphics g) {
			g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
			if (fillOvalBlue) {
				g.setColor(Color.blue);
				g.fillOval(getPositionX() + 2 , getPositionY() + 2, getWidth() - 4, getHeight() - 4);
				g.setColor(Color.black);
	
			}
	
			System.out.format("OvalShape paint: x+%d, y+%d, w=%d, h=%d\n",
					getPositionX(), getPositionY(), getWidth(), getHeight());
		}
	}
	
	class RandomGen {
		public static int GenerateRandNumInclusive(int min, int max) {
			Random myRandomFace = new Random();
			return min + myRandomFace.nextInt(max-min + 1);
		}
	}
	
	
	class OvalFace extends OvalShape {
		private OvalShape eyeOne; // creating oval shape from eyes
		private OvalShape eyeTwo;
		//constructor method
		public OvalFace() {
			super(0,0,0,0); // default coordinates
			eyeOne = new OvalShape(0,0,0,0);
			eyeTwo = new OvalShape(0,0,0,0);
		}
	
		public OvalFace (int positionX, int positionY, int widthOval, int heightOval) {
			super(positionX, positionY, widthOval, heightOval);
	
			int heightOfEyeOne = heightOval / 9;
			int widthOfEyeOne = heightOfEyeOne * 2;
			int positionXOfEyeOne = positionX + (widthOval / 4) - (widthOfEyeOne / 2);
			int positionYOfEyeOne = positionY + (heightOval / 4) - (heightOfEyeOne / 2);
	
			int heightOfEyeTwo = heightOval / 9;
			int widthOfEyeTwo = heightOfEyeTwo * 2;
			int positionXOfEyeTwo = positionX + (widthOval / 2) - (widthOfEyeTwo / 4);
			int positionYOfEyeTwo = positionY + (heightOval / 4) - (heightOfEyeTwo / 4);
	
	
			eyeOne = new OvalShape(positionXOfEyeOne, positionYOfEyeOne, widthOfEyeOne, heightOfEyeOne);
			eyeTwo = new OvalShape(positionXOfEyeTwo, positionYOfEyeTwo, widthOfEyeTwo, heightOfEyeTwo);
			
	
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			eyeOne.paintComponent(g);
			eyeTwo.paintComponent(g);
	
			// draw mouth shapes
			//g.drawArc(getPositionx(), getPositionY() + (getHeight() / 2), getWidth() - 2, getHeight() - 130, 60, 60); // neutral face
			//g.drawArc(getPositionx(), getPositionY() + (getHeight() / 3), getWidth() - 40, getHeight() - 125, 180, 180); // smile face
			// g.drawArc(getPositionx(), getPositionY() + (getHeight() / 2), getWidth() - 10, getHeight() - 8, 43, 90); // frown face
			 
			 int randomSmileStatus = RandomGen.GenerateRandNumInclusive(1,3);
			 if (randomSmileStatus == 1) {
				 g.drawArc(getPositionX(), getPositionY() + (getHeight() / 2), getWidth() - 2, getHeight() - 130, 60, 60); 
			 } else if (randomSmileStatus == 2) {
				 g.drawArc(getPositionX(), getPositionY() + (getHeight() / 3), getWidth() - 40, getHeight() - 125, 180, 180);
			 } else {
				 g.drawArc(getPositionX(), getPositionY() + (getHeight() / 2), getWidth() - 10, getHeight() - 8, 43, 90); 
				 
			 }
	
		}
	}
	
	class OvalFacesPanel extends JPanel {
		private OvalFace myOvalFace;
		private OvalFace myOvalFace2;
		private OvalFace myOvalFace3;
		private OvalFace myOvalFace4;
		private OvalFace myOvalFace5;
		private OvalFace myOvalFace6;
		private OvalFace myOvalFace7;
		private OvalFace myOvalFace8;
		private OvalFace myOvalFace9;
		private OvalFace myOvalFace10;
	
		public OvalFacesPanel() {
			// create String variables
			 final String s;
			 final int positionX;
			 final int positionY;
			 final int Width;
			 final int Height;
			 final int smileStatus;
			 
		/*public String toString() {
				 return s;
		} */
			 

			
			myOvalFace = new OvalFace(80,80,80,150);
			myOvalFace2 = new OvalFace(200,200,100,160);
			myOvalFace3 = new OvalFace(300,300,120,170);
			myOvalFace4 = new OvalFace(250,400,100,140);
			myOvalFace5 = new OvalFace(60,200,160,190);
			myOvalFace6 = new OvalFace(100,400,100,140);
			myOvalFace7 = new OvalFace(140,70,170,190);
			myOvalFace8 = new OvalFace(220,500,150,200);
			myOvalFace9 = new OvalFace(350,400,160,180);
			myOvalFace10 = new OvalFace(400,350,230,200);
	
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // using paintComponent for lightweight drawing
	
			myOvalFace.paintComponent(g);
			myOvalFace2.paintComponent(g);
			myOvalFace3.paintComponent(g);
			myOvalFace4.paintComponent(g);
			myOvalFace5.paintComponent(g);
			myOvalFace6.paintComponent(g);
			myOvalFace7.paintComponent(g);
			myOvalFace8.paintComponent(g);
			myOvalFace9.paintComponent(g);
			myOvalFace10.paintComponent(g);
	
		}
	}
	
	
	public class FaceDraw {
	
		public static void main(String[] args) {
			System.out.println("Starting FaceDraw...");
	
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame myFrame = new JFrame("FaceDraw"); // shows window interface
			myFrame.setBounds(100, 100, 900, 500); // 900 wide, 500 tall
			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ArrayList<OvalFacesPanel> ovalFacesList = new ArrayList<OvalFacesPanel>();
			int randomOvalFace = RandomGen.GenerateRandNumInclusive(3,10);
			for (int i = 0; i < randomOvalFace; i++);
				ovalFacesList.add(new OvalFacesPanel());

			for (OvalFacesPanel ovalFaces : ovalFacesList) {
				System.out.println (ovalFaces);
			}
	
			OvalFacesPanel myOvalFacesPanel = new OvalFacesPanel();
			myFrame.add(myOvalFacesPanel);
			myFrame.setVisible(true);
	
		}
	}
	
	