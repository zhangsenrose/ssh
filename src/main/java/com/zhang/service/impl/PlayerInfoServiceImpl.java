package com.zhang.service.impl;

import com.zhang.dao.PlayerMapper;
import com.zhang.entity.Player;
import com.zhang.service.PlayerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By ZhangSenWei on 2018/7/2
 **/
@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {

    @Resource
    private PlayerMapper playerMapper;


    @Override
    public List<Player> getPlayerInfo() {
        return playerMapper.selectAll();
    }

    @Override
    public List<Player> getPlayerByPIds(Map<String, Object> params) {
        return playerMapper.selectByParams(params);
    }


}
