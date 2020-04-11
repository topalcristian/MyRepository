% exercises from the tutorial
A = [1 5 3 10 3; 5 3 9 1 12; 19 8 0.5 3 8; 4 4 6 2 6; 8 2 3 2 10]
b = [4; 6; 3; 8; 1]
c = [10 20 50]

D1 = A*b
D2 = b'*A
D3 = A^2
D4 = eye(5)*A

A(1, 4) = 11;
A(5, 2) = 3;
A(3, 3) = 5

c = [5 c 100]

c.*b' % value in each banknote
c*b % total sum

x = -10:0.2:10

y = 5*sin(2*x).*exp((-x.^2)/10)
plot(x,y, 'r*')
whos
clearvars -except x y
whos




% from the tutorial
x = linspace(0,10)
z = cubicRoot(x);
whos

[y, order] = anyRoot(x, 4)
whos
order
%plot(x,y)

[y2,order]=anyRoot(x);
whos
order
plot(x,y, x,y2);


% exercises again: 

C = companionMatrix(rand(5,1))







