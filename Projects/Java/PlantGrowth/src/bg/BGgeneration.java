/**
* CSYE 6200 Assignment 5a
* Filename: BGgeneration.java
* NUID: 001351994
* @author Satish Kumar Anbalagan
*/
package edu.neu.csye6200.bg;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BGgeneration extends JFrame  {

	public BGgeneration(String BGgenernationName) {
        super(BGgenernationName);
        setBounds(100, 100, 1000, 1000);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
    	Stem s = new Stem (1, 500, 900, -90, 30);
        BGrule bgrule = new BGrule(s);
        bgrule.GenerateStem(g, 6);
        System.out.println("Total number of Stems : " + bgrule.getI());
    }
    
}
