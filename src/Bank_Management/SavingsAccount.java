package Bank_Management;
import java.math.BigDecimal;

public class SavingsAccount {//储蓄账户类
	private int id;//账号
	private double balance;//余额
	private double rate;//存款的年利率
	private int lastDate;//上次变更余额的时期
	private double accumulation;//余额按日累加之和
	private void record(int date,int id,double amount) { //获得到指定日期为止的存款金额按日累积值
		accumulation = accumulate(date);
		lastDate = date;
		amount = (amount * 100 + 0.5) / 100;
		//保留小数点后两位
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		balance += amount;
		System.out.println("#"+date+"  "+id+"  "+amount+"  "+balance);
	}
	private double accumulate(int date)  {
		return accumulation + balance * (date - lastDate);
	}
	
	public SavingsAccount(int date, int id, double rate) {
		System.out.println("#"+date+"  "+id+" is created");
	}
	public int getId() { return id; }
	public double getBalance() { return balance; }
	public double getRate() { return rate; }

	//存入现金
	public void deposit(int date,int id, double amount) {//取出现金
		record(date,id,amount);
	}
	public void withdraw(int date,int id, double amount) {//结算利息，每年1月1日调用一次该函数
		if(amount>getBalance()) {
			System.out.println("Error:not enough money");
		}
		else {
			record(date,id,-amount);
		}
	}
	public void settle(int date,int id) {//显示账户信息
		double interest = accumulate(date) * rate / 365;	//计算年息
		if (interest != 0)
			record(date, id,interest);
		accumulation = 0;
	}
	public void show(int id) {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}
	
	
	public static void main(String[] args) {
		//建立几个账户
		SavingsAccount sa0=new SavingsAccount(1, 21325302, 0.015);
		SavingsAccount sa1=new SavingsAccount(1, 58320212, 0.015);
		

		//几笔账目
		sa0.deposit(5,21325302, 5000);
		sa1.deposit(25,58320212, 10000);
		sa0.deposit(45,21325302, 5500);
		sa1.withdraw(60,58320212, 4000);

		//开户后第90天到了银行的计息日，结算所有账户的年息
		sa0.settle(90,213253020);
		sa1.settle(90,58320212);

		//输出各个账户信息
		sa0.show(21325302);	
		sa1.show(58320212);	
	}	
}
