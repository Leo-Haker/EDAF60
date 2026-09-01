package xl.model;

import java.util.Map;
import java.util.TreeMap;

import xl.model.expr.Environment;
import xl.model.cell.Cell;
import xl.model.cell.CommentCell;
import xl.model.cellFactory.CellFactory;
import xl.model.sheetToString.SheetToString;
import xl.model.sheetToString.ValuetoString;
import xl.model.sheetToString.ExprToString;
import xl.model.sheetToString.Formatter;

public class Sheet implements Environment {
    private final TreeMap<String, Cell> cells;
    private final CellFactory cellFactory;
    private final Formatter sheetToString;
    private final Formatter valueToString;
    private final Formatter exprToString;

    public Sheet() {
        cells = new TreeMap<String, Cell>();

        cellFactory = new CellFactory(cells, this);

        sheetToString = new SheetToString(cells, this);
        valueToString = new ValuetoString(cells, this);
        exprToString = new ExprToString(cells, this);

    }

    // returnera cellens värde
    @Override
    public double value(String key) {
        Cell cell = cells.get(key);
        if (cell == null) {
            throw new RuntimeException("Cell " + key + " is undefined");
        }
        return cell.value(this);
    }

    // uppdatera cellens innehåll och kontrollera om uttrycket är giltigt
    public String update(String key, String value) {
        return cellFactory.update(key, value);
    }

    public void clearAll() {
        cells.clear();
    }

    public String clear(String key) {
        Cell cell;

        if (cells.get(key) != null) {
            cell = cells.get(key);
            cells.remove(key);
            try {
                evaluateAll();
            } catch (Exception e) {
                cells.put(key, cell);
                return e.getMessage();
            }

        }

        return "Success";

    }

    public void evaluateAll() {
        for (Cell cell : cells.values()) {
            if (!(cell instanceof CommentCell)) {
                cell.value(this);
            }
        }
    }

    public void load(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            cellFactory.load(key, value);
        }
    }

    // returnera alla celler som sträng: namn = värde
    @Override
    public String toString() {
        return sheetToString.toString();
    }

    // returnera cellens värde som en sträng
    public String toStringValue(String key) {
        return valueToString.toString(key);
    }

    // returnera cellens uttryck som en sträng
    public String toStringExpr(String key) {
        return exprToString.toString(key);
    }

    public Map<String, String> getMap() {

        Map<String, String> map = new TreeMap<>();

        cells.forEach((k, v) -> map.put(k, toStringValue(k)));

        return map;
    }

}
