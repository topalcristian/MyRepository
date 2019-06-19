function KuttasMethod()

format long

% given function
func = @(t,y) cos(t)+y-y^3;

% given h, t and wNULL
h= 0.1;
t = 0.5;
current = 0;
wNULL= 2;

% while loop, which calculates the w's until we reached the step size 6 
while(current < t-h)
 
 k_ONE = h*func(current,wNULL);
 k_TWO = h*func(current + 1/2*h,wNULL+1/2*k_ONE);
 k_THREE = h*func(current + h, wNULL-k_TWO+2*k_ONE);
    
 wONE = wNULL+ 1/6*(k_ONE+ 4*k_TWO+k_THREE);  
 % we have to increase current after each calculated w 
 current = current + h;
 %  update wNULL
 wNULL = wONE;
 
end
% exact value 
exact = -0.4845092473;
fprintf("Result: %1.10f",wNULL);
% absolute error
absolutError = abs(exact- wNULL);
fprintf("\n The absolut error is %1.10f", absolutError);
fprintf("\n");
end

