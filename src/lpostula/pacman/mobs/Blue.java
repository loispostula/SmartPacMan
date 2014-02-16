package lpostula.pacman.mobs;

import javafx.scene.paint.Color;
import lpostula.pacman.board.Board;
import lpostula.pacman.board.RecursifSolutioner;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Red
 */
public class Blue extends Hunter {
    public Blue(Board board, PacMan pacman) {
        super(board, pacman);
        MOB_COLOR = Color.BLUE;
        SPEED_FACTOR = 10.0;
        constructNode();
    }

    @Override
    protected void computePath() {
        RecursifSolutioner solutioner = new RecursifSolutioner(board, position, target.getPos());
        path = solutioner.getPath();
    }
}
