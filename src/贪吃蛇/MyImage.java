package 贪吃蛇;
import sun.security.rsa.RSAUtil;

import javax.swing.*;
import java.net.URL;

public class MyImage {

     static String shangtou="snakePhoto\\狗上.png";
     static String xiatou="snakePhoto\\狗下.png";
     static String lefttou="snakePhoto\\狗左.png";
     static String righttou="snakePhoto\\狗右.png";

     static String foodimg="snakePhoto\\苹果.png";

    static String bodyimg="snakePhoto\\body.png";

    public  void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }



    public  void setBodyimg(String bodyimg) {
        this.bodyimg = bodyimg;
        System.out.println(bodyimg);
    }

    //以下为从设置界面栏修改之后的设置头图像的方法
    public  void setShangtou(String shangtou) {
        MyImage.shangtou=shangtou;

    }

    public  void setXiatou(String xiatou) {
        this.xiatou = xiatou;
    }

    public  void setLefttou(String lefttou) {
        this.lefttou=lefttou;
    }

    public  void setRighttou(String righttou) {
        this.righttou = righttou;
    }

    //    static URL bodyUrl= MyImage.class.getResource(bodyimg);
    static ImageIcon body=new ImageIcon(bodyimg);

    //    static URL downUrl= MyImage.class.getResource(xiatou);
    static ImageIcon down=new ImageIcon(xiatou);

    //    static URL foodUrl= MyImage.class.getResource(foodimg);
    static ImageIcon food=new ImageIcon(foodimg);
    //    static URL leftUrl= MyImage.class.getResource(lefttou);
    static ImageIcon left=new ImageIcon(lefttou);
    //    static URL rightUrl= MyImage.class.getResource(righttou);
    static ImageIcon right=new ImageIcon(righttou);
    //    static URL upUrl= MyImage.class.getResource(shangtou);
    static ImageIcon up=new ImageIcon(shangtou);
    //    static URL headerUrl= MyImage.class.getResource("D:\\学习文件\\java\\IDEA\\java项目实战弹球小游戏\\snakePhoto\\header.png");
    static ImageIcon header=new ImageIcon("snakePhoto\\header.png");

    public static void setImageIcon(){
        body=new ImageIcon(bodyimg);
        up=new ImageIcon(shangtou);
        right=new ImageIcon(righttou);
        down=new ImageIcon(xiatou);
        food=new ImageIcon(foodimg);
        left=new ImageIcon(lefttou);

    }


}
