package com.zhang.controller;

import com.zhang.common.RespData;
import com.zhang.service.MockInterface;

/**
 * Create By ZhangSenWei on 2018/8/21
 **/
public class OasRefundMock {

    private MockInterface anInterface;

    public void setAnInterface(MockInterface anInterface) {
        this.anInterface = anInterface;
    }
    public RespData refund(String amount, String id){
        return anInterface.OasReceBillRefund(amount, id);
    }
}
