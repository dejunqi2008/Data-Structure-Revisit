/*

对类的静态成员访问时不依赖于对象的, 因此可以用普通的指针来指向和访问静态成员

*/

#include <iostream>

using namespace std;

class Point {
public:
    // non-const static data member must be initialized out of line
    // static int count = 0;
    static int count;

    Point(int x=0, int y=0) : x(x), y(y) {
        count++;
    }

    Point(const Point &p) : x(p.x), y(p.y) {
        count++;
    }

    ~Point() {
        count--;
    }

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

private:
    int x, y;
};

int Point::count = 0;

int main(void) {
    int * ptr = &Point::count ;

    Point a(4, 5);

    cout << "Point A: " << a.getX() << ", " << a.getY() << endl;
    cout << "Object count = " << * ptr << endl;

    Point b(a);
    cout << "Point B: " << b.getX() << ", " << b.getY() << endl;
    cout << "Object count = " << * ptr << endl;


    return 0;
}

