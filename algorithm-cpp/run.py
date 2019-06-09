import os
import sys
# clang++ -std=c++11 01-sorting/main.cpp -o ./out/main.out
def run(dirname, filename):
    command = "clang++ -std=c++11 " + dirname + "/" + filename + ".cpp -o ./out/main.out"
    print command
    os.system(command)

run(sys.argv[1], sys.argv[2])




