package xl.gui.menu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;

import xl.gui.SlotLabel;

import java.util.Set;

public class XLPrintStream extends PrintStream {

    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void save(String string) {
        print(string);
        flush();
        close();

    }
}
