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

package lpostula.gameengine;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Sprite
 */
public abstract class Sprite {
    /**
     * The Animations.
     */
    public List animations = new ArrayList<>();
    /**
     * The Node.
     */
    public Node node;
    /**
     * The V x.
     */
    public double vX;
    /**
     * The V y.
     */
    public double vY;
    /**
     * The Is dead.
     */
    public boolean isDead = false;

    /**
     * Update void.
     */
    public abstract void update();

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public abstract int getDirection();

    /**
     * Collide boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean collide(Sprite other) {
        return false;
    }


}
