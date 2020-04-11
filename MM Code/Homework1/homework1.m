
%% This is the solution to the bonus assignment 1 of MM 2019/2020
%% Question 1

% load the data 
load data1_1
% Define constants 
k=20;
d=30;
m1=10;
m2=8;
% Define the system
A = [0 0 1 0; 0 0 0 1; -k/m1 k/m1 -d/m1 d/m1; k/m2 -k/m2 d/m2 -d/m2]; % system matrix
B = [0;0;1/m1;0];    % input vector 
C = [0 1 0 0];      % output vector
D = 0;      % direct feed-through

sys1 = ss(A,B,C,D);
lsim(sys1, u, t) % produces the plot of time response to the input u, t
legend('input')


%% Question 2

% define the transfer function
% H = (s^3+2*s^2+3*s+4)/(s^3+6*s^2+11*s+6);

% coefficients of the polynomials b and a 
b =[1 2 3 4];
a =[1 6 11 6];

[r, b, k] = residue(b, a);

% outputs

% residues r
r
% poles b
b
% polynomial k 
k

%The partial fraction expansion found is:
%                -7        2       1
% H(s)= 1 + ---------- + ----- + ----- 
%               s+3       s+2     s+1



