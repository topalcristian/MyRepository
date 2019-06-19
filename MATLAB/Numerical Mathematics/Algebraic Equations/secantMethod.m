function p2 = secantMethod(p1,p2)

% given tolerance
tolerance = 1e-6;
% given function 
func = @(x) x*exp(x)-5*x^2+1;

% secant method -> if |p2-p1| is greater than the given tolerance, then
% enter the while loop 
while abs(p2-p1)>tolerance
   % x to store the value of p2, since it will become the new p1, and
   % update p2
    x = p2;
    p2 = p2 - ((p2-p1)/(func(p2)-func(p1)))*func(p2);   
    p1 = x;
end

fprintf("\n f has root %1.25f ", p2);
fprintf("\n");
end

