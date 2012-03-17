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
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cRanking extends Canvas implements iScreen, CommandListener
{
    private Display display;
    private mMain main;
    private Sprite sRanking;
    private Font font;

    private Command menuCommand = new Command("", Command.BACK, 1);
    private Command exitCommand = new Command("", Command.EXIT, 1);

    public cRanking(mMain midlet)
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
            font = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);

            gGameDesign GD = new gGameDesign();
            sRanking = GD.getRankingScreen01();
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

            sRanking.setPosition(0, 0);
            sRanking.paint(g);

            g.setColor(0xffffff);
            g.drawString("MENU", 0, getHeight(), Graphics.BOTTOM | Graphics.LEFT);
            //g.drawString("EXIT", getWidth(), getHeight(), Graphics.BOTTOM | Graphics.RIGHT);

            g.setFont(font);
            g.drawString("" + getScore(1), 0, 50, Graphics.TOP | Graphics.LEFT);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    private String getScore(int position)
    {
        cScore score = new cScore();
        return score.readData(position);
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

