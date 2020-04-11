%% Bonus 2 MM 2019/2020
%  I have been using
%  MatLab <== Select what you used


%% Define the model
% Add as needed
% Note that this should work generically and we can plug in a different
% discrete-time system to test matters
A=[0,-0.6400;1,0];
B=[0.5;0];
C=[0,0.72];
D=1;
fs=100; % sampling frequency

%% Task 1: Find the transfer function
% implement the Fadeev algorithm
% ==> your code here

n = size(A);
counter = 1;
S = eye(n);

while counter ~= n+1
    c = C*S*B;
    bList(counter) = c; % b coefficients
    a = -(trace(S*A)/counter);
    aList(counter) = a; % a coefficients
    S = S*A + a*eye(n);  
    SList{counter} = S; % holds list of matrices
    counter = counter + 1;
end 

a = [1 aList];
b = [0 bList] + D*a;

a % denominator polynomial
b % numerator polynomial

%          s^2 + 1
%  H(s) = ------------
%          s^2 + 0.64         

%% Task 2: Find the poles and zeros without using toolboxes
% Code for finding poles and zeros here
% ==> your code here   -> just residue???

[z, p, k] = residue(a,b);

p % poles
z % zeros

% Make a pole-zero plot
figure(1);
% plot unit circle
tmpw=linspace(0,2*pi);
tmpx=real(exp(tmpw*1i));
tmpy=imag(exp(tmpw*1i));
plot(tmpx,tmpy,'k--');
% plot real axis
hold on
plot(linspace(-1.1,1.1,100),zeros(1,100),'k:');
% plot imaginary axis
plot(zeros(1,100),linspace(-1.1,1.1,100),'k:');
% plot poles with an x
% plot zeros with an o
zplane(z,p)
xlabel('real axis')
ylabel('imaginary axis')
axis square
title('Pole-zero plot')


%% Task 3: Compute and plot frequency response
% frequencies from 0 to 50 Hz for which we wish to compute the frequency
% response
w=linspace(0,50,1000); 
% Compute frequency response for each of those frequencies
% ==> your code here
H = freqz(b, a, w);  % Frequency response

% plot the frequency response phase and magnitude with proper axis
figure(2);
plot(w,abs(H),w,angle(H));
legend({'Magnitude response','Phase response'});
xlabel('frequency (Hz)');
title('Frequency response')

%% Task 4: Discover what happens to an actual signal
% create signal
t=0:1/fs:5; % create time vector
s=randn(size(t)); % create WGN as background
s=s+2*sin(2*pi*25*t); % add 25Hz component
s=s+cos(2*pi*37*t); % add 37Hz component

% Simulate the effect of the model on the signal
% Here you are allowed to use ss and lsim from the control systems toolbox
% The simulated output should be y
% ==> your code here

system = ss(A, B, C, D);
y = lsim(system, s, t);

% plot the Fourier spectrum of input and output
hold on
figure(3);
plot(fs*(0:length(t)-1)/(length(t)-2),abs(fft(s)),fs*(0:length(t)-1)/(length(t)-2),abs(fft(y)));
title('Magnitude spectrum');
legend({'input','output'});
axis tight
xlabel('frequency (Hz)')

% Relate what you are seeing here with the frequency response and the
% pole-zero plot and explain what you are seeing. 

% ==> your explanation in comments here
% In general we can say, that the Fourier Transform tells us where the
% impulse response is on the imaginary axis