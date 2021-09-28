import java.util.Scanner;

public class MoonPhase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Taking in the date
		System.out.print("Enter the date (e.g. July 4, 1776): ");
		String monthName = in.next();
		String inputDay = in.next();
		String inputYear = in.next();
		
		String stringDay = "";
		
		//Converting Strings into Int
		if(inputDay.length() < 3) {
			stringDay = inputDay.substring(0, 1);
		}else
			stringDay = inputDay.substring(0, 2);
		
		int day = Integer.parseInt(stringDay);
		int year = Integer.parseInt(inputYear);
		int monthNumber = 0;
		
		//Getting month number from month name
		switch (monthName) {
		case "January": case "january":
			monthNumber = 1;
			break;
		case "February": case "february":
			monthNumber = 2;
			break;
		case "March": case "march":
			monthNumber = 3;
			break;
		case "April": case "april":
			monthNumber = 4;
			break;
		case "May": case "may":
			monthNumber = 5;
			break;
		case "June": case "june":
			monthNumber = 6;
			break;
		case "July": case "july":
			monthNumber = 7;
			break;
		case "August": case "august":
			monthNumber = 8;
			break;
		case "September": case "september":
			monthNumber = 9;
			break;
		case "October": case "october":
			monthNumber = 10;
			break;
		case "November": case "november":
			monthNumber = 11;
			break;
		case "December": case "december":
			monthNumber = 12;
			break;
		default: 
			System.out.println("That is not a month");
		
		}
		
		//calculating julian day & day of the week
		int aJulian = (14-monthNumber)/12;
		int yJulian = year + 4800 - aJulian;
		int mJulian = monthNumber + (12 * aJulian) - 3;
		int julian = day + ((153*mJulian + 2)/5) + (365*yJulian) + (yJulian/4) - (yJulian/100) + (yJulian/400) - 32045;		
		int dayOfWeekNum = (julian + 1) % 7;
		String dayOfWeekName = "";
		
		//Getting day of week name from answer of calculation above
		switch (dayOfWeekNum) {
		case 0: dayOfWeekName = "Sunday"; 
		break;
		case 1: dayOfWeekName = "Monday"; 
		break;
		case 2: dayOfWeekName = "Tuesday"; 
		break;
		case 3: dayOfWeekName = "Wednesday"; 
		break;
		case 4: dayOfWeekName = "Thursday"; 
		break;
		case 5: dayOfWeekName = "Friday"; 
		break;
		case 6: dayOfWeekName = "Saturday"; 
		break;
		
		}
		
		//Finding Phase of the Moon
		double moonPhase = (((julian - 2415021) % 29.530588853) / 29.530588853) * 8; 
		
		//if moonPhase is negative, make it positive
		if(moonPhase < 0) {
			moonPhase += 8;
		}
		
		//Rounding MoonPhase to an int
		int roundedMoonPhase = (int)Math.round(moonPhase);
		
		String moonPhaseName = "";
			
		//Getting name of Moon Phase from calculated moonPhase number
		switch (roundedMoonPhase) {
		case 0: 
		
		case 8: moonPhaseName = "New Moon";
		break;
		case 1: moonPhaseName = "Waxing Crescent";
		break;
		case 2: moonPhaseName = "First Quarter";
		break;
		case 3: moonPhaseName = "Waxing Gibbous";
		break;
		case 4: moonPhaseName = "Full Moon";
		break;
		case 5: moonPhaseName = "Waning Gibbous";
		break;
		case 6: moonPhaseName = "Last Quarter";
		break;
		case 7: moonPhaseName = "Waning Crescent";
		break;
		
		}
		
		//Final Output
		System.out.println(monthName + " " + inputDay + " " + inputYear + " has a Julian day of " + julian + '.');
		System.out.println("Its day of the week is " + dayOfWeekName + '.');
		System.out.println("Its phase of the moon is " + moonPhaseName + '.');
		
		//Resource Leak is annoying to look at
		in.close();
	}
	
}
