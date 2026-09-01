package xl.gui.menu;

import java.io.FileNotFoundException;
import xl.gui.Controller;
import xl.util.XLBufferedReader;

import javax.swing.JFileChooser;
import xl.gui.StatusLabel;
import xl.gui.XL;

class LoadMenuItem extends OpenMenuItem {

    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
        XLBufferedReader xlBufferedReader = new XLBufferedReader(path);
        Controller controller = xl.getController();
        xlBufferedReader.load(controller);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
