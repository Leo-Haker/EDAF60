package xl.model.sheetToString;

import java.util.Map;

import xl.model.expr.Environment;
import xl.model.cell.Cell;
import xl.model.cell.CommentCell;

public class ValuetoString extends Formatter {

    public ValuetoString(Map<String, Cell> cells, Environment env) {
        super(cells, env);

    }

    @Override
    public String toString(String key) {
        Cell cell = cells.get(key);
        if (cell == null) {
            return key + " is undefined";
        }

        if (cell instanceof CommentCell) {
            return cell.toString();
        }
        String value = String.valueOf(cell.value(env));
        return value;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("ValuetoString does not support toString without a key.");
    }
}
