package fatsquirrel;

import fatsquirrel.core.BoardGame;
import fatsquirrel.core.EntitySet;
import fatsquirrel.core.HandOperatedMasterSquirrel;
import fatsquirrel.core.XY;
import fatsquirrel.entities.*;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        BoardGame game = new BoardGame();
        EntitySet entitySet = new EntitySet(game);
        initBoard(entitySet, game);

        while(true) {
            entitySet.nextRound();
        }
    }

    private static void initBoard(EntitySet entitySet, BoardGame boardGame) {

        for (int x = 0; x < boardGame.getWidth(); x++) {
            for (int y = 0; y < boardGame.getHeight(); y++) {
                XY pos = new XY(x, y);
                if (x == 0 && y == 0)
                    entitySet.add(new HandOperatedMasterSquirrel(new XY(0,0)), new XY(0,0));
                else
                    entitySet.add(createEntity(pos), pos);
            }
        }
    }

    private static Entity createEntity(XY pos) {
        int randomNum = random.nextInt(12);
        if (randomNum <= 6)
            return null;
        else if (randomNum == 7)
            return new GoodPlant(pos);
        else if (randomNum == 8)
            return new GoodBeast(pos);
        else if (randomNum == 9)
            return new BadPlant(pos);
        else if (randomNum == 10)
            return new BadBeast(pos);
        else if (randomNum == 11)
            return new Wall(pos);
        return null;
    }

}
