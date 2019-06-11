#include <iostream>
#include <string>
#include <vector>
#include "BinarySearchTree.h"

using namespace std;


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

    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    cout << endl;
    return 0;
}
