/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import environment.Environment;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinlawrence
 * 
 */

class Space extends Environment {
   
    
    
       private Asteroid asteroid, twoAsteroid, lastAsteroid;
    Image ship;
    Image bigAsteroid;
    Velocity shipVelocity;
    Velocity asteroidVelocity;
    
    int shipX = 500;
    int shipY = 500;
    int angle = 0;
    int asteroidX = 100;
    int asteroidY = 100;
    int v1;
    int v2;
    
    public Space() {
        
        this.setBackground(new Color(0,0,50));
        shipVelocity = new Velocity(0, 0);
        asteroid = new Asteroid(v1, v2, 100, 100);
        asteroidVelocity = new Velocity(v1,v2); 
        String shipType = JOptionPane.showInputDialog("What ship US or USSR");
        ship = ResourceTools.loadImageFromResource("asteroids/" + shipType + " Ship.png");
        bigAsteroid = ResourceTools.loadImageFromResource("asteroids/Big Asteroid.png");
        v1 = (int) Math.random();
        v2 = (int) Math.random();
        System.out.println(v1);
        System.out.println(v2);
    }
    private double getAngleInRadians(){
        return Math.toRadians(angle);
    }
    
    @Override
    public void initializeEnvironment() {
    
    }

    @Override
    public void timerTaskHandler() {
        asteroidX += asteroidVelocity.x;
        asteroidY += asteroidVelocity.y;
        shipX += shipVelocity.x;
        shipY += shipVelocity.y;

        if (shipX < -5) {
            shipX = 895;  
        }
        if (shipX > 895) {
            shipX = -5;
        }
        if (shipY > 600) {
            shipY = -5;
        }
        if (shipY < -5) {
            shipY = 600;
        }                
        if (asteroidX < -5) {
            asteroidX = 895;  
        }
        if (asteroidX > 895) {
            asteroidX = -5;
        }
        if (asteroidY > 600) {
            asteroidY = -5;
        }
        if (asteroidY < -5) {
            asteroidY = 600;
        }         
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
                             
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            angle = (++angle % 360);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            angle = (--angle % 360);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            shipVelocity.y--;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            shipVelocity.y++;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            shipVelocity.x--;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            shipVelocity.x++;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            asteroidVelocity.x++;
            asteroidVelocity.y++;
        }
        
                    System.out.println(angle);

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
     public void paintEnvironment(Graphics graphics) {
         
//         if (asteroid != null) {
//            graphics.setColor(Color.black);
//            asteroid.draw(graphics);
//        }
         
        Graphics2D g2d = (Graphics2D) graphics;
        AffineTransform olde = g2d.getTransform();
        
        if (ship != null) {
//            graphics.drawImage(ship, 50, 500, 50, 80, this);
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle));
            at.setToRotation(getAngleInRadians(), shipX + (ship.getWidth(this)/ 2), shipY + (ship.getHeight(this) / 2));
            g2d.setTransform(at);
            g2d.drawImage(ship, shipX, shipY, this);
           
        }
        g2d.setTransform(olde);
        if (bigAsteroid != null) {
            
          
            g2d.drawImage(bigAsteroid, asteroidX, asteroidY, this);
          
        }
        g2d.dispose(); 
        
            
           
     }
     
    
     
    
}


