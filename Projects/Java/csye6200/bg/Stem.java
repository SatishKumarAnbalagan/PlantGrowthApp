/**
* CSYE 6200 Assignment 5a
* Filename: Stem.java
* NUID: 001351994
* @author Satish Kumar Anbalagan
*/
package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class Stem {

	double X_startCordinate, Y_startCordinate,X_endCordinate, Y_endCordinate, Stemlength, Angle, diffAngle, nextGenLeftAngle, nextGenRightAngle ;
	int StemID;
	private ArrayList<Stem> Stemlist; // an Arraylist class

	public Stem(int StemID, double X_startCordinate, double Y_startCordinate, double Angle, double Stemlength) {
		this.StemID = StemID;
		this.X_startCordinate = X_startCordinate;
		this.Y_startCordinate = Y_startCordinate;
		this.Angle = Angle;
		this.Stemlength = Stemlength;
		Stemlist = new ArrayList<Stem>();
	}
	
	public void addChildStem(Stem s) {
		Stemlist.add(s);
	}
	
	public int getStemID() {
		return StemID;
	}

	public void setStemID(int stemID) {
		StemID = stemID;
	}

	public int getNumberofChildStem() {
		return Stemlist.size();
	}
	
	public double getX_startCordinate() {
		return X_startCordinate;
	}
	public double getStemlength() {
		return Stemlength;
	}

	public void setStemlength(double stemlength) {
		Stemlength = stemlength;
	}

	public void setX_startCordinate(double x_startCordinate) {
		X_startCordinate = x_startCordinate;
	}
	public double getY_startCordinate() {
		return Y_startCordinate;
	}
	public void setY_startCordinate(double y_startCordinate) {
		Y_startCordinate = y_startCordinate;
	}
	public double getX_endCordinate() {
		return X_endCordinate;
	}
	public void setX_endCordinate(double x_endCordinate) {
		X_endCordinate = x_endCordinate;
	}
	public double getY_endCordinate() {
		return Y_endCordinate;
	}
	public void setY_endCordinate(double y_endCordinate) {
		Y_endCordinate = y_endCordinate;
	}
	public double getAngle() {
		return Angle;
	}
	public void setAngle(double Angle) {
		this.Angle = Angle;
	}

	public double getNextGenLeftAngle() {
		return nextGenLeftAngle;
	}

	public void setNextGenLeftAngle(double nextGenLeftAngle) {
		this.nextGenLeftAngle = nextGenLeftAngle;
	}

	public double getNextGenRightAngle() {
		return nextGenRightAngle;
	}

	public void setNextGenRightAngle(double nextGenRightAngle) {
		this.nextGenRightAngle = nextGenRightAngle;
	}
	
	/**
	 * @return the diffAngle
	 */
	public double getDiffAngle() {
		return diffAngle;
	}

	/**
	 * @return the stemlist
	 */
	public ArrayList<Stem> getStemlist() {
		return Stemlist;
	}

	/**
	 * @param stemlist the stemlist to set
	 */
	public void setStemlist(ArrayList<Stem> stemlist) {
		Stemlist = stemlist;
	}

	/**
	 * @param diffAngle the diffAngle to set
	 */
	public void setDiffAngle(double diffAngle) {
		this.diffAngle = diffAngle;
	}

	@Override
	public String toString() {
		return "Stem [StemID =" + StemID +", X_startCordinate=" + X_startCordinate + ", Y_startCordinate=" + Y_startCordinate
				+ ", X_endCordinate=" + X_endCordinate + ", Y_endCordinate=" + Y_endCordinate + ", Stemlength="
				+ Stemlength + ", Angle=" + Angle + ", nextGenLeftAngle=" + nextGenLeftAngle + ", nextGenRightAngle="
				+ nextGenRightAngle;
	}
		
}
