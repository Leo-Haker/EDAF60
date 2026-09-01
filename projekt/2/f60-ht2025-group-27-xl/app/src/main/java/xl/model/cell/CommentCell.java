package xl.model.cell;

import xl.model.expr.Environment;

public class CommentCell implements Cell {
    private String comment;

    public CommentCell(String comment) {
        this.comment = comment;
    }

    @Override
    public double value(Environment env) {
        throw new UnsupportedOperationException("Comment cells do not have a numeric value.");
    }

    @Override
    public String toString() {
        return comment;
    }
}