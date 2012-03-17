/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import java.io.*;
import javax.microedition.media.*;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cSound
{
    private Player player;
    private boolean bPlay;

    public cSound(boolean play)
    {
        bPlay = play;
    }

    public void Explosion()
    {
        PlayMusic("/explosion.wav");
    }

    public void Item()
    {
        PlayMusic("/scratch.wav");
    }
    
    public void Ploc()
    {
        PlayMusic("/cork_pop.wav");
    }

    private void PlayMusic(String file)
    {
        try
        {
            if (bPlay)
            {
                InputStream in = getClass().getResourceAsStream(file);
                player = Manager.createPlayer(in, "audio/x-wav");
                player.start();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    private void StopMusic()
    {
        try
        {
             player.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
