package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class ZhuanJia implements Initializable {
    private static int id;
    public int getId()
    {
        return id;
    }
    private int zonghao1 = 50,zonghao2 = 50,yuhao1 = 50,yuhao2 = 50;
    @FXML
    private Label time1,time2,zh1,zh2,yh1,yh2;
    @Override
    public void initialize(URL url, ResourceBundle r)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date d = calendar.getTime();
        calendar.add(Calendar.DATE,5);
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrow = sp.format(d);
        time1.setText(tomorrow + "上午\n");
        time2.setText(tomorrow + "下午\n");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
            Statement sta = con.createStatement();
            String sql;
            sql = "SELECT * FROM zhuanjia WHERE id = 1";
            ResultSet res = sta.executeQuery(sql);
            if (res.next()) {
                yuhao1 = res.getInt("yuhao");
            }
            sql = "SELECT * FROM zhuanjia WHERE id = 2";
            res = sta.executeQuery(sql);
            if (res.next()) {
                yuhao2 = res.getInt("yuhao");
            }
            sta.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        zh1.setText(Integer.toString(zonghao1) + "\n");
        zh2.setText(Integer.toString(zonghao2) + "\n");
        yh1.setText(Integer.toString(yuhao1) + "\n");
        yh2.setText(Integer.toString(yuhao2) + "\n");
    }
    public void yuYueStage(ActionEvent event) throws Exception
    {
        String s = event.getSource().toString();
        s = s.substring(10,12);
        String ss = "zs";
        if(s.equals(ss))
            id = 1;
        else
            id = 2;
        Stage yuYueStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("yuYue.fxml"));
        yuYueStage.setTitle("预约");
        yuYueStage.setScene(new Scene(root, 800, 600));
        yuYueStage.initModality(Modality.APPLICATION_MODAL);
        yuYueStage.setResizable(false);
        yuYueStage.show();
    }
}
