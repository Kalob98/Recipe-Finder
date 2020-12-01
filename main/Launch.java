package main;

/**
 * This class is used to start the application.
 *
 * @author Brody
 * @author Kalob Reinholz
 * @author Heng Tan
 *
 * Last updated 10/28/20
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.WindowSize;

public class Launch extends Application {

    @Override
    public void start(Stage _stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));

        Scene scene = new Scene(root);

        _stage.setTitle("Recipe Finder");
        _stage.getIcons().add(new Image("assets/ChickenLeg.png"));
        _stage.setScene(scene);
        _stage.setHeight(WindowSize.height);
        _stage.setWidth(WindowSize.width);
        _stage.show();
    }

    public static void main(String[] _args) {
        launch(_args);
    }
}
