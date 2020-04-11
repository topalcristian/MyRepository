A = [0 0 2; 1 0 1; 0 1 3];
B = [1; 0; 0];
C = [0 0 1];
D = 2;

A2 = [8 24 0; 0.5 0 0; 0 2 0];
B2 = [0.25; 0; 0];
C2 = [0 0 1];
D2 = 1;

fadeevFunction(A, B, C, D)
fadeevFunction(A2, B2, C2, D2)

% number 1
a = [1 -0.25 -0.25 1/16 0]; %  0 because its a discrete time system
b = poly([(-0.25) (1/3) (-1/3)]);
[r, b, k] = residue(b, a);
r
b
k

% number 2
a = [1 -4/3 5/6 -1/6 0];
b = [1 1/3 -1/12];
[r, b, k] = residue(b, a);
r
b
k