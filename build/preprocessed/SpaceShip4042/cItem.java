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
public class cItem implements iSprite
{
    private Sprite sLife, sPower;
    private int iX, iY, iWidth;

    public Sprite getLife()
    {
        return sLife;
    }

    public Sprite getPower()
    {
        return sPower;
    }

    public cItem(int width)
    {
        try
        {
            gGameDesign GD = new gGameDesign();
            sLife = GD.getLife();
            sLife.setVisible(false);
            sPower = GD.getPower();
            sPower.setVisible(false);

            iWidth = width - sLife.getWidth();
            iY = -100;
            iX = generateX();
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void draw(Graphics g)
    {
        if (sLife.isVisible())
        {
            sLife.setPosition(iX, iY);
            sLife.paint(g);
            move();
        }

        if (sPower.isVisible())
        {
            sPower.setPosition(iX, iY);
            sPower.paint(g);
            move();
        }
    }

    public void move()
    {
        iY += 15;
    }

    private int generateX()
    {
        Random r = new Random();
        return r.nextInt(iWidth);
    }

    public void showLife()
    {
        hidePower();
        sLife.setVisible(true);
        iY = -100;
        iX = generateX();
    }

    public void showPower()
    {
        hideLife();
        sPower.setVisible(true);
        iY = -100;
        iX = generateX();
    }

    public void hideLife()
    {
        sLife.setVisible(false);
    }

    public void hidePower()
    {
        sPower.setVisible(false);
    }
}
