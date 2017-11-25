#############################################################
#               DIABETIC PREDICTOR ANN                      #
#############################################################

import numpy as np
from keras.models import load_model
from sklearn.preprocessing import StandardScaler
from sklearn.externals import joblib



def predict(pregnancies, glucose, bp, skinThickness, insulin, BMI, diabetesFunction, age):
    #Initalizing the classifier
    classifier=load_model('diabetes_predictor.h5')
        
    #Loading the scaler
    scaler = joblib.load('scaler.save')
        
    #Creating the array
    x=np.array(scaler.fit_transform([[pregnancies,glucose,bp,skinThickness,insulin,BMI,diabetesFunction,age]]))
        
    #Predicting the output
    ypred=classifier.predict(x)
    
    #Return the value
    return ypred


