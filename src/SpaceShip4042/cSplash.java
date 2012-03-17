/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import java.util.Timer;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cSplash extends Canvas implements iScreen
{
    private Display display;
    private mMain main;
    private gGameDesign GD;
    private Timer timer;

    public cSplash(mMain midlet)
    {
        setFullScreenMode(true);
        display = midlet.getDisplay();
        display.setCurrent(this);
        main = midlet;
        GD = new gGameDesign();
        timer = new Timer();
    }

    protected void keyPressed(int keyCode)
    {
        dismiss();
    }

    protected void pointerPressed(int x, int y)
    {
        dismiss();
    }

    public void paint(Graphics g) 
    {
        try
        {
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(0x000000);

            if (getWidth() >= 240)
            {
                GD.getSplashScreen01().setPosition(0, 0);
                GD.getSplashScreen01().paint(g);
            }
            else
            {
                GD.getSplashScreen02().setPosition(0, 0);
                GD.getSplashScreen02().paint(g);
            }
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public static void access(cSplash splash)
    {
        splash.dismiss();
    }

    private void dismiss()
    {
        timer.cancel();
        display.setCurrent(main.getMenu());
    }

    protected void showNotify()
    {
        timer.schedule(new cCountDown(this), 3000);
    }
}

