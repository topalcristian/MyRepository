# Assignment: Linear Regression
# In this assignment you will implement Linear Regression for a very simple
# test case. Please fill into the marked places of the code
#   (1) the cost function
#   (2) the update function for Gradient Descent
#
#   Things that need to be updated are marked with "HERE YOU ..."
#
# This assignment is kept very simple on purpose to help you familiarize
# with Matlab and Linear Regression. Feel free to make some useful tests.
# E.g. What happens if the learning rate is too high or too low?
#      Can Linear Regression really find the absolute global minimum?
#      What effect does it have if you change the initial guess for the
#      gradient descent to something completely off?
#      What happens if you are not updating thet0 and thet1
#      "simultaneously" but you are updating both parameters in separate
#      for loops (see below)?
#      You can try to turn this code for Linear Regression into an
#      implementation of Logistic Regression

import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D


def gradient_descent(x, y, theta, alpha, m, maxsteps):
    theta_hist = np.empty([maxsteps, 2])
    theta_hist[0] = theta  # new
    xTrans = x.transpose()
    for s in range(1, maxsteps):
        total0 = 0
        total1 = 0
        for t in range(1, m):
            total0 += (theta[0] + theta[1]*x[t,1] - y[t])
            total1 += (theta[0] + theta[1]*x[t,1] - y[t]) * x[t,1]
        derivative0 = total0 / m
        derivative1 = total1 / m
        theta_0 = theta[0] - alpha * derivative0
        theta_1 = theta[1] - alpha * derivative1
        theta = [theta_0, theta_1]
        theta_hist[s] = theta

    return theta, theta_hist


# Define some training data
# To test your algorithm it is a good idea to start with very simple test data
# where you know the right answer. So let's put all data points on a line
# first. Feel free to play this test data.
x = np.array([[1, 0], [1, 0.5], [1, 1], [1, 1.5], [1, 2], [1, 2.5], [1, 3], [1, 4], [1, 5]])
y = np.array([0, 0.5, 1, 1.5, 2, 2.5, 3, 4, 5])

# Calculate length of training set
m, n = np.shape(x)

# Plot training set
fig = plt.figure(1)  # An empty figure with no axes
plt.plot(x[:, 1], y, 'x')

# Also it is useful for simple test cases to not just run an optimization
# but first to do a systematic search. So let us first calculate the values
# of the cost function for different parameters theta
theta0 = np.arange(-2, 2.01, 0.25)
theta1 = np.arange(-2, 3.01, 0.25)
J = np.empty([len(theta0), len(theta1)])
# Calculate values of the cost function
for i in range(0, len(theta0)):
    for j in range(0, len(theta1)):
        total = 0
        for k in range(1, m):
            total += (theta0[i] + theta1[j]*x[k,1] - y[k]) ** 2
        cost = 0.5*m*total
        J[i,j] = cost

# Let us do some test plots to see the cost function J and to analyze how
# it depends on the parameters theta0 and theta1
theta0, theta1 = np.meshgrid(theta0, theta1)
fig2 = plt.figure(2)
ax = fig2.add_subplot(121, projection="3d")
surf = ax.plot_surface(theta0, theta1, np.transpose(J))
ax.set_xlabel('theta 0')
ax.set_ylabel('theta 1')
ax.set_zlabel('Cost J')
ax.set_title('Cost function Surface plot')

ax = fig2.add_subplot(122)
contour = ax.contour(theta0, theta1, np.transpose(J))
ax.set_xlabel('theta 0')
ax.set_ylabel('theta 1')
ax.set_title('Cost function Contour plot')

fig2.subplots_adjust(bottom=0.1, right=1.5, top=0.9)

# Here we implement Gradient Descent
alpha = 0.05  # learning parameter
maxsteps = 1000  # number of iterations that the algorithm is running

# First estimates for our parameters
thet = [2, 0]

# HERE (FUNCTION gradientDescent) YOU HAVE TO IMPLEMENT THE UPDATE OF THE PARAMETERS
thet, thetaHist = gradient_descent(x, y, thet, alpha, m, maxsteps)

# Print found optimal values
print("Optimized Theta0 is ", thet[0])
print("Optimized Theta1 is ", thet[1])

# Now let's plot the found solutions of the Gradient Descent algorithms on
# the contour plot of our cost function to see how it approaches the
# desired minimum.
fig3 = plt.figure(3)
print("Transpose matrix: ", np.transpose(J))
plt.contour(theta0, theta1, np.transpose(J))
plt.plot(thetaHist[:, 0], thetaHist[:, 1], 'x')
ax.set_xlabel('theta 0')
ax.set_ylabel('theta 1')

# Finally, let's plot the hypothesis function into our data
xs = np.array([x[0, 1], x[x.shape[0] - 1, 1]])
h = np.array([[thet[1] * xs[0] + thet[0]], [thet[1] * xs[1] + thet[0]]])
plt.figure(1)
plt.plot(xs, h, '-o')
plt.show()
