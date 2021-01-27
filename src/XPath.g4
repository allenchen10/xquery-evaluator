grammar XPath;
ap
    : 'doc(' fileName=STRING ')' op=('/'|'//') rp;
rp
    : tagName=ID
	| op='*'
	| op='.'
	| op='..'
	| op='text()'
	| op='@' attName=ID
	| op='(' rp ')'
	| rp op=('/'|'//') rp
	| rp op='[' f ']'
	| rp op=',' rp;
f
    : rp
	| rp op='=' rp
	| rp op='eq' rp
	| rp op='==' rp
	| rp op='is' rp
	| rp op='=' STRING
	| op='(' f ')'
	| f op='and' f
	| f op='or' f
	| op='not' f;
ID: [a-zA-Z]+;
STRING: '"' .*? '"';
WS : [ \t\r\n]+ -> skip ;
