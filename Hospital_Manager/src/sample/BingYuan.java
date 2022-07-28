package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BingYuan implements Initializable
{
    private boolean xmf = false,mmf = false,sfzhf = false,lxdhf = false,txzzf = false ,bqqkf = false;
    private int flag = 0;
    @FXML
    private TextField xingming;
    @FXML
    private PasswordField mima;
    @FXML
    private TextField shenfenzhenghao;
    @FXML
    private TextField lianxidianhua;
    @FXML
    private TextField tongxinzhuzhi;
    @FXML
    private TextArea bingqingqingkuang;
    @FXML
    private RadioButton nan;
    @FXML
    private RadioButton nv;
    @FXML
    private Label ts1;
    @FXML
    private Label ts2;
    @FXML
    private Label ts3;
    @FXML
    private Label ts4;
    @FXML
    private Label ts5;
    @FXML
    private Label ts6;
    //重构分支结构
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            xingming.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (xingming.getText().length() > 6)
                        xingming.setText(xingming.getText().substring(0, 6));
                    if(!xingming.getText().matches("^[\\u4e00-\\u9fa5]{0,}$")) {
                        ts1.setText("真实姓名填写有误！");
                        xmf = false;
                    }
                    else if(xingming.getText().isEmpty()) {
                        ts1.setText("真实姓名不能为空！");
                        xmf = false;
                    }
                    else if(xingming.getText().length() >= 2 && xingming.getText().length() <=6)
                    {
                        ts1.setText("OK!");
                        xmf = true;
                    }
                }
            });
            mima.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (mima.getText().length() > 12)
                        mima.setText(mima.getText().substring(0, 12));
                    if(!mima.getText().matches("^\\w+$")) {
                        ts2.setText("密码填写有误！");
                        mmf = false;
                    }
                    else if(mima.getText().isEmpty()) {
                        ts2.setText("密码不能为空！");
                        mmf = false;
                    }
                    else {
                        ts2.setText("OK!");
                        mmf = true;
                    }
                }
            });
            shenfenzhenghao.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (shenfenzhenghao.getText().length() > 18)
                        shenfenzhenghao.setText(shenfenzhenghao.getText().substring(0, 18));
                    if(!shenfenzhenghao.getText().matches("^[A-Za-z0-9]+$") || shenfenzhenghao.getText().length() != 18) {
                        ts3.setText("身份证号格式错误！");
                        sfzhf = false;
                    }
                    else if(shenfenzhenghao.getText().isEmpty()) {
                        ts3.setText("身份证号不能为空！");
                        sfzhf = false;
                    }
                    else {
                        ts3.setText("OK!");
                        sfzhf = true;
                    }
                }
            });
            lianxidianhua.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (lianxidianhua.getText().length() > 11)
                        lianxidianhua.setText(lianxidianhua.getText().substring(0, 11));
                    if(!lianxidianhua.getText().matches("^[0-9]*$") || lianxidianhua.getText().length() != 11) {
                        ts4.setText("联系电话格式错误！");
                        lxdhf = false;
                    }
                    else if(lianxidianhua.getText().isEmpty()) {
                        ts4.setText("联系电话不能为空！");
                        lxdhf = false;
                    }
                    else {
                        ts4.setText("OK!");
                        lxdhf = true;
                    }
                }
            });
            tongxinzhuzhi.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (tongxinzhuzhi.getText().length() > 40)
                        tongxinzhuzhi.setText(tongxinzhuzhi.getText().substring(0, 40));
                    if(tongxinzhuzhi.getText().isEmpty()) {
                        ts5.setText("通信住址不能为空！");
                        txzzf = false;
                    }
                    else {
                        ts5.setText("OK!");
                        txzzf = true;
                    }
                }
            });
            bingqingqingkuang.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (bingqingqingkuang.getText().length() > 120)
                        bingqingqingkuang.setText(bingqingqingkuang.getText().substring(0, 120));
                    if(bingqingqingkuang.getText().isEmpty()) {
                        ts6.setText("病情状况不能为空！");
                        bqqkf = false;
                    }
                    else {
                        ts6.setText("OK!");
                        bqqkf = true;
                    }
                }
            });
            bingqingqingkuang.setWrapText(true);
        }
    @FXML
    public void tiJiao()
    {
        if(xmf && mmf && sfzhf && lxdhf && txzzf && bqqkf) {
            String xm, mm, sfzh, lxdh, txzz, bqqk, xingbie;
            boolean n1 = nan.isSelected();
            xm = xingming.getText();
            mm = mima.getText();
            sfzh = shenfenzhenghao.getText();
            lxdh = lianxidianhua.getText();
            txzz = tongxinzhuzhi.getText();
            bqqk = bingqingqingkuang.getText();
            if (n1)
                xingbie = "男";
            else
                xingbie = "女";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
                Statement sta = con.createStatement();
                String sql = "INSERT IGNORE INTO bingren VALUES('" + xm + "','" + mm + "','" + sfzh + "','" + xingbie + "','" + lxdh + "','" + txzz + "','" + bqqk + "')";
                flag = sta.executeUpdate(sql);
                if(flag == 0)
                {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Error");
                    error.setHeaderText("注册失败");
                    error.setContentText("此用户已注册");
                    error.showAndWait();
                }
                else
                {
                    Alert in = new Alert(Alert.AlertType.INFORMATION);
                    in.setTitle("Information");
                    in.setHeaderText("注册成功");
                    in.setContentText("注册成功！");
                    in.showAndWait();
                    Stage stage = (Stage) xingming.getScene().getWindow();
                    stage.close();
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
            error.setTitle("Error!");
            error.setHeaderText("注册失败");
            error.setContentText("请确认输入信息格式是否正确！");
            error.showAndWait();
        }
    }
    @FXML void chongZhi(ActionEvent event)
    {
        xingming.clear();
        mima.clear();
        shenfenzhenghao.clear();
        lianxidianhua.clear();
        tongxinzhuzhi.clear();
        bingqingqingkuang.clear();
    }
}