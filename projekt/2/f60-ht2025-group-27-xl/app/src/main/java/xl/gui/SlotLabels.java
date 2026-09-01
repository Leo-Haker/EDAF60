package xl.gui;

import static java.awt.Color.YELLOW;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel {

    private Map<String, SlotLabel> labelList;

    public SlotLabels(int rows, int cols) {
        super(rows + 1, cols);
        labelList = new TreeMap<String, SlotLabel>();
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                StringBuilder strb = new StringBuilder();
                strb.append(ch).append(row);
                SlotLabel label = new SlotLabel();
                add(label);
                labelList.put(strb.toString(), label);
            }
        }
        labelList.get("A1").setBackground(YELLOW);
    }

    public Map<String, SlotLabel> getSlotList() {
        return this.labelList;
    }
}