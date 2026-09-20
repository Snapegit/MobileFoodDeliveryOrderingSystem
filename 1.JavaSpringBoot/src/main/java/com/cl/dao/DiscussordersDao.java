package com.cl.dao;

import com.cl.entity.DiscussordersEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussordersView;


/**
 * orders评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-24 10:42:20
 */
public interface DiscussordersDao extends BaseMapper<DiscussordersEntity> {
	
	List<DiscussordersView> selectListView(@Param("ew") Wrapper<DiscussordersEntity> wrapper);

	List<DiscussordersView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussordersEntity> wrapper);
	
	DiscussordersView selectView(@Param("ew") Wrapper<DiscussordersEntity> wrapper);
	

}
