package com.zhang.controller;

import com.google.common.collect.Maps;
import com.zhang.common.PageInfoDto;
import com.zhang.common.StringToolsUtil;
import com.zhang.entity.Player;
import com.zhang.entity.TestL;
import com.zhang.service.PlayerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By ZhangSenWei on 2018/7/2
 **/
@Controller
@Api(value = "getPlayerInfo", description = "查询player接口",produces = "application/json",position = 1)
public class PlayerInfoController {

    private Logger logger =LoggerFactory.getLogger(PlayerInfoController.class);

    @Resource
    private PlayerInfoService playerInfoService;

    @RequestMapping("/player/getPlayerInfo")
    @ResponseBody
    @ApiOperation(value = "player查询", httpMethod = "POST")
    public List<Player> getPlayerInfo(){
        logger.info("查询到的数据为......",playerInfoService.getPlayerInfo());
        return  playerInfoService.getPlayerInfo();
    }


    @RequestMapping("/player/getPlayerListByPIds")
    @ResponseBody
    @ApiOperation(value = "根据单个或者多个p_ids查询Player", httpMethod = "POST")
    public  List<Player> getPlayerListByPIds(
            @ApiParam(value = "pids") @RequestParam(value = "pIds",required = false) String pIds
    ){
        Map<String,Object> searchMap = Maps.newHashMap();
        List<Integer> PIds = StringToolsUtil.strToList(pIds,"");
        searchMap.put("PIds",PIds);
        return  playerInfoService.getPlayerByPIds(searchMap);

    }

    @RequestMapping("/postList")
    @ResponseBody
    @ApiOperation(value = "测试接受传来的List",httpMethod = "POST")
    public PageInfoDto postList(
            @ApiParam(value = "List<testL>")@RequestBody List<TestL> testL){
        System.out.println(testL);
        return new PageInfoDto(0l,testL);
    }

}
