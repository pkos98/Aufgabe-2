package fatsquirrel.entities;

import fatsquirrel.core.XY;

public class Wall extends Entity {

    public Wall(XY startPos) {
        super(startPos);
        energy = -10;
    }

}
