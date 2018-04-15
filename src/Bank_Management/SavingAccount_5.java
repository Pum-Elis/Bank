package Bank_Management;
import java.math.BigDecimal;

public class SavingAccount_5 {
	private int id;//�˺�
	private double balance;//���
	private double rate;//����������
	private int lastDate;//�ϴα������ʱ��
	private double accumulation;//�����ۼ�֮��
	private  static double total;//����һ����̬����
	private void record(int date,int id,double amount) { //��õ�ָ������Ϊֹ�Ĵ������ۻ�ֵ
		accumulation = accumulate(date);
		lastDate = date;
		amount = (amount * 100 + 0.5) / 100;
		//����С�������λ
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.print("amount:"+amount);
		balance += amount;
		total+=amount;
		System.out.println("#"+date+"  "+id+"  "+amount+"  "+balance);
	}
	private final double accumulate(int date)  {
		return accumulation + balance * (date - lastDate);
	}//��accumulate������final�ؼ��ֽ�������
	
	public SavingAccount_5(int date, int id, double rate) {
		System.out.println("#"+date+"  "+id+" is created");
	}
	public final int getId() { return id; }
	public final double getBalance() { return balance; }
	public final double getRate() { return rate; }//���ַ�������final����
	
	public static double getTotal() {
		return total;
	}//������getTotal����

	//�����ֽ�
	public void deposit(int date,int id, double amount) {//ȡ���ֽ�
		record(date,id,amount);
	}
	public void withdraw(int date,int id, double amount) {//������Ϣ��ÿ��1��1�յ���һ�θú���
		if(amount>getBalance()) {
			System.out.println("Error:not enough money");
		}
		else {
			record(date,id,-amount);
		}
	}
	public void settle(int date,int id) {//��ʾ�˻���Ϣ
		double interest = accumulate(date) * rate / 365;	//������Ϣ
		if (interest != 0)
			record(date, id,interest);
		accumulation = 0;
	}
	public void show(int id) {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}
	
	
	public static void main(String[] args) {
		//���������˻�
		SavingAccount_5 sa0=new SavingAccount_5(1, 21325302, 0.015);
		SavingAccount_5 sa1=new SavingAccount_5(1, 58320212, 0.015);
		

		//������Ŀ
		sa0.deposit(5,21325302, 5000);
		sa1.deposit(25,58320212, 10000);
		sa0.deposit(45,21325302, 5500);
		sa1.withdraw(60,58320212, 4000);

		//�������90�쵽�����еļ�Ϣ�գ����������˻�����Ϣ
		sa0.settle(90,213253020);
		sa1.settle(90,58320212);

		//��������˻���Ϣ
		sa0.show(21325302);	
		sa1.show(58320212);
		//main������������total��������
		System.out.println("Total:"+SavingAccount_5.getTotal());
	}	

}