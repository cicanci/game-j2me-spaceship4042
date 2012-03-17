/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cMeteor implements iSprite
{
    private Sprite sMeteor;
    private int iX, iY, iLife, iWidth;

    public Sprite getMeteor()
    {
        return sMeteor;
    }

    public int getX()
    {
        return iX;
    }

    public int getY()
    {
        return iY;
    }

    public int getLife()
    {
        return iLife;
    }

    public cMeteor(int width, int meteor)
    {    
        try
        {
            gGameDesign GD = new gGameDesign();
            sMeteor = GD.getMeteor();
            sMeteor.setFrame(meteor);

            iWidth = width - sMeteor.getWidth();
            iY = -100;
            iLife = 3;
            iX = generateX();
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void draw(Graphics g)
    {
        sMeteor.setPosition(iX, iY);
        sMeteor.paint(g);

        move();
    }

    public void move()
    {
        iY += 10;
    }

    private int generateX()
    {
        Random r = new Random();
        return r.nextInt(iWidth);
    }

    public void damage()
    {
        iLife--;
    }
}
