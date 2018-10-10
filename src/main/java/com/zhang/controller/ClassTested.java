package com.zhang.controller;

import com.zhang.service.Collaborator;

/**
 * Create By ZhangSenWei on 2018/8/21
 **/
public class ClassTested {

    private Collaborator listener;

    public Collaborator getListener() {
        return listener;
    }

    public void setListener(Collaborator listener) {
        this.listener = listener;
    }
    public String carryQuery(String id){
        return this.listener.documentAdded(id);
    }

}
