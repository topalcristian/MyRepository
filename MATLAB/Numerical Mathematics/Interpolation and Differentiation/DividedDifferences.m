function dividedDiffTable =  DividedDifferences(X,Y) 

% Note: the table begins with the y-values 

dividedDiffTable = zeros(length(X),length(X));

% inserting the y-values to the table
for i = 1 : length(X)
    dividedDiffTable(i, 1) = Y(i);
end

% i is the row and j is the coloumn
for j = 2 : length(X) 
    for i = 1 : length(X)-j+1
            % calculating the divided differences and insert them into the
            % table 
            dividedDiffTable(i,j) = (dividedDiffTable(i+1, j-1)-dividedDiffTable(i, j-1))/(X(i+j-1)-X(i));
       
    end
end 
end
