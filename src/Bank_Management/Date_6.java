//Date类
package Bank_Management;

public class Date_6 {
	private int year;		//年
	private int month;		//月
	private int day;		//日
	private int totalDays;	//该日期是从公元元年1月1日开始的第几天
	private final int DAYS_BEFORE_MONTH[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

	public  Date_6(int _year, int _month, int _day) {//用年、月、日构造日期
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
	public final boolean isLeapYear() {	//判断当年是否为闰年
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public final void show() {//输出当前日期
		System.out.println(getYear()+"-"+getMonth()+"-"+getDay());
	}
	//计算两个日期之间差多少天	
	public final int  distance(final Date_6 date) {
		return totalDays - date.totalDays;
	}
}
