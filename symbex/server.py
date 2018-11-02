#!/usr/bin/python3
from flask import Flask, request, jsonify
from flask_restful import Resource, Api
from json import dumps
import subprocess

app = Flask(__name__)
api = Api(app)


class JDart(Resource):
    def get(self):
        subprocess.Popen("./entrypoint.sh")
        return jsonify()
    
api.add_resource(JDart, '/jdart') # Route_1

if __name__ == '__main__':
    app.run(host='0.0.0.0', port='80')
