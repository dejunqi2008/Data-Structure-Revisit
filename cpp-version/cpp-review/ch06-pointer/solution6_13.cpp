/*
对象指针
*/

#include <iostream>

using namespace std;

class Point {
public:
    Point(int x=0, int y=0) : x(x), y(y) {}
    int getX() const {
        return x;
    }
    int getY() const {
        return y;
    }

private:
    int x, y;
};

int main(void) {

    /***********************/
    Point pointB(5, 6);
    Point * ptr = &pointB;

    // 等号左边为函数指针定义, 等号右边为通过类访取得成员函数, 然后再取地址, 可写为 &(Point::getX)
    int (Point:: * funcPtr)() const = &Point::getX;

    cout << (pointB.*funcPtr)() << endl; // output 5
    cout << (ptr->*funcPtr)() << endl; // output 5
    cout << pointB.getX() << endl; // output 5
    cout << ptr->getX() << endl; // output 5


    return 0;
}

