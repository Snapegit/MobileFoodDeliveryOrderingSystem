package com.cl.dao;

import com.cl.entity.PeisongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeisongxinxiView;


/**
 * 配送信息
 * 
 * @author 
 * @email 
 * @date 2024-01-24 10:42:20
 */
public interface PeisongxinxiDao extends BaseMapper<PeisongxinxiEntity> {
	
	List<PeisongxinxiView> selectListView(@Param("ew") Wrapper<PeisongxinxiEntity> wrapper);

	List<PeisongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PeisongxinxiEntity> wrapper);
	
	PeisongxinxiView selectView(@Param("ew") Wrapper<PeisongxinxiEntity> wrapper);
	

}
