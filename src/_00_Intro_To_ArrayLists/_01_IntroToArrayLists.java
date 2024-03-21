package _00_Intro_To_ArrayLists;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> strings = new ArrayList<String>();
        // 2. Add five Strings to your list
    	strings.add("Joshua");
    	strings.add("Sally");
    	strings.add("Paul");
    	strings.add("Jonathan");
    	strings.add("Joleen");
        // 3. Print all the Strings using a standard for-loop
    	for (int i = 0; i < 5; i++) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
    	for (String s : strings) {
    		System.out.println(s);
    	}
    	System.out.println();
        // 4. Print all the Strings using a for-each loop

        // 5. Print only the even numbered elements in the list.
    	for (int i = 0; i < 5; i+=2) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
    	for (int i = 4; i <= 0; i++) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
        // 6. Print all the Strings in reverse order.

        // 7. Print only the Strings that have the letter 'e' in them.
        for (int i = 0; i < 5; i++) {
        	if (strings.get(i).contains("e")) {
        		System.out.println(strings.get(i));
        	}
        }
    }
}
