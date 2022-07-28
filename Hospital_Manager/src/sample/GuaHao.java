package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GuaHao implements Initializable
{
    int cnt = 0;
    @FXML
    private TableView biao;
    @FXML
    private TextField sfzh,id;
    @FXML
    private PasswordField mm;
    @FXML
    private TableColumn xm,xb,ys,sj,sh;
    @FXML
    public void qingLing()
    {
        if(id.getText().isEmpty() || mm.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("清零错误");
            error.setContentText("请检查医生id或输入密码");
            error.showAndWait();
        }
        else {
            if (mm.getText().equals("root") && (id.getText().equals("1") || id.getText().equals("2"))) {
                String id1 = id.getText();
                System.out.println(id1);
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "UPDATE zhuanjia SET yuhao = 0 WHERE id = '" + id1 + "'";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("清零成功");
                    information.setContentText("清零成功");
                    information.showAndWait();
                    sta.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("清零错误");
                error.setContentText("请检查医生id或输入密码");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void sheMan()
    {
        if(id.getText().isEmpty() || mm.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("设满错误");
            error.setContentText("请检查医生id或输入密码");
            error.showAndWait();
        }
        else {
            if(mm.getText().equals("root") && (id.getText().equals("1") || id.getText().equals("2"))) {
                String id1 = id.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "UPDATE zhuanjia SET yuhao = 50 WHERE id = '" + id1 + "'";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("设满成功");
                    information.setContentText("设满成功");
                    information.showAndWait();
                    sta.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("设满错误");
                error.setContentText("请检查医生id或输入密码");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void shenHe()
    {
        GH gh = (GH)biao.getSelectionModel().getSelectedItem();
        String sj1 = gh.getShijian();
        if(mm.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("审核错误");
            error.setContentText("请检查输入密码");
            error.showAndWait();
        }
        else {
            if(mm.getText().equals("root"))
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "UPDATE guahao SET shenhe = '已审核' WHERE sj = '"+ sj1 +"'";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("审核成功");
                    information.setContentText("审核成功");
                    information.showAndWait();
                    sta.close();
                    con.close();
                    chaXun();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("审核错误");
                error.setContentText("请检查输入密码");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void buTongGuo()
    {
        GH gh = (GH)biao.getSelectionModel().getSelectedItem();
        String sj1 = gh.getShijian();
        if(mm.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("审核错误");
            error.setContentText("请检查输入密码");
            error.showAndWait();
        }
        else {
            if(mm.getText().equals("root"))
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "UPDATE guahao SET shenhe = '审核未通过' WHERE sj = '"+ sj1 +"'";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("已未通过审核");
                    information.setContentText("已未通过审核");
                    information.showAndWait();
                    sta.close();
                    con.close();
                    chaXun();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("审核错误");
                error.setContentText("请检查输入密码");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void chaXun()
    {
        if(sfzh.getText().length() != 18)
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("查询失败");
            error.setContentText("请检查身份证号格式！");
        }
        biao.getItems().clear();
        if(!sfzh.getText().isEmpty())
        {
            xm.setCellValueFactory(new PropertyValueFactory<>("name"));
            xb.setCellValueFactory(new PropertyValueFactory<>("xingbie"));
            ys.setCellValueFactory(new PropertyValueFactory<>("yisheng"));
            sj.setCellValueFactory(new PropertyValueFactory<>("shijian"));
            sh.setCellValueFactory(new PropertyValueFactory<>("shenhe"));
            String shenfen = sfzh.getText();
            String sj1 = new String();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                Statement sta = con.createStatement();
                String sql;
                sql = "SELECT * FROM guahao";
                ResultSet res = sta.executeQuery(sql);
                if (res.next())
                {
                    sj1 = res.getString(("sj"));
                }
                sta.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            biao.getItems().add(new GH(shenfen,sj1));
        }
        else
        {
            xm.setCellValueFactory(new PropertyValueFactory<>("name"));
            xb.setCellValueFactory(new PropertyValueFactory<>("xingbie"));
            ys.setCellValueFactory(new PropertyValueFactory<>("yisheng"));
            sj.setCellValueFactory(new PropertyValueFactory<>("shijian"));
            sh.setCellValueFactory(new PropertyValueFactory<>("shenhe"));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                Statement sta = con.createStatement();
                String sql;
                sql = "SELECT * FROM guahao";
                ResultSet res = sta.executeQuery(sql);
                while (res.next()) {
                    String sfzh = res.getString("sfzh");
                    String sj = res.getString(("sj"));
                    biao.getItems().add(new GH(sfzh,sj));
                }
                sta.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cnt++;
    }
    @FXML
    public void shanChu()
    {
        GH gh = (GH)biao.getSelectionModel().getSelectedItem();
        if(mm.getText().isEmpty() && sfzh.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("审核错误");
            error.setContentText("请检查输入密码");
            error.showAndWait();
        }
        else {
            if(mm.getText().equals("root")) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "DELETE FROM guahao WHERE sj = '" + gh.getShijian() + "'";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("已成功删除");
                    information.setContentText("已成功删除");
                    information.showAndWait();
                    sta.close();
                    con.close();
                    chaXun();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                chaXun();
            }
            else if(!sfzh.getText().isEmpty())
            {
                GH gh1 = (GH)biao.getSelectionModel().getSelectedItem();
                String sj2 = gh1.getShijian();
                String sfzh1 = new String();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql;
                    sql = "SELECT * FROM guahao WHERE sj = '"+ sj2 + "'";
                    ResultSet res = sta.executeQuery(sql);
                    if(res.next())
                    {
                        sfzh1 = res.getString("sfzh");
                    }
                    if(sfzh.getText().equals(sfzh1))
                    {
                        sql = "DELETE FROM guahao WHERE sj = '"+ sj2 + "'";
                        sta.executeUpdate(sql);
                        Alert information = new Alert(Alert.AlertType.INFORMATION);
                        information.setTitle("Information");
                        information.setHeaderText("已成功删除");
                        information.setContentText("已成功删除");
                        information.showAndWait();
                        chaXun();
                    }
                    else
                    {
                        Alert error = new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Error");
                        error.setHeaderText("删除错误");
                        error.setContentText("请检查身份证号");
                        error.showAndWait();
                    }
                    sta.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("审核错误");
                error.setContentText("请检查输入密码或身份证号");
                error.showAndWait();
            }
        }
    }
    @FXML
    public void qingChu()
    {
        if(mm.getText().isEmpty())
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("审核错误");
            error.setContentText("请检查输入密码");
            error.showAndWait();
        }
        else {
            if (mm.getText().equals("root")) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                    Statement sta = con.createStatement();
                    String sql = "DELETE FROM guahao";
                    sta.executeUpdate(sql);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setHeaderText("已全部删除");
                    information.setContentText("已全部删除");
                    information.showAndWait();
                    sta.close();
                    con.close();
                    chaXun();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("审核错误");
                error.setContentText("请检查输入密码");
                error.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        biao.setPlaceholder(new Label("身份证号为空时查询全部挂号信息，存在身份证号时查询指定信息"));
        sfzh.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (sfzh.getText().length() > 18)
                    sfzh.setText(sfzh.getText().substring(0, 18));
                if(!sfzh.getText().matches("^[A-Za-z0-9]+$"))
                    sfzh.clear();
            }
        });
        mm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(mm.getText().length() > 10)
                    mm.setText(mm.getText().substring(0,10));
                if(!mm.getText().matches("^\\w+$"))
                    mm.clear();
            }
        });
    }
}
