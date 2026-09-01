package xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
    private ColoredLabel currentLabel;
    private ColoredLabel statusLabel;

    protected StatusPanel(StatusLabel statusLabel) {
        this.currentLabel = new CurrentLabel();
        this.statusLabel = statusLabel;
        add(WEST, currentLabel);
        add(CENTER, this.statusLabel);
    }

    public void updateCurrentLabel(String s) {
        this.currentLabel.setText(s);
    }

    public void updateStatusLabel(String s) {
        this.statusLabel.setText(s);
    }
}
