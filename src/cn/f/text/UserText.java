package cn.f.text;

import java.util.Scanner;

import cn.f.Dao.UserDao;  //一个用户登录注册接口
import cn.f.Dao.impl.UserDaoImpl;  //实现用户登录注册功能实现类
import cn.f.game.GuessNumber;  //用户体验用户注册登录成功后给用户玩个小游戏
import cn.f.pojo.User;

public class UserText {
    static Scanner sc = new Scanner(System.in);
    //多态
    static UserDao ud = new UserDaoImpl();

    public static void denglu(){
        System.out.println("---------登录界面（请先注册后再登录！）--------");
        System.out.println("请输入用户名：");
        String n = sc.nextLine();
        System.out.println("请输入密码：");
        String p = sc.nextLine();
        //调用登录功能
        boolean flag = ud.isLogin(n,p);
        if (flag){
            System.out.println("登陆成功！奖励你玩游戏。");
            System.out.println("你要玩？y/n");
            while(true) {
                String r = sc.nextLine();
                if (r.equalsIgnoreCase("y")) {
                    //玩游戏
                    GuessNumber.strat();
                    System.out.println("是否继续游戏？y/n");
                } else {
                    break;
                }
            }
            System.out.println("谢谢使用，欢迎下次再来！");
            System.exit(0);
        }
        else{
            System.out.println("用户名或者密码有误，登录失败！");
        }
    }
    public static void zhuce(){
        //注册界面，请输入用户名和密码
        System.out.println("---------注册界面----------");
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String mima = sc.nextLine();
        //把用户名和密码封装到一个对象中
        User user = new User();
        user.setName(name);
        user.setMima(mima);
        //调用注册功能
        ud.regist(user);
        System.out.println("注册成功！");

    }
    public static void main(String[] args){
        while(true){
            //欢迎界面，给出选项
            System.out.println("---------欢迎光临---------");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.println("请输入你的选择：");
            //键盘录入选择，根据选择做出不同的操作

            //为了后面录入信息方便，我将所有的数据录入全部用字符接受
            String m = sc.nextLine();
            switch(m){
                case "1":
                    denglu();
                    break;
                case "2":
                    zhuce();
                    break;
                case "3":

                default:
                    System.out.println("谢谢使用，欢迎下次再来！");
                    System.exit(0);
            }
        }
    }

    }
