#include <iostream>

using namespace std;

void splitFloat(float x, int *intPar, float *factPar) {
    * intPar = static_cast<int>(x);
    * factPar = x - (* intPar);
}

int main(void) {
    for (int i = 0; i < 3; i++) {
        float x, f;
        int n;
        cin >> x;
        splitFloat(x, &n, &f);
        cout << "Int part: " << n << ", Fraction part: " << f << endl;
    }

    return 0;
}
