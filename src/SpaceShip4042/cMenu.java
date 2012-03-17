/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cMenu extends Canvas implements iScreen
{
    private Image play, exit, help, about, ranking,
            play_off, play_on, exit_off, exit_on,
            help_on, help_off, about_on, about_off,
            ranking_on, ranking_off;
    private int menu, width, height;
    private mMain main;
    private Display display;
    private Sprite sBackGround;

    public cMenu(mMain midlet)
    {
        try
        {
            CreateMenu();
            setFullScreenMode(true);
            main = midlet;
            display = midlet.getDisplay();
            menu = 0;
            width = (getWidth() - play.getWidth()) / 2;
            height = (getHeight() / 2);

            gGameDesign GD = new gGameDesign();
            sBackGround = GD.getBackGround();
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    public void paint(Graphics g)
    {
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0x000000);

        sBackGround.setPosition(0, 0);
        sBackGround.paint(g);

        g.drawImage(play, width, height - 90, 0);
        g.drawImage(ranking, width, height - 60, 0);
        g.drawImage(help, width, height - 30, 0);
        g.drawImage(about, width, height, 0);
        g.drawImage(exit, width, height + 30, 0);
    }

    protected void keyPressed(int keyCode)
    {
        int gameAction = getGameAction(keyCode);

        if (gameAction == FIRE)
        {
            switch(menu)
            {
                case 0:
                    main.getGame().init();
                    main.getGame().start();
                    display.setCurrent(main.getGame());
                    break;
                case 1:
                    main.getRanking().init();
                    display.setCurrent(main.getRanking());
                    break;
                case 2:
                    main.getHelp().init();
                    display.setCurrent(main.getHelp());
                    break;
                case 3:
                    main.getAbout().init();
                    display.setCurrent(main.getAbout());
                    break;
                case 4:
                    main.destroyApp(true);
                    break;
            }
        }

        if (gameAction == UP)
        {
            switch(menu)
            {
                case 0:
                    break;
                case 1:
                    play = play_on;
                    ranking = ranking_off;
                    menu = 0;
                    break;
                case  2:
                    ranking = ranking_on;
                    help = help_off;
                    menu = 1;
                    break;
                case 3:
                    help = help_on;
                    about = about_off;
                    menu = 2;
                    break;
                case 4:
                    about = about_on;
                    exit = exit_off;
                    menu = 3;
                    break;
            }
            repaint();
        }

        if (gameAction == DOWN)
        {
            switch(menu)
            {
                case 0:
                    play = play_off;
                    ranking = ranking_on;
                    menu = 1;
                    break;
                case 1:
                    ranking = ranking_off;
                    help = help_on;
                    menu = 2;
                    break;
                case 2:
                    help = help_off;
                    about = about_on;
                    menu = 3;
                    break;
                case 3:
                    about = about_off;
                    exit = exit_on;
                    menu = 4;
                    break;
                case 4:
                    break;
            }
            repaint();
        }
    }

    private void CreateMenu()
    {
        try
        {
            play_off = Image.createImage("/btn_play_off.png");
            play_on = Image.createImage("/btn_play_on.png");
            ranking_off = Image.createImage("/btn_ranking_off.png");
            ranking_on = Image.createImage("/btn_ranking_on.png");
            help_off = Image.createImage("/btn_help_off.png");
            help_on = Image.createImage("/btn_help_on.png");
            about_off = Image.createImage("/btn_about_off.png");
            about_on = Image.createImage("/btn_about_on.png");
            exit_off = Image.createImage("/btn_exit_off.png");
            exit_on = Image.createImage("/btn_exit_on.png");

            play = play_on;
            ranking = ranking_off;
            help = help_off;
            about = about_off;
            exit = exit_off;
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }
}

