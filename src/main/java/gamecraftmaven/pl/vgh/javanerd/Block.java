package gamecraftmaven.pl.vgh.javanerd;

import gamecraftmaven.pl.vgh.javanerd.Tile;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Michal Leja Blocks
 */
public class Block extends Rectangle {

    private static final long serialVersionUID = 1L;

    /**
     * Block placement id
     *
     */
    public int[] id = {-1, -1};

    /**
     * @param size - block size
     * @param id - placement
     */
    public Block(Rectangle size, int[] id) {

        setBounds(size);

        this.id = id;

    }

    /**
     * DrawImage: img - the specified image to be drawn. This method does
     * nothing if img is null. dx1 - the x coordinate of the first corner of the
     * destination rectangle. dy1 - the y coordinate of the first corner of the
     * destination rectangle. dx2 - the x coordinate of the second corner of the
     * destination rectangle. dy2 - the y coordinate of the second corner of the
     * destination rectangle. sx1 - the x coordinate of the first corner of the
     * source rectangle. sy1 - the y coordinate of the first corner of the
     * source rectangle. sx2 - the x coordinate of the second corner of the
     * source rectangle. sy2 - the y coordinate of the second corner of the
     * source rectangle. observer - object to be notified as more of the image
     * is scaled and converted.
     *
     * @param g - Graphics
     */
    public void render(Graphics g) {

        if (id != Tile.air) {
            g.drawImage(Tile.tileset_terrain, x - (int) Component.sX, y - (int) Component.sY, x + width - (int) Component.sX, y + height - (int) Component.sY,
                    id[0] * Tile.tileSize, id[1] * Tile.tileSize, id[0]
                    * Tile.tileSize + Tile.tileSize, id[1]
                    * Tile.tileSize + Tile.tileSize, null);
        }
    }
}
