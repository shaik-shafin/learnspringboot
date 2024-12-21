package com.shaik.acknowledge.aop.myenum;

public enum TrueFalse {

   TRUE("True", 1),
   FALSE("False", 0);

    private String name;
    private int value;

    TrueFalse(String name, int value) {
        this.name = name;
        this.value = value;
    }

   public String getName() {
       return name;
   }

   public int getValue() {
       return value;
   }
}
