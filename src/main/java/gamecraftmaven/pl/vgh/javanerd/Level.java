package gamecraftmaven.pl.vgh.javanerd;

import gamecraftmaven.pl.vgh.javanerd.Tile;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/**
 * @author Michal Leja Game Level
 */
public class Level extends Rectangle {

    public int worldW = 170, worldH = 170;

    private static final long serialVersionUID = 1L;

    /**
     * defining block
     *
     */
    public Block[][] block = new Block[worldW][worldH];

    /**
     * Constructor fill place
     *
     */
    public Level() {

        for (int x = 0; x < block.length; x++) {

            for (int y = 0; y < block[0].length; y++) {

                block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y
                        * Tile.tileSize, Tile.tileSize, Tile.tileSize),
                        Tile.air);

            }
        }

        generateLevel();
        //         generateLevel2();
    }

    public void generateLevel() {

//dla losowe generowanego w pełni
//        for (int x = 0; x < block.length; x++) {
//
//            for (int y = 0; y < block[0].length; y++) {
        for (int y = 0; y < block.length; y++) {

            for (int x = 0; x < block[0].length; x++) {

                if (y > worldH / 4) {
                    //try generuja gore tylko
                    if (new Random().nextInt(100) > 20) {

                        try {
                            if (block[x - 1][y - 1].id == Tile.earth) {
                                block[x][y].id = Tile.earth;
                            }
                        } catch (Exception e) {

                        }
                    }
                    if (new Random().nextInt(100) > 30) {
                        try {
                            if (block[x + 1][y - 1].id == Tile.earth) {
                                block[x][y].id = Tile.earth;
                            }
                        } catch (Exception e) {

                        }
                    }
                    //     if (new Random().nextInt(100) > 10) {
                    try {
                        if (block[x][y - 1].id == Tile.earth) {
                            block[x][y].id = Tile.earth;
                        }
                    } catch (Exception e) {

                    }
                    //          }
                    if (new Random().nextInt(100) < 2) {

                        block[x][y].id = Tile.earth;
                    }
                }
            }
        }

        //placing grass box
        for (int x = 0; x < block.length; x++) {

            for (int y = 0; y < block[0].length; y++) {
                if (block[x][y].id == Tile.earth && block[x][y - 1].id == Tile.air) {
                    block[x][y].id = Tile.grass;
                }
            }
        }
    }

    private boolean isBlockPlaceable(int x, int y) {
        return 0 == x || 0 == y || (block.length - 1) == x
                || (block[0].length - 1) == y;
    }

    public void building(int camX, int camY, int renW, int renH) {
        if (Component.isMouseLeft || Component.isMouseRight) {
            for (int x = (camX / Tile.tileSize); x < (camX / Tile.tileSize) + renW; x++) {

                for (int y = (camY / Tile.tileSize); y < (camY / Tile.tileSize) + renH; y++) {

                    if (x >= 0 && y >= 0 && x < worldW && y < worldH) {
                        if (block[x][y].contains(new Point((Component.mse.x + (int) Component.sX * Component.pixelSize) / Component.pixelSize, (Component.mse.y + (int) Component.sY * Component.pixelSize) / Component.pixelSize))) {
                            block[x][y].id = Tile.air;
                            break;
                        }

                    }

                }
            }
        }
    }

    public void tick(int camX, int camY, int renW, int renH) {
        building(camX, camY, renW, renH);
    }

    public void render(Graphics g, int camX, int camY, int renW, int renH) {
        for (int x = (camX / Tile.tileSize); x < (camX / Tile.tileSize) + renW; x++) {

            for (int y = (camY / Tile.tileSize); y < (camY / Tile.tileSize) + renH; y++) {

                if (x >= 0 && y >= 0 && x < worldW && y < worldH) {
                    block[x][y].render(g);
                }

            }
        }
    }

}
