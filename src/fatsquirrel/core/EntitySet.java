package fatsquirrel.core;

import fatsquirrel.entities.Entity;
import fatsquirrel.entities.Wall;

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

    public void nextRound() {
        for (int x = 0; x < BoardGame.WIDTH; x++) {
            for (int y = 0; y < BoardGame.HEIGHT; y++) {
                Entity field = boardGame.getEntity(new XY(x, y));
                if (field == null)
                    continue;
                XY newPos = field.nextStep();
                Entity newPosField = boardGame.getEntity(newPos);
                while (!BoardGame.isInRange(newPos))
                    newPos = field.nextStep();
                if (!(newPosField instanceof Wall))
                    setPosition(new XY(x, y), newPos, field);
                applyCollision(field, newPosField);
            }
        }
        System.out.println(toString());
    }

    public void applyCollision(Entity toMove, Entity newPosField) {
        if (newPosField == null)
            return;
        toMove.updateEnergy(newPosField.getEnergy());
        newPosField.resetEnergy();
    }

    public void setPosition(XY oldPos, XY newPos, Entity entity) {
        if (entity != null)
            entity.setPosition(newPos);
        boardGame.setEntity(oldPos, null, true);
        boardGame.setEntity(newPos, entity, true);
    }

    @Override
    public String toString() {
        String result = "";

        for (int x = 0; x < boardGame.getWidth(); x++) {
            for (int y = 0; y < boardGame.getHeight(); y++) {
                Entity field = boardGame.getEntity(new XY(x, y));
                if (field != null)
                    result += field.toString() + System.lineSeparator();
            }
        }
        return result;
    }

}
