#ifndef SELECTIONSORT_STUDENT_H
#define SELECTIONSORT_STUDENT_H

using namespace std;

struct Student {
    string name;
    int score;

    bool operator < (const Student &other) {
        return score != other.score ? score < other.score : name < other.name;
    }

    // 对 << 进行重载, 目的是为了实现打印 cout << ...
    // friend 关键字声明了友元函数, 
    friend ostream& operator << (ostream &os, const Student &student) {
        os << "Student: " << student.name << " " << student.score << endl;
        return os;
    } 
};


#endif // SELECTIONSORT_STUDENT_H