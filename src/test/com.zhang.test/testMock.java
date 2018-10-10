package com.zhang.test;

import com.zhang.common.RespData;
import com.zhang.controller.ClassTested;
import com.zhang.controller.OasRefundMock;
import com.zhang.service.Collaborator;
import com.zhang.service.MockInterface;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


/**
 * Create By ZhangSenWei on 2018/8/21
 **/
public class testMock {

    @Resource
    private MockInterface mockInterface;

    @Test
    public void testMock(){

        String amount = "2";
        String billId = "2897we8787";
        MockInterface mockInterface = EasyMock.createMock(MockInterface.class);
        EasyMock.expect(mockInterface.OasReceBillRefund(EasyMock.anyString(), EasyMock.anyString())).andReturn(new RespData(RespData.SUCCESS_CODE, "退款成功"));
        EasyMock.replay(mockInterface);
        RespData res = mockInterface.OasReceBillRefund(amount, billId);
        EasyMock.verify(mockInterface);
        System.out.println(res.getMessage());

    }
}
