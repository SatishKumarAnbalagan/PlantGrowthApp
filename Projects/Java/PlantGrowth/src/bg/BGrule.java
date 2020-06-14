/**
* CSYE 6200 Assignment 5a
* Filename: BGrule.java
* NUID: 001351994
* @author Satish Kumar Anbalagan
*/
package edu.neu.csye6200.bg;

import java.awt.Graphics;
import java.util.ArrayList;


public class BGrule {
		Stem CurrentStem;
		private ArrayList<Stem> baseStemlist; // an Arraylist class
		int i = 0;
		
	    public BGrule(Stem s) {
	        this.CurrentStem  = s;
	        baseStemlist = new ArrayList<Stem>();
	    }
	
	    public void GenerateStem(Graphics g, int order) {
	    	
	    	if (order == 0) return;
	    	
	    	double X_endCordinate, Y_endCordinate;
	    	
	    	X_endCordinate = CurrentStem.getX_startCordinate() + (int) (Math.cos(Math.toRadians(CurrentStem.getAngle())) * CurrentStem.getStemlength() * order);
	        CurrentStem.setX_endCordinate(X_endCordinate);
	        
	        Y_endCordinate = CurrentStem.getY_startCordinate() + (int) (Math.sin(Math.toRadians(CurrentStem.getAngle())) * CurrentStem.getStemlength() * order);
	        CurrentStem.setY_endCordinate(Y_endCordinate);
	        
	        double nextGenDiffAngle = CurrentStem.getDiffAngle();
	        double nextGenLeftAngle = CurrentStem.getAngle() - nextGenDiffAngle;
	        double nextGenRightAngle = CurrentStem.getAngle() + nextGenDiffAngle;
	        
	        CurrentStem.setNextGenRightAngle(nextGenRightAngle);
	        CurrentStem.setNextGenRightAngle(nextGenRightAngle);
	        
	        baseStemlist.add(CurrentStem);

	        //g.drawLine((int) CurrentStem.getX_startCordinate(), (int) CurrentStem.getY_startCordinate(), (int) CurrentStem.getX_endCordinate(), (int) CurrentStem.getY_endCordinate());
	        i++;
	        
	        /*try {
	        	Thread.sleep(100L);
	        	System.out.println("Current stem details : " + CurrentStem);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        
	        Stem LeftChildStem = new Stem (i, X_endCordinate, Y_endCordinate,nextGenLeftAngle,CurrentStem.getStemlength() );
	        LeftChildStem.setStemID(i);
	        LeftChildStem.setDiffAngle(nextGenDiffAngle);
	        Stem RightChildStem = new Stem (i, X_endCordinate, Y_endCordinate,nextGenRightAngle,CurrentStem.getStemlength() );
	        RightChildStem.setStemID(i);
	        RightChildStem.setDiffAngle(nextGenDiffAngle);
	        
	        CurrentStem.addChildStem(LeftChildStem);
	        CurrentStem.addChildStem(RightChildStem);
	        
	        System.out.println("Current stem details : " + CurrentStem);
	        
	        setCurrentStem(LeftChildStem);
	        GenerateStem(g, order - 1);
	        
	        setCurrentStem(RightChildStem);
	        GenerateStem(g, order - 1);
	    }
	 
	    /**
		 * @return the baseStemlist
		 */
		public ArrayList<Stem> getBaseStemlist() {
			return baseStemlist;
		}

		/**
		 * @param baseStemlist the baseStemlist to set
		 */
		public void setBaseStemlist(ArrayList<Stem> baseStemlist) {
			this.baseStemlist = baseStemlist;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public Stem getCurrentStem() {
			return CurrentStem;
		}

		public void setCurrentStem(Stem currentStem) {
			CurrentStem = currentStem;
		}

	}
