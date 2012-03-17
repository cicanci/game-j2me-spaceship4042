/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author tit
 */
public class gGameDesign {

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image img_splash;
    private Image spaceship01;
    private Image shoot01;
    private Sprite ShootYellow;
    public int ShootYellowseq001Delay = 200;
    public int[] ShootYellowseq001 = {0};
    private Sprite SpaceShip01;
    public int SpaceShip01seq001Delay = 200;
    public int[] SpaceShip01seq001 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private Image meteor01;
    private Sprite Meteor;
    public int Meteorseq001Delay = 200;
    public int[] Meteorseq001 = {0, 1, 2, 3, 4};
    private Image splash02;
    private Sprite SplashScreen01;
    public int SplashScreen01seq001Delay = 200;
    public int[] SplashScreen01seq001 = {0};
    private Image splash01;
    private Image gameover;
    private Sprite GameOver;
    public int GameOverseq001Delay = 200;
    public int[] GameOverseq001 = {0};
    private Image background;
    private Sprite BackGround;
    public int BackGroundseq002Delay = 200;
    public int[] BackGroundseq002 = {0};
    private Sprite SplashScreen02;
    public int SplashScreen02seq001Delay = 200;
    public int[] SplashScreen02seq001 = {0};
    private Image about01;
    private Image help01;
    private Sprite HelpScreen01;
    public int HelpScreen01seq001Delay = 200;
    public int[] HelpScreen01seq001 = {0};
    private Sprite AboutScreen01;
    public int AboutScreen01seq001Delay = 200;
    public int[] AboutScreen01seq001 = {0};
    private Sprite RankingScreen01;
    public int RankingScreen01seq001Delay = 200;
    public int[] RankingScreen01seq001 = {0};
    private Image ranking01;
    private Image item_power;
    private Image item_life;
    private Sprite Life;
    public int Lifeseq001Delay = 200;
    public int[] Lifeseq001 = {0};
    private Image shoot02;
    private Sprite ShootBlue;
    public int ShootBlueseq001Delay = 200;
    public int[] ShootBlueseq001 = {0};
    private Sprite Power;
    public int Powerseq001Delay = 200;
    public int[] Powerseq001 = {0};
    private Image spaceship02;
    private Sprite SpaceShip02;
    public int SpaceShip02seq001Delay = 200;
    public int[] SpaceShip02seq001 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    //</editor-fold>//GEN-END:|fields|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    public Image getImg_splash() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (img_splash == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            img_splash = Image.createImage("/splash01.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here
        return this.img_splash;//GEN-BEGIN:|1-getter|2|
    }
//GEN-END:|1-getter|2|



    public Image getSpaceship01() throws java.io.IOException {//GEN-BEGIN:|4-getter|0|4-preInit
        if (spaceship01 == null) {//GEN-END:|4-getter|0|4-preInit
            // write pre-init user code here
            spaceship01 = Image.createImage("/spaceship01.png");//GEN-BEGIN:|4-getter|1|4-postInit
        }//GEN-END:|4-getter|1|4-postInit
        // write post-init user code here
        return this.spaceship01;//GEN-BEGIN:|4-getter|2|
    }
//GEN-END:|4-getter|2|



    public Image getShoot01() throws java.io.IOException {//GEN-BEGIN:|7-getter|0|7-preInit
        if (shoot01 == null) {//GEN-END:|7-getter|0|7-preInit
            // write pre-init user code here
            shoot01 = Image.createImage("/shoot01.png");//GEN-BEGIN:|7-getter|1|7-postInit
        }//GEN-END:|7-getter|1|7-postInit
        // write post-init user code here
        return this.shoot01;//GEN-BEGIN:|7-getter|2|
    }
//GEN-END:|7-getter|2|

    public Sprite getShootYellow() throws java.io.IOException {//GEN-BEGIN:|8-getter|0|8-preInit
        if (ShootYellow == null) {//GEN-END:|8-getter|0|8-preInit
            // write pre-init user code here
            ShootYellow = new Sprite(getShoot01(), 4, 12);//GEN-BEGIN:|8-getter|1|8-postInit
            ShootYellow.setFrameSequence(ShootYellowseq001);//GEN-END:|8-getter|1|8-postInit
            // write post-init user code here
        }//GEN-BEGIN:|8-getter|2|
        return ShootYellow;
    }
