import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Taavi Tilk on 4.12.2015.
 */
public class Toidud {

    private final SimpleStringProperty toit;
    private final SimpleIntegerProperty kogus;
    private final SimpleStringProperty yhik;




    public Toidud(String t, Integer k, String y) {
        toit = new SimpleStringProperty(t);
        kogus = new SimpleIntegerProperty(k);
        yhik = new SimpleStringProperty(y);
    }

    public String getToit() {
        return toit.get();
    }

    public void setToit(String t) {
        toit.set(t);
    }

    public Integer getKogus() {
        return kogus.get();
    }

    public void setKogus(Integer k) {
        kogus.set(k);
    }

    public String getYhik() {
        return yhik.get();
    }

    public void setYhik(String y) {
        yhik.set(y);
    }
}
