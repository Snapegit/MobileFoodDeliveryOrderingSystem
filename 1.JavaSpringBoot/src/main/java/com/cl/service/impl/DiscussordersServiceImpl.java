package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussordersDao;
import com.cl.entity.DiscussordersEntity;
import com.cl.service.DiscussordersService;
import com.cl.entity.view.DiscussordersView;

@Service("discussordersService")
public class DiscussordersServiceImpl extends ServiceImpl<DiscussordersDao, DiscussordersEntity> implements DiscussordersService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussordersEntity> page = this.selectPage(
                new Query<DiscussordersEntity>(params).getPage(),
                new EntityWrapper<DiscussordersEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussordersEntity> wrapper) {
		  Page<DiscussordersView> page =new Query<DiscussordersView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussordersView> selectListView(Wrapper<DiscussordersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussordersView selectView(Wrapper<DiscussordersEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
