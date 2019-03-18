package com.designModes.decker;

//ConcreteDectrator 具体装饰者，具体得装饰对象，给内部持有得具体被装饰对象，增加具体职责
public class ManDecoratorB extends Decorator {
    @Override
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}
