package fatsquirrel.entities;

import fatsquirrel.core.XY;

public abstract class Entity {

    protected static int idCounter = 0;
    protected XY position;
    protected int id;
    protected int energy;

    public int getId() {
        return id;
    }

    public void setPosition(XY pos) {
        position = pos;
    }
    public XY getPosition() {
        return position;
    }
    public void resetEnergy() {energy = 0;}
    public int getEnergy() {return energy;}
    public abstract String getSymbol();

    public XY nextStep() {
        XY deltaVector = XY.getRandomMoveVector();
        XY newPos = new XY(position.getX() + deltaVector.getX(),
                          position.getY() + deltaVector.getY());
        return newPos;
    }

    public void updateEnergy(int delta) {
        energy += delta;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Type: " + getSymbol() + System.lineSeparator();
        result += "ID: " + id + System.lineSeparator();
        result += "Position: " + position.toString() + System.lineSeparator();
        result += "Energy: " + energy + System.lineSeparator();
        return result;
    }

    public Entity(XY startPos) {
        this.position = startPos;
        this.id = idCounter++;
    }

}