//GEN-END:|8-getter|2|

    public Sprite getSpaceShip01() throws java.io.IOException {//GEN-BEGIN:|10-getter|0|10-preInit
        if (SpaceShip01 == null) {//GEN-END:|10-getter|0|10-preInit
            // write pre-init user code here
            SpaceShip01 = new Sprite(getSpaceship01(), 45, 60);//GEN-BEGIN:|10-getter|1|10-postInit
            SpaceShip01.setFrameSequence(SpaceShip01seq001);//GEN-END:|10-getter|1|10-postInit
            // write post-init user code here
        }//GEN-BEGIN:|10-getter|2|
        return SpaceShip01;
    }
//GEN-END:|10-getter|2|

    public Image getMeteor01() throws java.io.IOException {//GEN-BEGIN:|12-getter|0|12-preInit
        if (meteor01 == null) {//GEN-END:|12-getter|0|12-preInit
            // write pre-init user code here
            meteor01 = Image.createImage("/meteor01.png");//GEN-BEGIN:|12-getter|1|12-postInit
        }//GEN-END:|12-getter|1|12-postInit
        // write post-init user code here
        return this.meteor01;//GEN-BEGIN:|12-getter|2|
    }
//GEN-END:|12-getter|2|

    public Sprite getMeteor() throws java.io.IOException {//GEN-BEGIN:|13-getter|0|13-preInit
        if (Meteor == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            Meteor = new Sprite(getMeteor01(), 80, 80);//GEN-BEGIN:|13-getter|1|13-postInit
            Meteor.setFrameSequence(Meteorseq001);//GEN-END:|13-getter|1|13-postInit
            // write post-init user code here
        }//GEN-BEGIN:|13-getter|2|
        return Meteor;
    }
//GEN-END:|13-getter|2|

    public Image getSplash02() throws java.io.IOException {//GEN-BEGIN:|15-getter|0|15-preInit
        if (splash02 == null) {//GEN-END:|15-getter|0|15-preInit
            // write pre-init user code here
            splash02 = Image.createImage("/splash02.png");//GEN-BEGIN:|15-getter|1|15-postInit
        }//GEN-END:|15-getter|1|15-postInit
        // write post-init user code here
        return this.splash02;//GEN-BEGIN:|15-getter|2|
    }
//GEN-END:|15-getter|2|



    public Image getSplash01() throws java.io.IOException {//GEN-BEGIN:|18-getter|0|18-preInit
        if (splash01 == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            splash01 = Image.createImage("/splash01.png");//GEN-BEGIN:|18-getter|1|18-postInit
        }//GEN-END:|18-getter|1|18-postInit
        // write post-init user code here
        return this.splash01;//GEN-BEGIN:|18-getter|2|
    }
//GEN-END:|18-getter|2|

    public Sprite getSplashScreen01() throws java.io.IOException {//GEN-BEGIN:|19-getter|0|19-preInit
        if (SplashScreen01 == null) {//GEN-END:|19-getter|0|19-preInit
            // write pre-init user code here
            SplashScreen01 = new Sprite(getSplash01(), 240, 320);//GEN-BEGIN:|19-getter|1|19-postInit
            SplashScreen01.setFrameSequence(SplashScreen01seq001);//GEN-END:|19-getter|1|19-postInit
            // write post-init user code here
        }//GEN-BEGIN:|19-getter|2|
        return SplashScreen01;
    }
//GEN-END:|19-getter|2|

    public Image getGameover() throws java.io.IOException {//GEN-BEGIN:|21-getter|0|21-preInit
        if (gameover == null) {//GEN-END:|21-getter|0|21-preInit
            // write pre-init user code here
            gameover = Image.createImage("/gameover.png");//GEN-BEGIN:|21-getter|1|21-postInit
        }//GEN-END:|21-getter|1|21-postInit
        // write post-init user code here
        return this.gameover;//GEN-BEGIN:|21-getter|2|
    }
