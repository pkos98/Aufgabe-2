package fatsquirrel.entities;

import fatsquirrel.core.XY;

public class MasterSquirrel extends Entity {

    MiniSquirrel[] miniSquirrel = new MiniSquirrel[10];

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

    public MiniSquirrel[] creat() {
        return miniSquirrel;
    }

    public MiniSquirrel[] getMiniSquireel() {
        return miniSquirrel;
    }

}
