package models.arrayInstruction;

import enums.Heading;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Position {
    private int X;
    private int Y;
    private Heading heading;

    public void startPosition(int X, int Y, Heading heading) {
        this.X = X;
        this.Y = Y;
        this.heading = heading;
    }

    public static Position copyPreviousPosition(Position previousPosition) {
        Position position = new Position();
        position.setX(previousPosition.getX());
        position.setY(previousPosition.getY());
        position.setHeading(previousPosition.getHeading());
        return position;
    }

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

    public static List<Position> routeBetweenPositions(Position previousPosition, Position newPosition) {
        List<Position> route = new ArrayList<>();
        if (previousPosition.getX() == newPosition.getX()) {
            int steps = newPosition.getY() - previousPosition.getY();
            int y = previousPosition.getY();
            if (steps > 0) {
                for (int i = 0; i < steps; i++) {
                    y++;
                    route.add(createPosition(previousPosition.getX(), y, newPosition.getHeading()));
                }
            } else {
                steps = Math.abs(steps);
                for (int i = 0; i < steps; i++) {
                    y--;
                    route.add(createPosition(previousPosition.getX(), y, newPosition.getHeading()));
                }
            }
        } else {
            int steps = newPosition.getX() - previousPosition.getX();
            int x = previousPosition.getX();
            if (steps > 0) {
                for (int i = 0; i < steps; i++) {
                    x++;
                    route.add(createPosition(x, previousPosition.getY(), newPosition.getHeading()));
                }
            } else {
                steps = Math.abs(steps);
                for (int i = 0; i < steps; i++) {
                    x--;
                    route.add(createPosition(x, previousPosition.getY(), newPosition.getHeading()));
                }
            }
        }
        return route;
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

    private static Position createPosition(int x, int y, Heading heading) {
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        position.setHeading(heading);

        return position;
    }
}
