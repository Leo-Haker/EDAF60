package xl.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import xl.gui.Controller;

import xl.gui.SlotLabel;

// TODO move to another package
public class XLBufferedReader extends BufferedReader {

    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // Kanske kan skriva om funktionen ovan genom att använda funktioner i sheet
    // direkt? DENNA FUNKAR JU BRA :D

    public void load(Controller controller) {
        try {
            Map<String, String> map = new TreeMap<>();

            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');

                String key = string.substring(0, i).trim();
                String value = string.substring(i + 1).trim();
                map.put(key, value);
            }

            controller.load(map);

        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }

    /*
     * // TODO Change Object to something appropriate
     * public void load(Map<String, SlotLabel> map) {
     * try {
     * while (ready()) {
     * String string = readLine();
     * int i = string.indexOf('=');
     * // TODO
     * 
     * // ett förlag på hur vi kan göra
     * String key = string.substring(0, i).trim();
     * String value = string.substring(i + 1).trim();
     * 
     * SlotLabel slotLabel = map.get(key);
     * if (slotLabel != null) {
     * slotLabel.setText(value);
     * }
     * 
     * }
     * } catch (Exception e) {
     * throw new XLException(e.getMessage());
     * }
     * }
     * 
     */

}