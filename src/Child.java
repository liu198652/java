public class Child extends DingDan {
    public String getZhan() {
        return Zhan;
    }

    public void setZhan(String zhan) {
        Zhan = zhan;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    /**
     * 计算价格
     * @return
     */
    public double ShowPrice() {
        if (this.Zhan.equals("1")) {
            this.No = "是";
            return 30;
        } else {
            return 0;
        }
    }
    private String Zhan;
    private String No = "否";

    /**
     * 无参
     */
    public Child(){}

    /**
     * 有参
     * @param data
     * @param phone
     * @param name
     * @param age
     * @param sum
     * @param zhan
     */
    public Child(String data,String phone,String name,int age,double sum,String zhan){
        super(data,phone,name,age,sum);
        this.Zhan = zhan;
    }

    @Override
    public void show() {
            System.out.println("订单信息:");
            System.out.println("出行日期" +super.getData() + "联系人手机" + super.getPhone() + "订单总金额" + super.getSum());
    }
}
