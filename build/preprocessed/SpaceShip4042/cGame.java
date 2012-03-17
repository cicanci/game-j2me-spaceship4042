/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cGame extends GameCanvas implements iScreen, Runnable, CommandListener
{
    private cSpaceShip SpaceShip;
    private cSound Sound;
    private cItem Item;
    private Sprite background;
    private Vector vMeteor;
    private int FRAME_RATE, METEOR_RATE, LIFE_ITEM_RATE, POWER_ITEM_RATE,
            iCount, iWidth, iHeight, iMeteor, SCORE, iScroll, iPosition, iLifeRate, iPowerRate;
    private boolean isPlay, isDifficult, isPotente;
    private mMain main;
    private Display display;

    private Command menuCommand = new Command("", Command.BACK, 1);
    private Command exitCommand = new Command("", Command.EXIT, 1);

    public cGame(mMain midlet)
    {
        super(true);
        setFullScreenMode(true);

        main = midlet;
        display = main.getDisplay();

        addCommand(menuCommand);
        addCommand(exitCommand);
        setCommandListener(this);
    }

    public void init()
    {
        try
        {
            iWidth = getWidth();
            iHeight = getHeight();

            if (iWidth >= 240)
            {
                isPotente = true;
            }
            else
            {
                isPotente = false;
            }
            
            SpaceShip = new cSpaceShip(iWidth, iHeight);            
            Item = new cItem(iWidth);
            Sound = new cSound(isPotente);

            vMeteor = new Vector();
            isPlay = false;
            isDifficult = false;
            FRAME_RATE = 100;
            METEOR_RATE = 15;
            LIFE_ITEM_RATE = 1000;
            POWER_ITEM_RATE = 1250;
            iCount = 0;
            iMeteor = 0;
            SCORE = 0;
            iScroll = 300;
            iPosition = 0;
            iLifeRate = 500;
            iPowerRate = 500;            
            
            if (isPotente)
            {
                gGameDesign GD = new gGameDesign();
                background = GD.getBackGround();
            }
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void start()
    {
        Thread t = new Thread(this);
        t.start();
        isPlay = true;
    }
    
    public void stop()
    {
        isPlay = false;
    }

    public void run()
    {
        while(isPlay)
        {
            try
            {
                generateMeteor();
                shootMeteor();
                move();                
                gameOver();                
                difficult();
                item();
                print();

                iCount++;
                iScroll += 1;

                Thread.sleep(FRAME_RATE);
            }
            catch (Exception ex)
            {
                System.out.print(ex);
            }
        }
    }

    private void setScore(int SCORE)
    {
        this.SCORE += SCORE;
        isDifficult = true;
    }

    private void difficult()
    {
        if ((isDifficult) && (SCORE != 0) && ((SCORE % 1000) == 0))
        {
            isDifficult = false;

            // Aumenta a frequencia de meteoros
            /*if (METEOR_RATE >= 1)
            {
                METEOR_RATE--;
            }*/

            // Aumenta a velocidade dos meteoros
            if (FRAME_RATE >= 1)
            {
                FRAME_RATE = FRAME_RATE / 2;
            }
        }
    }

    private void item()
    {
        if (!SpaceShip.isPower())
        {
            if (iLifeRate >= LIFE_ITEM_RATE)
            {
                iLifeRate = 0;
                Item.showLife();
            }
            else
            {
                iLifeRate++;
            }

            if (iPowerRate >= POWER_ITEM_RATE)
            {
                iPowerRate = 0;
                Item.showPower();
            }
            else
            {
                iPowerRate++;
            }
        }
    }

    private void move()
    {
        SpaceShip.setKeyState(getKeyStates());
        SpaceShip.move();

        if (collisionItem(SpaceShip.getSpaceShip()))
        {
            Sound.Item();
        }

        if (collisionMeteor(SpaceShip.getSpaceShip()))
        {
            if (SpaceShip.isPower())
            {
                FRAME_RATE = FRAME_RATE * 2;
            }
            SpaceShip.crash();
            Sound.Explosion();
        }

        if (isPotente)
        {
            if (iScroll >= (background.getHeight() + 300))
            {
                iScroll = 0;
            }
            else
            {
                iPosition = iScroll - background.getHeight();
            }
        }
    }

    private void print()
    {
        Graphics g = getGraphics();
        g.setColor(0x000000);
        g.fillRect(0, 0, getWidth(), getHeight());        

        if (isPotente)
        {
            background.setPosition(0, iPosition);
            background.paint(g);
        }

        SpaceShip.draw(g);
        
        for (int i = 0; i < vMeteor.size(); i++)
        {
            if (((cMeteor)vMeteor.elementAt(i)).getY() <= (iHeight + 150))
            {
                ((cMeteor)vMeteor.elementAt(i)).draw(g);
            }
            else
            {
                if (((cMeteor)vMeteor.elementAt(i)).getMeteor().isVisible())
                {
                    setScore(10);
                }
                vMeteor.removeElementAt(i);                
            }
        }

        Item.draw(g);

        g.setColor(0xffffff);
        g.drawString("SCORE: " + SCORE, 0, 0, Graphics.TOP | Graphics.LEFT);
        g.drawString("LIFE: " + SpaceShip.getLife(), getWidth(), 0, Graphics.TOP | Graphics.RIGHT);
        g.drawString("MENU", 0, getHeight(), Graphics.BOTTOM | Graphics.LEFT);
        //g.drawString("EXIT", getWidth(), getHeight(), Graphics.BOTTOM | Graphics.RIGHT);
        
        flushGraphics();
    }

    private void gameOver()
    {
        if (SpaceShip.getLife() <= 0)
        {
            isPlay = false;
            cGameOver gameover = new cGameOver(main, SCORE);
            display.setCurrent(gameover);
        }
    }

    private void generateMeteor()
    {
        if (iCount >= METEOR_RATE)
        {
            cMeteor Meteor = new cMeteor(iWidth, iMeteor);
            vMeteor.addElement(Meteor);
            iCount = 0;

            if (iMeteor >= 4)
            {
                iMeteor = 0;
            }
            else
            {
                iMeteor++;
            }
        }
    }

    private boolean collisionMeteor(Sprite srite)
    {
        for (int i = 0; i < vMeteor.size(); i++)
        {
            if ((((cMeteor)vMeteor.elementAt(i)).getMeteor().isVisible()) && 
                    (((cMeteor)vMeteor.elementAt(i)).getMeteor().collidesWith(srite, true)))
            {
                ((cMeteor)vMeteor.elementAt(i)).getMeteor().setVisible(false);
                return true;
            }
        }
        return false;
    }

    private boolean collisionItem(Sprite srite)
    {
        if ((Item.getLife().isVisible()) && (Item.getLife().collidesWith(srite, true)))
        {
            Item.hideLife();
            SpaceShip.lifeItem();
            return true;
        }
        if ((Item.getPower().isVisible()) && (Item.getPower().collidesWith(srite, true)))
        {
            Item.hidePower();
            SpaceShip.powerItem();
            // Aumenta a velocidade dos meteoros
            if (FRAME_RATE >= 1)
            {
                FRAME_RATE = FRAME_RATE / 2;
            }
            return true;
        }
        return false;
    }

    private void shootMeteor()
    {
        for (int i = 0; i < SpaceShip.getShoot().size(); i++)
        {
            if (shootMeteor(((cShoot)SpaceShip.getShoot().elementAt(i)).getShoot()))
            {
                ((cShoot)SpaceShip.getShoot().elementAt(i)).getShoot().setVisible(false);
            }
        }
    }

    private boolean shootMeteor(Sprite srite)
    {
        for (int i = 0; i < vMeteor.size(); i++)
        {
            if ((((cMeteor)vMeteor.elementAt(i)).getMeteor().isVisible()) &&
                    (((cMeteor)vMeteor.elementAt(i)).getMeteor().collidesWith(srite, true)))
            {
                if (SpaceShip.isPower())
                {
                    ((cMeteor)vMeteor.elementAt(i)).getMeteor().setVisible(false);
                    setScore(30);
                    Sound.Ploc();
                }
                else
                {
                    if (((cMeteor)vMeteor.elementAt(i)).getLife() <= 1)
                    {
                        ((cMeteor)vMeteor.elementAt(i)).getMeteor().setVisible(false);
                        setScore(30);
                        Sound.Ploc();
                    }
                    else
                    {
                        ((cMeteor)vMeteor.elementAt(i)).damage();
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void commandAction(Command c, Displayable d)
    {
        if (c == exitCommand)
        {
            display.setCurrent(main.getMenu());
        }
        else if (c == menuCommand)
        {
            display.setCurrent(main.getMenu());
        }
    }

    protected void pointerDragged(int x, int y)
    {
        SpaceShip.move(x - (SpaceShip.getSpaceShip().getWidth() / 2), y - (SpaceShip.getSpaceShip().getHeight() / 2));
    }

    protected void pointerPressed(int x, int y)
    {

    }

    protected void pointerReleased(int x, int y)
    {
        SpaceShip.fire();
    }
}

