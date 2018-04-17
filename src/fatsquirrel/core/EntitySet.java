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

    public void nextRound() {
        for (int x = 0; x < BoardGame.WIDTH; x++) {
            for (int y = 0; y < BoardGame.HEIGHT; y++) {
                Entity field = boardGame.getEntity(new XY(x, y));
                if (field == null)
                    continue;
                XY newPos = field.nextStep();
                while (!BoardGame.isInRange(newPos))
                    newPos = field.nextStep();
                field.setPosition(newPos);
            }
        }
        System.out.println(toString());
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
