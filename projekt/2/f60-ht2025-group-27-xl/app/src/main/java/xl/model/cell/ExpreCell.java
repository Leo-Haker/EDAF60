package xl.model.cell;

import xl.model.expr.Expr;
import xl.model.expr.Environment;

public class ExpreCell implements Cell {
    private Expr expr;

    public ExpreCell(Expr expr) {
        this.expr = expr;
    }

    @Override
    public double value(Environment env) {
        return expr.value(env);
    }

    @Override
    public String toString() {
        return expr.toString();
    }
}
