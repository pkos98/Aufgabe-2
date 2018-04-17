package fatsquirrel.entities;

import fatsquirrel.core.XY;

public class GoodPlant extends Entity {

    @Override
    public String getSymbol() {
        return "GP";
    }

    public GoodPlant(XY startPos) {
        super(startPos);
        energy = 100;
    }

}
