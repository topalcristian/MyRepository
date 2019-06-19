function secant()
%first root in the interval [-1,0]
root1a = -1;
root1b = 0;

%second root in the interval [0,1]
root2a = 0;
root2b = 1;

%third root in the interval [2,3]
root3a = 2;
root3b = 3;

%call secantMethod for each root
secantMethod(root1a, root1b);
secantMethod(root2a, root2b);
secantMethod(root3a, root3b);


fprintf("The first root has the interval [-1,0], the second has the interval [0,1], and the third root has the interval [2,3]")
fprintf("\n")
end

