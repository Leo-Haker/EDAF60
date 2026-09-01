
interface ButtonOP {
    void action();
}

class Button {
    private ButtonOP op;
    private String name;

    public Button(String name, ButtonOP op) {
        this.name = name;
        this.op = op;

    }

    public void press() {
        op.action();
    }
}

public class Main {
    public static void main(String[] args) {
        Button b1 = new Button("Hej", () -> System.out.println("Hej!"));

        b1.press();
    }
}
