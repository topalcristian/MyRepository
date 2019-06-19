% testing method 

% given function
func = @(x) sin(3*x)./(2+cos(x)+sin(2*x));
% coefficients of A and B for k = 1,...,6
for k=1 : 6
[coefficientsA, coefficientsB] =  coefficientsCalc(k, func);
sk = functionCalc(coefficientsA, coefficientsB);
    % plot function for k = 1,2,3
    if k < 4 
        plotFunction(coefficientsA, coefficientsB);
    end 
% calculating the error 
error = errorFormula(func, sk);
end 