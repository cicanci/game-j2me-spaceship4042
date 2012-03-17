package SpaceShip4042;

import java.util.TimerTask;

public class cCountDown extends TimerTask
{
    private final cSplash splash;
    private final cGameOver gameover;

    public cCountDown(cSplash splash)
    {
        this.splash = splash;
        gameover = null;
    }

    public cCountDown(cGameOver gameover)
    {
        this.gameover = gameover;
        splash = null;
    }

    public void run()
    {
        if (splash != null)
        {
            splash.access(splash);
        }
        else if (gameover != null)
        {
            gameover.access(gameover);
        }
    }
}