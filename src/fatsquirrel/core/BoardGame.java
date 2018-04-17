package fatsquirrel.core;

import fatsquirrel.entities.Entity;

public class BoardGame {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private Entity[][] boardMatrix = new Entity[WIDTH][HEIGHT];

    public int getWidth() {
        return boardMatrix.length;
    }

    public int getHeight() {
        return boardMatrix[0].length;
    }

    public Entity getEntity(XY pos) {

        if (!isInRange(pos))
            return null;
        return boardMatrix[pos.getX()][pos.getY()];
    }

    public void setEntity(XY pos, Entity entity, boolean overwrite) {

        if (!isInRange(pos))
            return;
        Entity boardField = boardMatrix[pos.getX()][pos.getY()];
        if (boardField != null && overwrite == false)
            return;
        else
            boardMatrix[pos.getX()][pos.getY()] = entity;

    }

    @Override
    public String toString() {
        String result = "";

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Entity field = getEntity(new XY(x, y));
                if (field == null)
                    result += " + ";
                else
                    result += " " + field.getSymbol() + " ";
            }
            result += System.lineSeparator();
        }
        return result;
    }

    public static boolean isInRange(XY pos) {
        return !(pos.getX() < 0 || pos.getX() >= WIDTH ||
        pos.getY() < 0 || pos.getY() >= HEIGHT);
    }

}
