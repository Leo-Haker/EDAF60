package xl.model.sheetToString;

import java.util.TreeMap;
import xl.model.cell.Cell;
import xl.model.expr.Environment;

public class SheetToString extends Formatter {

    public SheetToString(TreeMap<String, Cell> cells, Environment env) {
        super(cells, env);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : cells.keySet()) {
            sb.append(key).append("=").append(cells.get(key).toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(String key) {
        throw new UnsupportedOperationException("SheetToString does not support toString with a key.");
    }

}
