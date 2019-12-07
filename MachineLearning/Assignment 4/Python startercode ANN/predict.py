import numpy as np
import sigmoid as s


def predict(Theta1, Theta2, X):
    # PREDICT Predict the label of an input given a trained neural network
    #   p = PREDICT(Theta1, Theta2, X) outputs the predicted label of X given the
    #   trained weights of a neural network (Theta1, Theta2)

    # Useful values
    m = np.shape(X)[0]  # number of examples

    # You need to return the following variables correctly
    p = np.zeros(m);

    # ====================== YOUR CODE HERE ======================
    # Instructions: Complete the following code to make predictions using
    #               your learned neural network. You should set p to a
    #               vector containing labels between 1 to num_labels.

    # Hint: The max function might come in useful. In particular, the max
    #       function can also return the index of the max element, for more
    #       information see 'help max'. If your examples are in rows, then, you
    #       can use max(A, [], 2) to obtain the max for each row.
    #

    # add bias column
    # from first layer into the second
    # X = a1
    # input layer
    X = np.column_stack((np.ones((m, 1)), X))

    # calculate second layer
    # sigmoid(z), z2 = Theta1 * a1
    a2 = s.sigmoid(np.dot(X, Theta1.T))

    # add bias column
    # from second into third layer
    a2 = np.column_stack((np.ones((a2.shape[0], 1)), a2))

    # calculate outer layer
    # sigmoid(z), z3 = Theta2 * a2
    a3 = s.sigmoid(np.dot(a2, Theta2.T))

    # predict value
    p = np.argmax(a3, axis=1)

    return p + 1

# =========================================================================
