package org.shiksha.fleet.utility;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String timeValue ="1010";
		/*ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=0;i<4;i++)
		{
			if(i==0)
			arr.add(Integer.parseInt(data));
			else
			arr.add(arr.get(i-1)+10);	
		}
		for(int i=0;i<arr.size();i++)
		{
			System.out.println("Values ::"+arr.get(i));
		}
	}
	*/
	
	int i = Integer.parseInt(timeValue);
    int var = i + 10;
    String str = Integer.toString(var);
    System.out.println(str);
}
}