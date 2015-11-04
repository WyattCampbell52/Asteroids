/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author WyattCampbell
 */
public class Asteroid {
        public void draw(Graphics graphics){
            
            graphics.drawRect(getX(), getY(), getHeight(), getWidth());
            graphics.setColor(Color.white);            
             int[] xPoints = new int[13];
        xPoints[0] = getX() + (getWidth() * 8/16);
        xPoints[1] = getX() + (getWidth() * 6/16);
        xPoints[2] = getX() + (getWidth() * 4/16);
        xPoints[3] = getX() + (getWidth() * 2/16);
        xPoints[4] = getX();
        xPoints[5] = getX() + (getWidth() * 1/16);
        xPoints[6] = getX() + (getWidth() * 4/16);
        xPoints[7] = getX() + (getWidth() * 7/16);
        xPoints[8] = getX() + (getWidth() * 10/16);
        xPoints[9] = getX() + (getWidth() * 13/16);
        xPoints[10] = getX() + getWidth();
        xPoints[11] = getX() + (getWidth() * 12/16);
        xPoints[12] = getX() + (getWidth() * 10/16);

        int[] yPoints = new int[13];
        yPoints[0] = getY();
        yPoints[1] = getY() + (getHeight() * 1/16);
        yPoints[2] = getY() + (getHeight() * 4/16);
        yPoints[3] = getY() + (getHeight() * 7/16);
        yPoints[4] = getY() + (getHeight() * 10/16);
        yPoints[5] = getY() + (getHeight() * 13/16);
        yPoints[6] = getY() + getHeight();
        yPoints[7] = getY() + (getHeight() * 14/16);
        yPoints[8] = getY() + (getHeight() * 12/16);
        yPoints[9] = getY() + (getHeight() * 8/16);
        yPoints[10] = getY() + (getHeight() * 6/16);
        yPoints[11] = getY() + (getHeight() * 3/16);
        yPoints[12] = getY();
            
            
            graphics.fillPolygon(xPoints, yPoints, 13);
            
        }
        
         public Asteroid(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;        
    }
    
    int x;
    int y;
    int height;
    int width;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    

  
    
}


