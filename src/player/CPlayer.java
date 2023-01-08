package player;

import game.GamePlayer;
import java.awt.*;

public class CPlayer extends GamePlayer {

    public CPlayer(int mark) {
        super(mark);
    }

    @Override
    public boolean isUserPlayer() {
        return false;
    }

    @Override
    public String playerName() {
        return "C Server" ;
    }

    @Override
    public Point play(int[][] board) {
        return null;
    }

}
