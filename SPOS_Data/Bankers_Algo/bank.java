import java.lang.*;
import java.util.*;

class bank {

Scanner sc = new Scanner (System.in);

private int i,j, np, nr;

private int allo[][] , max[][] , need[][];

private int a1[][],a2[];

private int avai[];


void input () {

System.out.println("Enter the no of process: ");
np = sc.nextInt();

System.out.println("Enter the no of resources: ");
nr = sc.nextInt();

allo = new int [np][nr]; 
max = new int [np][nr];
need = new int [np][nr];

avai = new int [nr];
a1 = new int [np][nr];
a2 = new int [nr];

System.out.println("Enter the allocation matrix: ");

for( i = 0 ; i < np ; i++){
	
	for ( j = 0 ; j < nr ; j++){
	
		allo[i][j] = sc.nextInt();
		
	}

}
System.out.println("Enter the max matrix: ");

for( i = 0 ; i < np ; i++){
	
	for ( j = 0 ; j < nr ; j++){
	
		max[i][j] = sc.nextInt();
		
	}

}

System.out.println("Enter the available matrix: ");

for (i = 0 ; i < nr; i++)
{
avai[i]= sc.nextInt();

}

}


void calc_need () {
//need=max - allocation
  for (i = 0 ; i < np; i++)
  {
  	for (j = 0 ; j<nr ; j++)
  	{
  		need[i][j] = max[i][j]-allo[i][j];
  	}
  
  }

}

boolean check(int i ) {

	for(j=0 ; j < nr ; j++)
	{
	  if (avai[j]<need[i][j])
	  		return false;
	} 
	
	return true;	
		
}




void display () {

System.out.print("\n\n *****Showing need matrix***** \n\n");
for (i = 0 ; i < np; i++)
  {
  	for (j = 0 ; j<nr ; j++)
  	{
  		System.out.print(need[i][j] + " ");
  		//need[i][j] = max[i][j]-allo[i][j]
  	}
  System.out.println("\n");
  }
System.out.print(" ***************************** \n\n");
}




public void safe()
{
boolean allocated;
boolean done [];
done = new boolean[np];
int j =0 ;
while(j<np){

	allocated = false;
	
	for(int i =0 ; i<np; i++)
	{
		if (!done[i] && check(i))
			{
				 for(int k=0;k<nr;k++)
				    avai[k] += allo[i][k];
				done[i]=allocated=true;
				System.out.println("process allocted is"+(i+1));
				j++;
			}
	
	
	}
     
    if(allocated==false) 
		break;

}
if (j == np){
System.out.println("all alocated");
}
else{
	
	System.out.println("not safe");

}



}





public static void main( String args []){

//System.out.println("hi");

bank b = new bank();

b.input();
b.calc_need();
b.display();
/*
boolean flag = b.check(1); //process no 0 checking for condition
System.out.print(flag); 
*/
b.safe();





}   

}
