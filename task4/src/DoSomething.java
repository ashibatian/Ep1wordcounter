public class DoSomething implements Runnable {
    Container container=new Container();
    int variety;
    DoSomething(int i)
    {
        variety=i;
    }
    public void run() {
        if(variety==1)
            for(int i=0;i<10000;i++)
               container.produce(i);
        if(variety==2)
            for(int i=0;i<5000;i++)
                container.consume();
        if(variety==3)
            for(int i=0;i<5000;i++)
                container.throwfirst();
    }
}