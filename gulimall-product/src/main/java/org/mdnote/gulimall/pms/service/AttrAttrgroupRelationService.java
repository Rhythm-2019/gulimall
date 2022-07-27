package org.mdnote.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.mdnote.gulimall.common.utils.PageUtils;
import org.mdnote.gulimall.pms.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author Rhythm-2019
 * @email rhythm-2019@163.com
 * @date 2022-07-27 13:08:14
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

