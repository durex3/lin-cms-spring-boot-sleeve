package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;

/**
 * @author gelong
 * @date 2020/12/27 21:00
 */
public interface BannerService extends IService<BannerDO> {

    /**
     * 根据id更新
     *
     * @param id        id
     * @param bannerDTO bannerDTO
     */
    void updateById(Long id, BannerDTO bannerDTO);

    /**
     * 根据id删除
     *
     * @param id id
     */
    void deleteById(Long id);

    /**
     * 查询banner以及banner_item
     *
     * @param id id
     * @return BannerWithItemsBO
     */
    BannerWithItemsBO getWithItems(Long id);
}
