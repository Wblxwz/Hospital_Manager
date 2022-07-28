package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class wangShang {
    @FXML
    public void neiKe(ActionEvent event) throws Exception
    {
        Stage ws = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("zhuanJia.fxml"));
        ws.setTitle("专家列表");
        ws.setScene(new Scene(root, 800, 600));
        ws.initModality(Modality.APPLICATION_MODAL);
        ws.setResizable(false);
        ws.show();
    }
}
