package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class problemB {


	public static void main(String[] args) throws Exception {
		
		int row,col;
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/LXZE/Desktop/B-large.in"));
		FileWriter fstream = new FileWriter("C:/Users/LXZE/Desktop/out.txt");
		BufferedWriter write = new BufferedWriter(fstream);
		
		int casenum = Integer.parseInt(br.readLine());
		for(int i = 0; i < casenum; i++){
			String[] s = br.readLine().split(" ");
			row = Integer.parseInt(s[0]);
			col = Integer.parseInt(s[1]);
			
			ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
			for(int i_row=0;i_row<row;i_row++){
        		al.add(new ArrayList<Integer>());
        		
        		String[] line = br.readLine().split(" ");
        		for(int i_col=0;i_col<col;i_col++){
        			al.get(i_row).add(Integer.parseInt(line[i_col]));
        		}
        	}
			if(check(al))
			{
				System.out.println("Case #"+(i+1)+": YES");
				write.write("Case #"+(i+1)+": YES\n");
			}
			else
			{
				System.out.println("Case #"+(i+1)+": NO");
				write.write("Case #"+(i+1)+": NO\n");
			}
			
		}	//end case
			write.close();
	}
	
	static boolean check(ArrayList<ArrayList<Integer>> al)
	{
		
		while(true){
    		int k = 0;
    		while(k<al.size()){
    			if (al.get(k).isEmpty()){
    				al.remove(k);
    				continue;
    			}
    			k++;
    		}
    		if(al.isEmpty())
    			break;        	
    		int min = 1000;
    		int min_row = 0;
    		int min_col = 0;
    		
        	for(int r=0;r<al.size();r++){
        		for(int c=0;c<al.get(0).size();c++){
        			if (min>al.get(r).get(c)){
        				min_row = r;
        				min_col = c;
        				min = al.get(r).get(c);
        			}
        		}
        	}

        	int number_row = 0,number_col = 0;
        	boolean b_row = true,b_col = true;
        	
        	// row		        	
        	for(int i_row=0;i_row<al.get(min_row).size();i_row++)
        		if(al.get(min_row).get(i_row) == min)
        			number_row++;
        	if(number_row!=al.get(min_row).size())
        		b_row = false;

        	// column
        	for(int i_col=0;i_col<al.size();i_col++)
        		if (al.get(i_col).get(min_col) == min)
        			number_col++;
        	if (number_col!=al.size())
        		b_col = false;
        	// NO case
        	if(!b_col&&!b_row)
        		return false;
        	
        	// remove col
        	if (b_col){
        		for(int i2_col=0;i2_col<al.size();i2_col++)
	        		al.get(i2_col).remove(min_col);
        	}
        	// remove row
        	else if(b_row){
	        	al.remove(min_row);
        	}
    	} // end while true
		
    	return true;
	}
	
}
