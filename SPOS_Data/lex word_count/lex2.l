
/*lex program to count number of words*/
%{ 
#include<stdio.h> 
#include<string.h>

int iLine,iSpace,iChar,iSplChar,iWords,iNum,myword; 
%} 
  
/* Rules Section*/
%% 
(\n)					{	iLine++;	}

([0-9])					{	iNum++;		}
" "						{	iSpace++;	}

([a-z|A-Z][a-zA-Z]*[^ \t\n]*)				{	myword++; iChar+=yyleng;  }
.			{	iSplChar++;	}
%% 
  
int yywrap(void){} 
  
int main() 
{    
	iLine=0;
	iSpace=0;
	iChar=0;
	iSplChar=0;
	iWords=0;
	iNum=0;
    // The function that starts the analysis 
    yylex(); 
    printf("Number of lines are \t\t-> %d\n",iLine);
    printf("Number of Space are \t\t-> %d\n",iSpace);
    printf("Number of Digits are \t\t-> %d\n",iNum);
    printf("Number of char are \t\t-> %d\n",iChar);
    printf("Number of Special char are \t-> %d\n",iSplChar);
    //printf("Number of words are \t\t-> %d\n",iWords);
        printf("Number of mywords are \t\t-> %d\n",myword);  
    return 0; 
} 

/*
ubuntu@PL-LAB:~/TA02/spos/lex2$ lex lex2.l 
ubuntu@PL-LAB:~/TA02/spos/lex2$ cc lex.yy.c 
ubuntu@PL-LAB:~/TA02/spos/lex2$ ./a.out < test.txt 
Number of lines are 		-> 3
Number of Space are 		-> 7
Number of Digits are 		-> 4
Number of char are 			-> 42
Number of Special char are 	-> 1
Number of words are 		-> 10
*/
