package com.designModes.decker;

//ConcreteDectrator 具体装饰者，具体得装饰对象，给内部持有得具体被装饰对象，增加具体职责
public class ManDecoratorA extends Decorator{

    @Override
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat(){
        System.out.println("再吃一顿饭");
    }
}


/**
 * 继承属于扩展形式之一，但不见得是达到弹性设计的最佳方案。
 * 在我们的设计中，应该允许行为可以被扩展，而不须修改现有的代码。
 * 组合和委托可用于在运行时动态地加上新的行为。
 * 除了继承，装饰者模式也可以让我们扩展行为。
 * 装饰者模式意味着一群装饰者类， 这些类用来包装具体组件。
 * 装饰者类反映出被装饰的组件类型（实际上，他们具有相同的类型，都经过接口或继承实现）。
 * 装饰者可以在被装饰者的行为前面与/或后面加上自己的行为，甚至将被装饰者的行为整个取代掉，而达到特定的目的。
 **/