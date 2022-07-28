package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage mainStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage.setTitle("网上预约挂号系统");
        mainStage.setScene(new Scene(root, 800, 300));
        mainStage.setResizable(false);
        //mainStage.initModality(Modality.APPLICATION_MODAL);
        mainStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
