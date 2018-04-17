package fatsquirrel.entities;

import fatsquirrel.core.XY;

import java.util.LinkedList;
import java.util.List;

public abstract class MasterSquirrel extends Entity {

    List<MiniSquirrel> miniSquirrels = new LinkedList<>();

    @Override
    public String getSymbol() {
        return "MS";
    }

    public MasterSquirrel(XY startPos) {
        super(startPos);
        energy = 1000;
    }

    public boolean checkEntity(Entity entity) {
        for (int i = 0; i < miniSquirrel.length; i++) {
            if(true)
                return true;
        }
        return false;
    }

    public MiniSquirrel[] getMiniSquirrel() {
        return miniSquirrel;
    }

}
