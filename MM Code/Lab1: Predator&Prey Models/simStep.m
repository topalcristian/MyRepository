function [x, y] = simStep(x, y, e1, a1, e2, a2, dt)

if(nargin<7)
    dt=1;
end
dx=(e1*x-a1*x*y)*dt; 
dy=(-e2*y+a2*x*y)*dt; 

x=x+dx;
y=y+dy;

end

