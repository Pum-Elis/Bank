package Bank_Management;

public class main_7 {
	public static void main(String[] arg) {
		Date_6 date=new Date_6(2008, 11, 1);	//��ʼ����
		//���������˻�
		SavingAccount_7 sa1=new SavingAccount_7(date, "S3755217", 0.015);
		SavingAccount_7 sa2=new SavingAccount_7(date, "02342342", 0.015);
		CreditAccount_7 ca=new CreditAccount_7(date, "C5392394", 10000, 0.0005, 50);
		//11�·ݵļ�����Ŀ
		sa1.deposit(new Date_6(2008, 11, 5), 5000, "salary");
		ca.withdraw(new Date_6(2008, 11, 15), 2000, "buy a cell");
		sa2.deposit(new Date_6(2008, 11, 25), 10000, "sell stock 0323");
		//�������ÿ�
		ca.settle(new Date_6(2008, 12, 1));
		//12�·ݵļ�����Ŀ
		ca.deposit(new Date_6(2008, 12, 1), 2016, "repay the credit");
		sa1.deposit(new Date_6(2008, 12, 5), 5500, "salary");
		//���������˻�
		sa1.settle(new Date_6(2009, 1, 1));
		sa2.settle(new Date_6(2009, 1, 1));
		ca.settle(new Date_6(2009, 1, 1));
		//��������˻���Ϣ
		sa1.show();
		System.out.println();
		sa2.show();
		System.out.println();
		ca.show1();
		System.out.println();
		System.out.print("Total��"+SavingAccount_6.getTotal());
		
	}

}
