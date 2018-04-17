package fatsquirrel.entities;

import fatsquirrel.core.XY;

public class BadPlant extends Entity {

    public BadPlant(XY startPos) {
        super(startPos);
        energy = -100;
    }

    @Override
    public String getSymbol() {
        return "BP";
    }

}
