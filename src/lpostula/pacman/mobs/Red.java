package lpostula.pacman.mobs;

import javafx.scene.paint.Color;
import lpostula.pacman.board.AStarSolutionner;
import lpostula.pacman.board.Board;

import java.util.ArrayList;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Red
 */
public class Red extends Hunter {
    AStarSolutionner solutionner;

    /**
     * Instantiates a new Red.
     *
     * @param board  the board
     * @param pacman the pacman
     */
    public Red(Board board, PacMan pacman) {
        super(board, pacman);
        MOB_COLOR = Color.RED;
        SPEED_FACTOR = 8.0;
        constructNode();
        solutionner = new AStarSolutionner(board);
        path = new ArrayList<Integer>();
    }

    @Override
    protected void computePath() {
        solutionner.setStart(getPosition().x, getPosition().y);
        solutionner.setEnd(target.getPos().x, target.getPos().y);
        solutionner.run();
        path = solutionner.getPath();
        //path = new ArrayList<>();
    }
}
