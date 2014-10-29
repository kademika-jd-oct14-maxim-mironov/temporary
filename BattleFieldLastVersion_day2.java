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



public class BattleFieldLastVersion_day2 extends JPanel {

	boolean COLORDED_MODE = true;
	
	int tankX = 0;
	int tankY = 0;
	
	long speed = 255;
	
	/**
	 * Write your code here.
	 */
	
	
	static void printCoordinates(String v, String h){
		String pixels = getQuadrant(v, h).replace("_", "px; ");
		pixels = v + h + ":" + "(" + pixels + "px" + ")";
		
		System.out.println(pixels);
		}
	
	void up (int upMove){
			if (tankY <= 64){
				System.out.println("Error. You can't move up");
			} else {
				tankY -= 64;
				System.out.println("Tank move up");
			}
	}
	
	void down (int downMove){
			if (tankY >= 512){
				System.out.println("Error. You can't move down");
			} else {
				tankY += 64;
				System.out.println("Tank move down");
			}
	}
	
	void left (int leftMove){
			if (tankX <= 64){
				System.out.println("Error. You can't move left");
			} else {
				tankX -= 64;
				System.out.println("Tank move left");
			}
	}
	
	void right (int rightMove){
			if (tankX >= 512){
				System.out.println("Error. You can't move right");
			} else {
				tankX += 64;
				System.out.println("Tank move right");
			}
	}	
	
	void move(int direction) {
		if (direction == 1){
		up(1);
		} else if (direction == 2) {
		down(2);	
		} else if (direction == 3) {
		left(3);
		} else if (direction == 4) {
		right(4);
		}
		
		
	}
	
	static String getQuadrant(String v, String h){
		int hor = Integer.valueOf(h);
		int vert = 1;
		
		if (v.equals("a")){
			vert = 1;
		} else if (v.equals("b")){
			vert = 2;
		} else if (v.equals("c")){
			vert = 3;
		} else if (v.equals("d")){
			vert = 4;
		} else if (v.equals("e")){
			vert = 5;
		} else if (v.equals("f")){
			vert = 6;
		} else if (v.equals("g")){
			vert = 7;
		} else if (v.equals("h")){
			vert = 8;
		} else if (v.equals("i")){
			vert = 9;
		}
		
		return (vert -1 ) * 64 + "_" + (hor - 1) * 64;
			
		}
	
	void moveRandom() throws InterruptedException{
		while (true){
			long time = System.currentTimeMillis();
			double timeNow = time % 15.9;
			int random = (int)timeNow;
			System.out.println(random);
			
			if (random < 2){
				up(1);
			} else if (random < 4 && random > 2){
				down(2);
			} else if (random < 6 && random > 4){
				left(3);
			} else if (random < 8 && random > 6){
				right(4);
			} else if (random < 10 && random > 8){
				up(1);
				up(1);
			} else if (random < 12 && random > 10){
				down(2);
				down(2);
			} else if (random < 14 && random > 12){
				left(3);
				left(3);
			} else if (random < 16 && random > 14){
				right(4);
				right(4);
			} 
			
			
			
			
			repaint();
			Thread.sleep(speed);
			}
			
			
		}
	
	void moveToQuadrant(String v, String h){
		
		String coordinates = getQuadrant(v, h);
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
	
	void runTheGame() throws Exception {
	
		moveToQuadrant("a", "1");
		repaint();
		Thread.sleep(speed);
		moveToQuadrant("g", "6");
		repaint();
		Thread.sleep(speed);
		moveToQuadrant("b", "4");
		repaint();
		Thread.sleep(speed);
		
		}
	
	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	
	public static void main(String[] args) throws Exception {
		BattleFieldLastVersion_day2 bf = new BattleFieldLastVersion_day2();
		bf.runTheGame();
	}

	public BattleFieldLastVersion_day2() throws Exception {
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