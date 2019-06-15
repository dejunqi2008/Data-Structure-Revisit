#ifndef HELPER_FUNCTIONS_H
#define HELPER_FUNCTIONS_H

#include <iostream>
#include <string>
#include "ListNode.h"


using namespace std;

namespace HelperFunction {

    ListNode* createLinkedList(int arr[], int n) {
        if (n == 0) {
            return NULL;
        }

        ListNode* head = new ListNode(arr[0]);

        ListNode* cur = head;
        for (int i = 1; i < n; i++) {
            cur->next = new ListNode(arr[i]);
            cur = cur->next;
        }
        return head;
    }

    void printLinkedList(ListNode* head) {
        ListNode* cur = head;
        string res = "";
        while (cur != NULL) {
            int val = cur->val;
            res += std::to_string(val) += " -> ";
            cur = cur->next;
        }
        res += "NULL";
        cout << res << endl;
    }

    void deleteLinkedList(ListNode* head) {
        ListNode* cur = head;
        while (cur != NULL) {
            ListNode* node = cur;
            cur = cur->next;
            delete node;
        }
    }

}

#endif