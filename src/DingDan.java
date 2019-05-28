public class DingDan {
    private String data;
    private String phone;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    private String name;
    private int age;
    private double sum;
    public DingDan(){}
    public DingDan(String data,String phone,String name,int age,double sum){
        this.data = data;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.sum = sum;
    }
    public double ShowPrice() {
        return 2000;
    }
    public void show(){
        System.out.println("订单信息:");
        System.out.println("出行日期"  +this.data+ "联系人手机号码" + this.phone+"订单总金额" + this.sum);
    }
}
