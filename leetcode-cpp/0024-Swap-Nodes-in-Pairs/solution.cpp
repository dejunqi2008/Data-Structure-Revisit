#include <iostream>
#include <vector>
#include "../utils/ListNode.h"
#include "../utils/HelperFunction.h"

using namespace std;

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* p1 = dummy;
        ListNode* p2 = head;

        while (p2 != NULL && p2->next != NULL) {
            ListNode* tmp = p2->next;
            p1->next = tmp;
            p2->next = tmp->next;
            tmp->next = p2;
            p1 = p2;
            p2 = p1->next;
        }

        head = dummy->next;
        delete dummy;
        return head;
    }
};

int main(void) {
    int arr[] = {1, 2, 3, 4, 5};
    ListNode* head = HelperFunction::createLinkedList(arr, 5);
    Solution* obj = new Solution();
    ListNode* newHead = obj->swapPairs(head);

    HelperFunction::printLinkedList(newHead);
    HelperFunction::deleteLinkedList(newHead);

    return 0;
}
