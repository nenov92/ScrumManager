grammar Norm;

prog: (norm NEWLINE*)*;

norm: obligation
	| prohibition
	;
	
obligation: 'norm' LPAREN INTEGER ',' 'obligation' ',' ROLE ',' NAME ',' activationCondition ',' expirationCondition ',' fulfilledCondition ',' notFulfilledCondition RPAREN;

prohibition: 'norm' LPAREN INTEGER ',' 'prohibition' ',' ROLE ',' NAME ',' activationCondition ',' expirationCondition RPAREN;

activationCondition: tuple (LOGICAL_OPERATOR tuple)*;

expirationCondition: tuple (LOGICAL_OPERATOR tuple)*;

fulfilledCondition: tuple (LOGICAL_OPERATOR tuple)*;

notFulfilledCondition: tuple (LOGICAL_OPERATOR tuple)*;

tuple: NAME comparator value;

bool: 'true' | 'false';

comparator: '==' | '!=' | '>'| '<'| '>='| '<=';

value: bool | INTEGER;

LPAREN: '(';
RPAREN: ')';
INTEGER: [0-9]+;
ROLE: 'PRODUCT_OWNER'
	| 'SCRUM_MASTER'
	| 'DEV_TEAM'
	;
NAME: [a-zA-Z]+;
LOGICAL_OPERATOR: '&&' | '||';
NEWLINE: '\r' ? '\n';
WS: [ \t]+ -> skip;