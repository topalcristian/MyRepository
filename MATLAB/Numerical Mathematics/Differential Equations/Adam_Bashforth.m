function Adam_Bashforth(h)

format long


% given function
func = @(t,y) cos(t)+y-y^3;

% initializing t and wNULL; current counts each step until t
t = 6;
current = 0;
wNULL= 2;

% Kutta thrid order method to calculate wONE and wTWO

%wNULL 
 k_ONE = h*func(current,wNULL);
 k_TWO = h*func(current + 1/2*h,wNULL+1/2*k_ONE);
 k_THREE = h*func(current + h, wNULL-k_TWO+2*k_ONE);
    
 wONE = wNULL+ 1/6*(k_ONE+ 4*k_TWO+k_THREE);  
 % we have to increase current after each calculated w 
 current = current + h;
 
% wTwo
 k_ONE = h*func(current,wONE);
 k_TWO = h*func(current + 1/2*h,wONE+1/2*k_ONE);
 k_THREE = h*func(current + h, wONE-k_TWO+2*k_ONE);
    
 wTWO = wONE + 1/6*(k_ONE + 4*k_TWO+k_THREE);
 current = current + h;

 

% thrid stage Adams Bashforth method 
while(current < t-h)   
   % calculating the following w's and increasing current 
   nextW = wTWO + 1/12*h*(23*func(current,wTWO)-16*func(current-h,wONE)+5*func(current-h*2,wNULL));
   current = current + h;
   
   % updating wNULL, wONE, wTWO
   wNULL = wONE;
   wONE = wTWO;  
   wTWO = nextW;
   
end

% exact value 
exact = -0.4845092473;

% absolut error 
absolutError = abs(exact- nextW);
fprintf("\n Calculated w:  %1.10f", nextW);
fprintf("\n The absolut error is %1.10f", absolutError);
fprintf("\n");
end 

