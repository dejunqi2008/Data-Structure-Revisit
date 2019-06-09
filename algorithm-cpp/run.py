import os
import sys

# clang++ -std=c++11 01-sorting/main.cpp -o ./out/main.out
def run(path):
    if not os.path.exists("./out"):
        os.system("mkdir ./out")

    command = "clang++ -std=c++11 " + path + " -o ./out/main.out"
    # print command
    os.system(command)
    os.system("./out/main.out");

run(sys.argv[1])




