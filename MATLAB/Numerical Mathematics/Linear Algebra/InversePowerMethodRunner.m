%  Graded Assignment 5
%  Inverse Power Method

A =  [4.8, 0.8, 0, 0; 0.8, 3.7, 0.9, 0; 0, 0.9, 2.0, -0.2; 0, 0, -0.2, 1.5];
lengthOfMatrix = length(A);

for i = 1 : lengthOfMatrix
    % estimates eigenvalue - diagonals of the matrix A 
    u = A(i,i);
     
    % elementary vector 
    x = zeros(lengthOfMatrix, 1);
    x(i) = 1;
    
    eigenvalue = inversePowerMethod(A, x, u);
    fprintf("The eigenvalue is:  %1.06f", eigenvalue);
    fprintf("\n");
end