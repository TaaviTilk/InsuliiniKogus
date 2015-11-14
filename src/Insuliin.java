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
    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Insuliini koguse arvutamine");


        // TOP
        HBox hbox = new HBox(10);
        //hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.setPadding(new Insets(10, 10, 10, 10));

        // Hiljem v�iks teha juurde uue kasutaja lisamise mooduli



        ChoiceBox valik = new ChoiceBox(FXCollections.observableArrayList(
                "Kasper", "Jesper", "Joonatan")
        );
        valik.setTooltip(new Tooltip("Vali kasutaja"));
        valik.getValue();
        valik.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object nimi) -> {
                            // Do stuff
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
/*
        TextField toidulahter2= new TextField();
        gridPane.setMargin(toidulahter2, new Insets(5));
        gridPane.setConstraints(toidulahter2, 0, 2);
        gridPane.setHalignment(toidulahter2, HPos.LEFT);
        toidulahter2.setPromptText("toit2");

        TextField toidulahter3= new TextField();
        gridPane.setMargin(toidulahter3, new Insets(5));
        gridPane.setConstraints(toidulahter3, 0, 3);
        gridPane.setHalignment(toidulahter3, HPos.LEFT);
        toidulahter3.setPromptText("toit3");

        TextField toidulahter4= new TextField();
        gridPane.setMargin(toidulahter4, new Insets(5));
        gridPane.setConstraints(toidulahter4, 0, 4);
        gridPane.setHalignment(toidulahter4, HPos.LEFT);
        toidulahter4.setPromptText("toit4");

        TextField toidulahter5= new TextField();
        gridPane.setMargin(toidulahter5, new Insets(5));
        gridPane.setConstraints(toidulahter5, 0, 5);
        gridPane.setHalignment(toidulahter5, HPos.LEFT);
        toidulahter5.setPromptText("toit5");
*/
        TextField toidukogus1= new TextField();
        gridPane.setMargin(toidukogus1, new Insets(5));
        gridPane.setConstraints(toidukogus1, 1, 1);
        gridPane.setHalignment(toidukogus1, HPos.LEFT);
        toidukogus1.setPromptText("kogus1");
        toidukogus1.setId("Kogus1");
/*
        TextField toidukogus2= new TextField();
        gridPane.setMargin(toidukogus2, new Insets(5));
        gridPane.setConstraints(toidukogus2, 1, 2);
        gridPane.setHalignment(toidukogus2, HPos.LEFT);
        toidukogus2.setPromptText("kogus2");

        TextField toidukogus3= new TextField();
        gridPane.setMargin(toidukogus3, new Insets(5));
        gridPane.setConstraints(toidukogus3, 1, 3);
        gridPane.setHalignment(toidukogus3, HPos.LEFT);
        toidukogus3.setPromptText("kogus3");

        TextField toidukogus4= new TextField();
        gridPane.setMargin(toidukogus4, new Insets(5));
        gridPane.setConstraints(toidukogus4, 1, 4);
        gridPane.setHalignment(toidukogus4, HPos.LEFT);
        toidukogus4.setPromptText("kogus4");

        TextField toidukogus5= new TextField();
        gridPane.setMargin(toidukogus5, new Insets(5));
        gridPane.setConstraints(toidukogus5, 1, 5);
        gridPane.setHalignment(toidukogus5, HPos.LEFT);
        toidukogus5.setPromptText("kogus5");
*/
        Button arvuta = new Button();
        arvuta.setText("Arvuta");
        arvuta.setOnAction(event -> {
                    System.out.println("Arvutatud");
                }
        );
        gridPane.setConstraints(arvuta, 1, 6);
        gridPane.setHalignment(arvuta, HPos.RIGHT);

        Button salvesta = new Button();
        salvesta.setText("Salvesta");
        salvesta.setOnAction(event -> {
                    System.out.println("Salvestatud");
                }
        );
        gridPane.setConstraints(salvesta, 1, 7);
        gridPane.setHalignment(salvesta, HPos.RIGHT);

        //Text tekst1= new Text("vasakul");


        Label vastus= new Label();
        gridPane.setConstraints(vastus, 2, 1);
        gridPane.setColumnSpan(vastus, 1); // näitab mitu veergu ta ära katab 1 või 2
        gridPane.setHalignment(vastus, HPos.RIGHT);
        vastus.setText(toidulahter1.getId()+toidukogus1.getId());


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
                arvuta,
                salvesta
        );

        // Lava
        BorderPane lava = new BorderPane();
        lava.setTop(hbox);
        lava.setCenter(gridPane);
        Scene scene = new Scene(lava); //, 500,300
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


        ///static String nimi;
        ///static int insuliinikogus;

        // Kõsib isikut
        // küsib süsivesikute hulka ühe stitava insuliini �hiku kohta nt 10 (g) (vahemik 10-14 g)
        //isik();
        ///insuliinikogus ();

        // Mis toitu sõid
        //toit ();

        // toidu kogust
        // arvutab toidukoguse kokku
        // Arvutab s�stitava insuliini koguse.
        // Salvestada s�stitav kopgus ja s�sivesikute hulk andmebaasi






