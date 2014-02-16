package lpostula.pacman;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Path
 */
public class Path {
    private int[] path;
    public Canvas node;
    private GraphicsContext gc;
    private int width;
    private int height;
    private double stepSize;

    public Path(int nX, int nY, double size) {
        width = nX;
        height = nY;
        stepSize = size;
        node = new Canvas(width * stepSize, height * stepSize);
        gc = node.getGraphicsContext2D();
        gc.setFill(Color.TRANSPARENT);
        gc.setLineWidth(size * 0.2);
        gc.setStroke(Color.FUCHSIA);
        path = new int[]{2, 2, 2, 3, 3, 3, 1, 3, 2, 2, 2, 2, 0};
        renderPath(1, 1);
    }

    public void renderPath(int startX, int startY) {
        int x = startX;
        int y = startY;
        double x1, y1, x2, y2;
        for (int i = 0; i < path.length; ++i) {
            boolean vert = false;
            switch (path[i]) {
                case -1:
                    break;
                case 0:
                    //up
                    //down
                    x1 = stepSize / 2;
                    y1 = stepSize / 2;
                    x2 = stepSize / 2;
                    y2 = stepSize + stepSize / 2;
                    ++y;
                    gc.strokeLine((x) * stepSize + x1, (y - 2) * stepSize + y1, (x) * stepSize + x2, (y - 2) * stepSize + y2);
                    --y;
                    break;
                case 1:
                    //left
                    x1 = stepSize / 2;
                    y1 = stepSize / 2 + stepSize;
                    x2 = stepSize / 2 + stepSize;
                    y2 = stepSize / 2 + stepSize;
                    --x;
                    gc.strokeLine((x) * stepSize + x1, (y - 1) * stepSize + y1, (x) * stepSize + x2, (y - 1) * stepSize + y2);
                    break;
                case 2:
                    //right
                    x1 = stepSize / 2;
                    y1 = stepSize / 2 + stepSize;
                    x2 = stepSize / 2 + stepSize;
                    y2 = stepSize / 2 + stepSize;
                    ++x;
                    gc.strokeLine((x - 1) * stepSize + x1, (y - 1) * stepSize + y1, (x - 1) * stepSize + x2, (y - 1) * stepSize + y2);
                    break;
                case 3:
                    //down
                    x1 = stepSize / 2;
                    y1 = stepSize / 2;
                    x2 = stepSize / 2;
                    y2 = stepSize + stepSize / 2;
                    ++y;
                    gc.strokeLine((x) * stepSize + x1, (y - 1) * stepSize + y1, (x) * stepSize + x2, (y - 1) * stepSize + y2);

                    break;
            }
        }
    }


}
