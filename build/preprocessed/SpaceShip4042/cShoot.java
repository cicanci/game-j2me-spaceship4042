/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cShoot implements iSprite
{
    private Sprite sShoot;
    private int iX, iY;

    public Sprite getShoot()
    {
        return sShoot;
    }

    public int getX()
    {
        return iX;
    }

    public int getY()
    {
        return iY;
    }

    public cShoot(int x, int y, int type)
    {
        iX = x;
        iY = y;

        try
        {
            gGameDesign GD = new gGameDesign();
            
            if (type == 2)
            {
                sShoot = GD.getShootYellow();
            }
            else
            {
                sShoot = GD.getShootBlue();
            }
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void draw(Graphics g)
    {
        sShoot.setPosition(iX, iY);
        sShoot.paint(g);

        move();
    }

    public void move()
    {
        iY -= 20;
    }
}