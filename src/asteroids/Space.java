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
    Image bullet;
    Image ship;
    Image bigAsteroid;
    Velocity shipVelocity;
    Velocity bulletVelocity;
    Velocity asteroidVelocity;
    Velocity asteroid2Velocity;
    Velocity asteroid3Velocity;
    
    public int shipX = 500;
    public int shipY = 500;
    public int bulletX = 500;
    public int bulletY = 500;
    int angle = 0;
    int asteroidX = 100;
    int asteroidY = 100;
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    
    public Space() {
        
        this.setBackground(new Color(0,0,50));
        bulletVelocity = new Velocity(0,0);
        shipVelocity = new Velocity(0, 0);
        asteroid = new Asteroid(x1, y1, x1, y1);
        asteroidVelocity = new Velocity(x1,y1); 
        asteroidVelocity.x = 2;
        asteroidVelocity.y = 2;
        String shipType = JOptionPane.showInputDialog("What ship US or USSR");
        ship = ResourceTools.loadImageFromResource("asteroids/" + shipType + " Ship Moving.png");
        bigAsteroid = ResourceTools.loadImageFromResource("asteroids/Big Asteroid.png");
        bullet = ResourceTools.loadImageFromResource("asteroids/Bullet.png");

        x1 = (int) (Math.random( )* 100);
        y1 = (int) (Math.random() * 100);
        x2 = (int) (Math.random( )* 100);
        y2 = (int) (Math.random() * 100);
        x3 = (int) (Math.random( )* 100);
        y3 = (int) (Math.random() * 100);        
        System.out.println(x1);
        System.out.println(y1);
        
    }
    private double getAngleInRadians(){
        return Math.toRadians(angle);
    }
    
    @Override
    public void initializeEnvironment() {
    
    }

    @Override
    public void timerTaskHandler() {
        x1 += asteroidVelocity.x;
        y1 += asteroidVelocity.y;
        x2 += asteroidVelocity.x;
        y2 += asteroidVelocity.y;
        x3 += asteroidVelocity.x;
        y3 += asteroidVelocity.y;
        shipX += shipVelocity.x;
        shipY += shipVelocity.y;
        bulletX += bulletVelocity.x;
        bulletY += bulletVelocity.y;
        if (bulletX < -5) {
            bulletX = shipX;
        }
        if (bulletX > 895) {
            bulletX = shipX;
        }
        if (bulletY < -5) {
            bulletY = shipX;
        }
        if (bulletY > 600) {
            bulletY = shipY;
        }

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
        if (x1 < -5) {
            x1 = 895;  
        }
        if (x1 > 895) {
            x1 = -5;
        }
        if (y1 > 600) {
            y1 = -5;
        }
        if (y1 < -5) {
            y1 = 600;
        }
        if (x2 < -5) {
            x2 = 895;  
        }
        if (x2 > 895) {
            x2 = -5;
        }
        if (y2 > 600) {
            y2 = -5;
        }
        if (y2 < -5) {
            y2 = 600;
        }
        if (x3 < -5) {
            x3 = 895;  
        }
        if (x3 > 895) {
            x3 = -5;
        }
        if (y3 > 600) {
            y3 = -5;
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
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bulletVelocity.y--;
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
        if (bullet != null) {
           AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle));
            at.setToRotation(getAngleInRadians(), shipX + (ship.getWidth(this)/ 2), shipY + (ship.getHeight(this) / 2));
            g2d.setTransform(at);
            g2d.drawImage(bullet, bulletX, bulletY, this);
        
        }
        g2d.setTransform(olde);
        
        
        if (ship != null) {
//            graphics.drawImage(ship, 50, 500, 50, 80, this);
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle));
            at.setToRotation(getAngleInRadians(), shipX + (ship.getWidth(this)/ 2), shipY + (ship.getHeight(this) / 2));
            g2d.setTransform(at);
            g2d.drawImage(ship, shipX, shipY, this);
           
        }
        g2d.setTransform(olde);
        if (bigAsteroid != null) {
            g2d.drawImage(bigAsteroid, x1, y1, this);
            g2d.drawImage(bigAsteroid, x2, y2, this);
            g2d.drawImage(bigAsteroid, x3, y3, this);
//          asteroidVelocity.x = 2;
//          asteroidVelocity.y = 2;
        }
        
        g2d.dispose(); 
    
     }
}


