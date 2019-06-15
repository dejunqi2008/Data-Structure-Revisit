#include <iostream>
#include <vector>
#include <string>
#include "../utils/ListNode.h"
#include "../utils/HelperFunction.h"


using namespace std;

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        
        ListNode* tail = head;
        ListNode* p1 = NULL;
        ListNode* p2 = head;
        
        while (p2 != NULL) {
            ListNode* tmp = p2->next;
            p2->next = p1;
            p1 = p2;
            p2 = tmp;
        }

        ListNode* tmp = tail->next;
        tail->next = NULL;
        delete tmp;
        
        return p1;
    }
};


int main(void) {
    int arr[] = {1, 2, 3, 4, 5};
    ListNode* head = HelperFunction::createLinkedList(arr, 5);
    Solution obj;
    ListNode* newhead = obj.reverseList(head);
    HelperFunction::printLinkedList(newhead);
    HelperFunction::deleteLinkedList(newhead);
    return 0;
}

