function sk = fourierCalc(arr1, arr2, x)

    sk = arr1(1)/2;
    for i = 1 : length(arr2) 
               
           sk = sk + arr1(i+1) * cos(i*x) + arr2(i) * sin(i*x);
          
    end 
end 