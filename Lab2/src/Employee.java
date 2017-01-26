import java.util.Date;
public class Employee {

	
private String empName;

private String empNum;//in the format of XXX-L
//where X represents a digit within the range of 0-9
//and L is a letter within the range of A-M

private Date hireYear;
//number that the Date Class adds to each of the year field
//subtracting gives the correct year input
private final int subtractYear = 1900;
private double weekEarnings;



//Constructor that asks for all information
public Employee(int year, String name, String number, double earnings)
{
	hireYear = new Date();
	setHireYear((year-subtractYear));
	empName = "unknown";
	setEmpName(name);
	empNum = "000-A";
	setEmpNum(number);
	weekEarnings = earnings;
	
	
}
//Constructor for those without names or numbers
//may be overwritten
public Employee()
{
	hireYear = new Date();
	empName = "Unknown";
	empNum = "000-A";
	weekEarnings = 10.0;
}

//for new employees that are being added to the database
public Employee(String name, String number, double earnings)
{
	hireYear = new Date();
	empName = "unknown";
	setEmpName(name);
	empNum = "000-A";
	setEmpNum(number);
	weekEarnings = 10.0;
	setWeekEarnings(earnings);
}

public String getEmpName() 
{
	return empName;
}

public void setEmpName(String empName)
{
	this.empName = empName;
}

public String getEmpNum()
{
	return empNum;
}

public void setEmpNum(String empNum)
{
	if(checkNumber(empNum))
	{
	this.empNum = empNum;
	}
}

public Date getHireYear()
{
	return hireYear;
}
@SuppressWarnings("deprecation")
protected void setHireYear(int year)
{

	//year in which the company started
int startYear = 1970;
	if(((year-subtractYear) < startYear))
	{
		hireYear.setYear((year-subtractYear)); 
		
	}
}

public double getWeekEarnings() 
{
	return weekEarnings;
}

//
public void setWeekEarnings(double earnings) 
{
	if((earnings > 0) && (earnings < 10000))
	{
	this.weekEarnings = earnings;
	}
}

//method to check every time the employee number
//needs to change, used to avoid code duplication
public boolean checkNumber(String number)
{
	String[] parts = number.split("-");
	String numbers = parts[0];
	Character letter = empNum.charAt(4);
	
	Integer num = Integer.parseInt(numbers); 
	try{
	if((num >= 0) && (num<= 999) && 
			(letter >= 'A') && (letter <='M'))
			{
				return true;
			}
	}catch(Exception e)
	{
		System.out.println("Not a valid statement");
	}
	return false;
}


@Override
public boolean equals(Object obj) 
{

	if (this == obj)
	{
		return true;
	}
	
	if (obj == null)
	{
		return false;
	}
	
	if (getClass() != obj.getClass())
	{
		return false;
	}
	// after checking if the object passed is an object
	//of this class we can cast to see if this object is the
	//same as the one we are comparing it to
	Employee other = (Employee) obj;
	
	if (empName == null) 
	{
		if (other.empName != null)
		{
			return false;
		}
	}
	// if the names are the same it will continue
	// some people have the same name within a company
	else if (!empName.equals(other.empName))
	{
		return false;
	}
	
	if (empNum == null)
	{
		if (other.empNum != null)
		{
			return false;
		}
	} 
	//if the numbers are not the same then it will continue
	//if the company is large and doesn't want to change the
	//employee number system then some employees may have the same
	//number
	else if (!empNum.equals(other.empNum))
	{
		return false;
	}
	
	if (hireYear == null) 
	{
		if (other.hireYear != null)
		{
			return false;
		}
	}
	
	else if (!hireYear.equals(other.hireYear))
	{
		return false;
	}
	
	if (Double.doubleToLongBits(weekEarnings) != Double
			.doubleToLongBits(other.weekEarnings))
	{
		return false;
	}
	
	return true;
}

@Override
public String toString() 
{
	return "Employee \nEmployee Name -- \t" + empName + 
			"\n Emplyee ID -- \t" + empNum + 
			"\n Hire Year -- \t" + hireYear + 
			"\n Weekly wage -- \t" + weekEarnings;
}









}
