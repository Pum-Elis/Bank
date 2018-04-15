package Bank_Management;

public class SavingAccount_7 extends Account_7 {
	private Accumulator_7 acc;//����������Ϣ���ۼ���
	private double rate;//����������
	Account_7 balance_A=new Account_7();
	private double balance_a=balance_A.getBalance();
	public SavingAccount_7(final Date_6 date,final String id,double _rate){
		super(date,id);//���๹�췽���ĵ���
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
	
	//������Ϣ��ÿ���1��1�յ���һ�θ÷���
	public void settle(Date_6 date) {
		Date_6 dd=new Date_6(date.getYear() - 1, 1, 1);
		double interest = acc.getSum(date) * rate / date.distance(dd);	//������Ϣ
		if (interest != 0) {
			super.record(date,interest,"interest");
			//Account_7 balance_A=new Account_7();
			acc.reset(date, balance_a);
	}
	}
}
