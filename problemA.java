package code;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {

	public static void main(String[] args) {
		String[] result = {"X won","O won","Draw","Game has not completed"};
		
		int count;
		String input;
		char[][] sq = new char[4][4];
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		String[] allcase = new String[count];
		int type;
		
		for(int i_count=0;i_count<count;i_count++)
		{
			sc.nextLine();
			for(int i=0;i<4;i++){
				input = sc.nextLine();
				sq[i] = input.toCharArray();
			}

			type = check(sq);
			allcase[i_count] = "Case #"+(i_count+1)+": "+result[type];
			sq = new char[4][4];
		}
		
		for(int i=0;i<allcase.length;i++)
		{
			System.out.println(allcase[i]);
		}

	}
	
	static int check(char[][] sq)
	{
		char charspot = 'A';
		boolean win = false;
		//row
		for (int i = 0; i < 4 && !win; i++) 
		{
			char spot1 = sq[i][0];
			char spot2 = sq[i][1];
			char spot3 = sq[i][2];
			char spot4 = sq[i][3];
			if (spot1==spot2 && spot2==spot3 && spot3==spot4 && spot1!='.'){
				charspot = spot1;
				win = true;}
			else if(spot1=='T')
			{
				if(spot2==spot3 && spot3==spot4 && spot2!='.'){
					charspot = spot2;
					win = true;}
			}
			else if(spot2=='T')
			{
				if(spot1==spot3 && spot3==spot4 && spot1!='.'){
					charspot = spot1;
					win = true;}
			}
			else if(spot3=='T')
			{
				if(spot2==spot1 && spot2==spot4 && spot1!='.'){
					charspot = spot1;
					win = true;}
			}
			else if(spot4=='T')
			{
				if(spot2==spot3 && spot3==spot1 && spot1!='.'){
					charspot = spot1;
					win = true;}
			}
		}
		
		//collum
		if(!win)
		{
			for (int i = 0; i < 4 && !win; i++) {
				char spot1 = sq[0][i];
				char spot2 = sq[1][i];
				char spot3 = sq[2][i];
				char spot4 = sq[3][i];
				if (spot1==spot2 && spot2==spot3 && spot3==spot4 && spot1!='.'){
					charspot = spot1;
					win = true;}
				else if(spot1=='T')
				{
					if(spot2==spot3 && spot3==spot4 && spot2!='.'){
						charspot = spot2;
						win = true;}
				}
				else if(spot2=='T')
				{
					if(spot1==spot3 && spot3==spot4 && spot1!='.'){
						charspot = spot1;
						win = true;}
				}
				else if(spot3=='T')
				{
					if(spot2==spot1 && spot2==spot4 && spot1!='.'){
						charspot = spot1;
						win = true;}
				}
				else if(spot4=='T')
				{
					if(spot2==spot3 && spot3==spot1 && spot1!='.'){
						charspot = spot1;
						win = true;}
				}
			}
		}

		// Check diagonals
		if (!win) {
			char spot1 = sq[0][0];
			char spot2 = sq[1][1];
			char spot3 = sq[2][2];
			char spot4 = sq[3][3];
			
			if (spot1==spot2 && spot2==spot3 && spot3==spot4 && spot1!='.')
				charspot = spot1;
			else if(spot1=='T')
			{
				if(spot2==spot3 && spot3==spot4 && spot2!='.')
					charspot = spot2;
			}
			else if(spot2=='T')
			{
				if(spot1==spot3 && spot3==spot4 && spot1!='.')
					charspot = spot1;
			}
			else if(spot3=='T')
			{
				if(spot2==spot1 && spot2==spot4 && spot1!='.')
					charspot = spot1;
			}
			else if(spot4=='T')
			{
				if(spot2==spot3 && spot3==spot1 && spot1!='.')
					charspot = spot1;
			}
			
			else {
				spot1 = sq[0][3];
				spot2 = sq[1][2];
				spot3 = sq[2][1];
				spot4 = sq[3][0];
				
				if (spot1==spot2 && spot2==spot3 && spot3==spot4 && spot1!='.')
					charspot = spot1;
				else if(spot1=='T')
				{
					if(spot2==spot3 && spot3==spot4 && spot2!='.')
						charspot = spot2;
				}
				else if(spot2=='T')
				{
					if(spot1==spot3 && spot3==spot4 && spot1!='.')
						charspot = spot1;
				}
				else if(spot3=='T')
				{
					if(spot2==spot1 && spot2==spot4 && spot1!='.')
						charspot = spot1;
				}
				else if(spot4=='T')
				{
					if(spot2==spot3 && spot3==spot1 && spot1!='.')
						charspot = spot1;
				}
				else{
					for(int x=0;x<4;x++)
						for(int y=0;y<4;y++)
							if(sq[x][y]=='.')
								return 3;
					return 2;
				}
			}
		}

		if(charspot=='X')
			return 0;
		else if(charspot=='O')
			return 1;
		else return 2;

	}

}
