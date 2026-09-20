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


import com.cl.dao.PeisongxinxiDao;
import com.cl.entity.PeisongxinxiEntity;
import com.cl.service.PeisongxinxiService;
import com.cl.entity.view.PeisongxinxiView;

@Service("peisongxinxiService")
public class PeisongxinxiServiceImpl extends ServiceImpl<PeisongxinxiDao, PeisongxinxiEntity> implements PeisongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeisongxinxiEntity> page = this.selectPage(
                new Query<PeisongxinxiEntity>(params).getPage(),
                new EntityWrapper<PeisongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeisongxinxiEntity> wrapper) {
		  Page<PeisongxinxiView> page =new Query<PeisongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeisongxinxiView> selectListView(Wrapper<PeisongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeisongxinxiView selectView(Wrapper<PeisongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
