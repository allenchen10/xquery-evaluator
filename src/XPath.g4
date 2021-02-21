grammar XPath;
xq
    : var
    | text=STRING
    | ap
    | op='(' xq ')'
    | xq op=',' xq
    | xq op=('/'|'//') rp
    | op='<' tagName=ID '>' '{' xq '}' '</' tagName=ID '>'
    | forClause letClause? whereClause? returnClause
    | letClause xq;
var
    : '$' varName=ID;
forClause
    : 'for' (var 'in' xq ',')* var 'in' xq;
letClause
    : 'let';
whereClause
    : 'where' cond;
returnClause
    : 'return' xq;
cond
    : xq op=('='|'eq'|'=='|'is') xq
    | 'empty(' xq ')'
    | 'some' (var 'in' xq ',')* var 'in' xq 'satisfies' cond
    | '(' cond ')'
    | cond op=('and'|'or') cond
    | 'not' cond;
ap
    : 'doc(' fileName=STRING ')' op=('/'|'//') rp;
rp
    : tagName=ID
	| op=('*'|'.'|'..'|'text()')
	| op='@' attName=ID
	| op='(' rp ')'
	| rp op=('/'|'//'|',') rp
	| rp op='[' f ']';
f
    : rp
	| rp op=('='|'eq'|'=='|'is') rp
	| rp op='=' STRING
	| op='(' f ')'
	| f op=('and'|'or') f
	| op='not' f;
ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip ;
