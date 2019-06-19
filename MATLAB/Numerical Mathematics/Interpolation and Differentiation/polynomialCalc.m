% calculating coefficients of the resulting polynomials 
% the x is just a random value of X to check if the answer is correct
function polynomial = polynomialCalc(X,Y,x)

dividedDiffTable=DividedDifferences(X,Y);
% first row of the table -> coefficients 
coefficients = dividedDiffTable(1,:);
polynomial = coefficients(length(coefficients));
% formula for the polynomial
for i = length(X)-1:-1:1
    polynomial = polynomial*(x-X(i))+coefficients(i);     
end 
end 