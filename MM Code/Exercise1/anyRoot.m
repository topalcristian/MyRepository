function [y,ord]=anyRoot(x,ord)

% if only one argument is supplied then assume the square root
if(nargin==1)
    ord=2;
    %this statement defines ord in case it was not provided as a parameter
end

y=x.^(1/ord);