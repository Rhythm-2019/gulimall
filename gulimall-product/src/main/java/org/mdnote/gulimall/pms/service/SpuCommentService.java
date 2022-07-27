package org.mdnote.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.mdnote.gulimall.common.utils.PageUtils;
import org.mdnote.gulimall.pms.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author Rhythm-2019
 * @email rhythm-2019@163.com
 * @date 2022-07-27 13:08:14
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

