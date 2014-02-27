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

package lpostula.pacman.mobs;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 17/02/14.
 * Documentation de la classe PowerBall
 */
public class PowerBall extends Sprite {
    private static final Color COLOR = Color.BLUE;
    private static final int POWERBALL_DIMENSION = 2;
    private double dimension;
    private Canvas canva;

    /**
     * Instantiates a new Power ball.
     *
     * @param size the size
     */
    public PowerBall(double size) {
        dimension = size;
        canva = new Canvas(dimension, dimension);
        double x = dimension / 2 - POWERBALL_DIMENSION / 2;
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillOval(x, x, POWERBALL_DIMENSION * 2, POWERBALL_DIMENSION * 2);
        node = canva;
    }

    @Override
    public void update() {

    }

    @Override
    public int getDirection() {
        return 0;
    }

    /**
     * Handle death.
     */
    public void handleDeath() {
        isDead = true;
        canva.setVisible(false);
    }

    /**
     * Is dead.
     *
     * @return the boolean
     */
    public boolean isDead() {
        return isDead;
    }
}
