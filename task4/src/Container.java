import java.util.Deque;
import java.util.LinkedList;

public class Container {
     private static Deque<Integer> deque=new LinkedList<>();

    public void produce(int i)
     {
         System.out.print("produce "+i+ '\n');
         deque.addLast(i);
     }
    public void consume()
    {
        if(deque.isEmpty()) {
            System.out.print("no product"+ '\n');
        }
        else {
            System.out.print("consume" + deque.getLast() + '\n');
            this.deque.removeLast();
        }
    }
    public void throwfirst()
    {
        if(deque.isEmpty()) {
            System.out.print("no product"+ '\n');
        }
        else {
        System.out.print("throw"+deque.getFirst()+ '\n');
        this.deque.removeFirst();
        }
    }

}
