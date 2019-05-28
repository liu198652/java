import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("*********欢迎光临阳光旅游网**********");
        Tool tool = new Tool();
        while (true) {
            System.out.println("1.添加出行订单2.查看我的出行订单3.修改订单信息4.删除出行人5.查看行程6.退出系统");
            System.out.println("请选择要办理的业务(1-6):");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    tool.addDingDan();
                    break;
                case 2:
                    tool.LookDingDan();
                    break;
                case 3:
                    tool.UpdateDingDan();
                    break;
                case 4:
                    tool.DeleteDingDan();
                    break;
                case 5:
                    try {
                        tool.LookXingCheng();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    tool.EXit();
                    return;
                default:
                    System.out.println("输入错误,请重新输入!");
                    break;
            }
        }

    }
}
