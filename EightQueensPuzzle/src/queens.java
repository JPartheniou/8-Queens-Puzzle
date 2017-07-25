import java.util.*;

public class queens {
	private static int board[][];
	private static int hillboard1[][];
	private static int hillboard2[][];
	private static int place[];
	private static int place2[];
	private static int place3[];
	private static int threats1[];
	private static int threats2[];
	static int threats3;
	static int threats4;
	static int Sthreats1=0;
	static int Sthreats2=0;
	static int Sthreats3=0;
	static int counter1=1;
	static int counter2=1;
	static int counter3=1;
	static int counter4=1;
	static int steps1=0;
	static int steps2=0;
	static int max=0;
	static int spotx=0;
	static int spoty=0;
	static int x;
	static int y;
	static boolean stop=false;
	static int totalthreats=0;


	static Random rand = new Random();
	public static void main(String[] args) 
	{
		place = new int[8];
		place2 = new int[8];
		place3 = new int[8];
		threats1 = new int[8];
		threats2 = new int[8];
		board = new int[8][9];
		hillboard1 = new int [8][9];
		hillboard2 = new int [8][9];

		for(int j=0; j<8; j++){
			threats1[j]=0;
			threats2[j]=0;
		}

		for (int i = 0; i < 9; i++)	//Fills it with 0's
		{ 
			for (int j = 0; j < 8; j++)	
			{
				board[j][i] = 0;
			}	        
		}	
		for (int j = 0; j < 8; j++)	//Puts random 1's
		{
			int m = rand.nextInt(8);
			board[j][m] = 1;
			place[j]=m;
		}

		for (int i = 0; i < 9; i++)	//Creates the board 
		{ 
			for (int j = 0; j < 8; j++)	//Fills it with 0's
			{
				hillboard1[j][i] = board[j][i];
				hillboard2[j][i] = board[j][i];
			}

		}	
		for(int j=0; j<8; j++){
			place2[j]=place[j];
			place3[j]=place[j];
		}

		for (int j = 0; j < 8; j++)	//Search Horizontally
		{
			//threats=0;
			for (int x = 0; x < 8; x++)
			{ 	    
				if(board[x][place[j]]==1)
					board[j][8] ++;
			}    
			board[j][8]=board[j][8]-1;
		}   		


		for (int j=0; j<8; j++){	//Search Diagonally
			for (int i=1; i<8; i++){
				if(j+i<8 && place[j]+i<8){
					if(board[j+i][place[j]+i]==1){
						board[j][8] ++;
					}
				}
				if(j+i<8 && place[j]-i>=0){
					if(board[j+i][place[j]-i]==1){
						board[j][8] ++;
					}
				}
				if(j-i>=0 && place[j]+i<8){
					if(board[j-i][place[j]+i]==1){
						board[j][8] ++;
					}
				}
				if(j-i>=0 && place[j]-i>=0){
					if(board[j-i][place[j]-i]==1){
						board[j][8] ++;
					}
				}
			}
		}

		//==========================================================================//
		for(int reps=100; reps>0; reps--){
			steps1++;
			for(int j=0; j<8; j++){
				threats3 = 0;
				threats4 = 0;
				if(hillboard1[j][8]>0){
					for (int x = 0; x < 8; x++)
					{ 	
						if(place2[j]-1>=0){
							if(hillboard1[x][place2[j]-1]==1)
								threats3 ++;
						}
					}    
					threats3=threats3-1;
					for (int i=1; i<8; i++){
						if(j+i<8 && place2[j]-1+i<8){
							if(hillboard1[j+i][place2[j]-1+i]==1){
								threats3 ++;
							}
						}
						if(j+i<8 && place2[j]-1-i>=0){
							if(hillboard1[j+i][place2[j]-1-i]==1){
								threats3 ++;
							}
						}
						if(j-i>=0 && place2[j]-1+i<8){
							if(hillboard1[j-i][place2[j]-1+i]==1){
								threats3 ++;
							}
						}
						if(j-i>=0 && place2[j]-1-i>=0){
							if(hillboard1[j-i][place2[j]-1-i]==1){
								threats3 ++;
							}
						}
					}

					for (int x = 0; x < 8; x++)
					{
						if(place2[j]+1<=7){
							if(hillboard1[x][place2[j]+1]==1)
								threats4 ++;
						}
					}    
					threats4=threats4-1;
					for (int i=1; i<8; i++){
						if(j+i<8 && place2[j]+1+i<8){
							if(hillboard1[j+i][place2[j]+1+i]==1){
								threats4 ++;
							}
						}
						if(j+i<8 && place2[j]+1-i>=0){
							if(hillboard1[j+i][place2[j]+1-i]==1){
								threats4 ++;
							}
						}
						if(j-i>=0 && place2[j]+1+i<8){
							if(hillboard1[j-i][place2[j]+1+i]==1){
								threats4 ++;
							}
						}
						if(j-i>=0 && place2[j]+1-i>=0){
							if(hillboard1[j-i][place2[j]+1-i]==1){
								threats4 ++;
							}
						}
					}
				}
				if(threats3>=threats4){
					if(threats3 < hillboard1[j][8]){
						if(place2[j]-1>0){
							hillboard1[j][place2[j]] = 0;
							hillboard1[j][place2[j]-1] = 1;
							place2[j]=place2[j]-1;
							for(int y=0;y<8;y++){
								hillboard1[y][8]=0;
								//threats=0;
								for (int x = 0; x < 8; x++)
								{ 	    
									if(hillboard1[x][place2[y]]==1)
										hillboard1[y][8] ++;
								}    
								hillboard1[y][8]=hillboard1[y][8]-1;


								for (int i=1; i<8; i++){
									if(y+i<8 && place2[y]+i<8){
										if(hillboard1[y+i][place2[y]+i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y+i<8 && place2[y]-i>=0){
										if(hillboard1[y+i][place2[y]-i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y-i>=0 && place2[y]+i<8){
										if(hillboard1[y-i][place2[y]+i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y-i>=0 && place2[y]-i>=0){
										if(hillboard1[y-i][place2[y]-i]==1){
											hillboard1[y][8] ++;
										}
									}
								}
							}
						}
					}else{
						counter1=0;
					}
				}else{
					if(threats4 < hillboard1[j][8]){
						if(place2[j]+1<7){
							hillboard1[j][place2[j]] = 0;
							hillboard1[j][place2[j]+1] = 1;
							place2[j]=place2[j]+1;
							for(int y=0;y<8;y++){
								hillboard1[y][8]=0;
								//threats=0;
								for (int x = 0; x < 8; x++)
								{ 	    
									if(hillboard1[x][place2[y]]==1)
										hillboard1[y][8] ++;
								}    
								hillboard1[y][8]=hillboard1[y][8]-1;


								for (int i=1; i<8; i++){
									if(y+i<8 && place2[y]+i<8){
										if(hillboard1[y+i][place2[y]+i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y+i<8 && place2[y]-i>=0){
										if(hillboard1[y+i][place2[y]-i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y-i>=0 && place2[y]+i<8){
										if(hillboard1[y-i][place2[y]+i]==1){
											hillboard1[y][8] ++;
										}
									}
									if(y-i>=0 && place2[y]-i>=0){
										if(hillboard1[y-i][place2[y]-i]==1){
											hillboard1[y][8] ++;
										}
									}
								}
							}
						}
					}else{
						counter2=0;
					}
				}

				hillboard1[j][8]=0;
				//threats=0;
				for (int x = 0; x < 8; x++)
				{ 	    
					if(hillboard1[x][place2[j]]==1)
						hillboard1[j][8] ++;
				}    
				hillboard1[j][8]=hillboard1[j][8]-1;


				for (int i=1; i<8; i++){
					if(j+i<8 && place2[j]+i<8){
						if(hillboard1[j+i][place2[j]+i]==1){
							hillboard1[j][8] ++;
						}
					}
					if(j+i<8 && place2[j]-i>=0){
						if(hillboard1[j+i][place2[j]-i]==1){
							hillboard1[j][8] ++;
						}
					}
					if(j-i>=0 && place2[j]+i<8){
						if(hillboard1[j-i][place2[j]+i]==1){
							hillboard1[j][8] ++;
						}
					}
					if(j-i>=0 && place2[j]-i>=0){
						if(hillboard1[j-i][place2[j]-i]==1){
							hillboard1[j][8] ++;
						}
					}
				}
			}
			if(counter1==0 && counter2==0){
				reps = 0;
			}
		} 
		//==========================================================================//	   
		for(int reps=1000; reps>=0; reps--){
			steps2++;
			for(int j=0; j<8; j++){
				threats3 = 0;
				threats4 = 0;
				if(hillboard2[j][8]>0){
					for (int x = 0; x < 8; x++)
					{ 	
						if(place[j]-1>=0){
							if(hillboard2[x][place3[j]-1]==1)
								threats3 ++;
						}
					}    
					threats3=threats3-1;
					for (int i=1; i<8; i++){
						if(j+i<8 && place3[j]-1+i<8){
							if(hillboard2[j+i][place3[j]-1+i]==1){
								threats3 ++;
							}
						}
						if(j+i<8 && place3[j]-1-i>=0){
							if(hillboard2[j+i][place3[j]-1-i]==1){
								threats3 ++;
							}
						}
						if(j-i>=0 && place3[j]-1+i<8){
							if(hillboard2[j-i][place3[j]-1+i]==1){
								threats3 ++;
							}
						}
						if(j-i>=0 && place3[j]-1-i>=0){
							if(hillboard2[j-i][place3[j]-1-i]==1){
								threats3 ++;
							}
						}
					}

					for (int x = 0; x < 8; x++)
					{
						if(place3[j]+1<=7){
							if(hillboard2[x][place3[j]+1]==1)
								threats4 ++;
						}
					}    
					threats4=threats4-1;
					for (int i=1; i<8; i++){
						if(j+i<8 && place3[j]+1+i<8){
							if(hillboard2[j+i][place3[j]+1+i]==1){
								threats4 ++;
							}
						}
						if(j+i<8 && place3[j]+1-i>=0){
							if(hillboard2[j+i][place3[j]+1-i]==1){
								threats4 ++;
							}
						}
						if(j-i>=0 && place3[j]+1+i<8){
							if(hillboard2[j-i][place3[j]+1+i]==1){
								threats4 ++;
							}
						}
						if(j-i>=0 && place3[j]+1-i>=0){
							if(hillboard2[j-i][place3[j]+1-i]==1){
								threats4 ++;
							}
						}
					}
				}
				if(threats3>=threats4){
					if(threats3 < hillboard2[j][8]){
						if(place3[j]-1>0){
							hillboard2[j][place3[j]] = 0;
							hillboard2[j][place3[j]-1] = 1;
							place3[j]=place3[j]-1;
							for(int y=0;y<8;y++){
								hillboard2[y][8]=0;
								//threats=0;
								for (int x = 0; x < 8; x++)
								{ 	    
									if(hillboard2[x][place3[y]]==1)
										hillboard2[y][8] ++;
								}    
								hillboard2[y][8]=hillboard2[y][8]-1;


								for (int i=1; i<8; i++){
									if(y+i<8 && place3[y]+i<8){
										if(hillboard2[y+i][place3[y]+i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y+i<8 && place3[y]-i>=0){
										if(hillboard2[y+i][place3[y]-i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y-i>=0 && place3[y]+i<8){
										if(hillboard2[y-i][place3[y]+i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y-i>=0 && place3[y]-i>=0){
										if(hillboard2[y-i][place3[y]-i]==1){
											hillboard2[y][8] ++;
										}
									}
								}
							}
						}
					}else{
						counter3=0;
					}
				}else{
					if(threats4 < hillboard2[j][8]){
						if(place3[j]+1<7){
							hillboard2[j][place3[j]] = 0;
							hillboard2[j][place3[j]+1] = 1;
							place3[j]=place3[j]+1;
							for(int y=0;y<8;y++){
								hillboard2[y][8]=0;
								//threats=0;
								for (int x = 0; x < 8; x++)
								{ 	    
									if(hillboard2[x][place3[y]]==1)
										hillboard2[y][8] ++;
								}    
								hillboard2[y][8]=hillboard2[y][8]-1;


								for (int i=1; i<8; i++){
									if(y+i<8 && place3[y]+i<8){
										if(hillboard2[y+i][place3[y]+i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y+i<8 && place3[y]-i>=0){
										if(hillboard2[y+i][place3[y]-i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y-i>=0 && place3[y]+i<8){
										if(hillboard2[y-i][place3[y]+i]==1){
											hillboard2[y][8] ++;
										}
									}
									if(y-i>=0 && place3[y]-i>=0){
										if(hillboard2[y-i][place3[y]-i]==1){
											hillboard2[y][8] ++;
										}
									}
								}
							}
						}
					}else{
						counter4=0;
					}
				}


				hillboard2[j][8]=0;
				//threats=0;
				for (int x = 0; x < 8; x++)
				{ 	    
					if(hillboard2[x][place3[j]]==1)
						hillboard2[j][8] ++;
				}    
				hillboard2[j][8]=hillboard2[j][8]-1;


				for (int i=1; i<8; i++){
					if(j+i<8 && place3[j]+i<8){
						if(hillboard2[j+i][place3[j]+i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j+i<8 && place3[j]-i>=0){
						if(hillboard2[j+i][place3[j]-i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j-i>=0 && place3[j]+i<8){
						if(hillboard2[j-i][place3[j]+i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j-i>=0 && place3[j]-i>=0){
						if(hillboard2[j-i][place3[j]-i]==1){
							hillboard2[j][8] ++;
						}
					}
				}
			}
			if(counter3==0 && counter4==0){
				totalthreats=0;
				max=0;
				x = rand.nextInt(8);
				y = rand.nextInt(6)+1;
				for(int j=0;j<8; j++){
					totalthreats=totalthreats + hillboard2[j][8];
					if(max<hillboard2[j][8]){
						max=j;
					}
				}
				if(totalthreats==0){
					reps=0;
				}else{
					hillboard2[max][place3[max]]=0;
					hillboard2[max][y]=1;
					place3[max]=y;
					for(int y=0;y<8;y++){
						hillboard2[y][8]=0;
						//threats=0;
						for (int x = 0; x < 8; x++)
						{ 	    
							if(hillboard2[x][place3[y]]==1)
								hillboard2[y][8] ++;
						}    
						hillboard2[y][8]=hillboard2[y][8]-1;


						for (int i=1; i<8; i++){
							if(y+i<8 && place3[y]+i<8){
								if(hillboard2[y+i][place3[y]+i]==1){
									hillboard2[y][8] ++;
								}
							}
							if(y+i<8 && place3[y]-i>=0){
								if(hillboard2[y+i][place3[y]-i]==1){
									hillboard2[y][8] ++;
								}
							}
							if(y-i>=0 && place3[y]+i<8){
								if(hillboard2[y-i][place3[y]+i]==1){
									hillboard2[y][8] ++;
								}
							}
							if(y-i>=0 && place3[y]-i>=0){
								if(hillboard2[y-i][place3[y]-i]==1){
									hillboard2[y][8] ++;
								}
							}
						}
					}
				}
			}
			
			for(int j=0;j<8;j++){
				hillboard2[j][8]=0;
				//threats=0;
				for (int x = 0; x < 8; x++)
				{ 	    
					if(hillboard2[x][place3[j]]==1)
						hillboard2[j][8] ++;
				}    
				hillboard2[j][8]=hillboard2[j][8]-1;


				for (int i=1; i<8; i++){
					if(j+i<8 && place3[j]+i<8){
						if(hillboard2[j+i][place3[j]+i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j+i<8 && place3[j]-i>=0){
						if(hillboard2[j+i][place3[j]-i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j-i>=0 && place3[j]+i<8){
						if(hillboard2[j-i][place3[j]+i]==1){
							hillboard2[j][8] ++;
						}
					}
					if(j-i>=0 && place3[j]-i>=0){
						if(hillboard2[j-i][place3[j]-i]==1){
							hillboard2[j][8] ++;
						}
					}
				}
			}

		}







		System.out.println("Initial Board");
		for (int i = 0; i < 8; i++)
		{ 
			for (int j = 0; j < 8; j++)
			{
				System.out.print(board[j][i] + " ");
			}
			System.out.println();
		}	
		System.out.println("Threats");
		for (int j = 0; j < 8; j++)
		{
			System.out.print(board[j][8] + " ");
			Sthreats1 = Sthreats1 + board[j][8];

		}
		System.out.println("Sum of threats: "+ Sthreats1);
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("Simple Hill Climbing Result");

		for (int i = 0; i < 8; i++)
		{ 
			for (int j = 0; j < 8; j++)
			{
				System.out.print(hillboard1[j][i] + " ");
			}
			System.out.println();
		}	
		System.out.println("Threats");
		for (int j = 0; j < 8; j++)
		{
			System.out.print(hillboard1[j][8] + " ");
			Sthreats2 = Sthreats2 + hillboard1[j][8];

		}
		System.out.println("Sum of threats: "+ Sthreats2 + " Steps: " + steps1);


		System.out.println();
		System.out.println("---------------------------");
		System.out.println("Randomized Hill Climbing Result");

		for (int i = 0; i < 8; i++)
		{ 
			for (int j = 0; j < 8; j++)
			{
				System.out.print(hillboard2[j][i] + " ");
			}
			System.out.println();
		}	
		System.out.println("Threats");
		for (int j = 0; j < 8; j++)
		{
			System.out.print(hillboard2[j][8] + " ");
			Sthreats3 = Sthreats3 + hillboard2[j][8];

		}
		System.out.println("Sum of threats: "+ Sthreats3 + " Steps: " + steps2);

	}
}