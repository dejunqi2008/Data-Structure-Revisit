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
        destroy(root);
    }

    int size() {return count;}

    int isEmpty() {return count == 0;}

    void insert(Key key, Value value) {
        root = insertHelper(root, key, value);
    }

    void remove(Key key) {
        root = removeHelper(root, key);
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
        inorder(res, root);
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

        Node(Node * node) {
            this->key = node->key;
            this->value = node->value;
            this->left = node->left;
            this->right = node->right;
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

        if (key < node->key) {
            node->left = removeHelper(node->left, key);
        } else if (key > node->key) {
            node->right = removeHelper(node->right, key);
        } else {
            if (node->left == NULL) {
                count--;
                Node* rightNode = node->right;
                delete node;
                return rightNode;
            }
            if (node->right == NULL) {
                count--;
                Node* leftNode = node->left;
                delete node;
                return leftNode;
            }
            Node *minNode = findMin(node->right);
            node->key = minNode->key;
            node->value = minNode->value;
            node->right = removeHelper(node->right, minNode->key);
        }
        count--;
        return node;

    }

    Node * findMin(Node *node) {
        Node *cur = node;
        while (cur->left != NULL) {
            cur = cur->left;
        }
        return cur;
    }

    void inorder(vector<Key> &res, Node* node) {
        if (node == NULL) {
            return;
        }
        inorder(res, node->left);
        res.push_back(node->key);

        inorder(res, node->right);
    }

    void destroy(Node* node) {
        if (node != NULL) {
            destroy(node->left);
            destroy(node->right);

            delete node;
            count--;
        }
    }
};


#endif