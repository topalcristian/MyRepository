function n = inversePowerMethod()  
            A= [ 2, -1, 1; -1, 3, -2; 1, 2, 3];
            x = zeros(length(A), 1);
            x(1) = 1;
            u  = 1.5;
            n  = 100000000;   
            B=inv(A-u*eye(length(A)));
            accuracy = 0.00001;
       
            % runs until the computed eigenvalue is within
            % the given accuracy compared to the real eigenvalue
        while norm(A*x-n*x, inf)> accuracy
         % calulate y-vector
          y = B * x;
          p = inf;
          % calculate x-vecctor 
          x = y/norm(y, p);  
          % eigenvalue
          n = norm(A*x, inf);   
        end
        
   eigenvector  = x;
   fprintf("\n");
   eigenvector 
   fprintf("\n");

end 