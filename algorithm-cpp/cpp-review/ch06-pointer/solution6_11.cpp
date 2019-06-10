/*
指针型函数: 以指针为返回值得函数
指向函数的指针
*/

#include <iostream>

using namespace std;

void printStuff(float) {
    cout << "This is the print stuff function." << endl;
}

void printMessage(float data) {
    cout << "The data to be listed is: " << data << endl;
}

void printFloat(float data) {
    cout << "The data to be printed is: " << data << endl;
}

const float PI = 3.14159f;
const float TWO_PI = PI * 2.0f;


int main() {
    void ( * functionPointer )(float);
    printMessage(PI);
    functionPointer = printMessage;
    functionPointer(PI);

    return 0;
}

