from flask import Flask
from flask import request
from flask import jsonify
import Interface as pd
app = Flask(__name__)
@app.route("/predict",methods=['POST'])
def predict():
    result = pd.predict(request.form['pregnancies'],request.form['glucose'],request.form['bp'],request.form['skinThickness'],request.form['insulin'],request.form['BMI'],request.form['diabetesFunction'],request.form['age'])
    res={}
    res['value']= str(result[0][0])
    return jsonify(res)
    
if __name__ == '__main__':
    app.run(debug=True)