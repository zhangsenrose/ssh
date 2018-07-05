package com.zhang.controller;

import com.zhang.entity.Player;
import com.zhang.service.PlayerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

}
