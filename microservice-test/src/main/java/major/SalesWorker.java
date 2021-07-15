package major;
public class SalesWorker extends Worker 
{
	// attributes
	protected double monthlysales;
	
	// default constructor 
	public SalesWorker()
	{
		monthlysales = 0;
	}

	// parameterized constructor
	public SalesWorker(String name, double pay, double sales) 
	{
		super(name, pay);
		monthlysales = sales;
	}

	// set monthly sales
	public void setSales(double sales) 
	{
		monthlysales = sales;
	}

	// get monthly sales
	public double getSales() 
	{
		return monthlysales;
	}

	// get pct
	public double getPct() 
	{
		double pct = 0;
		if (monthlysales < 5000) 
		{
			pct = .15 * 100;
		} else if (monthlysales < 9999.99) 
		{
			pct = .18 * 100;
		} else {
			pct = .20 * 100;
		}
		return pct;
	}

	// get commission
	public double getCommission() 
	{
		double commission = 0;
		commission = (getPct() / 100) * monthlysales;
		return commission;
	}

	// get total
	/*
	public double getTotal() 
	{
		return getCommission() + getPay();
	}
	*/

	// print pay
	public void printPay() 
	{
		System.out.println("Name: " + getName());
		System.out.println("Commission percentage: " + getCommission());
		System.out.println("$" + monthlysales + " at " +  getPct() + " percent");		
		// call display from abstract worker class
		display();
	}

}// end class

