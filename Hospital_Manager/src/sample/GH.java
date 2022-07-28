package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GH
{
    public GH(String sfzh,String sj)
    {
        int id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosipitalmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "a2394559659");
            Statement sta = con.createStatement();
            String sql;
            sql = "SELECT * FROM guahao WHERE sfzh = '"+ sfzh +"' ";
            ResultSet res = sta.executeQuery(sql);
            if (res.next()) {
                this.name = res.getString("name");
                //this.shijian = res.getString("sj");
                this.shijian = sj;
                this.shenhe = res.getString("shenhe");
                id = res.getInt("id");
            }
            sql = "SELECT * FROM bingren WHERE shenfenzhenghao = '"+ sfzh + "'";
            res = sta.executeQuery(sql);
            if (res.next()) {
                this.xingbie = res.getString("sex");
            }
            sql = "SELECT * FROM zhuanjia WHERE id = '" + id + "' ";
            res = sta.executeQuery(sql);
            if (res.next()) {
                this.yisheng = res.getString("name");
            }
            sta.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getName()
    {
        return this.name;
    }
    public String getXingbie()
    {
        return this.xingbie;
    }
    public String getYisheng()
    {
        return this.yisheng;
    }
    public String getShijian()
    {
        return this.shijian;
    }
    public String getShenhe()
    {
        return this.shenhe;
    }
    private String name,xingbie,yisheng,shijian,shenhe;
}
