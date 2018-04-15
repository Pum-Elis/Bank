package Bank_Management;

public class Accumulator_7 {
	private Date_6 lastDate;//上次变更数值的时期
	private double value;//数值的当前值
	private double sum;//数值按日累加之和
	Account_7 balance_A=new Account_7();
	//构造方法，date为开始累加的日期，value为初始值
	public Accumulator_7(final Date_6 _lastDate,double _value) {
		lastDate=_lastDate;
		value=_value;
		sum=0;
	}
	
	//获得日期date的累加结果
	public final double getSum(final Date_6 date) {
		return sum+value*date.distance(lastDate);
	}
	
	//在date将数值变更为value
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
