package com.linhua.study.bean;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 7:27 下午
 */


public class Person {
    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }



    public Person() {

    }
}
