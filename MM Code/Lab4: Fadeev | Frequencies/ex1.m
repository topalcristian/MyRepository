% define the model
% 1 a)

A  = [4 1 0; -7 -1 -1; 119 32 -8];
B = [0; 0; -1];
C = [227 55 -13];
D = -2;

system1 = ss(A,B,C,D);

n = size(A);
counter = 1;
S = eye(n);

while counter ~= n+1
    c = C*S*B;
    bList(counter) = c;
    a = -(trace(S*A)/counter);
    aList(counter) = a;
    S = S*A + a*eye(n);  
    SList{counter} = S; 
    counter = counter + 1;

end 
a = [1 aList]
b = [0 bList] + D*a


%       -2s^3 + 3s^2 -6s + 16
% H(s) = --------------------- 
%        s^3+5s^2´ + 11s + 15    

% 1b)

stable = isstable(system1)
[r, poles, k] = residue(b, a);
poles

% 1c)

x = 0;
t = 0:0.01:5;
u = sin(4*t);
lsim(system1, u, t)


% 1d)

s = 4*i;
H = calculateH(a, b, s)

K = abs(H)
phi = angle(H)

% 2a)

fs=100; % sampling frequency
t=0:1/fs:5; % time vector
s1=randn(size(t)) + sin(2*pi*15*t); %signal
S1=fft(s1); % Fourier transform
omega=linspace(0,fs,length(t)+1);omega(end)=[]; % generate vector of frequencies 
figure;plot(omega,abs(S1)); % plot Fourier magnitude spectrum

% 2b)

p = [0 2*pi*50];
q = [1  2*pi*50];

[z, pole, k] = residue(p, q);

[A, B, C, D] = tf2ss(p,q)
lpf = ss(A,B,C,D)
linearSystemAnalyzer(lpf)


