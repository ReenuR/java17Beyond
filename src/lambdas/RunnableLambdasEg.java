package lambdas;

public class RunnableLambdasEg {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };
        new Thread(runnable).start();


        //java 8 lambda syntax
        Runnable runnableLambda = () -> System.out.println("Inside Lambda Runnable");
        new Thread(runnableLambda).start();
    }
}
