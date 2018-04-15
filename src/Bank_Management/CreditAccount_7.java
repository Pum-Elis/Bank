package Bank_Management;

public class CreditAccount_7 extends Account_7 {
	private Accumulator_7 acc;	//辅助计算利息的累加器
	private double credit;		//信用额度
	private double rate;		//欠款的日利率
	private double fee;			//信用卡年费
	
	private final double getDebt(){	//获得欠款额
		double balance = getBalance();
		return (balance < 0 ? balance : 0);
	}
	
	public CreditAccount_7(final Date_6 date,final String id,double _credit,double _rate,double _fee) {
		super(date,id);//父类构造方法的调用
		credit=_credit;
		rate=_rate;
		fee=_fee;
	}
	
	final double getCredit(){ return credit; }
	final double getRate(){ return rate; }
	final double getFee(){ return fee; }
	
	final double getAvailableCredit(){	//获得可用信用
		if (getBalance() < 0) 
			return credit + getBalance();
		else
			return credit;
	}
	
	public void deposit(final Date_6 date,double amount, String desc) {
		record(date,amount,desc);
		acc.change(date, getDebt());
	}
	
	public void withdraw(final Date_6 date,double amount,final String desc) {
		if (amount - getBalance() > credit) {
			error("not enough credit");
		} else {
			record(date, -amount, desc);
			acc.change(date, getDebt());
		}
	}
	
	public void settle(final Date_6 date) {
		double interest = acc.getSum(date) * rate;
		if (interest != 0)
			record(date, interest, "interest");
		if (date.getMonth() == 1)
			record(date, -fee, "annual fee");
		acc.reset(date, getDebt());
	}
	
	public final void show1() {
		super.show();
		System.out.println("\tAvailable credit:"+getAvailableCredit());
	}

}
