package fatsquirrel.core;

import fatsquirrel.entities.Entity;

public class BoardGame {

    private Entity[][] boardMatrix = new Entity[20][20];

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

    private boolean isInRange(XY pos) {
        return !(pos.getX() < 0 || pos.getX() > getWidth() ||
        pos.getY() < 0 || pos.getY() > getHeight());
    }

}
