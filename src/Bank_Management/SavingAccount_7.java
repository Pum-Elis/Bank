package Bank_Management;

public class SavingAccount_7 extends Account_7 {
	private Accumulator_7 acc;//辅助计算利息的累加器
	private double rate;//存款的年利率
	Account_7 balance_A=new Account_7();
	private double balance_a=balance_A.getBalance();
	public SavingAccount_7(final Date_6 date,final String id,double _rate){
		super(date,id);//父类构造方法的调用
		rate=_rate;
	}
	public final double getRate() {
		return rate;
	}
	
	public void deposit(final Date_6 date,double amount,final String desc) {
		record(date,amount,desc);
		//Account_7 balance_A=new Account_7();
		acc.change(date,balance_a);
	}
	
	public void withdraw(final Date_6 date,double amount,final String desc) {
		if (amount > getBalance()) {
			error("not enough money");
		} else {
			record(date, -amount, desc);
			//Account_7 balance_A=new Account_7();
			acc.change(date, balance_a);
		}
	}
	
	//结算利息，每年的1月1日调用一次该方法
	public void settle(Date_6 date) {
		Date_6 dd=new Date_6(date.getYear() - 1, 1, 1);
		double interest = acc.getSum(date) * rate / date.distance(dd);	//计算年息
		if (interest != 0) {
			super.record(date,interest,"interest");
			//Account_7 balance_A=new Account_7();
			acc.reset(date, balance_a);
	}
	}
}
