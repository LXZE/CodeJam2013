package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class problemC {


	public static void main(String[] args) throws IOException {
		try{
		int count;
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/LXZE/Desktop/codejam/C-large-2.in"));
		FileWriter fstream = new FileWriter("C:/Users/LXZE/Desktop/out_C.txt");
		BufferedWriter write = new BufferedWriter(fstream);
		
		//Scanner sc = new Scanner(System.im);
		//count = sc.nextInt();
		count = Integer.parseInt(br.readLine());
		long st,end;
		int number;
		String[] nCase = new String[count];
		long[] b = new long[20000000];
		
		for(int i_count=0;i_count<count;i_count++)
		{
			String[] s = br.readLine().split(" ");
			st = Long.parseLong(s[0]);
			end = Long.parseLong(s[1]);
			/*sc.nextLine();
			st = sc.nextLong();
			end = sc.nextLong();*/
			number = checkfsq(st,end);
			nCase[i_count] = "Case #"+(i_count+1)+": "+number;
			write.write(nCase[i_count]);
		}
		
		for(int i=0;i<nCase.length;i++)
		{
			System.out.println(nCase[i]);
		}
		}
		catch(Exception e){
			for(int i_count=0;i_count<1000;i_count++)
			{
				FileWriter fstream = new FileWriter("C:/Users/LXZE/Desktop/out_C.txt");
				BufferedWriter write = new BufferedWriter(fstream);
				write.write("Case #"+(i_count+1)+": 0");
			}
		}
	}
	
	static int checkfsq(Long st,Long end)
	{
		int i;
		int numcase = 0;
		Long n = (long) 0;
		for(n=st;n<=end;n++)
		{
			if(checkSq(n)&&checkPld(n)){
				//System.out.println(n);
				long b;
				b=n;
				numcase++;
			}
		}
		return numcase;
	}
	static boolean checkSq(long n) {
		double x;
		long y = 0;
		try{
			x = java.lang.Math.sqrt(n);
			y=(long) x;
			if((x-y)!=0){
				return false;
			}
			else 
				if(checkPld(y))
					return true;
				else
					return false;
			
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

	static Boolean checkPld(long y)
	{
		String st = String.valueOf(y);
	    int i1 = 0;
	    int i2 = st.length() - 1;
	    while (i2 > i1) {
	        if (st.charAt(i1) != st.charAt(i2)) {
	            return false;
	        }
	        i1++;
	        i2--;
	    }
	    return true;
	}
}
