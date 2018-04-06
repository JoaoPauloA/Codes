import re

STATES = ['q0', 'q1', 'q2', 'q3', 'q4', 'q5', 'q6', 'q7', 'q8', 
		'q9', 'q10', 'q11', 'q12', 'q13', 'q14', 'q15', 'q16', 'q17',
		'q18', 'q19', 'q20', 'q21', 'q22', 'q23', 'q24', 'q25', 'q26',
		'q27', 'q28', 'q29', 'q30', 'q31', 'q32', 'q33', 'q34', 'q35', 
		'q36', 'q37', 'q38', 'q39', 'q40', 'q41']

FINALS = ['q3','q8','q39','q13', 'q16', 'q22', 'q28', 'q33']

TOKENS = ['IF', 'THEN', 'WRITE', 'ELSE', 'END', 'REPEAT', 'REPEAT', 'UNTIL', 'READ']

TRANSITIONS = [('q0',re.compile('$'),'q1'),('q0',re.compile('$'),'q4'),('q0',re.compile('$'),'q9'), ('q0',re.compile('$'),'q14'), ('q0',re.compile('$'),'q17'),
		('q0',re.compile('$'),'q23'), ('q0',re.compile('$'),'q29'), ('q0',re.compile('$'),'q34'),
		('q1',re.compile('i'),'q2'), ('q2',re.compile('f'),'q3'), 
		('q4',re.compile('t'),'q5'), ('q5',re.compile('h'),'q6'),('q6',re.compile('e'),'q7'),('q7',re.compile('n'),'q8'),
		('q9',re.compile('e'),'q10'), ('q10',re.compile('l'),'q11'),('q11',re.compile('s'),'q12'),('q12',re.compile('e'),'q13'),
		('q14',re.compile('e'),'q15'), ('q15',re.compile('n'),'q40'), ('q40',re.compile('d'),'q16'), 
		('q17',re.compile('r'),'q18'), ('q18',re.compile('e'),'q19'), ('q19',re.compile('p'),'q20'), ('q20',re.compile('e'),'q21'),('q21',re.compile('a'),'q41'), ('q41',re.compile('t'),'q22'),
		('q23',re.compile('u'),'q24'),('q24',re.compile('n'),'q25'),('q25',re.compile('t'),'q26'),('q26',re.compile('i'),'q27'),('q27',re.compile('l'),'q28'),
		('q29',re.compile('r'),'q30'), ('q30',re.compile('e'),'q31'), ('q31',re.compile('a'),'q32'),('q32',re.compile('d'),'q33'),
		('q34',re.compile('w'),'q35'),('q35',re.compile('r'),'q36'), ('q36',re.compile('i'),'q37'), ('q37',re.compile('t'),'38'), ('q38',re.compile('e'),'q39')]

SIGMA = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
		'r','s','t','u','v','w','x','y','z','A','B','C','D','E', 'F',
		'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
		'W','X','Y','Z','{','}','[',']','(',')',',',';','.','=','!','*','/',
		'+','-','>','<','\"','\'','0','1','2','3','4','5','6','7','8','9']

EMPTY = re.compile('$')

def edge(s, c):
    conj = set()
    for t in TRANSITIONS:
	if s == t[0] and t[1] == c :
	   conj.add(t[2])
    return conj

def closure(s):
    clo = set()
    for t in TRANSITIONS:
	if t[0] == s:
	    clo = clo.union(edge(t[0],EMPTY))
    return clo

def DFAedge(d, c):
    lp = set()
    se = closure(d)
    if len(se)== 0:
	return set([d])
    for s in se:
	ed = edge(s,c)
	for f in ed:
	    lp = lp.union(DFAedge(f,c))
    return lp

DFAstates = []
DFAtransitions = []

"""def NFA2DFA():
    DFAstates.append(0)
    DFAstates.append(closure('q0'))
    p = 1
    j = 0
    while j <= p:
        for c in SIGMA:
	    e = DFAedge(STATES[j], c)
	    for i in range(p):
	        if e == DFAstates[i]:
		     DFAtransitions
"""

#print closure('q0')
print edge('q1',re.compile('i'))
