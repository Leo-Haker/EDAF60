package xl.model.sheetToString;

import java.util.Map;

import xl.model.cell.Cell;
import xl.model.expr.Environment;

public abstract class Formatter {
    protected Environment env;
    protected Map<String, Cell> cells;

    public Formatter(Map<String, Cell> cells, Environment env) {
        this.cells = cells;
        this.env = env;
    }

    @Override
    public abstract String toString();

    public abstract String toString(String key);

}
