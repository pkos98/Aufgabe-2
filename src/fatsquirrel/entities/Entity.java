package fatsquirrel.entities;

import fatsquirrel.core.XY;

public abstract class Entity {

    protected XY position;
    protected int id;
    protected int energy;

    public int getId() {
        return id;
    }

    public XY getPosition() {
        return position;
    }

    public XY nextStep() {
        return position;
    }

    public void updateEnergy(int delta) {
        energy += delta;
    }

    public Entity(XY startPos) {
        this.position = startPos;
    }

}