//GEN-END:|21-getter|2|

    public Sprite getGameOver() throws java.io.IOException {//GEN-BEGIN:|22-getter|0|22-preInit
        if (GameOver == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            GameOver = new Sprite(getGameover(), 120, 60);//GEN-BEGIN:|22-getter|1|22-postInit
            GameOver.setFrameSequence(GameOverseq001);//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return GameOver;
    }
//GEN-END:|22-getter|2|

    public Image getBackground() throws java.io.IOException {//GEN-BEGIN:|24-getter|0|24-preInit
        if (background == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            background = Image.createImage("/background.png");//GEN-BEGIN:|24-getter|1|24-postInit
        }//GEN-END:|24-getter|1|24-postInit
        // write post-init user code here
        return this.background;//GEN-BEGIN:|24-getter|2|
    }
//GEN-END:|24-getter|2|



    public Sprite getBackGround() throws java.io.IOException {//GEN-BEGIN:|27-getter|0|27-preInit
        if (BackGround == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            BackGround = new Sprite(getBackground(), 240, 1250);//GEN-BEGIN:|27-getter|1|27-postInit
            BackGround.setFrameSequence(BackGroundseq002);//GEN-END:|27-getter|1|27-postInit
            // write post-init user code here
        }//GEN-BEGIN:|27-getter|2|
        return BackGround;
    }
//GEN-END:|27-getter|2|

    public Sprite getSplashScreen02() throws java.io.IOException {//GEN-BEGIN:|29-getter|0|29-preInit
        if (SplashScreen02 == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            SplashScreen02 = new Sprite(getSplash02(), 176, 235);//GEN-BEGIN:|29-getter|1|29-postInit
            SplashScreen02.setFrameSequence(SplashScreen02seq001);//GEN-END:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return SplashScreen02;
    }
//GEN-END:|29-getter|2|

    public Image getAbout01() throws java.io.IOException {//GEN-BEGIN:|31-getter|0|31-preInit
        if (about01 == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            about01 = Image.createImage("/about01.png");//GEN-BEGIN:|31-getter|1|31-postInit
        }//GEN-END:|31-getter|1|31-postInit
        // write post-init user code here
        return this.about01;//GEN-BEGIN:|31-getter|2|
    }
//GEN-END:|31-getter|2|

    public Sprite getAboutScreen01() throws java.io.IOException {//GEN-BEGIN:|32-getter|0|32-preInit
        if (AboutScreen01 == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            AboutScreen01 = new Sprite(getAbout01(), 176, 220);//GEN-BEGIN:|32-getter|1|32-postInit
            AboutScreen01.setFrameSequence(AboutScreen01seq001);//GEN-END:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return AboutScreen01;
    }
//GEN-END:|32-getter|2|

    public Image getHelp01() throws java.io.IOException {//GEN-BEGIN:|34-getter|0|34-preInit
        if (help01 == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            help01 = Image.createImage("/help01.png");//GEN-BEGIN:|34-getter|1|34-postInit
        }//GEN-END:|34-getter|1|34-postInit
        // write post-init user code here
        return this.help01;//GEN-BEGIN:|34-getter|2|
    }
//GEN-END:|34-getter|2|

    public Sprite getHelpScreen01() throws java.io.IOException {//GEN-BEGIN:|35-getter|0|35-preInit
        if (HelpScreen01 == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
            HelpScreen01 = new Sprite(getHelp01(), 176, 220);//GEN-BEGIN:|35-getter|1|35-postInit
            HelpScreen01.setFrameSequence(HelpScreen01seq001);//GEN-END:|35-getter|1|35-postInit
            // write post-init user code here
        }//GEN-BEGIN:|35-getter|2|
        return HelpScreen01;
    }
//GEN-END:|35-getter|2|

    public Image getRanking01() throws java.io.IOException {//GEN-BEGIN:|37-getter|0|37-preInit
        if (ranking01 == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
            ranking01 = Image.createImage("/ranking01.png");//GEN-BEGIN:|37-getter|1|37-postInit
        }//GEN-END:|37-getter|1|37-postInit
        // write post-init user code here
        return this.ranking01;//GEN-BEGIN:|37-getter|2|
    }
//GEN-END:|37-getter|2|

    public Sprite getRankingScreen01() throws java.io.IOException {//GEN-BEGIN:|38-getter|0|38-preInit
        if (RankingScreen01 == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            RankingScreen01 = new Sprite(getRanking01(), 176, 220);//GEN-BEGIN:|38-getter|1|38-postInit
            RankingScreen01.setFrameSequence(RankingScreen01seq001);//GEN-END:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return RankingScreen01;
    }
//GEN-END:|38-getter|2|

    public Image getItem_life() throws java.io.IOException {//GEN-BEGIN:|40-getter|0|40-preInit
        if (item_life == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            item_life = Image.createImage("/item_life.png");//GEN-BEGIN:|40-getter|1|40-postInit
        }//GEN-END:|40-getter|1|40-postInit
        // write post-init user code here
        return this.item_life;//GEN-BEGIN:|40-getter|2|
    }
//GEN-END:|40-getter|2|

    public Sprite getLife() throws java.io.IOException {//GEN-BEGIN:|41-getter|0|41-preInit
        if (Life == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            Life = new Sprite(getItem_life(), 50, 50);//GEN-BEGIN:|41-getter|1|41-postInit
            Life.setFrameSequence(Lifeseq001);//GEN-END:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return Life;
    }
//GEN-END:|41-getter|2|

    public Image getItem_power() throws java.io.IOException {//GEN-BEGIN:|43-getter|0|43-preInit
        if (item_power == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            item_power = Image.createImage("/item_power.png");//GEN-BEGIN:|43-getter|1|43-postInit
        }//GEN-END:|43-getter|1|43-postInit
        // write post-init user code here
        return this.item_power;//GEN-BEGIN:|43-getter|2|
    }
//GEN-END:|43-getter|2|

    public Sprite getPower() throws java.io.IOException {//GEN-BEGIN:|44-getter|0|44-preInit
        if (Power == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            Power = new Sprite(getItem_power(), 50, 50);//GEN-BEGIN:|44-getter|1|44-postInit
            Power.setFrameSequence(Powerseq001);//GEN-END:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return Power;
    }
//GEN-END:|44-getter|2|

    public Image getShoot02() throws java.io.IOException {//GEN-BEGIN:|46-getter|0|46-preInit
        if (shoot02 == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            shoot02 = Image.createImage("/shoot02.png");//GEN-BEGIN:|46-getter|1|46-postInit
        }//GEN-END:|46-getter|1|46-postInit
        // write post-init user code here
        return this.shoot02;//GEN-BEGIN:|46-getter|2|
    }
//GEN-END:|46-getter|2|

    public Sprite getShootBlue() throws java.io.IOException {//GEN-BEGIN:|47-getter|0|47-preInit
        if (ShootBlue == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            ShootBlue = new Sprite(getShoot02(), 4, 12);//GEN-BEGIN:|47-getter|1|47-postInit
            ShootBlue.setFrameSequence(ShootBlueseq001);//GEN-END:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return ShootBlue;
    }
//GEN-END:|47-getter|2|

    public Image getSpaceship02() throws java.io.IOException {//GEN-BEGIN:|49-getter|0|49-preInit
        if (spaceship02 == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            spaceship02 = Image.createImage("/spaceship02.png");//GEN-BEGIN:|49-getter|1|49-postInit
        }//GEN-END:|49-getter|1|49-postInit
        // write post-init user code here
        return this.spaceship02;//GEN-BEGIN:|49-getter|2|
    }
//GEN-END:|49-getter|2|

    public Sprite getSpaceShip02() throws java.io.IOException {//GEN-BEGIN:|50-getter|0|50-preInit
        if (SpaceShip02 == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            SpaceShip02 = new Sprite(getSpaceship02(), 70, 60);//GEN-BEGIN:|50-getter|1|50-postInit
            SpaceShip02.setFrameSequence(SpaceShip02seq001);//GEN-END:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return SpaceShip02;
    }
//GEN-END:|50-getter|2|

}
