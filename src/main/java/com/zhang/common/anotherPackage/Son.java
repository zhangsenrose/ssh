package com.zhang.common.anotherPackage;

import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * Create By ZhangSenWei on 2018/11/13
 **/
public class Son extends  Father {
    public Son() {
    }

    @Override
    public void walk() {
        super.walk();
    }
}
