%% Algorithm for computing transfer function from state-space representation
% Inputs: state-space representation by specifying A, B, C, D
%    outputs: coefficients of the numerator polynomial b of transfer function,
%    the coefficients of the denominator polynomial a of transfer function
% and a cell array S containing S1 through Sn 
function [b,a,S] = fadeevFunction(A,B,C,D)

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
SList

end
