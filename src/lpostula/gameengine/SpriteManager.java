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

import java.util.*;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe SpriteManager
 */
public class SpriteManager {
    private final static List GAME_ACTORS = new ArrayList<>();
    private final static List CHECK_COLLISION_LIST = new ArrayList<>();
    private final static Set CLEAN_UP_SPRITES = new HashSet<>();

    /**
     * Gets all sprites.
     *
     * @return the all sprites
     */
    public List<Sprite> getAllSprites() {
        return GAME_ACTORS;
    }

    /**
     * Add sprites.
     *
     * @param sprites the sprites
     */
    public void addSprites(Sprite... sprites) {
        GAME_ACTORS.addAll(Arrays.asList(sprites));
    }

    /**
     * Remove sprites.
     *
     * @param sprites the sprites
     */
    public void removeSprites(Sprite... sprites) {
        GAME_ACTORS.removeAll(Arrays.asList(sprites));
    }

    /**
     * Gets sprites to be removed.
     *
     * @return the sprites to be removed
     */
    public Set getSpritesToBeRemoved() {
        return CLEAN_UP_SPRITES;
    }

    /**
     * Add sprites to be removed.
     *
     * @param sprites the sprites
     */
    public void addSpritesToBeRemoved(Sprite... sprites) {
        if (sprites.length > 1) {
            CLEAN_UP_SPRITES.addAll(Arrays.asList((Sprite[]) sprites));
        } else CLEAN_UP_SPRITES.add(sprites[0]);
    }

    /**
     * Gets collisions to check.
     *
     * @return the collisions to check
     */
    public List<Sprite> getCollisionsToCheck() {
        return CHECK_COLLISION_LIST;
    }

    /**
     * Reset collisions to check.
     */
    public void resetCollisionsToCheck() {
        CHECK_COLLISION_LIST.clear();
        CHECK_COLLISION_LIST.addAll(GAME_ACTORS);
    }

    /**
     * Clean up sprites.
     */
    public void cleanUpSprites() {
        GAME_ACTORS.removeAll(CLEAN_UP_SPRITES);
        CLEAN_UP_SPRITES.clear();
    }
}
