package 贪吃蛇;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class DataBase {
//
//    //将玩家数据库中的数据全部导入
//
//    public ArrayList search_allpeople() {
//        ArrayList A = new ArrayList();
//        Connection conn = null;
//        Statement stat = null;
//        ResultSet result = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsproject", "root", "123456");
//            stat = conn.createStatement();
//            result = stat.executeQuery("select * from code");
//
//
//            while (result.next()) {
//                for (int i = 1; i <= 3; i++) {
//                    A.add(result.getString(i));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//                stat.close();
//                result.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return A;
//    }


    //数据库的增加
    /*此处有错*/
    public void add(String name,int code) throws SQLException {

        /*
        增加信息
         */

        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        name = "" + name + "";


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsproject", "root", "123456");
            st = con.createStatement();
            String sql = "select * from code where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
//            rs = st.executeQuery("select * from code where name =" + name);

            if (!rs.next()) {
                String sq1 = "insert into code (name,code) values(?,?)";
                ps = con.prepareStatement(sq1);
                ps.setString(1, name);
                ps.setInt(2, code);


                int result = ps.executeUpdate();
                if (result != 0) {
                    System.out.println("插入成功！");
                }
            } else {
                System.out.println("插入失败！该用户id已存在");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //    从这个获取到数据中的游戏玩家的信息
    public Vector wanjiaxinxi() {
        Vector<Vector> A = new Vector();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsproject", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery("select * from code");


            while (result.next()) {
                Vector A1 = new Vector();
                for (int a = 1; a <= 2; a++) {
                    A1.add(result.getString(a));
                }
                A.add(A1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return A;
//        返回的是一个Vector数组
    }







//    //判断如果玩家积分顶替排行榜的数据库连接
//    public void shangbang(int id) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList A = new ArrayList();
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//        Statement st = null;
//        ResultSet rs = null;
//        try {
//            // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsproject", "root", "123456");
//            st = conn.createStatement();
//            rs = st.executeQuery("select * from code where id=" + id);
//
//            if (rs.next()) {
//                System.out.println("存在该用户");
//                System.out.println("请输入你的姓名或者代号");
//                String name = sc.next();
//
//                System.out.println("请输入你的积分");
//                String code = sc.next();
//
//                String sql = "update code set name=?,code=? where id=? ";
//                ps = conn.prepareStatement(sql);
//
//                ps.setString(1, name);
//                ps.setString(2, code);
//                ps.setInt(3,id);
//
//
//                int count = ps.executeUpdate();
//                if (count > 0)
//                    System.out.println("修改成功");
//                else
//                    System.out.println("失败");
//            } else {
//                System.out.println("不存在该用户");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    //测试本页代码是否正常运行
    public static void main(String[] args) {
        DataBase d = new DataBase();
        try {
            d.add("name1211",17);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
