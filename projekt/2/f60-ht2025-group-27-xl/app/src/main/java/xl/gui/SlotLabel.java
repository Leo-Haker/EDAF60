package xl.gui;

import java.awt.Color;

public class SlotLabel extends ColoredLabel {

    public SlotLabel() {
        super("                    ", Color.WHITE, RIGHT);
    }

    public void update(String s) {
        this.setText(s);
    }

   
}
