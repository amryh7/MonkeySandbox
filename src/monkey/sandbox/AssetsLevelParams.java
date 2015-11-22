package monkey.sandbox;

import java.awt.Point;

public class AssetsLevelParams {
    
    static Point[] lbc;
    
    static Point[] Switch(int level){
        
        switch(level){
            case 1:
                lbc = LevelOneBananaCords.getLevelCords();
                break;
            case 2:
                lbc = LevelTwoBananaCords.getLevelCords();
                break;
            case 3:
                lbc = LevelThreeBananaCords.getLevelCords();
                break;
            case 4:
                lbc = LevelFourBananaCords.getLevelCords();
                break;
            case 5:
                lbc = LevelFiveBananaCords.getLevelCords();
                break;
        }
        return lbc;
    }
}