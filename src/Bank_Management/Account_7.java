package Bank_Management;

import java.math.BigDecimal;

public class Account_7 {
	private String id;//�˺�
	private double balance=0;//���
	private static double total=0;//�����˻����ܽ��
	public Account_7() {};
	protected Account_7(final Date_6 date,final String _id) {
		id=_id;
		date.show();
		System.out.println("#"+id+" is created");
	}
	
	
	protected void record(final Date_6 date,double amount,final String desc) { //��õ�ָ������Ϊֹ�Ĵ������ۻ�ֵ
		amount = (amount * 100 + 0.5) / 100;
		//����С�������λ
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		//System.out.print("amount:"+amount);
		balance += amount;
		total += amount;
		date.show();//��record�����н����ڵ������
		System.out.println("\t#"+id+"  "+amount+"  "+balance+"  "+desc);
	}
	
	protected void error(final String msg) {
		System.out.println("Error(#"+id+"):"+msg);
	}//���������Ϣ
	
	public final String getId() { return id; }
	public final double getBalance() { return balance; }
	public static double getTotal() {return total;}
	
	public final void show() {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}

}
