package util;

import models.shapes.RectangularCuboid;

import java.math.BigDecimal;
import java.util.*;

import static util.StringHelper.splitString;

public class ShapeHelper {
    public static List<RectangularCuboid> transformInputToCuboidShapeList(List<String> inputList, String splitter) {
        List<RectangularCuboid> rectangularCuboidList = new ArrayList<>();
        for (String input : inputList) {
            RectangularCuboid rectangularCuboid = new RectangularCuboid();
            String[] split = splitString(input, splitter);
            rectangularCuboid.setLength(new BigDecimal(split[0]));
            rectangularCuboid.setWidth(new BigDecimal(split[1]));
            rectangularCuboid.setHeight(new BigDecimal(split[2]));
            rectangularCuboidList.add(rectangularCuboid);
        }
        return rectangularCuboidList;
    }

    public static Map<Integer, List<BigDecimal>> calculateRectangularCuboidSurfaces(List<RectangularCuboid> rectangularCuboidList) {
        Map<Integer, List<BigDecimal>> surfacesMap = new HashMap<>();
        int key = 0;
        for (RectangularCuboid rectangularCuboid : rectangularCuboidList) {
            surfacesMap.put(key, rectangularCuboid.getSurfaces());
            key++;
        }
        return surfacesMap;
    }

    public static List<BigDecimal> calculateRectangularCuboidCompleteSurfaceAddSmallestSurface(Map<Integer, List<BigDecimal>> surfacesMap) {
        List<BigDecimal> rectangularCuboidSurfaceList = new ArrayList<>();
        BigDecimal multiplicant = new BigDecimal(2);
        for (Map.Entry<Integer, List<BigDecimal>> surfacesEntry : surfacesMap.entrySet()) {
            BigDecimal rectangularCuboidSurface = BigDecimal.ZERO;
            List<BigDecimal> surfacesList = surfacesEntry.getValue();
            Collections.sort(surfacesList);
            rectangularCuboidSurface = rectangularCuboidSurface.add(surfacesList.getFirst());
            for (BigDecimal surface : surfacesList) {
                rectangularCuboidSurface = rectangularCuboidSurface.add(surface.multiply(multiplicant));
            }
            rectangularCuboidSurfaceList.add(rectangularCuboidSurface);
        }
        return rectangularCuboidSurfaceList;
    }

    public static List<BigDecimal> calculateRectangularCuboidShortestDistanceAroundSides(List<RectangularCuboid> rectangularCuboidList) {
        List<BigDecimal> shortestDistanceAroundSides = new ArrayList<>();
        for (RectangularCuboid rectangularCuboid : rectangularCuboidList) {
            shortestDistanceAroundSides.add(rectangularCuboid.getShortestDistanceAroundSides());
        }
        return shortestDistanceAroundSides;
    }

    public static List<BigDecimal> calculateBows(List<RectangularCuboid> rectangularCuboidList) {
        List<BigDecimal> bows = new ArrayList<>();
        for (RectangularCuboid rectangularCuboid : rectangularCuboidList) {
            bows.add(rectangularCuboid.getDimensionsMultiplied());
        }
        return bows;
    }
}
