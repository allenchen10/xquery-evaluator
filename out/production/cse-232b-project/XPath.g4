grammar XPath;
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
