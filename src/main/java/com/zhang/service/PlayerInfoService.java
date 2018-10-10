package com.zhang.service;

import com.zhang.entity.Player;
import com.zhang.entity.TestL;

import java.util.List;
import java.util.Map;

/**
 * Create By ZhangSenWei on 2018/7/2
 **/
public interface PlayerInfoService {
    List<Player> getPlayerInfo();
    List<Player> getPlayerByPIds(Map<String,Object> params);


}
