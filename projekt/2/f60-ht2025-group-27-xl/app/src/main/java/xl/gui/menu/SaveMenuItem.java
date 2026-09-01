package xl.gui.menu;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import xl.gui.StatusLabel;
import xl.gui.XL;

class SaveMenuItem extends OpenMenuItem {

    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        var printStream = new XLPrintStream(path);
        printStream.save(xl.getController().sheetToString());

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}
