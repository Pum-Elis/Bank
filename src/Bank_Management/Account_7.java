package Bank_Management;

import java.math.BigDecimal;

public class Account_7 {
	private String id;//账号
	private double balance=0;//余额
	private static double total=0;//所有账户的总金额
	public Account_7() {};
	protected Account_7(final Date_6 date,final String _id) {
		id=_id;
		date.show();
		System.out.println("#"+id+" is created");
	}
	
	
	protected void record(final Date_6 date,double amount,final String desc) { //获得到指定日期为止的存款金额按日累积值
		amount = (amount * 100 + 0.5) / 100;
		//保留小数点后两位
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		//System.out.print("amount:"+amount);
		balance += amount;
		total += amount;
		date.show();//在record方法中将日期单独输出
		System.out.println("\t#"+id+"  "+amount+"  "+balance+"  "+desc);
	}
	
	protected void error(final String msg) {
		System.out.println("Error(#"+id+"):"+msg);
	}//输出错误信息
	
	public final String getId() { return id; }
	public final double getBalance() { return balance; }
	public static double getTotal() {return total;}
	
	public final void show() {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}

}
