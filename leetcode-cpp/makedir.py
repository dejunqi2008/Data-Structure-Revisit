import sys
import os

def makedir(arg):
    print(arg)
    num = arg[1]
    if "." in num:
        num = num[:-1]

    while len(num) < 3:
        num = "0" + num

    length = len(arg)
    problename = ""
    for i in range(2, length):
        if i < length - 1:
            problename += arg[i] + "-"
        else:
            problename += arg[i]

    title = num + "-" + problename
    command1 = "mkdir " + title
    command2 = "touch " + title + "/" + "solution.cpp"
    os.system(command1)
    os.system(command2)

makedir(sys.argv)