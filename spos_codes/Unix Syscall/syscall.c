#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

int main()
{
	int op;
	int status = 0;
	while(1)
	{
		printf("\n\n********************************Menu***************************\n");
		printf("1.fork \n2.exec \n3.ps \n4.joint \n5.exit\n6.show parent id \n7.show current id\nEnter choice =>");
	
		scanf("%d",&op);
	
		switch(op)
		{
			case 1:
					if(fork()==0)		//true for child process
					{
						printf("This is child process pid => %d \n",getpid());
						//return 0;
					}
					else				
					{
						wait(&status);
						printf("This is parent process pid => %d \n",getpid());
					}
					break;
			case 2:
					if(fork()==0)
					{						
						execv("./p2",0);						
					}
					else
					{	//waiting parent process
						wait(&status);
						printf("parent process is executed \n");
					}
					
					break;
					
			case 3:
					system("ps -e");
					break;
			case 4:		
					system("join f1.txt f2.txt -a 1 > f3.txt\n");
					break;
			case 5:
					exit(0);
					break;
			case 6:
					printf("This is parent process id of current process => %d \n",getppid());
					break;
			case 7:
					printf("This is a Current Process id=> %d \n",getpid());	
					break;			
			default:
					printf("Wrong choice please try again\n");
					break;
		}	
	}
	return 0;
}

/*

********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>1
This is child process pid => 5809 
This is parent process pid => 5808 


********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>2


This is process 2 ppid => 5808



********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>3
After waiting for 80000msec


********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>4
  PID TTY          TIME CMD
 5639 pts/0    00:00:00 bash
 5808 pts/0    00:00:00 p1
 5812 pts/0    00:00:00 sh
 5813 pts/0    00:00:00 ps


********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>5
join: f1.txt: No such file or directory


********************************Menu***************************
1.fork 
2.exec 
3.wait 
4.ps 
5.joint 
6.exit
Enter choice =>6
*/
