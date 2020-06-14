package edu.neu.csye6200.BGAppUI;

import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import edu.neu.csye6200.bg.BGrule;
import edu.neu.csye6200.bg.Stem;

/**
 * A sample canvas that draws a rainbow of lines
 * @author MMUNSON
 */
public class BGCanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(BGCanvas.class.getName());
    private int lineSize = 20;
    private Color col = null;
    private long counter = 0L;
	protected boolean growthStarted = false;
	private String ruleSelected = null;
	private int generation;
	//public static final Color VERY_LIGHT_RED = new Color(255,102,102);
	

	/**
     * CellAutCanvas constructor
     */
	public BGCanvas() {
		//col = Color.WHITE;
		col = new Color(153,102,0); //brown color
	}

	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
			log.info("Draw started");
			drawBG(g); // Our Added-on drawing
    }
	
	/**
	 * Draw the CA graphics panel
	 * @param g
	 */
	public void drawBG(Graphics g) {
		log.info("Drawing BG : " + counter++ + "ruleSelected : " + ruleSelected + "growthStarted : " + growthStarted);
		/*Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
		
		g2d.setColor(Color.RED);
		g2d.drawString("BG 2D", 10, 15);
		
		int maxRows = size.height / lineSize;
		int maxCols = size.width / lineSize;
		for (int j = 0; j < maxRows; j++) {
		   for (int i = 0; i < maxCols; i++) {
			   int redVal = validColor(i*5);
			   int greenVal = validColor(255-j*5);
			   int blueVal = validColor((j*5)-(i*2));
			   col = new Color(redVal, greenVal, blueVal);
			   // Draw box, one pixel less to create a black outline
			   int startx = i*lineSize;
			   int starty = j*lineSize;
			   int endx = startx + 15;
			   int endy = starty + 15;
			   paintLine( g2d, startx, starty, endx, endy, col); 
		   }
		}*/
		
		if (growthStarted) {
		
			Dimension size = getSize();
			
			g.setColor(col);
			
			if (getRuleSelected() == "Rule 1"){
				log.info("Rule 1 selected");
				Stem s = new Stem (1, size.width/2, size.height * 0.95, -90, 10);
				s.setDiffAngle(30);
				BGrule bgrule = new BGrule(s);
				bgrule.GenerateStem(g, getGeneration());
				for(Stem i : bgrule.getBaseStemlist()) {
					try {
						Thread.sleep(50L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        g.drawLine((int) i.getX_startCordinate(), (int) i.getY_startCordinate(), (int) i.getX_endCordinate(), (int) i.getY_endCordinate());
				}
			}  else if(getRuleSelected() == "Rule 2") {
				log.info("Rule 2 selected");
				Stem s = new Stem (1, size.width/2, size.height * 0.95, -90, 15);
				s.setDiffAngle(15);
				BGrule bgrule = new BGrule(s);
				bgrule.GenerateStem(g, getGeneration());
			}
			//System.out.println("Total number of Stems : " + bgrule.getI());
		}
	}
	
	/*
	 * A local routine to ensure that the color value is in the 0 to 255 range.
	 */
	private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
	

	/**
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		g2d.drawLine(startx, starty, endx, endy);
	}
	
	/**
	 * @param growthStarted the growthStarted to set
	 */
	public void setGrowthStarted(boolean growthStarted) {
		this.growthStarted = growthStarted;
	}


	/**
	 * @return the ruleSelected
	 */
	public String getRuleSelected() {
		return ruleSelected;
	}

	/**
	 * @param ruleSelected the ruleSelected to set
	 */
	public void setRuleSelected(String ruleSelected) {
		this.ruleSelected = ruleSelected;
	}

	/**
	 * @return the generation
	 */
	public int getGeneration() {
		return generation;
	}

	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	
	
}
