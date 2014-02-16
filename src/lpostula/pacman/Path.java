package lpostula.pacman;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lpostula.pacman.board.Point;
import lpostula.pacman.mobs.Hunter;

import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Path
 */
public class Path {
    private List<Integer> path;
    public Canvas node;
    private GraphicsContext gc;
    private int width;
    private int height;
    private double stepSize;
    private Hunter mob;

    public Path(int nX, int nY, double size, Hunter mob) {
        width = nX;
        height = nY;
        stepSize = size;
        node = new Canvas(width * stepSize, height * stepSize);
        gc = node.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        gc.setLineWidth(size * 0.2);
        gc.setStroke(mob.getColor());
        this.mob = mob;
        path = mob.getPath();
    }

    public void update(int skip) {
        path = mob.getPath();
        gc.clearRect(0, 0, width * stepSize, height * stepSize);
        Point pos = mob.getInitPosForPath();
        renderPath(pos.x, pos.y, skip);
    }

    public void renderPath(int startX, int startY, int skip) {
        int x = startX;
        int y = startY;
        double add = stepSize / 2;
        for (int i = 0; i < path.size(); ++i) {
            switch (path.get(i)) {
                case -1:
                    break;
                case 0:
                    //up
                    if (i >= skip)
                        gc.strokeLine(x * stepSize + add, y * stepSize + add, x * stepSize + add, (y - 1) * stepSize + add);
                    --y;
                    break;
                case 1:
                    //left
                    if (i >= skip)
                        gc.strokeLine((x - 1) * stepSize + add, y * stepSize + add, (x) * stepSize + add, y * stepSize + add);
                    --x;
                    break;
                case 2:
                    //right
                    if (i >= skip)
                        gc.strokeLine((x) * stepSize + add, (y) * stepSize + add, (x + 1) * stepSize + add, (y) * stepSize + add);
                    ++x;
                    break;
                case 3:
                    //down
                    if (i >= skip)
                        gc.strokeLine((x) * stepSize + add, (y) * stepSize + add, (x) * stepSize + add, (y + 1) * stepSize + add);
                    ++y;

                    break;
            }
        }
    }


}
