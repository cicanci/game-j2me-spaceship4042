/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cHelp extends Canvas implements iScreen, CommandListener
{
    private Display display;
    private mMain main;
    private Sprite sHelp;

    private Command menuCommand = new Command("", Command.BACK, 1);
    private Command exitCommand = new Command("", Command.EXIT, 1);

    public cHelp(mMain midlet)
    {       
        setFullScreenMode(true);

        display = midlet.getDisplay();
        main = midlet;

        addCommand(menuCommand);
        addCommand(exitCommand);
        setCommandListener(this);
    }

    public void init()
    {
        try
        {
            gGameDesign GD = new gGameDesign();
            sHelp = GD.getHelpScreen01();
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void paint(Graphics g)
    {
        try
        {
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(0x000000);

            sHelp.setPosition(((getWidth() - sHelp.getWidth()) / 2), ((getHeight() - sHelp.getHeight()) / 2));
            sHelp.paint(g);

            g.setColor(0xffffff);
            g.drawString("MENU", 0, getHeight(), Graphics.BOTTOM | Graphics.LEFT);
            //g.drawString("EXIT", getWidth(), getHeight(), Graphics.BOTTOM | Graphics.RIGHT);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void commandAction(Command c, Displayable d)
    {
        if (c == exitCommand)
        {
            //main.destroyApp(true);
            display.setCurrent(main.getMenu());
        }
        else if (c == menuCommand)
        {
            display.setCurrent(main.getMenu());
        }
    }
}

