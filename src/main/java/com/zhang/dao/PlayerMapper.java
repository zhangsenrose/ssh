package com.zhang.dao;

import com.zhang.entity.Player;

public interface PlayerMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

}