package major;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkerApp 
{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// array list		
		ArrayList<Worker> type = new ArrayList<>();
		
		// variable
		int choice = 0;
		do
		{
		System.out.println("MENU");
		System.out.println("1 - Add pieceworker");
		System.out.println("2 - Add salesworker");
		System.out.println("3 - Payroll report");
		System.out.println("4 - Search for worker");
		System.out.println("5 - Exit");
		System.out.print("Your choice: ");
		try {
			choice  = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("Enter Valid Number");
		}

		switch (choice)
		{
		case 1:
			// call add pieceworker
			type.add(addPieceWorker());
			break;
			
		case 2:
			// call add salesworker
			type.add(addSalesWorker());
			break;
		
		case 3:
			//	call payroll report
			payrollReport(type);
			break;
			
		case 4:
			//	call search worker
			SearchWorker(type);			
			break;
			
		case 5:
			// quit
			quit();
			break;
			
			default:
				// invalid choice
		
		}// end switch 
		
		} while(choice!=5);
		
		
		
	}// end main
	
	// add pieceworker
	public static Worker addPieceWorker()
	{
		String name;
		double pay;
		int piecessold;
		
		System.out.print("Name? ");
		name = input.nextLine();
		System.out.print("Base pay? ");
		pay = Double.parseDouble(input.nextLine());
		System.out.print("Pieces sold? ");
		piecessold = Integer.parseInt(input.nextLine());
		
		// add object
		PieceWorker p = new PieceWorker(name, pay, piecessold);
		return p;
	}// end pieceworker
	
	// add salesworker
	public static Worker addSalesWorker()
	{
		String name;
		double pay;
		double sales;
		
		System.out.print("Name: ");
		name = input.nextLine();
		System.out.print("Base pay? ");
		pay = Double.parseDouble(input.nextLine());
		System.out.print("Monthly sales? ");
		sales = Double.parseDouble(input.nextLine());
		
		// add object
		SalesWorker w = new SalesWorker(name, pay, sales);
		return w;
	}// end sales worker

	// payroll report
	public static void payrollReport(ArrayList<Worker> list) {
		System.out.println("PAYROLL REPORT");
		System.out.printf("%-22s%-22s%-22s\n","Name","Commission","Total Pay");


		for (Worker worker:list) {
			System.out.printf("%-22s%-22f%-22f\n",worker.getName(),worker.getCommission(),worker.getTotal());

		}
		System.out.println("Totals");
	}

	// search for worker
	public static void SearchWorker(ArrayList<Worker> list)
	{
		String name;
		System.out.print("Enter name: ");
		name = input.nextLine();
		
		boolean found = false;
		
		for(int i = 0; i < list.size(); i ++) 
		{
			if(list.get(i).getName().equals(name))
			{
				found = true;
//				// print data for found worker
//				if (list.get(i) instanceof SalesWorker) {
//					((SalesWorker) list.get(i)).printPay();
////					System.out.println(((SalesWorker) list.get(i)).getSales() + " monthly sales at " + ((SalesWorker) list.get(i)).getPct() + " percent");
//				} else {
//					((PieceWorker) list.get(i)).printPay();
//					//System.out.println(((PieceWorker)list.get(i)).getPieces() + " pieces sold at " + ((PieceWorker)list.get(i)).getEach() + " each");
//				}
				((SalesWorker)list.get(i)).printPay();
				list.get(i).display();
				return;
			}

		}// end for loop
		if (found == false)
		{
			System.out.println(name + " not found ");
		}
	}// end search
	public static void quit() {
		System.out.println("Goodbye");
		System.out.println("Coded by name..");
	}
	
	
	
	
	
	
	
}// end class
		
		
		
		


















/*
		// variables
		int type = 0;

		do 
		{
			System.out.println("PAY CALCULATOR ");
			System.out.println("1: PieceWorker / 2: SalesRep / 3: Exit ");
			System.out.print("Enter option: ");
			type = Integer.parseInt(input.nextLine());

			// switch
			switch (type) 
			{
			case 1:
				// call pieceWorker
				System.out.println();
				pieceWorker();
				break;

			case 2:
				// call salesRep
				System.out.println();
				salesRep();
				break;

			case 3:
				// quit
				break;

			default:
				System.out.println();
				System.out.println("Invalid choice");

			}// end switch

		} while (type != 3);

		System.out.println("Goodbye!");

	}// end main

	public static void pieceWorker() 
	{
		// process data for piece worker
		int piecesSold;
		String name;
		double basePay;
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter monthly base pay: ");
		basePay = Double.parseDouble(input.nextLine());
		System.out.print("Enter number of pieces sold: ");
		piecesSold = Integer.parseInt(input.nextLine());
		System.out.println();
		// create piece worker object with
		// parameterized data
		PieceWorker p = new PieceWorker(name, basePay, piecesSold);
		p.printPay();
		System.out.println();
	}// end piece worker

	public static void salesRep() 
	{
		// process data for sales rep
		String name;
		double basePay;
		double sales;
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter monthly base pay: ");
		basePay = Double.parseDouble(input.nextLine());
		System.out.print("Enter amount of sales: ");
		sales = Double.parseDouble(input.nextLine());
		System.out.println();
		// create sales worker object with
		// parameterized data
		SalesWorker s = new SalesWorker(name, basePay, sales);
		s.printPay();
		System.out.println();
	*/
	// end sales rep
	


// end class

/*case 1
 * PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 2

Enter name: John C
Enter monthly base pay: 1500
Enter amount of sales: 5000

Commission is 18.0% of sales
Pay for John C
Commission  $ 900.00
Base salary $ 1500.00
Total pay   $ 2400.00

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 0

Invalid choice
PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 1

Enter name: Kim B
Enter monthly base pay: 2000
Enter number of pieces sold: 999

Commission is $1.25 per piece
Pay for Kim B
Commision   $ 1248.75
Base pay    $ 2000.00
Total pay   $ 3248.75

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 3
Goodbye!

 * case 2
PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 6

Invalid choice
PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 1

Enter name: Joe Smith
Enter monthly base pay: 500
Enter number of pieces sold: 199

Commission is $0.75 per piece
Pay for Joe Smith
Commision   $ 149.25
Base pay    $ 500.00
Total pay   $ 649.25

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 2

Enter name: Mike C
Enter monthly base pay: 500
Enter amount of sales: 4999

Commission is 15.0% of sales
Pay for Mike C
Commission  $ 749.85
Base salary $ 500.00
Total pay   $ 1249.85

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 3
Goodbye!

 * case 3
PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 1

Enter name: Mary M
Enter monthly base pay: 1000
Enter number of pieces sold: 1000

Commission is $1.75 per piece
Pay for Mary M
Commision   $ 1750.00
Base pay    $ 1000.00
Total pay   $ 2750.00

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 2

Enter name: Ben A
Enter monthly base pay: 2000
Enter amount of sales: 10000

Commission is 20.0% of sales
Pay for Ben A
Commission  $ 2000.00
Base salary $ 2000.00
Total pay   $ 4000.00

PAY CALCULATOR 
1: PieceWorker / 2: SalesRep / 3: Exit 
Enter option: 3
Goodbye!

*/
















