/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author WyattCampbell
 */
public class Shooting {
    Image bullet;
       public void draw(Graphics graphics){
              bullet = ResourceTools.loadImageFromResource("asteroid/Bullet.png");
//              graphics.drawImage(bullet, shipX, shipY, null);
    }
}
