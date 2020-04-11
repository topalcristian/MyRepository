
% given a linear system and a sampling interval
T=0.05; % sampling interval 
A=[1 -4;3 -2]; % System matrix 
B=[0;1]; % input matrix
C=[1 2]; % output matrix
D=0; % direct feedthrough

% sampled input signal
t=0:T:5-T; %create time vector 
u=linspace(-1,1,length(t))+sin(3*t); % sampled time series

% exercise 1.1

% continuous time system
sysc = ss(A,B,C,D);


% discrete time system
sysd2 = c2d(sysc, T)

% creating M matrix 
[m, n] = size(A)
zeros(1,m)
M = [A B;zeros(1,m) 0]

tempMatrix = expm(M*T)
phi = expm(A*T)
%phi2 = tempMatrix(1:m, 1:m)
gamma = tempMatrix(1:m, m+1)

% creating a discrete state space model
sysd = ss(phi, gamma, C, D, T)


% exercise 1.2
% continuous
[yC,tC,xC] = lsim(sysc, u, t, 'zoh');



% exercise 1.3
%discrete
[yD,tD,xD] = lsim(sysd, u, t, 'zoh');

% exercise 1.4a
% outputs
plot(yC, '-b', 'DisplayName', 'Continuous')
hold on 
plot(yD, '--r', 'DisplayName', 'Discrete')
legend;
hold off

% exercise 1.4b
% state trajectory 
figure;
plot(xC(:,1), '-b', 'DisplayName', 'Continuous1') % first column continuous
hold on 
plot(xC(:,2), '-m', 'DisplayName', 'Continuous2') % second column continuous
plot(xD(:,1), '--r', 'DisplayName', 'Discrete1') % first column discrete
plot(xD(:,2), '--k', 'DisplayName', 'Discrete2') % second column discrete
legend;
hold off


% exercise 2

A = [1, 0, 3; 0, 0, 2; 6, 4, 5];
b = [0; 5; -1];
c = [1, 0, -1];
d = 0;

cp = poly(A) % characteristic polynomial
Wc = [b A*b A^2*b] % controllability matrix
inverseWc = [1 cp(2) cp(3); 0 1 cp(2); 0 0 1] % inverse 
T = inv(Wc*inverseWc) % calculate  T
Aline = T*A*inv(T)
bline = T*b
Lline = [-cp(2), -cp(3), -cp(4)]
L= Lline*T
matrixOutcome = A - b*L
eig(matrixOutcome) % they are almost at 0, which means the pole placement is solved









