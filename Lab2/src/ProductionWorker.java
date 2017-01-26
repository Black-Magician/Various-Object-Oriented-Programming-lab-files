
public class ProductionWorker extends Employee
{
	private double hourlyRate;
	private final double MIN_WAGE = 6.00;
	private final double MAX_WAGE = 50.0;
	
	public ProductionWorker()
	{
		super();
		hourlyRate = MIN_WAGE;
	}
	
	public ProductionWorker(String name, String number, double earn, double rate)
	{
		super(name, number, earn);
		hourlyRate = MIN_WAGE;
		setHourlyRate(rate);
	}
	public ProductionWorker(int year, String name, String number, double earn, 
								double rate)
	{
		super(year, name, number, earn);
		hourlyRate = MIN_WAGE;
		setHourlyRate(rate);
		
	}
	
	
	
	public double getHourlyRate()
	{
		return hourlyRate;
	}

	//will check if the wage input is within the range of 6 and 50 dollars an hour
	public void setHourlyRate(double hourlyRate)
	{
		if((hourlyRate > MIN_WAGE) && (hourlyRate < MAX_WAGE))
		{
			this.hourlyRate = hourlyRate;
		}
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
		{
			return true;
		}
		
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		ProductionWorker other = (ProductionWorker) obj;
		
		if (Double.doubleToLongBits(hourlyRate) != Double
				.doubleToLongBits(other.hourlyRate))
		{
			return false;
		}
		
		return true;
	}

	@Override
	public String toString()
	{
		return "ProductionWorker \nEmployee Name -- \t" + getEmpName() +
				"\n Employee ID -- \t" + getEmpNum() +
				"\n Hire Year -- \t" + getHireYear() + 
				"\n Weekly Earnings -- \t"+ getWeekEarnings() + 
				"\n Hourly Rate -- \t"+ hourlyRate;
	}
	

	
	
	
}
