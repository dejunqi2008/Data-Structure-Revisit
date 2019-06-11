#ifndef BINARY_SEARCH_TREE_H
#define BINARY_SEARCH_TREE_H

#include <vector>
using namespace std;


template <typename Key, typename Value>
class BST {
public:
    BST() {
        root = NULL;
        count = 0;
    }


    ~BST() {
        // TODO:
    }

    int size() {return count;}

    int isEmpty() {return count == 0;}

    void insert(Key key, Value value) {
        root = insertHelper(root, key, value);
    }

    void remove(Key key) {
        removeHelper(root, key);
    }

    Value get(Key key) {
        assert(contain(key));
        Node *cur = root;
        Value res = 0;
        while (cur != NULL) {
            if (cur->key == key) {
                res = cur->value;
                break;
            } else if (cur->key < key) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }
        return res;
    }

    bool contain(Key key) {
        Node *cur = root;
        while (cur != NULL) {
            if (cur->key == key) {
                return true;
            } else if (cur->key < key) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }
        return false;
    }

    vector<Key> traverse() {
        vector<Key> res;
        traverseHelper(res, root);
        return res;
    }


private:
    struct Node {
        Key key;
        Value value;
        Node *left;
        Node *right;
        Node(Key key, Value val) {
            this->key = key;
            this->value = val;
            this->left = this->right = NULL;
        }
    };
    Node *root;
    int count;

    Node* insertHelper(Node *node, Key key, Value value) {
        if (node == NULL) {
            count++;
            return new Node(key, value);
        }

        if (key == node->key) {
            node->value = value;
        } else if (key < node->key) {
            node->left = insertHelper(node->left, key, value);
        } else {
            node->right = insertHelper(node->right, key, value);
        }

        return node;
    }

    Node* removeHelper(Node *node, Key key) {
        if (node == NULL) {
            return NULL;
        }

        if (node->key < key) {
            node->left = removeHelper(node->left, key);
        } else if (node->key > key) {
            node->right = removeHelper(node->right, key);
        } else {
            if (node->lefy == NULL) {
                return node->right;
            }
            if (node->right == NULL) {
                return node->left;
            }
            Node *minNode = findMin(node->right);
            node->value = minNode->value;
            node->right = removeHelper(node->right, minNode->key);
        }

        return node;
    }

    Node * findMin(Node *node) {
        Node *cur = node;
        while (cur != NULL) {
            cur = cur->left;
        }
        return cur;
    }

    void traverseHelper(vector<Key> &res, Node* node) {
        if (node == NULL) {
            return;
        }
        traverseHelper(res, node->left);
        res.push_back(node->key);
        traverseHelper(res, node->right);
    }


};


#endif