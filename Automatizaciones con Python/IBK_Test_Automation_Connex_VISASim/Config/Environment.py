from decouple import config


def env(value):
    return config(value)
