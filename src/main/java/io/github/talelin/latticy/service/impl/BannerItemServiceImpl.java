package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.banneritem.BannerItemDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.service.BannerItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2021-01-19
 */
@Service
public class BannerItemServiceImpl extends ServiceImpl<BannerItemMapper, BannerItemDO>
        implements BannerItemService {

    @Resource
    private BannerItemMapper bannerItemMapper;

    @Override
    public void updateById(Long id, BannerItemDTO bannerItemDTO) {
        BannerItemDO bannerItemDO = bannerItemMapper.selectById(id);
        if (bannerItemDO == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(bannerItemDTO, bannerItemDO);
        bannerItemMapper.updateById(bannerItemDO);
    }

    @Override
    public void deleteById(Long id) {
        BannerItemDO bannerItemDO = bannerItemMapper.selectById(id);
        if (bannerItemDO == null) {
            throw new NotFoundException(20000);
        }
        bannerItemMapper.deleteById(id);
    }
}
