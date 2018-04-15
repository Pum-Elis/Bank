//Date��
package Bank_Management;

public class Date_6 {
	private int year;		//��
	private int month;		//��
	private int day;		//��
	private int totalDays;	//�������Ǵӹ�ԪԪ��1��1�տ�ʼ�ĵڼ���
	private final int DAYS_BEFORE_MONTH[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

	public  Date_6(int _year, int _month, int _day) {//���ꡢ�¡��չ�������
		year=_year;
		month=_month;
		day=_day;
		if (day <= 0 || day > getMaxDay()) {
			System.out.println("Invalid date: ");
			show();
		}
		int years = year - 1;
		totalDays = years * 365 + years / 4 - years / 100 + years / 400
			+ DAYS_BEFORE_MONTH[month - 1] + day;
		if (isLeapYear() && month > 2) {totalDays++;}
	}

	public final int getYear()  { return year; }
	public final int getMonth() { return month; }
	public final int getDay() { return day; }
	public final int  getMaxDay() {
		if (isLeapYear() && month == 2)
			return 29;
		else
			return DAYS_BEFORE_MONTH[month]- DAYS_BEFORE_MONTH[month - 1];
	}
	public final boolean isLeapYear() {	//�жϵ����Ƿ�Ϊ����
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public final void show() {//�����ǰ����
		System.out.println(getYear()+"-"+getMonth()+"-"+getDay());
	}
	//������������֮��������	
	public final int  distance(final Date_6 date) {
		return totalDays - date.totalDays;
	}
}
