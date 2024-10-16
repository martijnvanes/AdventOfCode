package models.arrayInstruction;

import enums.Operation;
import lombok.Data;

@Data
public class TwoDimensionalInstruction {
    private Operation operation;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    void setStart(String[] pos) {
        startX = Integer.parseInt(pos[0]);
        startY = Integer.parseInt(pos[1]);
    }

    void setEnd(String[] pos) {
        endX = Integer.parseInt(pos[0]);
        endY = Integer.parseInt(pos[1]);
    }
    void determinePosition() {

    }
}
