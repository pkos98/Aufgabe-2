package fatsquirrel.core;

import fatsquirrel.entities.Entity;

import java.io.IOException;

public class HandOperatedMasterSquirrel extends Entity {


    public HandOperatedMasterSquirrel(XY startPos) {
        super(startPos);
        energy = 1000;
    }

    public XY getInput() {
        try {
            char input = (char) System.in.read();
            if (input == 's')
                return position;
            if (input == 'w')
                return new XY(position.getX(), position.getY() + 1);
            if (input == 'x')
                return new XY(position.getX(), position.getY() - 1);
            if (input == 'a')
                return new XY(position.getX() - 1, position.getY());
            if (input == 'd')
                return new XY(position.getX() + 1, position.getY());
            if (input == 'q')
                return new XY(position.getX() - 1, position.getY() - 1);
            if (input == 'e')
                return new XY(position.getX() + 1, position.getY() + 1);
            if (input == 'c')
                return new XY(position.getX() + 1, position.getY() - 1);
            if (input == 'c')
                return new XY(position.getX() - 1, position.getY() - 1);
            else
                return position;
        }
        catch (IOException ex) {
            return null;
        }
    }

    @Override
    public XY nextStep() {
        System.out.println("Please Enter: ");
        return getInput();
    }

    @Override
    public String getSymbol() {
        return "HM";
    }
}
