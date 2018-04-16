package fatsquirrel.core;

import fatsquirrel.entities.Entity;

public class EntitySet {

    BoardGame boardGame;

    public void add(Entity entity, XY pos) {
        boardGame.setEntity(pos, entity, true);
    }

    public void remove(Entity entity, XY pos) {
        boardGame.setEntity(pos, null, true);
    }

    public EntitySet(BoardGame boardGame) {
        this.boardGame = boardGame;
    }

    @Override
    public String toString() {
        return "";
    }

}
