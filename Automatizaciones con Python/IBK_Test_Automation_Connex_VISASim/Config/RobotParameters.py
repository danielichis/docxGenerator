from Utils import JsonReader


def values():
    path = "values.json"
    return JsonReader.values(path)


def user():
    path = "user.json"
    return JsonReader.values(path)