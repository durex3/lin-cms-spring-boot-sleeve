package io.github.talelin.latticy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.dto.banneritem.BannerItemDTO;
import io.github.talelin.latticy.model.BannerItemDO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-01-19
 */
public interface BannerItemService extends IService<BannerItemDO> {

    /**
     * 根据id更新
     *
     * @param id            id
     * @param bannerItemDTO bannerDTO
     */
    void updateById(Long id, BannerItemDTO bannerItemDTO);

    /**
     * 根据id删除
     *
     * @param id id
     */
    void deleteById(Long id);

}
