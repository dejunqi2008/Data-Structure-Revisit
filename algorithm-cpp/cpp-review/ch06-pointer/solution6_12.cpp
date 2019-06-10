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
    Point pointA(4, 5);
    Point * p1 = &pointA;

    // 使用指针访问对象成员使用箭头
    cout << p1->getX() << endl;

    // 直接使用对象变量访问对象成员使用 点
    cout << point.getX() << endl;
    return 0;
}

