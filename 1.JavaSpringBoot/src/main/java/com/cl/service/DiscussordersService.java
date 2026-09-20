package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussordersEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussordersView;


/**
 * orders评论表
 *
 * @author 
 * @email 
 * @date 2024-01-24 10:42:20
 */
public interface DiscussordersService extends IService<DiscussordersEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussordersView> selectListView(Wrapper<DiscussordersEntity> wrapper);
   	
   	DiscussordersView selectView(@Param("ew") Wrapper<DiscussordersEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussordersEntity> wrapper);
   	

}

