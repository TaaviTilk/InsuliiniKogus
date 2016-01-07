import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Taavi Tilk on 4.12.2015.
 */
public class Toit {

    private final SimpleStringProperty toit;
    private final SimpleStringProperty kogus;
    private final SimpleStringProperty yhik;




    public Toit(String t, String k, String y) {
        this.toit = new SimpleStringProperty(t);
        this.kogus = new SimpleStringProperty(k);
        this.yhik = new SimpleStringProperty(y);
    }
    public String getToit() {
        return toit.get();
    }
    @XmlElement(name = "eesnimi")
    public void setToit(String t) {
        toit.set(t);
    }

    public String getKogus() {
        return kogus.get();
    }

    public void setKogus(String k) {
        kogus.set(k);
    }

    public String getYhik() {
        return yhik.get();
    }

    public void setYhik(String y) {
        yhik.set(y);
    }
}
