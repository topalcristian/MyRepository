t = 0.1;
e1 = 0.04;
a1 = 0.0005;
e2 = 0.3;
a2 = 0.001;
x = 50;
y = 5;

timestep  = 1000;
counter = 1;

while counter < timestep
    [x, y] = simStep(x, y, e1, a1, e2, a2, t);
    X(counter) = x;
    Y(counter) = y;
    counter = counter + 1;    
end
figure();
plot(X, Y)
