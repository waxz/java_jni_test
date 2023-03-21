package org.example;

import ros.ros;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");

        System.out.println("load ros!");
        ros.ros_init(args);

        ros ros_node = new ros();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("shutdown");
                ros_node.close();
            }
        });




        String[] strAr1=new String[] {"Hello", "counter"}; //inline initialization
        for(int i = 0 ; i < 100; i++){
            strAr1[1] = String.format(", counter %d", i);
            boolean ok = ros_node.ok();
            if(!ok){
                break;
            }
            ros_node.hello(strAr1);
            Thread.sleep(100);

        }

    }

}