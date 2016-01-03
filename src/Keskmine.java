import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * Created by Taavi Tilk on 30.12.2015.
 */
public class Keskmine {

    static HBox hBox;
    static Label lbl;
    static Button btn1;
    static Button btn2;

    public Keskmine (){
        Kesk();
    }

    private void Kesk () {



        hBox = new HBox(10);
        lbl = new Label("HBox");

        // Buttons
        btn1 = new Button();
        btn1.setText("Button1");

        btn2 = new Button();
        btn2.setText("Button2");

        hBox.getChildren().addAll(lbl,btn1,btn2);

    }
}
