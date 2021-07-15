package major;
public abstract class Worker 
{
	// super class for all worker objects
	// attributes
	protected String name;
	protected double basePay;
	
	//default constructor
	public Worker()
	{
		name = "None";
		basePay = 0;
	}

	 //public abstract void printPay();
	
	// parameterized constructor
	public Worker(String na, double pay)
	{
		name = na;
		basePay = pay;
	}

	// set name
	public void setName(String na)
	{
		name = na;
	}
	
	// get name
	public String getName()
	{
		return name;
	}

	// set pay
	public void setPay(double pay)
	{
		basePay = pay;
	}

	// get pay
	public double getPay()
	{
		return basePay;
	}
	
	// abstract method
	public abstract double getCommission();
	// contract for all sub classes

	// get total
	public double getTotal()
	{
		return basePay + getCommission();
	}

	// print display
	public void display() 
	{
				
		System.out.printf("%s %.2f\n", "Base pay    $", getPay());
		System.out.printf("%s %.2f\n", "Commision   $", getCommission());		
		System.out.printf("%s %.2f\n", "Total       $", getTotal());
		
	}
	
}// end class
