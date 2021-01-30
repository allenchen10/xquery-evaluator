grammar XPath;
ap
    : 'doc(' fileName=STRING ')' op=('/'|'//') rp;
rp
    : tagName=TAGNAME
	| op=('*'|'.'|'..'|'text()')
	| op='@' attName=ATTRIBNAME
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
TAGNAME: [a-zA-Z_]+;
ATTRIBNAME: [a-zA-Z0-9_]+;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip ;
