/**
 *
 * @author dgb
 * @param <T>
 */
public class OurLinkedQueue<T> implements OurQueue<T>{
    private LinkNode<T> head; //Keeps track of the front of the queue.
    private LinkNode<T> tail;  //Keeps track of the back of the queue.
    private int count;
    
    public OurLinkedQueue()
    {
        head = tail = null;
        count = 0;
    }

    @Override
    public T add(T data)  //Add element to 'rear' of queue and return the parameter
    {
        LinkNode<T> newNode = new LinkNode<T>(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            count++;
            return newNode.data;
        } else {
            count++;
            LinkNode<T> node = tail;
            tail = newNode;
            node.next = tail;
            return tail.data;
        }
    }
    
    @Override
    public T remove()  //Remove element from 'front' of queue and return it.
    {
        
        if (head == null) {
            return null;
        } else {
            count--;
            LinkNode<T> node = head;
            head = node.next;
            return node.data;
        }
    }
    
    @Override
    public T peek() //Return element at 'front' of queue without removing it
    {
        if (head == null) return null;
        return head.data;
    }
    
    @Override
    public int size() //Return number of elements on the queue
    {
        if (head == null) {
            return 0;
        } else {
            return count;
        }
    }

    @Override
    public boolean isEmpty() //Return true if queue is empty, false otherwise.
    {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() //Resets the queue. 
    {

        if (head == null) {
            
        } else {
            head = null;
        }

    }


    //Inner Class
    private class LinkNode<T> {    
            private T data;
            private LinkNode<T> next;

            private LinkNode(T data)
            {
                this.data = data;
                next = null;
            }

    }
    
}//End LinkedStack
