package Bank_Management;
//main方法
public class main_6 {
	public static void main(String[] args) {
		//建立几个账户
		Date_6 date=new Date_6(2008, 11, 1);
		//数组形式输入信息
		SavingAccount_6 accounts[]= {new SavingAccount_6(date, "S3755217", 0.015),new SavingAccount_6(date, "02342342", 0.015)};
		int n=accounts.length;
		Date_6 d1=new Date_6(2008, 11, 5);
		Date_6 d2=new Date_6(2008, 11, 25);
		Date_6 d3=new Date_6(2008, 12, 5);
		Date_6 d4=new Date_6(2008, 12, 20);
		accounts[0].deposit(d1, 5000, "salary");
		accounts[1].deposit(d2, 10000, "sell stock 0323");
		//几笔账目
		accounts[0].deposit(d3, 5500, "salary");
		accounts[1].withdraw(d4, 4000, "buy a laptop");
		System.out.println();
		for (int i = 0; i < n; i++) {
			accounts[i].settle(new Date_6(2009, 1, 1));
			accounts[i].show();
			System.out.println();
		}
		System.out.print("Total："+SavingAccount_6.getTotal());
	}
}
