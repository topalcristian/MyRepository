% calculating the coefficients of A and B
function [arr1, arr2] = coefficientsCalc(k, func)

    b = pi;
    a = -pi;
    % first value of the array that stores the coefficients of A  
    a0 = 1/b * integral(func, a, b);
    arr1(1) = a0;
    % calculate the coefficients 
    for i = 1 : k
        
        coeffA = 1/b * integral(@(x)func(x).*cos(i*x), a, b);
        coeffB = 1/b * integral(@(x)func(x).*sin(i*x), a, b);
        % and storing them in the two arrays - arr1 stores the coeffiencts
        % of A and the arr2 of B 
        arr1(i+1) = coeffA; 
        arr2(i) = coeffB;         
    end 
end         