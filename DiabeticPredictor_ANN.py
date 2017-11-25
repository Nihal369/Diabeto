#############################################################
#               DIABETIC PREDICTOR ANN                      #
#############################################################

#Import libraries
import pandas as pd
import numpy as np

#Importing dataset
dataset=pd.read_csv("diabetes.csv")

#Splitting dependent and independent variables
x=dataset.iloc[:,:-1].values
y=dataset.iloc[:,-1].values

#Imputing the missing values
from sklearn.preprocessing import Imputer
imputer=Imputer(missing_values=0,strategy="mean",axis=0)
x[:,1:6]=imputer.fit_transform(x[:,1:6])
x[:,1:5]=x[:,1:5].astype(int)

#Train-test split
from sklearn.model_selection import train_test_split
xtrain,xtest,ytrain,ytest=train_test_split(x,y,test_size=0.1,train_size=0.9)

#Feature scaling
from sklearn.preprocessing import StandardScaler
scaler=StandardScaler()
xtrain=scaler.fit_transform(xtrain)
xtest=scaler.fit_transform(xtest)

#Creating the model
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import Dropout

#Initalizing the model
classifier=Sequential()

#Input layer
classifier.add(Dense(units=5,activation="relu",kernel_initializer="glorot_uniform",input_dim=8))
classifier.add(Dropout(rate=0.1))

#Hidden layer 1
classifier.add(Dense(units=5,activation="relu",kernel_initializer="glorot_uniform"))
classifier.add(Dropout(rate=0.1))

#Hidden layer 2
classifier.add(Dense(units=5,activation="relu",kernel_initializer="glorot_uniform"))
classifier.add(Dropout(rate=0.1))

#Output layer
classifier.add(Dense(units=1,activation="sigmoid",kernel_initializer="glorot_uniform"))
classifier.add(Dropout(rate=0.1))

#Compiling the ANN
classifier.compile(optimizer='rmsprop',loss='binary_crossentropy',metrics=['accuracy'])

#Fitting the ANN
classifier.fit(xtrain,ytrain,batch_size=1,epochs=500)

#Evaluvating the model on test set
ypred=classifier.predict(xtest)
ypred=(ypred>0.5)

#Confusion matrix
from sklearn.metrics import confusion_matrix
cm=confusion_matrix(ytest,ypred)

#Saving the classifier
from keras.models import load_model
classifier.save('diabetes_predictor.h5')
