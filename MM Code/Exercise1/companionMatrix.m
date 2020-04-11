function C = companionMatrix(a)
    
C = [a(:)'; eye(length(a)-1) zeros(length(a)-1,1)];

end

