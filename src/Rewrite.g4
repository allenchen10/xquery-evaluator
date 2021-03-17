grammar Rewrite;
xq
    : 'for' (var 'in' path ',')* var 'in' path 'where' cond 'return' ret;
var
    : '$' varName=ID;
path
    : ('doc' '(' fileName=STRING ')'|var) (sep ID)* sep (tagName=ID | 'text()');
sep
    : op=('/'|'//');
ret
    : var
    | ret ',' ret
    | '<' tagName=ID '>' '{' ret '}' '</' tagName=ID '>'
    | path;
cond
    : (var|constant=STRING) ('eq'|'=') (var|constant=STRING)
    | cond 'and' cond;
ID: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip ;
