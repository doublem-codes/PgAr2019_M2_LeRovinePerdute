/**
 * class define the coordinate of city in 3dimension
 */

public class Coordinate {
    private int x;//coordinate x
    private int y;//coordinate y
    private int h;//altitude

    /**
     * method to create the coordinate of city
     * @param x coordinate x
     * @param y coordinate y
     * @param h altitude
     */

    public Coordinate(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    /**
     * method to get coordinate x
     * @return coordinate x
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * method to get coordinate y
     * @return coordinate y
     */
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * method to get altitude
     * @return altitude
     */
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
