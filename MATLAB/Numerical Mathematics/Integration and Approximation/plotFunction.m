% plotting the function into a graph
function plotFunction(arr1, arr2)
    
    a = -pi;
    b = pi;
    p = 1;    
    for x = a: 0.05 : b
        
        X(p) = x;
        Y(p) = fourierCalc(arr1, arr2, x);
        p = p + 1;        
    end 
    figure();
    plot(X,Y);
end