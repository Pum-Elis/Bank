package Bank_Management;
//import Bank_Management.DATA_6;
import java.math.BigDecimal;

public class SavingAccount_6 {
	private String id;//账号改为string
	private double balance;//余额
	private double rate;//存款的年利率
	private Date_6 lastDate;//上次变更余额的时期
	private double accumulation;//余额按日累加之和
	private static double total=0;//增加一个静态属性
	private void record(final Date_6 date,double amount,final String desc) { //获得到指定日期为止的存款金额按日累积值
		accumulation = accumulate(date);
		lastDate = date;
		amount = (amount * 100 + 0.5) / 100;
		//保留小数点后两位
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		//System.out.print("amount:"+amount);
		balance += amount;
		total += amount;
		//BigDecimal to = new BigDecimal(total);
		//amount = to.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		date.show();//在record方法中将日期单独输出
		System.out.println("#"+id+"  "+amount+"  "+balance+"  "+desc);
	}
	
	public void error(final String msg) {
		System.out.println("Error(#"+id+"):"+msg);
	}//输出错误信息
	private final double accumulate(final Date_6 date)  {
		return accumulation + balance * date.distance(lastDate);
	}//将accumulate方法用final关键字进行修饰
	
	public SavingAccount_6(Date_6 _lastDate,String _id,double _rate) {
		id=_id;
		rate=_rate;
		lastDate=_lastDate;
		_lastDate.show();
		System.out.println("#"+id+" is created");
	}
	public final String getId() { return id; }
	public final double getBalance() { return balance; }
	public final double getRate() { return rate; }//三种方法都用final修饰
	
	public static double getTotal() {
		return total;
	}//增加了getTotal方法

	//存入现金
	public void deposit(Date_6 date,double amount,final String desc) {//取出现金
		record(date,amount,desc);
	}
	public void withdraw(Date_6 date,double amount,final String desc) {//结算利息，每年1月1日调用一次该函数
		if(amount>getBalance()) {
			System.out.println("Error:not enough money");
		}
		else {
			record(date,-amount,desc);
		}
	}
	public void settle(Date_6 date) {//显示账户信息
		Date_6 dd=new Date_6(date.getYear() - 1, 1, 1);
		double interest = accumulate(date) * rate / date.distance(dd);	//计算年息
		if (interest != 0)
			record(date,interest,"interest");
		accumulation = 0;
	}
	public void show() {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}

}
