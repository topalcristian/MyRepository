import numpy as np
import sigmoid as s
import sigmoidGradient as sg


def nnCostFunction(nn_params, input_layer_size, hidden_layer_size, \
                   num_labels, X, y, lambda_val):
    # NNCOSTFUNCTION Implements the neural network cost function for a two layer
    # neural network which performs classification
    #   [J grad] = NNCOSTFUNCTON(nn_params, hidden_layer_size, num_labels, ...
    #   X, y, lambda) computes the cost and gradient of the neural network. The
    #   parameters for the neural network are "unrolled" into the vector
    #   nn_params and need to be converted back into the weight matrices.
    #
    #   The returned parameter grad should be a "unrolled" vector of the
    #   partial derivatives of the neural network.

    # Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
    # for our 2 layer neural network
    Theta1 = np.reshape(nn_params[:hidden_layer_size * (input_layer_size + 1)], \
                        (hidden_layer_size, input_layer_size + 1), order='F')

    Theta2 = np.reshape(nn_params[hidden_layer_size * (input_layer_size + 1):], \
                        (num_labels, hidden_layer_size + 1), order='F')

    # Setup some useful variables
    m = len(X)

    # # You need to return the following variables correctly
    J = 0;
    Theta1_grad = np.zeros(Theta1.shape)
    Theta2_grad = np.zeros(Theta2.shape)

    # ====================== YOUR CODE HERE ======================
    #         Implement the backpropagation algorithm to compute the gradients
    #         Theta1_grad and Theta2_grad. You should return the partial derivatives of
    #         the cost function with respect to Theta1 and Theta2 in Theta1_grad and
    #         Theta2_grad, respectively. After implementing Part 2, you can check
    #         that your implementation is correct by running checkNNGradients
    #
    #         Note: The vector y passed into the function is a vector of labels
    #               containing values from 1..K. You need to map this vector into a
    #               binary vector of 1's and 0's to be used with the neural network
    #               cost function.
    #
    #         Hint: We recommend implementing backpropagation using a for-loop
    #               over the training examples if you are implementing it for the
    #               first time.

    # the algorithm is described in our given assignment pdf

    # one bias column form input to second layer (only ones)
    # X is a1
    X = np.column_stack((np.ones((m, 1)), X))

    # hidden layer + adding bias column
    a2 = s.sigmoid(np.dot(X, Theta1.T))
    a2 = np.column_stack((np.ones((a2.shape[0], 1)), a2))

    # outer layer
    a3 = s.sigmoid(np.dot(a2, Theta2.T))

    # calculating the cost function (non-regularized)
    # only values 0 or 1
    cost = 0
    y_ = y
    # setting y to a matrix with m (as the number of inputs) and num_labels
    y = np.zeros((m, num_labels))
    # for every label, convert it into vector of 0s and a 1 in the appropriate position
    for i in range(m):
        y[i, y_[i] - 1] = 1

    # calculate cost by summing 
    for i in range(m):
        cost += np.sum(y[i] * np.log(a3[i]) + (1 - y[i]) * np.log(1 - a3[i]))

    J = -(1.0 / m) * cost

    # note first column are bias units - this is why we start from the second column
    sumOfTheta1 = np.sum(np.sum(Theta1[:, 1:] ** 2))
    sumOfTheta2 = np.sum(np.sum(Theta2[:, 1:] ** 2))

    J = J + ((lambda_val / (2.0 * m)) * (sumOfTheta1 + sumOfTheta2))

    # foward propagation step
    # iterate over training examples
    for t in range(m):

        x = X[t]

        # hidden layer
        # z2 = Theta1 * a1, sigmoid(z)
        # returns vector
        a2 = s.sigmoid(np.dot(x, Theta1.T))

        # append bias values - to third layer
        a2 = np.append([1], a2)

        # outer layer
        # z3 = Theta2 * a2, sigmoid(z)
        # returns vector
        a3 = s.sigmoid(np.dot(a2, Theta2.T))

        # create delta with only zeros
        delta3 = np.zeros((num_labels))

        # num_labels is 10, used to compute delta3
        # number of hypotheses
        # indicates wheather the current training example belongs to class k
        # (y[t, k] = 1), or if it belongs to a different class (y[t, k] = 0)
        for k in range(num_labels):

            delta3[k] = a3[k] - y[t, k]

        # computing delta2, with all of the THETA2 values times DELTA3 * the SIGMUNDGRADIENT values
        delta2 = (np.dot(Theta2[:, 1:].T, delta3).T) * sg.sigmoidGradient(np.dot(x, Theta1.T))

        Theta1_grad += np.outer(delta2, x)
        Theta2_grad += np.outer(delta3, a2)

    ## UNREGULARIZED

    # devide accumalted gradients by 1/m
    Theta1_grad = Theta1_grad / m
    Theta2_grad = Theta2_grad / m

    ## REGULARIZATION

    # just temporary variable
    tmp1 = np.copy(Theta1_grad)
    tmp2 = np.copy(Theta2_grad)

    # regularize using lambda
    Theta1_grad += (float(lambda_val) / m) * Theta1
    Theta2_grad += (float(lambda_val) / m) * Theta2

    Theta1_grad[:, 0] = tmp1[:, 0]
    Theta2_grad[:, 0] = tmp2[:, 0]


    # # =========================================================================

    # Unroll gradients
    Theta1_grad = np.reshape(Theta1_grad, Theta1_grad.size, order='F')
    Theta2_grad = np.reshape(Theta2_grad, Theta2_grad.size, order='F')
    grad = np.expand_dims(np.hstack((Theta1_grad, Theta2_grad)), axis=1)

    return J, grad
