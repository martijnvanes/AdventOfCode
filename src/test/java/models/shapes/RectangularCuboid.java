package models.shapes;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
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
}
