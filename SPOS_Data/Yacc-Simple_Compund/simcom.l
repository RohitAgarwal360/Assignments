%{
//declaration block 
#include"y.tab.h"
%}

/*global variables*/
alpha [A-Za-z]
digit [0-9]



%%
	//code block  | transition rules

[ \t\n]
return return RETURN;
goto return GOTO;  
if    return IF;
then    return THEN;
else    return ELSE;
switch    return SWITCH;
case return CASE;
break return BREAK;
default return DEFAULT;
{digit}+    return NUM;
{alpha}({alpha}|{digit})*    return ID;
"<="    return LE;
">="    return GE;
"=="    return EQ;
"!="    return NE;
"||"    return OR;
"&&"    return AND;
"--"	return UMINUS;
.    return yytext[0];
%%
int yywrap()
{
return 1;
}
