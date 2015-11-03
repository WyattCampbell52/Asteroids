/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assteroids;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author WyattCampbell
 */
public class Background {
                public void draw(Graphics graphics){
           int xs;
           int widths;
           int ys;
           int heights;
           xs = 300;
           widths = 500;
           heights = 500;
           ys = 300;
           graphics.setColor(Color.white);
                       int[] xPoints = new int[10];
              xPoints[0] = xs + (widths * 90/160);
              xPoints[1] = xs + (widths * 100/160);
              xPoints[2] = xs + (widths * 110/160);
              xPoints[3] = xs + (widths * 100/160);
              xPoints[4] = xs + (widths * 110/160);
              xPoints[5] = xs + (widths * 90/160);
              xPoints[6] = xs + (widths * 75/160);
              xPoints[7] = xs + (widths * 80/160);
              xPoints[8] = xs + (widths * 70/160);
              xPoints[9] = xs + (widths * 80/160); 
              int[] yPoints = new int[10];
              yPoints[0] = ys + (heights * 120 / 720);
              yPoints[1] = ys + (heights * 170 / 720);
              yPoints[2] = ys + (heights * 190 / 720);
              yPoints[3] = ys + (heights * 210 / 720);
              yPoints[4] = ys + (heights * 280 / 720);
              yPoints[5] = ys + (heights * 220 / 720);
              yPoints[6] = ys + (heights * 280 / 720);
              yPoints[7] = ys + (heights * 210 / 720);
              yPoints[8] = ys + (heights * 190 / 720);
              yPoints[9] = ys + (heights * 170 / 720);       
              graphics.fillPolygon(xPoints, yPoints, 10);                     
                }

}
