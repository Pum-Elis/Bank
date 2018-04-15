package Bank_Management;

public class Accumulator_7 {
	private Date_6 lastDate;//�ϴα����ֵ��ʱ��
	private double value;//��ֵ�ĵ�ǰֵ
	private double sum;//��ֵ�����ۼ�֮��
	Account_7 balance_A=new Account_7();
	//���췽����dateΪ��ʼ�ۼӵ����ڣ�valueΪ��ʼֵ
	public Accumulator_7(final Date_6 _lastDate,double _value) {
		lastDate=_lastDate;
		value=_value;
		sum=0;
	}
	
	//�������date���ۼӽ��
	public final double getSum(final Date_6 date) {
		return sum+value*date.distance(lastDate);
	}
	
	//��date����ֵ���Ϊvalue
	public void change(final Date_6 date,double value) {
		sum=getSum(date);
		lastDate=date;
		this.value=value;
	}
	
	public void reset(final Date_6 date,double value) {
		lastDate=date;
		this.value=value;
		sum=0;
	}

}
