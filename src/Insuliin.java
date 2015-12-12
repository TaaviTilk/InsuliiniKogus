import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Insuliin extends Application{
    ChoiceBox valik;
    TextField toidulahter1;
    TextField toidukogus1;
    Button arvuta;
    Button salvesta;
    String tn1;




    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Insuliini koguse arvutamine");
        primaryStage.setWidth(450);
        primaryStage.setHeight(250);


        // TOP
        HBox hbox = new HBox(10);
        //hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        // Hiljem võiks teha juurde uue kasutaja lisamise mooduli


        //ChoiceBox valik = new ChoiceBox();
        ChoiceBox valik = new ChoiceBox(FXCollections.observableArrayList(
                "Kasper", "Jesper", "Joonatan")
        );
        valik.setTooltip(new Tooltip("Vali kasutaja"));
        valik.getValue();
        valik.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            System.out.println(nimi);
                        });


        hbox.setMargin(valik, new Insets(5));



        TextField lahter2= new TextField();
        hbox.setMargin(lahter2, new Insets(5)); // toob kasti 5 pix eemale servast
        lahter2.setPrefWidth(60); // kasti pikkus
        lahter2.setPromptText("number"); //tekitab kasti eelteksti



        hbox.getChildren().addAll(valik,lahter2);

        // CENTER
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setHgap(10); //horisontaalne
        gridPane.setVgap(10); //vertikaalne
        gridPane.setPadding(new Insets(10, 10, 10, 10));


        TextField toidulahter1= new TextField();
        gridPane.setMargin(toidulahter1, new Insets(5));
        gridPane.setConstraints(toidulahter1, 0, 1);
        gridPane.setHalignment(toidulahter1, HPos.LEFT);
        toidulahter1.setPromptText("toit1");
        toidulahter1.setId("Toit1");

        TextField toidukogus1= new TextField();
        gridPane.setMargin(toidukogus1, new Insets(5));
        gridPane.setConstraints(toidukogus1, 1, 1);
        gridPane.setHalignment(toidukogus1, HPos.LEFT);
        toidukogus1.setPromptText("kogus1");
        toidukogus1.setId("Kogus1");






        //Text tekst1= new Text("vasakul");

        Label vastus= new Label();
        gridPane.setConstraints(vastus, 2, 1);
        gridPane.setColumnSpan(vastus, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus, HPos.RIGHT);


        Button arvuta = new Button();
        arvuta.setText("Arvuta");
        arvuta.setOnAction(event -> {
                    float a = 20;
                    String b = toidukogus1.getText();
                    float c = Float.parseFloat(b);
                    float d = a*c;
                    String e = ""+d;
                    vastus.setText(e);
                }
        );



        gridPane.getChildren().addAll(
                //cb,
                toidulahter1,
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

        // Lava
        BorderPane lava = new BorderPane();
        lava.setTop(hbox);
        lava.setCenter(gridPane);
        Scene scene = new Scene(lava); //, 500,300
        primaryStage.setScene(scene);
        primaryStage.show();


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






