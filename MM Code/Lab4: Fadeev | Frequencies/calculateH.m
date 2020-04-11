function [output] = calculateH(a, b, s)
%CALCULATEH Summary of this function goes here
%   Detailed explanation goes here

H = (b(1)*s^3+b(2)*s^2+b(3)*s+b(4))/(a(1)*s^3+a(2)*s^2+a(3)*s+a(4));

output  = H;
end

