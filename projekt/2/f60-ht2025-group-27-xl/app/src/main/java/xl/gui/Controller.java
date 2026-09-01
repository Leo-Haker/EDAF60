package xl.gui;

import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JPanel;

import xl.model.Sheet;

public class Controller {
    private StatusPanel statusPanel;
    private Editor editor;
    private Sheet sheet;
    private SlotLabels slotLabels;
    private CurrentLabel currentLabel;

    public Controller(StatusPanel statusPanel, SheetPanel sheetPanel, Editor editor) {
        this.statusPanel = statusPanel;
        this.editor = editor;
        sheet = new Sheet();
        this.slotLabels = (SlotLabels) sheetPanel.getComponent(1);
        this.currentLabel = (CurrentLabel) statusPanel.getComponent(0);
        addListeners();
    }

    private void addListeners() {
        addListenersSheetPanel();
        addListenersEditor();
    }

    private void addListenersSheetPanel() {

        slotLabels.getSlotList().forEach((x, y) -> y.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                slotLabels.getSlotList().get(currentLabel.getText()).setBackground(WHITE);
                statusPanel.updateCurrentLabel(x);
                y.setBackground(YELLOW);
                editor.setText(sheet.toStringExpr(x));
            }
        }));
    }

    private void addListenersEditor() {
        editor.addActionListener(e -> {
            String text = editor.getText().trim();

            statusPanel.updateStatusLabel(sheet.update(currentLabel.getText(), text));
            update();

        });
    }

    private void update() {
        slotLabels.getSlotList().forEach((k, v) -> v.setText(""));
        sheet.getMap().forEach((k, v) -> {
            slotLabels.getSlotList().get(k).update(v);
        });
    }

    public String sheetToString() {
        return sheet.toString();
    }

    // testmetod
    public void load(Map<String, String> map) {
        clearAll();
        sheet.load(map);
        sheet.evaluateAll();
        update();
    }

    // test för att ta rensa rutnätet
    public void clearAll() {
        sheet.clearAll();
        update();
    }

    public void clearCurrent() {
        statusPanel.updateStatusLabel(sheet.clear(currentLabel.getText()));
        update();
    }
}
