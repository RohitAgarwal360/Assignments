%{
#include <stdio.h>
#include <stdlib.h>
FILE *yyin;
int yyerror(char *s);
%}
%token ID NUM SWITCH CASE DEFAULT BREAK LE GE EQ NE OR AND ELSE IF THEN GOTO RETURN
%right '='
%left AND OR
%left '<' '>' LE GE EQ NE
%left '+''-'
%left '*''/'
%right UMINUS
%left '!'

%%
statement:simple_statement {printf("Statement is Simple statement.\n");exit(0);}
         |compound_statement {printf("Statement is Compound statement.\n");exit(0);}
	 ;
simple_statement:goto_statement
		|return_statement
		;
goto_statement:GOTO ID
	      ;

return_statement:RETURN NUM ';'
		;

compound_statement:case_statement
		  |if_statement
         	  ;
case_statement:SWITCH'('ID')''{'B'}'
		  |SWITCH'('NUM')''{'B'}'

  	      ;

B:C
 |C D
 ;

C:C C
 |CASE NUM':'E';'
 |CASE ID':'E';'
 |BREAK ';'
 ;

D:DEFAULT':'E';'BREAK';'
 ;
  
if_statement:IF'('E2')' THEN ST1';'
	    |IF'('E2')' THEN ST1';' ELSE ST1';'
	    ;

ST1:if_statement
   |E
   ;

E:ID'='E
 |E'+'E
 |E'-'E
 |E'*'E
 |E'/'E
 |ID
 |NUM
 ;


E2:E'<'E
  |E'>'E
  |E LE E
  |E GE E
  |E EQ E
  |E NE E
  |E OR E
  |E AND E
  |ID
  |NUM
  ;
%%
/*main()
{
printf("Enter the exp: ");
*/
int main()
{

FILE *fp;
fp=fopen("input2","r");
yyin=fp;

yyparse();

return 0;
}
int yyerror(char *s)
{
fprintf(stderr,"%s\n",s);
}

