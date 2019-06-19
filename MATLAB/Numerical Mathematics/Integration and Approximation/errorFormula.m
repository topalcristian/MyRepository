function error =  errorFormula(func, sk)
    
   % creating a new function for computing the integral  
   f = @(x) (func(x)-sk(x)).^2;
   error = integral(f, -pi, pi); 
   fprintf("The error %1.10f ", error);
   fprintf("\n");
end 
    