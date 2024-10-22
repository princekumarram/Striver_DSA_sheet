
public class q1_implement_queue_Using_Array {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = 0;

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        // peek

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];

        }

    }

    public static void main(String[] args) {

        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}

/*
 * package queue;
 * 
 * class CustomQueue {
 * private int front, rear, capacity;
 * private int queue[];
 * 
 * // Constructor to initialize the queue
 * CustomQueue(int val) {
 * front = rear = 0;
 * capacity = val;
 * queue = new int[capacity];
 * }
 * 
 * // Enqueue operation to add an element to the queue
 * void enqueue(int data) {
 * if (rear == capacity) { // Corrected condition
 * System.out.println("Queue is full");
 * } else {
 * queue[rear] = data;
 * rear++;
 * }
 * }
 * 
 * // Dequeue operation to remove an element from the queue
 * void dequeue() {
 * if (front == rear) {
 * System.out.println("Queue is empty");
 * } else {
 * // Simply increment the front pointer
 * front++;
 * }
 * }
 * 
 * // Display the current elements in the queue
 * void display() {
 * if (front == rear) {
 * System.out.println("Queue is Empty");
 * } else {
 * System.out.print("Queue elements: ");
 * for (int i = front; i < rear; i++) {
 * System.out.print(queue[i] + " ");
 * }
 * System.out.println();
 * }
 * }
 * 
 * // Display the front element of the queue
 * void front() {
 * if (front == rear) {
 * System.out.println("Queue is Empty");
 * } else {
 * System.out.println("Front Element is: " + queue[front]);
 * }
 * }
 * }
 * 
 * public class q1_implement_queue_Using_Array {
 * 
 * public static void main(String[] args) {
 * 
 * // Creating a queue with capacity 4
 * CustomQueue q = new CustomQueue(4);
 * 
 * // Displaying the empty queue
 * q.display();
 * 
 * // Inserting elements into the queue
 * q.enqueue(20);
 * q.enqueue(30);
 * q.enqueue(40);
 * q.enqueue(50); // This will show "Queue is full"
 * 
 * // Displaying the queue after insertion
 * q.display();
 * 
 * // Trying to enqueue when the queue is full
 * q.enqueue(60); // This will show "Queue is full"
 * 
 * // Deleting two elements from the queue
 * q.dequeue();
 * q.dequeue();
 * System.out.println("After two node deletions:");
 * 
 * // Displaying the queue after deletions
 * q.display();
 * 
 * // Displaying the front element
 * q.front();
 * }
 * }
 * 
 */