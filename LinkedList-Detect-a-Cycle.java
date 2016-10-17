/*
* Problem description: https://www.hackerrank.com/challenges/ctci-linked-list-cycle/copy-from/28918390
*/

boolean hasCycle(Node head) {
    // Base case
    
    if(head == null) { 
        return false; 
    }
    /* Create two nodes, fast and slow
    * Fast will move twice as fast as slow
    */
    Node fast = head.next; 
    Node slow = head; 
    /* Loop that runs as long as 
    * fast, slow, and fast.next aren't null 
    */
    while(fast != null && fast.next != null && slow != null) { 
        // If there's ever a situation where fast == slow, 
        // this implies there was a cycle
        if(fast == slow) { 
            return true; 
        }
        fast = fast.next.next; 
        slow = slow.next; 
    }
    
    return false; 

}