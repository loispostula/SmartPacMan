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

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe GameWorld
 */
public abstract class GameWorld {
    private Scene gameSurface;
    private Group sceneNodes;
    private static Timeline gameLoop;
    private final int framesPerSecond;
    private final String windowTitle;
    private final SpriteManager spriteManager = new SpriteManager();

    /**
     * Instantiates a new Game world.
     *
     * @param fps   the fps
     * @param title the title
     */
    public GameWorld(final int fps, final String title) {
        framesPerSecond = fps;
        windowTitle = title;
        buildAndSetGameLoop();
    }

    /**
     * Build and set game loop.
     */
    protected final void buildAndSetGameLoop() {

        final Duration oneFrameAmt = Duration.millis(1000 / getFramesPerSecond());
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt,
                new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        // check for collision
                        checkCollisions();
                        // update actors
                        updateSprites();
                        // removed dead things
                        cleanupSprites();
                        // update path
                        updatePath();
                    }
                }); // oneFrame
        // sets the game world's game loop (Timeline)
        setGameLoop(TimelineBuilder.create()
                .cycleCount(Animation.INDEFINITE)
                .keyFrames(oneFrame)
                .build());
    }

    /**
     * Initialize void.
     *
     * @param primaryStage the primary stage
     */
    public abstract void initialize(final Stage primaryStage);

    /**
     * Update path.
     */
    public void updatePath() {
    }

    ;

    /**
     * Begin game loope.
     */
    public void beginGameLoope() {
        getGameLoop().play();
    }

    /**
     * Update sprites.
     */
    protected void updateSprites() {
        for (Sprite sprite : spriteManager.getAllSprites()) {
            handleUpdate(sprite);
        }
    }

    /**
     * Handle update.
     *
     * @param sprite the sprite
     */
    protected void handleUpdate(Sprite sprite) {
    }

    /**
     * Check collisions.
     */
    protected void checkCollisions() {
        // check other sprite's collisions
        spriteManager.resetCollisionsToCheck();
        // check each sprite against other sprite objects.
        for (Sprite spriteA : spriteManager.getCollisionsToCheck()) {
            for (Sprite spriteB : spriteManager.getAllSprites()) {
                if (handleCollision(spriteA, spriteB)) {
                    // The break helps optimize the collisions
                    //  The break statement means one object only hits another
                    // object as opposed to one hitting many objects.
                    // To be more accurate comment out the break statement.
                    break;
                }
            }
        }
    }

    /**
     * Handle collision.
     *
     * @param spriteA the sprite a
     * @param spriteB the sprite b
     * @return the boolean
     */
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        return false;
    }

    /**
     * Cleanup sprites.
     */
    protected void cleanupSprites() {
        spriteManager.cleanUpSprites();
    }

    /**
     * Gets frames per second.
     *
     * @return the frames per second
     */
    protected int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * Gets window title.
     *
     * @return the window title
     */
    public String getWindowTitle() {
        return windowTitle;
    }

    /**
     * Gets game loop.
     *
     * @return the game loop
     */
    protected static Timeline getGameLoop() {
        return gameLoop;
    }

    /**
     * Sets game loop.
     *
     * @param gameLoop the game loop
     */
    protected static void setGameLoop(Timeline gameLoop) {
        GameWorld.gameLoop = gameLoop;
    }

    /**
     * Gets sprite manager.
     *
     * @return the sprite manager
     */
    protected SpriteManager getSpriteManager() {
        return spriteManager;
    }

    /**
     * Gets game surface.
     *
     * @return the game surface
     */
    public Scene getGameSurface() {
        return gameSurface;
    }

    /**
     * Sets game surface.
     *
     * @param gameSurface the game surface
     */
    protected void setGameSurface(Scene gameSurface) {
        this.gameSurface = gameSurface;
    }

    /**
     * Gets scene nodes.
     *
     * @return the scene nodes
     */
    public Group getSceneNodes() {
        return sceneNodes;
    }

    /**
     * Sets scene nodes.
     *
     * @param sceneNodes the scene nodes
     */
    protected void setSceneNodes(Group sceneNodes) {
        this.sceneNodes = sceneNodes;
    }
}
