package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {
    @FXML
    public void xuZhi(ActionEvent event) throws Exception
    {
        Stage xuZhiStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("xuZhi.fxml"));
        xuZhiStage.setTitle("挂号须知");
        xuZhiStage.setScene(new Scene(root, 800, 600));
        xuZhiStage.initModality(Modality.APPLICATION_MODAL);
        xuZhiStage.setResizable(false);
        xuZhiStage.show();
    }
    @FXML
    public void bingYuan(ActionEvent event) throws Exception
    {
        Stage bingYuanStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bingYuan.fxml"));
        bingYuanStage.setTitle("病员注册");
        bingYuanStage.setScene(new Scene(root, 800, 600));
        bingYuanStage.initModality(Modality.APPLICATION_MODAL);
        bingYuanStage.setResizable(false);
        bingYuanStage.show();
    }
    @FXML
    public void wangShang(ActionEvent event) throws Exception
    {
        Stage wangShangStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("wangShang.fxml"));
        wangShangStage.setTitle("网上挂号");
        wangShangStage.setScene(new Scene(root, 800, 600));
        wangShangStage.initModality(Modality.APPLICATION_MODAL);
        wangShangStage.setResizable(false);
        wangShangStage.show();
    }
    @FXML
    public void guaHao(ActionEvent event) throws Exception
    {
        Stage guaHaoStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("guaHao.fxml"));
        guaHaoStage.setTitle("挂号查询");
        guaHaoStage.setScene(new Scene(root, 1000, 600));
        guaHaoStage.initModality(Modality.APPLICATION_MODAL);
        guaHaoStage.setResizable(false);
        guaHaoStage.show();
    }
}
