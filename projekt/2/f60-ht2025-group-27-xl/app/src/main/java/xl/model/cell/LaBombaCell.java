package xl.model.cell;

import xl.model.expr.Environment;

public class LaBombaCell implements Cell {
    public double value(Environment env) {
        throw new RuntimeException("La Bomba Cell explodes when evaluated!");
    }

    public String toString() {
        return "#BOMB!";
    }
}
