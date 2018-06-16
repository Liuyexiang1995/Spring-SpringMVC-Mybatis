package webapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.easytec.mybatis.plugins.Page;

import mybatis.dataObject.SysDictionary;
import mybatis.dataObject.SysDictionaryExample;
import mybatis.mapper.SysDictionaryMapper;
import webapp.common.util.BeanMapperUtil;
import webapp.model.PageModel;
import webapp.service.DictionaryService;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: webapp.service.impl 
 * @author: createdByliuyx 
 * @date: 2018年6月11日 下午2:12:34 
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private SysDictionaryMapper sysDictionaryMapper;
	@Override
	public SysDictionary findById(Long id) {
		// TODO Auto-generated method stub
		SysDictionary sysDict=sysDictionaryMapper.selectByPrimaryKey(id);
		return sysDict;
	}

	@Override
	public List<SysDictionary> findListByExample(SysDictionaryExample example) {
		// TODO Auto-generated method stub
		List<SysDictionary> resultList=sysDictionaryMapper.selectByExample(example);
		return resultList;
	}

	@Override
	public boolean saveOrUpdate(SysDictionary sysDict) {
		// TODO Auto-generated method stub
        if(StringUtils.isEmpty(sysDict.getId())){
          	return sysDictionaryMapper.insertSelective(sysDict)==1;
        }else{
        	SysDictionaryExample example=new SysDictionaryExample();
        	example.createCriteria().andIdEqualTo(sysDict.getId());
        	return sysDictionaryMapper.updateByExampleSelective(sysDict,example)==1;
        }
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(id)){
			return false;
        }else return sysDictionaryMapper.deleteByPrimaryKey(id)==1;
	}

	@Override
	public PageModel<SysDictionary> loadByParamsInPage(SysDictionaryExample example,
			PageModel<SysDictionary> pageModel) {
		// TODO Auto-generated method stub
        Page page = pageModel.createPage();
        example.setPage(page);
        int count = (int)sysDictionaryMapper.countByExample(example);
        pageModel.setTotalRecords(count);
        List<SysDictionary> list = BeanMapperUtil.mapList(sysDictionaryMapper.selectByExample(example), SysDictionary.class);
        pageModel.setResult(list);
        return pageModel;
	}


}
