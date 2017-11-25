#############################################################
#               DIABETIC PREDICTOR ANN                      #
#############################################################

import numpy as np
from keras.models import load_model


#Initalizing the classifier
classifier=load_model('diabetes_predictor.h5')

#Creating the array
x=np.array([[4,11,92,33,175,25.8,0.587,31]])

#Predicting the output
ypred=classifier.predict(x)

