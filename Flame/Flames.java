package Flame;
import java.util.*;
import java.io.*;

public class Flames {
	
	public static String calculate(String name1, String name2) {
		Map<Character, Integer> map= new HashMap<>();						//to keep a check on the common letters in the strings (canceled out)
		//Set<Character> n2= new HashSet<>();
		List<Character> list= new ArrayList<>();
		
		name1= name1.toLowerCase();
		name2= name2.toLowerCase();
		int count=0, common= 0;												
		String flames= "FLAMES";
		
		for(int i=0;i<flames.length();i++){
			list.add(flames.charAt(i));
		}

		for(int i=0;i<name1.length();i++) {	
			char temp= name1.charAt(i);
			map.put(temp, map.getOrDefault(temp,0) + 1);
		}
		for(int i=0;i<name2.length();i++){
			char temp= name2.charAt(i);
			if(map.containsKey(temp) && map.get(temp)>0) {				//instead of removing map objects with val: 0 or below, stop considering them present in the map
				common++;												//common: pair of letters common in both names 
				map.put(temp, map.get(temp)-1);
			}
		}
		count= name1.length() + name2.length() - 2*common;				//resulting letters to be use in calculation (after canceling pairs)
		//System.out.println(count);
		int i= 0;
		while(list.size()>1) {											//we will get our answer when only one letter is left in the list
			int cut =1;
			int temp= count%list.size();								//makes calculation easier, without altering the result
			if(temp==0) {												//0th count from the current index:i, have to move backwards
				if(i==0)												
					list.remove(list.size()-1);
				else {
					i=i-1;
					list.remove(i);
				}
			}
			else {
				for(;i<list.size();) {
					if(cut==temp) {					//time to cut the letter
						list.remove(i);
						
						if(i>=list.size())
							i=0;
						break;
					}
					i++;							//else keep counting, to approach letter to cut
					if(i>=list.size())				//circular loop
						i=0;
					
					cut++;
				}
			}
		}
		char ans= list.get(0);
		
		System.out.print("\n\nRELATION : ");
		switch(ans) {																//output according to the (only) letter left	
		case 'F': System.out.println("Friendship");				break;			
		case 'L': System.out.println("Love");	    			break;	
		case 'A': System.out.println("Affection"); 				break;		
		case 'M': System.out.println("Marriage");				break;			
		case 'E': System.out.println("Enemy");					break;			
		case 'S': System.out.println("Siblings");		break;		
		}
		System.out.println("");
		return "Thanks For Playing";
	}
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		
		try {																		//presentation
			System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t");
			System.out.print("F");
			Thread.sleep(1000);
			System.out.print("L");
			Thread.sleep(1000);
			System.out.print("A");
			Thread.sleep(1000);
			System.out.print("M");
			Thread.sleep(1000);
			System.out.print("E");
			Thread.sleep(1000);
			System.out.println("S");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.print("\nPerson 1 : ");
		String name1= in.next();
		System.out.print("Person 2 : ");
		String name2= in.next();
		
		in.close();
		
		System.out.print(calculate(name1, name2));
		
		try {
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
			System.out.print(".");
			Thread.sleep(400);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
