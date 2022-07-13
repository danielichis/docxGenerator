import json


def values(path):
    with open(path) as jsonFile:
        jsonObject = json.load(jsonFile)
        jsonFile.close()
    return jsonObject
