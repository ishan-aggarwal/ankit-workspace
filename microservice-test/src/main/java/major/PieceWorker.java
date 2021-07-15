package major;
public class PieceWorker extends Worker
{
	// attributes
	protected int numsold;
	
	//default
	public PieceWorker()
	{
		numsold = 0;
	}
	
	// parameterized
	public PieceWorker(String name, double pay, int sold)
	{
		super (name, pay);
		numsold = sold;
	}
	
	// set pieces sold
	public void setPieces(int sold)
	{
		numsold = sold;
	}
	
	// get piecesSold
	public int getPieces()
	{
		return numsold;
	}
	
	// get Each
	public double getEach()
	{
		double commission = 0;
		
		if (numsold < 200)
		{
			commission = .75; 
		}
		else if (numsold <= 999)
		{
			commission = 1.25;
		}
		else
		{
			commission = 1.75;
		}	
		return commission;	
	}
	

	
	// get commission
	public double getCommission()
	{
		return getEach() * numsold;
	}
	
	// get total
	/*
	public double getTotal()
	{	
		return getPay() + getCommission();
	}
	*/
	
	// print pay
	public void printPay()
	{
		System.out.println("Name: " + getName());
		System.out.println(numsold + " pieces sold at "  + getEach() + " each");
		// call display from abstract worker class
		display();
		
	}

	// toString
	/*
	public String toString()
	{
		return "Commission is " + "$" +getEach() + " per piece";
	}
	*/





}// end class
