package models.arrayInstruction;

import enums.Heading;
import lombok.Data;

@Data
public class Position {
    private int X;
    private int Y;
    private Heading heading;

    public Position updatePosition(String directionUpdate, int moves) {
        updateHeading(directionUpdate);
        switch (heading) {
            case NORTH -> setY(Y + moves);
            case WEST -> setX(X + moves);
            case SOUTH -> setY(Y - moves);
            case EAST -> setX(X - moves);
        }
        return this;
    }

    private void updateHeading(String directionUpdate) {
        switch (heading) {
            case NORTH -> {
                if (directionUpdate.equals("R")) {
                    setHeading(Heading.WEST);
                } else {
                    setHeading(Heading.EAST);
                }
            }
            case WEST -> {
                if (directionUpdate.equals("R")) {
                    setHeading(Heading.SOUTH);
                } else {
                    setHeading(Heading.NORTH);
                }
            }
            case SOUTH -> {
                if (directionUpdate.equals("R")) {
                    setHeading(Heading.EAST);
                } else {
                    setHeading(Heading.WEST);
                }
            }
            case EAST -> {
                if (directionUpdate.equals("R")) {
                    setHeading(Heading.NORTH);
                } else {
                    setHeading(Heading.SOUTH);
                }
            }
        }
    }
}
