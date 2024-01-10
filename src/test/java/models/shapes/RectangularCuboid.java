package models.shapes;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class RectangularCuboid {
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;

    public List<BigDecimal> getSurfaces() {
        List<BigDecimal> surfaces = new ArrayList<>();
        surfaces.add(this.length.multiply(this.width));
        surfaces.add(this.width.multiply(this.height));
        surfaces.add(this.height.multiply(this.length));
        return surfaces;
    }

    public List<BigDecimal> getRectangularCuboidDimensions() {
        List<BigDecimal> dimensions = new ArrayList<>();
        dimensions.add(length);
        dimensions.add(width);
        dimensions.add(height);
        return dimensions;
    }

    public BigDecimal getShortestDistanceAroundSides() {
        BigDecimal multiplicant = new BigDecimal(2);
        List<BigDecimal> dimensions = getRectangularCuboidDimensions();
        Collections.sort(dimensions);
        dimensions.removeLast();
        return (dimensions.getFirst().multiply(multiplicant)).add(dimensions.getLast().multiply(multiplicant));
    }

    public BigDecimal getDimensionsMultiplied() {
        List<BigDecimal> dimensions = getRectangularCuboidDimensions();
        return (dimensions.getFirst().multiply(dimensions.get(1).multiply(dimensions.getLast())));
    }
}
