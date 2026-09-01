package xl.model.sheetToString;

import java.util.Map;

import xl.model.expr.Environment;
import xl.model.cell.Cell;
import xl.model.cell.CommentCell;

public class ExprToString extends Formatter {

    public ExprToString(Map<String, Cell> cells, Environment env) {
        super(cells, env);

    }

    @Override
    public String toString(String key) {
        Cell cell = cells.get(key);
        if (cell == null) {
            return "";
        }

        if (cell instanceof CommentCell) {

            return "#" + cell.toString();
        }

        return cell.toString();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("ExprToString does not support toString without a key.");
    }
}
