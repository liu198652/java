public class Old extends DingDan {
    public Old(){}
    public Old(String data,String phone,String name,int age,double sum) {
        super(data,phone,name,age,sum);
    }
        public double ShowPrice() {
        return 1000;
    }
    public void show() {
        System.out.println("订单信息:");
        System.out.println("出行日期" +super.getData() + "联系人手机" + super.getPhone() + "订单总金额" + super.getSum());
    }
}
