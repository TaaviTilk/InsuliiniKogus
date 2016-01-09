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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    public Object kogus1;
    public Object kogus2;
    public Object kogus3;
    public Object kogus4;
    public Object kogus5;



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

        Label label = new Label("Süsivesikute ühikute omastamise koefitsent 6...15 ü");
        hbox.setMargin(label, new Insets(5)); // toob kasti 5 pix eemale servast
        hbox.setMargin(label, new Insets(5));



        TextField svok= new TextField();
        hbox.setMargin(svok, new Insets(5)); // toob kasti 5 pix eemale servast
        svok.setPrefWidth(60); // kasti pikkus
        svok.setPromptText("number"); //tekitab kasti eelteksti
        svok.setId("svok");

        hbox.getChildren().addAll(svok, label);


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
                                    kogus1 = per.getKogus();
                                    break;
                                }
                            }
                        });

        ChoiceBox valik2 = new ChoiceBox();
        gridPane.setMargin(valik2, new Insets(5));
        gridPane.setConstraints(valik2, 0, 2);
        gridPane.setHalignment(valik2, HPos.LEFT);

        for (int i = 0; i < toit.size(); i++) {
            valik2.getItems().add(toit.get(i).getToit()); }

        valik2.setTooltip(new Tooltip("vali toit"));
        valik2.getValue();
        valik2.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            for(Person per : toit){
                                if(per.getToit().equals(nimi)){
                                    kogus2 = per.getKogus();
                                    break;
                                }
                            }
                        });

        ChoiceBox valik3 = new ChoiceBox();
        gridPane.setMargin(valik3, new Insets(5));
        gridPane.setConstraints(valik3, 0, 3);
        gridPane.setHalignment(valik3, HPos.LEFT);

        for (int i = 0; i < toit.size(); i++) {
            valik3.getItems().add(toit.get(i).getToit()); }

        valik3.setTooltip(new Tooltip("vali toit"));
        valik3.getValue();
        valik3.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            for(Person per : toit){
                                if(per.getToit().equals(nimi)){
                                    kogus3 = per.getKogus();
                                    break;
                                }
                            }
                        });

        ChoiceBox valik4 = new ChoiceBox();
        gridPane.setMargin(valik4, new Insets(5));
        gridPane.setConstraints(valik4, 0, 4);
        gridPane.setHalignment(valik4, HPos.LEFT);

        for (int i = 0; i < toit.size(); i++) {
            valik4.getItems().add(toit.get(i).getToit()); }

        valik4.setTooltip(new Tooltip("vali toit"));
        valik4.getValue();
        valik4.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            for(Person per : toit){
                                if(per.getToit().equals(nimi)){
                                    kogus4 = per.getKogus();
                                    break;
                                }
                            }
                        });

        ChoiceBox valik5 = new ChoiceBox();
        gridPane.setMargin(valik5, new Insets(5));
        gridPane.setConstraints(valik5, 0, 5);
        gridPane.setHalignment(valik5, HPos.LEFT);

        for (int i = 0; i < toit.size(); i++) {
            valik5.getItems().add(toit.get(i).getToit()); }

        valik5.setTooltip(new Tooltip("vali toit"));
        valik5.getValue();
        valik5.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            for(Person per : toit){
                                if(per.getToit().equals(nimi)){
                                    kogus5 = per.getKogus();
                                    break;
                                }
                            }
                        });
        TextField toidukogus1= new TextField();
        gridPane.setMargin(toidukogus1, new Insets(5));
        gridPane.setConstraints(toidukogus1, 1, 1);
        gridPane.setHalignment(toidukogus1, HPos.LEFT);
        toidukogus1.setPromptText("kogus1");
        toidukogus1.setId("Kogus");

        TextField toidukogus2= new TextField();
        gridPane.setMargin(toidukogus2, new Insets(5));
        gridPane.setConstraints(toidukogus2, 1, 2);
        gridPane.setHalignment(toidukogus2, HPos.LEFT);
        toidukogus2.setPromptText("kogus2");
        toidukogus2.setId("Kogus");

        TextField toidukogus3= new TextField();
        gridPane.setMargin(toidukogus3, new Insets(5));
        gridPane.setConstraints(toidukogus3, 1, 3);
        gridPane.setHalignment(toidukogus3, HPos.LEFT);
        toidukogus3.setPromptText("kogus3");
        toidukogus3.setId("Kogus");

        TextField toidukogus4= new TextField();
        gridPane.setMargin(toidukogus4, new Insets(5));
        gridPane.setConstraints(toidukogus4, 1, 4);
        gridPane.setHalignment(toidukogus4, HPos.LEFT);
        toidukogus4.setPromptText("kogus4");
        toidukogus4.setId("Kogus");

        TextField toidukogus5= new TextField();
        gridPane.setMargin(toidukogus5, new Insets(5));
        gridPane.setConstraints(toidukogus5, 1, 5);
        gridPane.setHalignment(toidukogus5, HPos.LEFT);
        toidukogus5.setPromptText("kogus5");
        toidukogus5.setId("Kogu");


        Label vastus1= new Label();
        gridPane.setConstraints(vastus1, 2, 1);
        gridPane.setColumnSpan(vastus1, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus1, HPos.RIGHT);

        Label vastus2= new Label();
        gridPane.setConstraints(vastus2, 2, 2);
        gridPane.setColumnSpan(vastus2, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus2, HPos.RIGHT);

        Label vastus3= new Label();
        gridPane.setConstraints(vastus3, 2, 3);
        gridPane.setColumnSpan(vastus3, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus3, HPos.RIGHT);

        Label vastus4= new Label();
        gridPane.setConstraints(vastus4, 2, 4);
        gridPane.setColumnSpan(vastus4, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus4, HPos.RIGHT);

        Label vastus5= new Label();
        gridPane.setConstraints(vastus5, 2, 5);
        gridPane.setColumnSpan(vastus5, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus5, HPos.RIGHT);

        Text kokku= new Text();
        kokku.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        gridPane.setConstraints(kokku, 2, 6);
        gridPane.setColumnSpan(kokku, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(kokku, HPos.RIGHT);

        Text text= new Text();
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Button arvuta = new Button();
        arvuta.setText("Arvuta");
        gridPane.setConstraints(arvuta, 1, 6);
        arvuta.setOnAction(event -> {
                    float d1 =0;
                    float d2 =0;
                    float d3 =0;
                    float d4 =0;
                    float d5 =0;
            try {
                int i1 = Integer.valueOf((String) kogus1);
                float a1 = (float) i1;
                String b1 = toidukogus1.getText();
                float c1 = Float.parseFloat(b1);
                d1 = a1 * c1;
                String e1 = "" + d1;
                vastus1.setText(e1);
            }
            catch (Exception e){
                System.out.println("1. lahter tühi");
            }

            try {
                int i2 = Integer.valueOf((String) kogus2);
                float a2 = (float) i2;
                String b2 = toidukogus2.getText();
                float c2 = Float.parseFloat(b2);
                d2 = a2 * c2;
                String e2 = "" + d2;
                vastus2.setText(e2);
            }
            catch (Exception e){
                System.out.println("2. lahter tühi");
            }

            try {
                int i3 = Integer.valueOf((String) kogus3);
                float a3 = (float) i3;
                String b3 = toidukogus3.getText();
                float c3 = Float.parseFloat(b3);
                d3 = a3 * c3;
                String e3 = "" + d3;
                vastus3.setText(e3);
            }
            catch (Exception e){
                System.out.println("3. lahter tühi");
            }

            try {
                int i4 = Integer.valueOf((String) kogus4);
                float a4 = (float) i4;
                String b4 = toidukogus4.getText();
                float c4 = Float.parseFloat(b4);
                d4 = a4 * c4;
                String e4 = "" + d4;
                vastus4.setText(e4);
            }
            catch (Exception e){
                System.out.println("4. lahter tühi");
            }

            try {
                int i5 = Integer.valueOf((String) kogus5);
                float a5 = (float) i5;
                String b5 = toidukogus5.getText();
                float c5 = Float.parseFloat(b5);
                d5 = a5 * c5;
                String e5 = "" + d5;
                vastus5.setText(e5);
            }
            catch (Exception e){
                System.out.println("5. lahter tühi");
            }
                float sum = d1 + d2 + d3 + d4 + d5;
                String sum_string = "KOKKU: " + sum + "g";
                kokku.setText(sum_string);

            try {
                String abc = svok.getText();
                Integer abc1 = Integer.parseInt(abc);
                Integer sum2 = (int) sum / abc1;
                String text_string = "SINU SÜSTITAV KOGUS ON: " + sum2 + " ü";
                text.setText(text_string);
            }
            catch (Exception e){
                System.out.println("Konstant lahter tühi");
            }

            //catch (Exception e){
            //    System.out.println("Osad lahtrid tühjad");
            //}

            }
            );


            gridPane.getChildren().addAll(
                    valik1,
                    valik2,
                    valik3,
                    valik4,
                    valik5,
                    toidukogus1,
                    toidukogus2,
                    toidukogus3,
                    toidukogus4,
                    toidukogus5,
                    vastus1,
                    vastus2,
                    vastus3,
                    vastus4,
                    vastus5,
                    arvuta,
                    kokku
                    //salvesta
            );

            HBox hbox2 = new HBox(10);
            hbox2.setAlignment(Pos.BOTTOM_LEFT);
            hbox2.setPadding(new Insets(10, 10, 10, 10));

            hbox2.getChildren().addAll(text);


            vBox.getChildren().addAll(hbox, gridPane, hbox2);

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






