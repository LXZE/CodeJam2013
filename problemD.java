package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class problemD {

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/LXZE/Desktop/codejam/D-small-attempt0.in"));
		FileWriter fstream = new FileWriter("C:/Users/LXZE/Desktop/out_D.txt");
		BufferedWriter write = new BufferedWriter(fstream);
		int numKey;
		int numChest;
		int casenum = Integer.parseInt(br.readLine());
		String[] nCase = new String[casenum];
		for(int i = 0; i < casenum; i++){
			String[] s = br.readLine().split(" ");
			numKey = Integer.parseInt(s[0]);
			numChest = Integer.parseInt(s[1]);
			String[] key = br.readLine().split(" ");
			ArrayList<ArrayList<String>> chest = new ArrayList<ArrayList<String>>();
			for(int iCh=0;iCh<numChest;iCh++)
			{
				chest.add(new ArrayList<String>());
				String[] col = br.readLine().split(" ");
				for(int iCol=0;iCol<col.length;iCol++)
				{
					chest.get(iCh).add(col[iCol]);
				}
			}
			nCase[i] = "Case #"+(i+1)+": "+check(chest,key);
			
			System.out.println(nCase[i]);
			//write.write(nCase[i]);
		}	
		write.close();
	}
	
	static String check(ArrayList<ArrayList<String>> chest,String[] key)
	{
		
		String pattern = null;
		boolean openAll=false;
		boolean del=false;
		int maxKey = key.length;
		int i=0;
		
		
		do
		{
			
			for(int iKey=0;iKey<maxKey&&del;iKey++)
			{
				if(chest.get(i).get(0)==key[iKey])
				{
					while(iKey!=key.length)
						key[iKey]=key[++iKey];						
					maxKey--;
					for(int nKey=0;nKey<Integer.parseInt(chest.get(i).get(1));nKey++)
					{
						if(chest.get(i).get(1)=="0");
						else{
						key[iKey++]=chest.get(i).get(nKey+2);
						maxKey++;}
					}
					pattern = pattern+" "+(i+1);
					del=true;
					chest.remove(i++);
					continue;
				}
				else i++;
			}
		}while(maxKey!=0||!chest.isEmpty()||i!=chest.size());
		
		if(!chest.isEmpty())
			return "IMPOSSIBLE";
		else return pattern;
	}

}
