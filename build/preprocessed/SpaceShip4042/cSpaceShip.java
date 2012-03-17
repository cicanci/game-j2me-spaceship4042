/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cSpaceShip implements iSprite
{
    private Sprite sSpaceShip;
    private Vector vShoot;
    private int iX, iY, iAnima, iWidth, iHeight, iKeyState, iLife;
    private boolean bFire, bPower;

    public Sprite getSpaceShip()
    {
        return sSpaceShip;
    }

    public Vector getShoot()
    {
        return vShoot;
    }

    public void setKeyState(int iKeyState)
    {
        this.iKeyState = iKeyState;
    }

    public int getLife()
    {
        return iLife;
    }

    public void setLife(int iLife)
    {
        this.iLife = iLife;
    }

    public boolean isPower()
    {
        return bPower;
    }

    public cSpaceShip(int width, int height)
    {
        try
        {
            gGameDesign GD = new gGameDesign();
            sSpaceShip = GD.getSpaceShip01();

            vShoot = new Vector();
            iX = (width - sSpaceShip.getWidth()) / 2;
            iY = (height - sSpaceShip.getHeight()) / 2;
            iAnima = 0;
            iWidth = width;
            iHeight = height;
            iLife = 3;
            bFire = true;
            bPower = false;
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void draw(Graphics g)
    {
        for (int i = 0; i < vShoot.size(); i++)
        {
            if (((cShoot)vShoot.elementAt(i)).getY() >= 0)
            {
                ((cShoot)vShoot.elementAt(i)).draw(g);
            }
            else
            {
                vShoot.removeElementAt(i);
            }
        }

        sSpaceShip.setPosition(iX, iY);
        sSpaceShip.paint(g);
    }

    public void fire()
    {
        if (bFire)
        {
            if (bPower)
            {
                cShoot Shoot = new cShoot(sSpaceShip.getX() + 22, sSpaceShip.getY(), 1);
                vShoot.addElement(Shoot);
            }
            else
            {
                cShoot Shoot = new cShoot(sSpaceShip.getX() + 22, sSpaceShip.getY(), 2);
                vShoot.addElement(Shoot);
            }

            bFire = false;
        }
    }

    public void move()
    {
        sSpaceShip.setFrame(5 + iAnima);

        if ((iKeyState & 256) != 0) //FIRE
        {
            fire();
        }
        else
        {
            bFire = true;
        }
        if ((iKeyState & 2) != 0) //UP
        {
            iY = Math.max(0, iY - 15);            
        }
        if ((iKeyState & 64) != 0) //DOWN
        {
            iY = Math.min((iHeight - 60), iY + 15);
        }
        if ((iKeyState & 4) != 0) //LEFT
        {
            iX = Math.max(0, iX - 15);
            sSpaceShip.setFrame(0 + iAnima);
        }
        if ((iKeyState & 32) != 0) //RIGHT
        {
            iX = Math.min((iWidth - 45), iX + 15);
            sSpaceShip.setFrame(10 + iAnima);
        }

        if (iAnima >= 4)
        {
            iAnima = 0;
        }
        else
        {
            iAnima++;
        }
    }

    public void move (int x, int y)
    {
        iX = x;
        iY = y;
    }

    public void crash()
    {       
        if ((iKeyState & 2) != 0) //UP
        {
            sSpaceShip.setFrame(16);
        }
        else if ((iKeyState & 64) != 0) //DOWN
        {
            sSpaceShip.setFrame(16);
        }
        else if ((iKeyState & 4) != 0) //LEFT
        {
            sSpaceShip.setFrame(15);
        }
        else if ((iKeyState & 32) != 0) //RIGHT
        {
            sSpaceShip.setFrame(17);
        }
        else
        {
            sSpaceShip.setFrame(16);
        }
        
        if (bPower)
        {
            try
            {
                gGameDesign GD = new gGameDesign();
                this.sSpaceShip = GD.getSpaceShip01();
            }
            catch (Exception ex)
            {
                System.out.print(ex);
            }
            bPower = false;
        }
        else
        {
            iLife--;
        }
    }

    public void lifeItem()
    {
        iLife++;
    }

    public void powerItem()
    {
        try
        {
            gGameDesign GD = new gGameDesign();
            this.sSpaceShip = GD.getSpaceShip02();
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
        bPower = true;
    }
}
