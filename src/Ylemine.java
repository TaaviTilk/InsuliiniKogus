import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * Created by Taavi Tilk on 30.12.2015.
 */
public class Ylemine {


    VBox vb;
    Label lbl;
    Button btn1;
    Button btn2;

    public Ylemine (){
        Top();
    }


    private void Top () {



        vb = new VBox(10);
        lbl = new Label("VBox");

        // Buttons
        btn1 = new Button();
        btn1.setText("Button1");

        btn2 = new Button();
        btn2.setText("Button2");

        vb.getChildren().addAll(lbl,btn1,btn2);

    }
}
