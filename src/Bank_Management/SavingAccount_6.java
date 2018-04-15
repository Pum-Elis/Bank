package Bank_Management;
//import Bank_Management.DATA_6;
import java.math.BigDecimal;

public class SavingAccount_6 {
	private String id;//�˺Ÿ�Ϊstring
	private double balance;//���
	private double rate;//����������
	private Date_6 lastDate;//�ϴα������ʱ��
	private double accumulation;//�����ۼ�֮��
	private static double total=0;//����һ����̬����
	private void record(final Date_6 date,double amount,final String desc) { //��õ�ָ������Ϊֹ�Ĵ������ۻ�ֵ
		accumulation = accumulate(date);
		lastDate = date;
		amount = (amount * 100 + 0.5) / 100;
		//����С�������λ
		BigDecimal bg = new BigDecimal(amount);
		amount = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		//System.out.print("amount:"+amount);
		balance += amount;
		total += amount;
		//BigDecimal to = new BigDecimal(total);
		//amount = to.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		date.show();//��record�����н����ڵ������
		System.out.println("#"+id+"  "+amount+"  "+balance+"  "+desc);
	}
	
	public void error(final String msg) {
		System.out.println("Error(#"+id+"):"+msg);
	}//���������Ϣ
	private final double accumulate(final Date_6 date)  {
		return accumulation + balance * date.distance(lastDate);
	}//��accumulate������final�ؼ��ֽ�������
	
	public SavingAccount_6(Date_6 _lastDate,String _id,double _rate) {
		id=_id;
		rate=_rate;
		lastDate=_lastDate;
		_lastDate.show();
		System.out.println("#"+id+" is created");
	}
	public final String getId() { return id; }
	public final double getBalance() { return balance; }
	public final double getRate() { return rate; }//���ַ�������final����
	
	public static double getTotal() {
		return total;
	}//������getTotal����

	//�����ֽ�
	public void deposit(Date_6 date,double amount,final String desc) {//ȡ���ֽ�
		record(date,amount,desc);
	}
	public void withdraw(Date_6 date,double amount,final String desc) {//������Ϣ��ÿ��1��1�յ���һ�θú���
		if(amount>getBalance()) {
			System.out.println("Error:not enough money");
		}
		else {
			record(date,-amount,desc);
		}
	}
	public void settle(Date_6 date) {//��ʾ�˻���Ϣ
		Date_6 dd=new Date_6(date.getYear() - 1, 1, 1);
		double interest = accumulate(date) * rate / date.distance(dd);	//������Ϣ
		if (interest != 0)
			record(date,interest,"interest");
		accumulation = 0;
	}
	public void show() {
		System.out.println("#"+id+"  "+"Balance:"+balance);
	}

}
