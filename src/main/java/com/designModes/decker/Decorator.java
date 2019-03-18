package com.designModes.decker;

//Decorator（装饰者抽象类）维持一个指向Component接口一致得接口
public abstract class Decorator implements Person {


    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        person.eat();
    }
}
