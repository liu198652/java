import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tool {
    ArrayList list = new ArrayList();
    Scanner input = new Scanner(System.in);

    /**
     * 添加出行订单
     */
    public void addDingDan() {
        System.out.println("请输入出行日期(如20170501):");
        String data = input.next();
        if (data.length() == 8) {
            System.out.println("请输入手机号码");
            String phone = input.next();
            if (phone.length() == 11) {
                System.out.println("添加出行人信息");
                boolean isExit = true;
                double sum = 0;
                double ChengRenPrice = 0;
                double ChildPrice = 0;
                double OldPrice = 0;
                while (isExit) {
                    System.out.println("1.成人2.儿童3.老人");
                    System.out.println("请选择类别:");
                    int num1 = input.nextInt();
                    System.out.println("请输入姓名:");
                    String name = input.next();
                    System.out.println("请输入年龄:");
                    int age = input.nextInt();
                    switch (num1) {
                        case 1:
                            if (age >= 18 && age < 65) {
                                DingDan dingDan = new DingDan();
                                ChengRenPrice = dingDan.ShowPrice();
                                sum = ChengRenPrice;
                                dingDan.setAge(age);
                                dingDan.setData(data);
                                dingDan.setName(name);
                                dingDan.setPhone(phone);
                                list.add(dingDan);
                                break;
                            } else {
                                System.out.println("年龄输入不正确,成人年龄在18-65之间!");
                                break;
                            }
                        case 2:
                            if (age >= 1 && age < 18) {
                                System.out.println("是否占床(1.占床2.不占床)");
                                String zhan = input.next();
                                Child child = new Child(data, phone, name, age, sum, zhan);
                                ChildPrice = child.ShowPrice();
                                sum = ChildPrice;
                                child.setAge(age);
                                child.setData(data);
                                child.setName(name);
                                child.setPhone(phone);
                                list.add(child);
                                break;
                            } else {
                                System.out.println("输入年龄错误,儿童年龄在1-18之间!");
                                break;
                            }
                        case 3:
                            if (age >= 65) {
                                Old old = new Old();
                                OldPrice = old.ShowPrice();
                                sum = OldPrice;
                                old.setAge(age);
                                old.setData(data);
                                old.setName(name);
                                old.setPhone(phone);
                                list.add(old);
                                break;
                            } else {
                                System.out.println("输入年龄错误,老人年龄在65岁以上!");
                            }
                        default:
                            System.out.println("输入错误,请输入(1-3)之间的数字!");
                            break;
                    }
                    System.out.println("姓名:" + name + "年龄:" + age + "金额:" + sum);
                    sum = ChengRenPrice + ChildPrice + OldPrice;
                    System.out.println("是否继续(y/n)");
                    String yes = input.next();
                    if (yes.equalsIgnoreCase("y")) {
                        isExit = true;
                    } else if (yes.equalsIgnoreCase("n")) {
                        DingDan dingDan = new DingDan(data, phone, name, age, sum);
                        dingDan.ShowPrice();
                        isExit = false;
                    } else {
                        System.out.println("输入错误,停止运行!");
                        DingDan dingDan = new DingDan(data, phone, name, age, sum);
                        dingDan.ShowPrice();
                        isExit = false;
                    }
                }
            } else {
                System.out.println("你输入的手机号必须是11位!");
            }
        } else {
            System.out.println("你输入的日期必须是8位!");
        }
    }

    /**
     * 查看我的出行订单
     */
    public void LookDingDan() {
        System.out.println("出发日期:");
        String data = input.next();
        System.out.println("联系人的手机号码:");
        String phone = input.next();
        if (list.size() != 0) {
            System.out.println("详情信息:");
            System.out.println("姓名\t年龄\t儿童是否占床\t金额");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Child) {
                    Child child = (Child) list.get(i);
                    if (child.getPhone().equals(phone) && child.getData().equals(data)) {
                        System.out.println(child.getName() + "\t" + child.getAge() + "\t" + child.getNo() + "\t\t" + child.getSum());
                    } else {
                        System.out.println("出行日期或手机号码输入错误!");
                    }
                } else if (list.get(i) instanceof DingDan) {
                    DingDan dingDan = (DingDan) list.get(i);
                    if (dingDan.getPhone().equals(phone) && dingDan.getData().equals(data)) {
                        System.out.println(dingDan.getName() + "\t" + dingDan.getAge() + "\t" + "否" + "\t" + dingDan.getSum());
                    } else {
                        System.out.println("出行日期或手机号码输入错误!");
                    }
                } else if (list.get(i) instanceof Old) {
                    Old old = (Old) list.get(i);
                    if (old.getPhone().equals(phone) && old.getData().equals(data)) {
                        System.out.println(old.getName() + "\t" + old.getAge() + "\t" + "否" + "\t" + old.getSum());
                    } else {
                        System.out.println("出行日期或手机号码输入错误!");
                    }
                }
            }
        } else {
            System.err.println("查看失败,我的出行订单中不存在该出行日期或者手机号码!");

        }
    }

    /**
     * 修改订单
     */
    public void UpdateDingDan() {
        System.out.print("请输入你要修改的日期:");
        String data = input.next();
        System.out.print("请输入你要修改的手机号码:");
        String phone = input.next();
        System.out.print("请输入新的出行日期:");
        String newdata = input.next();
        System.out.print("请输入新的联系人的手机号码:");
        String newphone = input.next();
        if (phone.length() != 11) {
            try {
                throw new Exception("手机号码必须是11位");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof Child) {
                        Child child = (Child) list.get(i);
                        if (child.getData().equals(data) && child.getPhone().equals(phone)) {
                            ((DingDan) list.get(i)).setData(newdata);
                            ((DingDan) list.get(i)).setPhone(newphone);
                        } else {
                            System.err.println("出行日期或手机号码输入错误!");
                        }
                    } else if (list.get(i) instanceof DingDan) {
                        DingDan dingDan = (DingDan) list.get(i);
                        if (dingDan.getData().equals(data) && dingDan.getPhone().equals(phone)) {
                            ((DingDan) list.get(i)).setData(newdata);
                            ((DingDan) list.get(i)).setPhone(newphone);
                        } else {
                            System.err.println("出行日期或手机号码输入错误!");
                        }
                    } else if (list.get(i) instanceof Old) {
                        Old old = (Old) list.get(i);
                        if (old.getData().equals(data) && old.getPhone().equals(phone)) {
                            ((DingDan) list.get(i)).setData(newdata);
                            ((DingDan) list.get(i)).setPhone(newphone);
                        } else {
                            System.err.println("出行日期或手机号码输入错误!");
                        }
                    }
                }
            } else {
                System.err.println("修改失败,我的出行订单中不存在该出行日期或者手机号码,无法修改!");
            }
        }
        System.out.println("出行日期:" + newdata + ",联系人手机号码:" + newphone + ",修改成功!");

    }

    /**
     * 删除订单
     */
    public void DeleteDingDan() {
        System.out.print("请输入要删除的出行人姓名:");
        String name = input.next();
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Child) {
                    Child a_list = (Child) list.get(i);
                    if (a_list.getName().equals(name)) {
                        list.remove(a_list);
                        System.out.println("删除成功!");
                    }
                } else if (list.get(i) instanceof DingDan) {
                    DingDan dingDan = (DingDan) list.get(i);
                    if (dingDan.getName().equals(name)) {
                        list.remove(dingDan);
                        System.out.println("删除成功!");
                    }
                } else if (list.get(i) instanceof Old) {
                    Old old = (Old) list.get(i);
                    if (old.getName().equals(old)) {
                        list.remove(old);
                        System.out.println("删除成功!");
                    }
                }
            }
        } else {
            System.err.println("删除失败,我的出行订单中不存在该出行人姓名,无法删除!");
        }

    }

    /**
     * 查看行程
     */
    public void LookXingCheng() throws IOException {
        File file = new File("D:\\S2\\二书\\测试\\行程信息.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String text = "";
        while ((text = bufferedReader.readLine()) != null) {
            System.out.println(text);
        }
        bufferedReader.close();
        System.out.println("");
    }

    /**
     * 退出
     */
    public void EXit() {
        System.out.println("欢迎下次光临!");
    }
}
