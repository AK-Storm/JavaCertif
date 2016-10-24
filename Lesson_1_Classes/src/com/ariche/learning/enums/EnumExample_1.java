package com.ariche.learning.enums;

/***
 *  Java cetification
 *  Enum
 * 
 * 		1- Enum != Enumuration, Enum is data type ,Enumeration is an interface to iterate over collection. 
 * 		2- Enum data type cannot be declared local (inside a method).
 * 	    3- Enum data types are identical to a class,that all of theme extend the Enum class ,and Enum extends Object.
 * 	    4- Enum class override a number of  methods :
 * 		   - toString : return the Enum's String 
 * 		   - valueOf(String): convert String to Enum 
 * 		   - values(): return all the enum values for an Enum
 * 		   - ordinal() : return the ordinal number in the declaration 
 * 		   - compareTo() : to campare two Enums
 * 
 *
 */

public class EnumExample_1 {

	// Day Enum
	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	private Day day;

	public EnumExample_1(Day day) {
		super();
		this.day = day;
	}

	public void tellItLikeItIs() {
	        switch (day) {
	            case MONDAY:
	                System.out.println("Mondays are bad.");
	                break;
	                    
	            case FRIDAY:
	                System.out.println("Fridays are better.");
	                break;
	                         
	            case SATURDAY: case SUNDAY:
	                System.out.println("Weekends are best.");
	                break;
	                        
	            default:
	                System.out.println("Midweek days are so-so.");
	                break;
	        }
	        
	}
	
	public static void main(String[] args) {
		EnumExample_1 firstDay = new EnumExample_1(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumExample_1 thirdDay = new EnumExample_1(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumExample_1 fifthDay = new EnumExample_1(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumExample_1 sixthDay = new EnumExample_1(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumExample_1 seventhDay = new EnumExample_1(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
        
        
        // methods 
        // 1- toString
        System.out.println(Day.MONDAY.toString());
        // 2- valueOf
        Day aDay  = Day.valueOf("TUESDAY");
        System.out.println(aDay);
        // 3- values and ordinal()
        Day[] theWeek = Day.values();
        for (Day day : theWeek) {
			System.out.println(day+" order in "+day.ordinal());
		}
        //4- compareTo 
        System.out.println(aDay.compareTo(Day.FRIDAY));
	}
}
