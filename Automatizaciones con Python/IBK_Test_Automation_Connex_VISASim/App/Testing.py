from io import StringIO

import numpy as np
import pyperclip

s = str(pyperclip.paste())
with open('general_transaction_values.txt', 'w') as g:
    g.write(s)
a_file = open("general_transaction_values.txt", "r")
lines = a_file.readlines()
a_file.close()
del lines[0:12]
del lines[32:37]
text = ''.join(str(e) for e in lines)
c = StringIO(text)
data = np.loadtxt(c, dtype='str')
length = len(data)
result = []
print(length)
if(isinstance(data[0], str)):
    line_values = {}
    line_values["CardholderNumber/PAN"] = data[1]
    line_values["Terminal"] = data[2]
    line_values["Date"] = data[3]
    line_values["Time"] = data[4]
    line_values["P-CODE"] = data[5]
    line_values["SI"] = data[6]
    line_values["RC"] = data[7]
    line_values["Amount"] = data[8]
    result.append(line_values)
else:
    for value in data:
        line_values = {}
        line_values["CardholderNumber/PAN"] = value[1]
        line_values["Terminal"] = value[2]
        line_values["Date"] = value[3]
        line_values["Time"] = value[4]
        line_values["P-CODE"] = value[5]
        line_values["SI"] = value[6]
        line_values["RC"] = value[7]
        line_values["Amount"] = value[8]
        result.append(line_values)
print("paso general")
print(result)