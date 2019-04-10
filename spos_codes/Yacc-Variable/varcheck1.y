%{
#include<stdio.h>
#include<stdlib.h>
%}

%token ID BUILTIN SC NL COMMA

%%
start:BUILTIN varlist SC NL {printf("valid");exit(0);}

varlist:ID COMMA ID|ID|ID COMMA ID COMMA ID;
%%

int yyerror(char *str)
{
printf("error");
return 1;
}

int yywrap()
{return 1;}

main()
{
yyparse();
}
