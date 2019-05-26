

public class Main {

    public static void main(String[] args) {
       DoSomething produce=new DoSomething(1);
       DoSomething consume=new DoSomething(2);
       DoSomething throwfirst=new DoSomething(3);
       new Thread(produce).start();
       new Thread(consume).start();
       new Thread(throwfirst).start();
    }
}

