package xl.model.cell;

import xl.model.expr.Environment;

public interface Cell {
    double value(Environment env);

    String toString();
}
