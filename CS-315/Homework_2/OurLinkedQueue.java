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
            return newNode.data;
        } else {
            

        }
    }
    
    @Override
    public T remove()  //Remove element from 'front' of queue and return it.
            //Remember to adjust the tail if you need to.
    {
        //The following statement is there just so that we can compile the class
        //You will need to put the correct statements in here.
        return null; 
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
        //The following statement is there just so that we can compile the class
        //Replace it with the correct one.
        return 0;
    }
    @Override
    public boolean isEmpty() //Return true if queue is empty, false otherwise.
    {
        //The following statement is there just so that we can compile the class
        //Replace it with the correct one.
        return false;
    }
    @Override
    public void clear() //Resets the queue. 
    {
        //Fill in this method with the appropriate statements
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
