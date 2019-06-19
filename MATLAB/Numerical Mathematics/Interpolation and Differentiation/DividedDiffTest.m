X=[2.5,2.0,3.0,1.5,3.5,1.0,4.0,0.5,4.5,0.0,5.0];
Y=[0.69,0.86,0.54,1.02,0.43,1.19,0.47,1.35,0.79,1.50,1.27];
YwithNoise=[0.65,0.91,0.57,1.03,0.42,1.17,0.44,1.36,0.80,1.52,1.29];

% just some x value to check my answer 
x = 2.5;
% without noise 
fprintf("\n Divided differences table for Y: "); 
DividedDifferences(X,Y)
fprintf("\n The y value for x  = 2.5 is: %1.10f", polynomialCalc(X,Y,x));
fprintf("\n");

% with noise 
fprintf("\n Divided differences table for Y with Noise: "); 
DividedDifferences(X,YwithNoise)
fprintf("\n The y value with the noise for x  = 2.5 is: %1.10f", polynomialCalc(X,YwithNoise,x));
fprintf("\n");

% Polynomial without noise
p = 1;
for i = -0.1:0.05: 5.1
    y(p)=polynomialCalc(X, Y, i);
    x(p)=i;
    p=p+1;
end
figure("Name","Polynomial Uno");
plot(x,y);

% polynomial with noise 
q = 1;
for i = -0.1:0.05: 5.1
    r(q)=polynomialCalc(X, YwithNoise, i);
    s(q)=i;
    q=q+1;
end
figure("Name","Polynomial Duo");
plot(s,r);





