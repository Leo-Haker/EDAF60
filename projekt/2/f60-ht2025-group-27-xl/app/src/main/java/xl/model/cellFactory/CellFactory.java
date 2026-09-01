package xl.model.cellFactory;

import xl.model.cell.Cell;
import xl.model.expr.Environment;
import xl.model.cell.CommentCell;
import xl.model.cell.ExpreCell;
import xl.model.cell.LaBombaCell;
import xl.model.expr.ExprParser;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

public class CellFactory {

    protected final TreeMap<String, Cell> cells;
    protected final Environment env;
    private Cell newCell;
    private Cell oldCell;
    private final ExprParser exprParser = new ExprParser();

    public CellFactory(TreeMap<String, Cell> cells, Environment env) {
        this.cells = cells;
        this.env = env;
    }

    protected boolean checkIfCellExists(String key) {
        return cells.containsKey(key);
    }

    protected Cell getCell(String key) {
        return cells.get(key);
    }

    protected boolean checkIfComment(String key) {
        return key.startsWith("#");
    }

    public String update(String key, String value) {
        if (checkIfCellExists(key)) {
            oldCell = getCell(key);
        } else {
            oldCell = null;

        }

        if (checkIfComment(value)) {

            newCell = new CommentCell(value.substring(1).trim());
            cells.put(key, newCell);

            try {
                for (Map.Entry<String, Cell> entry : cells.entrySet()) {
                    if (!(entry.getValue() instanceof CommentCell)) {
                        entry.getValue().value(env);
                    }

                }

            } catch (UnsupportedOperationException e) {
                if (oldCell != null) {
                    cells.put(key, oldCell);
                } else {
                    cells.remove(key);
                }

                return "Comment Error";
            }

        } else {

            try {
                newCell = new ExpreCell(exprParser.build(value));
                Cell bombCell = new LaBombaCell();
                cells.put(key, bombCell);
                newCell.value(env);
                cells.put(key, newCell);

            } catch (RuntimeException e) {
                if (oldCell != null) {
                    cells.put(key, oldCell);
                } else {
                    cells.remove(key);
                }

                return e.getMessage();
            } catch (IOException e) {
                if (oldCell != null) {
                    cells.put(key, oldCell);
                } else {
                    cells.remove(key);
                }

                return e.getMessage();
            }
        }

        return "Success";
    }

    public void load(String key, String value) {

        if (checkIfComment(value)) {

            newCell = new CommentCell(value.substring(1).trim());

            cells.put(key, newCell);
        } else {
            try {
                newCell = new ExpreCell(exprParser.build(value));
                cells.put(key, newCell);
            } catch (IOException e) {

            }
        }
    }

}
