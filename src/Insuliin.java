import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Insuliin {
    ChoiceBox valik;
    ChoiceBox valik2;
    TextField toidulahter1;
    TextField toidukogus1;
    Button arvuta;
    Button salvesta;
    public ObservableList<Person> toit =  FXCollections.observableArrayList();
    VBox vBox;
    public Object kogus;



    public Insuliin(){
        loeXML();
        Start();
    }

    private void loeXML() {
        LoeXML a = new LoeXML();
        toit = a.getAndmed();

    }

    private void info (String nimi){
        System.out.println(nimi);
    }

    public void Start () {

        vBox = new VBox(10);
        // TOP
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        // Hiljem võiks teha juurde uue kasutaja lisamise mooduli

        Label label = new Label();
        hbox.setMargin(label, new Insets(5)); // toob kasti 5 pix eemale servast
        label.setPrefWidth(60); // kasti pikkus
        hbox.setMargin(label, new Insets(5));


        String[] greetings = new String[] { "A", "B", "C", "D", "E" };
        ChoiceBox<String> valik = new ChoiceBox<String>(
                FXCollections.observableArrayList("Kasper", "´Jesper", "Joonatan"));

        valik.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue ov, Number value, Number new_value) {
                        label.setText(greetings[new_value.intValue()]);
                    }
                });

        hbox.setMargin(valik, new Insets(5));


        TextField lahter2= new TextField();
        hbox.setMargin(lahter2, new Insets(5)); // toob kasti 5 pix eemale servast
        lahter2.setPrefWidth(60); // kasti pikkus
        lahter2.setPromptText("number"); //tekitab kasti eelteksti

        hbox.getChildren().addAll(valik, label,lahter2);


        // CENTER
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setHgap(10); //horisontaalne
        gridPane.setVgap(10); //vertikaalne
        gridPane.setPadding(new Insets(10, 10, 10, 10));



        ChoiceBox valik1 = new ChoiceBox();
        gridPane.setMargin(valik1, new Insets(5));
        gridPane.setConstraints(valik1, 0, 1);
        gridPane.setHalignment(valik1, HPos.LEFT);


        for (int i = 0; i < toit.size(); i++) {
            valik1.getItems().add(toit.get(i).getToit()); }

        valik1.setTooltip(new Tooltip("vali toit"));
        valik1.getValue();
        valik1.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            for(Person per : toit){
                                if(per.getToit().equals(nimi)){
                                    kogus = per.getKogus();
                                    break;
                                }
                            }

                            System.out.println("1.ne :"+kogus);
                        });


        TextField toidukogus1= new TextField();
        gridPane.setMargin(toidukogus1, new Insets(5));
        gridPane.setConstraints(toidukogus1, 1, 1);
        gridPane.setHalignment(toidukogus1, HPos.LEFT);
        toidukogus1.setPromptText("kogus1");
        toidukogus1.setId("Kogus1");


        hbox.setMargin(valik, new Insets(5));


        Label vastus= new Label();
        gridPane.setConstraints(vastus, 2, 1);
        gridPane.setColumnSpan(vastus, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus, HPos.RIGHT);


        Button arvuta = new Button();
        arvuta.setText("Arvuta");
        arvuta.setOnAction(event -> {

                    int i = Integer.valueOf((String) kogus);
                    System.out.println("2.ne :"+i);
                    float a = (float) i;
                    String b = toidukogus1.getText();
                    float c = Float.parseFloat(b);
                    float d = a*c;
                    String e = ""+d;
                    vastus.setText(e);
                }

        );


        gridPane.getChildren().addAll(
                //cb,
                valik1,
                /**
                 toidulahter2,
                 toidulahter3,
                 toidulahter4,
                 toidulahter5,
                 */
                toidukogus1,
                /**
                 toidukogus2,
                 toidukogus3,
                 toidukogus4,
                 toidukogus5,
                 */
                //tekst1,
                vastus,

                arvuta
                //salvesta
        );

        vBox.getChildren().addAll(hbox, gridPane);

    }







    /*public void arvutaToiduKogus (){

    }

    */
}


        ///static String nimi;
        ///static int insuliinikogus;

        // Kõsib isikut
        // küsib süsivesikute hulka ühe stitava insuliini ühiku kohta nt 10 (g) (vahemik 10-14 g)
        //isik();
        ///insuliinikogus ();

        // Mis toitu sõid
        //toit ();

        // toidu kogust
        // arvutab toidukoguse kokku
        // Arvutab süstitava insuliini koguse.
        // Salvestada süstitav kopgus ja süsivesikute hulk andmebaasi






