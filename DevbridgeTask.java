
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DevbridgeTask {

	public static void main(String[] args) {
		
		printBonusDatesBetween(2010, 2015);
		//printBonusDatesBetween(100, 111);
		//printBonusDatesBetween(0, 111);
	}

	/*
	Implement a method that prints all dates between two given years that remain the same if numbers of the date are reversed.

	Method signature:
	static void printBonusDatesBetween(int fromYear, int toYear)

	It should print dates in interval from fromYear (inclusive) to toYear (exclusive) that satisfy the condition.

	For example, calling printBonusDatesBetween(2010, 2015) should print:
	2010-01-02
	2011-11-02
	
	TEST
	printBonusDatesBetween(2010, 2015);
	printBonusDatesBetween(100, 111);
	printBonusDatesBetween(0, 111);
	*/
	public static void printBonusDatesBetween(int fromYear, int toYear) {
		GregorianCalendar dateFrom = new GregorianCalendar(fromYear, 0, 1);
		GregorianCalendar dateTo = new GregorianCalendar(toYear, 11, 31);
		
		//only for date > 999 year
		//DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateFormatResult = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormatMonthDay = new SimpleDateFormat("MMdd");
				
		String currentDate;
		Boolean isPolindrom = false;
		int i = 0;
		int symbolCenter = 4;
		int maxSymbol = 7;
		
		while (0 >= dateFrom.compareTo(dateTo)) {

			//currentDate = dateFormat.format(dateFrom.getTime());
			currentDate = "" + dateFrom.get(GregorianCalendar.YEAR) + dateFormatMonthDay.format(dateFrom.getTime()); 
								
			isPolindrom = true;
			
			maxSymbol = currentDate.length() - 1;
			symbolCenter = currentDate.length() / 2;
						
			for (i = 0; i < symbolCenter; i++) {
				if (currentDate.charAt(i) != currentDate.charAt(maxSymbol - i)) {
					isPolindrom = false;
				}			 
			};					
			
			if (isPolindrom) {
				System.out.println(dateFormatResult.format(dateFrom.getTime()));
			};
						
			dateFrom.add(GregorianCalendar.DAY_OF_MONTH, 1);			
		} 
		
	}
}
