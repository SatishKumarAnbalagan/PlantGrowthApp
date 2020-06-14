/**
* CSYE 6200 Assignment 5a
* Filename: BGgenerationTest.java
* NUID: 001351994
* @author Satish Kumar Anbalagan
*/
package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class BGgenerationTest {

	private ArrayList<BGgeneration> BGgenerationlist;

	public BGgenerationTest() {
		BGgenerationlist = new ArrayList <BGgeneration>(); 
	}
	
	public void run() {
    	BGgeneration BGgen = new BGgeneration ("BGgeneration");
    	BGgeneration BGgen1 = new BGgeneration ("BGgeneration 1");
    	BGgenerationlist.add(BGgen);
    	BGgenerationlist.add(BGgen1);
    	for(BGgeneration BGg : BGgenerationlist) {
    		BGg.setVisible(true);
    	}
	}

	public static void main(String[] args) {
		BGgenerationTest BGTest = new BGgenerationTest();
		BGTest.run();
	}

}
