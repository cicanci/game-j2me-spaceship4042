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
public class cGameOver extends Canvas implements iScreen
{
    private Display display;
    private mMain main;
    private gGameDesign GD;
    private int iScore;
    private Timer timer;

    public cGameOver(mMain midlet, int score)
    {
        setFullScreenMode(true);
        display = midlet.getDisplay();
        display.setCurrent(this);
        main = midlet;
        GD = new gGameDesign();
        iScore = score;
        timer = new Timer();

        recordScore();
    }

    private void recordScore()
    {
        cScore score = new cScore(iScore);

        try
        {
            String data = score.readData(1);

            if (!data.equals(""))
            {
                int stored = Integer.parseInt(data);
                if (iScore > stored)
                {
                    score.writeData(1);
                }
            }
            else
            {
                score.writeData(1);
            }
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    protected void keyPressed(int keyCode)
    {
        //dismiss();
    }

    public void paint(Graphics g)
    {
        try
        {
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(0xffffff);
            g.drawString("SCORE: " + iScore, 0, 0, Graphics.TOP | Graphics.LEFT);

            g.setColor(0x000000);
            GD.getGameOver().setPosition(((getWidth() - GD.getGameover().getWidth()) / 2), ((getHeight() - GD.getGameover().getHeight()) / 2));
            GD.getGameOver().paint(g);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public static void access(cGameOver gameover)
    {
        gameover.dismiss();
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
