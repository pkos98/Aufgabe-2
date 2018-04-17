package fatsquirrel.entities;

import fatsquirrel.core.XY;

public class Wall extends Entity {

    @Override
    public String getSymbol() {
        return "WL";
    }

    public Wall(XY startPos) {
        super(startPos);
        energy = -10;
    }



}
