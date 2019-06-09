#include <iostream>

using namespace std;

class Clock {

public:
    void setTime(int H = 0, int M = 0, int S = 0);
    void showTime();

private:
    int hour, minute, second;
};


void Clock::setTime(int H, int M, int S) {
    hour = H;
    minute = M;
    second = S;
}

void Clock::showTime() {
    cout << hour << " : " << minute << " : " << second << endl;
}

int main(void)
{
    /* code */
    Clock myClock;
    myClock.setTime(8, 30, 30);
    myClock.showTime();
    return 0;
}
