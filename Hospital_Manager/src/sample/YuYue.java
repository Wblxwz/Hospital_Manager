package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class YuYue implements Initializable {
    public int getId()
    {
        ZhuanJia zhuanJia = new ZhuanJia();
        int id_1 = zhuanJia.getId();
        return id_1;
    }
    private int id = getId();
    private boolean zhuce = false;
    @FXML
    private ComboBox xlk;
    @FXML
    private Label mc,sj,zh,yh,jj;
    @FXML
    private TextField zsxm,sfzh;
    @FXML
    private PasswordField mm;
    @FXML
    public void guaHao()
    {
        if(zsxm.getText().matches("^[\\u4e00-\\u9fa5]{0,}$") && !zsxm.getText().isEmpty() && !mm.getText().isEmpty() && mm.getText().matches("^\\w+$") && sfzh.getText().matches("^[A-Za-z0-9]+$") && sfzh.getText().length() == 18 && xlk.getValue().toString()!="请选择预约时间") {
            int x = 0;
            String yysj = xlk.getValue().toString();
            String shenfenzheng = sfzh.getText();
            int flag = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                Statement sta = con.createStatement();
                String sql;
                sql = "SELECT * FROM bingren WHERE shenfenzhenghao = '" + shenfenzheng + "' AND name = '"+ zsxm.getText() +"' AND password = '"+ mm.getText() +"'";
                ResultSet res = sta.executeQuery(sql);
                res = sta.executeQuery(sql);
                if (res.next()) {
                    zhuce = true;
                }
                if (id == 1) {
                    sql = "SELECT * FROM zhuanjia WHERE id = 1";
                } else {
                    sql = "SELECT * FROM zhuanjia WHERE id = 2";
                }
                res = sta.executeQuery(sql);
                if (res.next()) {
                    x = res.getInt("yuhao");
                }
                String sh = "未审核";
                if (x > 0) {
                    String name = zsxm.getText();
                    String password = mm.getText();
                    if (zhuce) {
                        sql = "INSERT IGNORE INTO guahao VALUES('" + name + "','" + password + "','" + shenfenzheng + "','" + yysj + "','" + sh + "','" + id + "')";
                    }
                    if(zhuce)
                        flag = sta.executeUpdate(sql);
                    if(flag == 1) {
                        yh.setText(Integer.toString(x - 1));
                    }
                }
                if (x > 0 && flag == 1) {
                    if (id == 1) {
                        sql = "UPDATE zhuanjia SET zhuanjia.yuhao = zhuanjia.yuhao - 1 WHERE zhuanjia.id = 1; ";
                    } else {
                        sql = "UPDATE zhuanjia SET zhuanjia.yuhao = zhuanjia.yuhao - 1 WHERE zhuanjia.id = 2; ";
                    }
                    sta.executeUpdate(sql);
                    yh.setText(Integer.toString(x - 1));
                }
                sta.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(zhuce && flag == 1)
            {
                Alert information = new Alert(Alert.AlertType.INFORMATION);
                information.setTitle("Information");
                information.setHeaderText("预约成功");
                information.setContentText("预约成功！");
                information.showAndWait();
            }
            else
            {
                boolean f = true;
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error!");
                error.setHeaderText("挂号失败");
                error.setContentText("请确认是否已注册或输入信息错误！");
                error.showAndWait();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql;
                    String s = xlk.getValue().toString();
                    sql = "SELECT * FROM guahao WHERE sj LIKE '"+ s +"'";
                    ResultSet res = sta.executeQuery(sql);
                    res = sta.executeQuery(sql);
                    if(res.next())
                    {
                        f = false;
                    }
                    sta.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(!f)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("挂号失败");
                    alert.setContentText("当前时间已被预约，请选择其他时间！");
                    alert.showAndWait();
                }
            }
        }
        else
        {
            if(xlk.getValue().toString() != "请选择预约时间")
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error!");
                error.setHeaderText("挂号失败");
                error.setContentText("请确认输入信息格式或密码是否正确！");
                error.showAndWait();
                System.out.println("1");
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error!");
                error.setHeaderText("挂号失败");
                error.setContentText("请确认预约时间！");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void zhuCe() throws Exception
    {
        Stage bingYuan = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bingYuan.fxml"));
        bingYuan.setTitle("病员注册");
        bingYuan.setScene(new Scene(root, 800, 600));
        bingYuan.initModality(Modality.APPLICATION_MODAL);
        bingYuan.setResizable(false);
        bingYuan.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle r)
    {
        zsxm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(zsxm.getText().length() > 6)
                    zsxm.setText(zsxm.getText().substring(0,6));
            }
        });
        mm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(mm.getText().length() > 12)
                    mm.setText(mm.getText().substring(0,12));
            }
        });
        sfzh.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(sfzh.getText().length() > 18)
                    sfzh.setText(sfzh.getText().substring(0,18));
            }
        });
        String tomorrow = new String();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
            Statement sta = con.createStatement();
            String sql;
            sql = "SELECT ADDDATE(CURRENT_DATE(),1)";
            ResultSet res = sta.executeQuery(sql);
            if(res.next())
            {
                tomorrow = res.getString(1).toString();
            }
            if(id == 1) {
                sql = "SELECT * FROM zhuanjia WHERE id = 1";
                sj.setText(tomorrow + "上午");
                jj.setText("擅长内科一");
            }
            else {
                sql = "SELECT * FROM zhuanjia WHERE id = 2";
                sj.setText(tomorrow + "下午");
                jj.setText("擅长内科二");
            }
            res = sta.executeQuery(sql);
            if(res.next()) {
                mc.setText(res.getString("name"));
                zh.setText(res.getString("zonghao"));
                yh.setText(res.getString("yuhao"));
            }
            sta.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(id == 1) {
            String times[] = {tomorrow + " 08:00~08:30", tomorrow + " 08:30~09:00", tomorrow + " 09:00~09:30", tomorrow + " 09:30~10:00", tomorrow + " 10:00~10:30", tomorrow + " 10:30~11:00", tomorrow + " 11:00~11:30"};
            xlk.setItems(FXCollections.observableArrayList(times));
            xlk.setValue("请选择预约时间");
        }
        else
        {
            String times[] = {tomorrow + " 14:00~14:30", tomorrow + " 14:30~15:00", tomorrow + " 15:00~15:30", tomorrow + " 15:30~16:00", tomorrow + " 16:00~16:30", tomorrow + " 16:30~17:00", tomorrow + " 17:00~17:30"};
            xlk.setItems(FXCollections.observableArrayList(times));
            xlk.setValue("请选择预约时间");
        }
    }
}
