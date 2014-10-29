/*
 * Copyright (c) 2014 kademika.com
 */
package temporary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class BattleFieldLastVersion extends JPanel {

	boolean COLORDED_MODE = true;
	
	int tankDirection = 1;
	
	int bulletX = -100;
	int bulletY = -100;
	
	int tankX = 0;
	int tankY = 0;
	
	int speed = 10;
	int bulletSpeed = 5;
	
	/**
	 * Write your code here.
	 */
	
	String[][] battleField = {
			{"B", "B", "B", "B", " ", "B", "B", "B", "B", },
			{"B", " ", " ", " ", " ", " ", " ", " ", "B", },
			{"B", " ", "B", " ", " ", " ", " ", " ", "B", },
			{"B", " ", " ", " ", " ", " ", "B", " ", "B", },
			{"B", " ", " ", " ", " ", " ", " ", " ", "B", },
			{"B", " ", "B", " ", " ", " ", " ", " ", "B", },
			{"B", " ", " ", " ", " ", " ", "B", " ", "B", },
			{"B", " ", " ", " ", " ", " ", " ", " ", "B", },
			{"B", "B", "B", "B", " ", "B", "B", "B", "B", },
	};
	
	
//My methods start------------------------------------------------------------------------
	
	void move(int direction) {
		int step = 1;
		int covered = 0;
		
		if ((direction == 1 && tankY == 0) || (direction == 2 && tankY >= 512)
			|| (direction == 3 && tankY == 0) || (direction == 4 && tankX >= 512)) {
			System.out.println("[illegal move] direction: " + direction + " tankX: " + tankX + ", tankY" + tankY);
			return;
		}
		
		turn(direction);
		
		while (covered < 64) {
		if (direction == 1){
			tankY -= step;
			System.out.println("[move up] direction: " + direction + " tankX: " + tankX + " tankY: " + tankY);
		} else if (direction == 2) {
			tankY += step;
			System.out.println("[move down] direction: " + direction + " tankX: " + tankX + " tankY: " + tankY);
		} else if (direction == 3) {
			tankX -= step;
			System.out.println("[move left] direction: " + direction + " tankX: " + tankX + " tankY: " + tankY);
		} else {
			tankX += step;
			System.out.println("[move right] direction: " + direction + " tankX: " + tankX + " tankY: " + tankY);
		}
		
		covered += step;
		
		repaint();
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	
	static String getQuadrantXY(int v, int h){		
		return (v -1 ) * 64 + "_" + (h - 1) * 64;
			
		}
	
	void moveToQuadrant(int v, int h){
		
		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));
		
		if (tankX < x){
			while (tankX != x){
				move(4);
			}
		} else {
			while (tankX != x){
				move(3);
			}
		}
		
		if (tankY < y) {
			while (tankY != y){
				move(2);
			}
		} else {
			while (tankY != y){
				move(1);
			}
		}		
		
	}
	
	void turn(int direction) {
		tankDirection = direction;
	}

//My methods finish-----------------------------------------------------------------------	
	
	void runTheGame() throws Exception {
	
		moveToQuadrant(1, 2);
		Thread.sleep(2000);
		moveToQuadrant(3, 3);
		Thread.sleep(2000);
		moveToQuadrant(1, 4);
		Thread.sleep(2000);
		moveToQuadrant(8, 8);
		Thread.sleep(2000);
		
		
		}
	

	
	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	
	public static void main(String[] args) throws Exception {
		BattleFieldLastVersion bf = new BattleFieldLastVersion();
		bf.runTheGame();
	}

	public BattleFieldLastVersion() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(500, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}
		
		g.setColor(new Color(255, 150, 150));
		g.fillRect(tankX, tankY, 64, 64);
	}
	

}