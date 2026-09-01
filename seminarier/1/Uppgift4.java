public class Uppgift4 {

    static void Main(String[] args) {
        new Uppgift4().run();
    }

    public void run() {

    }

    interface Expr {
        String toString();
        // ev. eval() eller andra metoder
    }

    abstract class BinaryExpr implements Expr {
        protected Expr left, right;

        public BinaryExpr(Expr left, Expr right) {
            this.left = left;
            this.right = right;
        }

        protected abstract String getSymbol();

        @Override
        public String toString() {
            return left.toString() + " " + getSymbol() + " " + right.toString();
        }
    }

    class Add extends BinaryExpr {
        public Add(Expr left, Expr right) {
            super(left, right);
        }

        @Override
        protected String getSymbol() {
            return "+";
        }
    }

    class Mul extends BinaryExpr {
        public Mul(Expr left, Expr right) {
            super(left, right);
        }

        @Override
        protected String getSymbol() {
            return "*";
        }
    }

}