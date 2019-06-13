#include <iostream>
#include <string>
#include <vector>
#include "BinarySearchTree.h"

using namespace std;


void printarr(vector<int> arr) {
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}


int main(void) {

    BST<int, string> bst = BST<int, string>();
    bst.insert(10, "a");
    bst.insert(8, "b");
    bst.insert(5, "c");
    bst.insert(9, "b");
    bst.insert(19, "d");
    bst.insert(22, "e");
    bst.insert(21, "i");

    vector<int> res = bst.traverse();
    printarr(res);

    bst.remove(10);
    printarr(bst.traverse());

    bst.remove(19);
    printarr(bst.traverse());

    // bst.remove(10);
    // printarr(bst.traverse());
    return 0;
}
