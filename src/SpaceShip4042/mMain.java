
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class mMain extends MIDlet
{
    private Display display;    
    private cSplash splash;
    private cMenu menu;
    private cGame game;
    private cHelp help;
    private cRanking ranking;
    private cAbout about;

    public Display getDisplay()
    {
        return display;
    }

    public cSplash getSplash()
    {
        return splash;
    }

    public cMenu getMenu()
    {
        game.stop();
        System.gc();
        return menu;
    }

    public cGame getGame()
    {
        return game;
    }

    public cAbout getAbout()
    {
        return about;
    }

    public cHelp getHelp()
    {
        return help;
    }

    public cRanking getRanking()
    {
        return ranking;
    }

    public mMain()
    {
        
    }

    public void startApp() 
    {
        try
        {
            display = Display.getDisplay(this);

            menu = new cMenu(this);            
            game = new cGame(this);
            help = new cHelp(this);
            about = new cAbout(this);
            ranking = new cRanking(this);
            splash = new cSplash(this);

            display.setCurrent(splash);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void pauseApp() 
    {
        
    }

    public void destroyApp(boolean unconditional) 
    {
        notifyDestroyed();
    }
}
