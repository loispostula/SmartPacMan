/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

package lpostula.pacman;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lpostula.pacman.board.Point;
import lpostula.pacman.mobs.PacMan;

import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Path
 */
public class Path {
    private List<Integer> path;
    /**
     * The Node.
     */
    public Canvas node;
    private GraphicsContext gc;
    private int width;
    private int height;
    private double stepSize;
    private PacMan pac;

    /**
     * Instantiates a new Path.
     *
     * @param nX   the n x
     * @param nY   the n y
     * @param size the size
     * @param pac  the pac
     */
    public Path(int nX, int nY, double size, PacMan pac) {
        width = nX;
        height = nY;
        stepSize = size;
        node = new Canvas(width * stepSize, height * stepSize);
        gc = node.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        gc.setLineWidth(size * 0.2);
        gc.setStroke(pac.getColor());
        this.pac = pac;
        path = pac.getPath();
    }


    /**
     * Update void.
     *
     * @param skip the skip
     */
    public void update(int skip) {
        path = pac.getPath();
        gc.clearRect(0, 0, width * stepSize, height * stepSize);
        Point pos = pac.getPos();
        renderPath(pos.x, pos.y, skip);
    }

    /**
     * Render path.
     *
     * @param startX the start x
     * @param startY the start y
     * @param skip   the skip
     */
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
