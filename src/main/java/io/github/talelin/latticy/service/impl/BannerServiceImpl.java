package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.service.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gelong
 * @date 2020/12/27 21:00
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO>
        implements BannerService {

    @Resource
    private BannerMapper bannerMapper;
    @Resource
    private BannerItemMapper bannerItemMapper;

    @Override
    public void updateById(Long id, BannerDTO bannerDTO) {
        BannerDO bannerDO = bannerMapper.selectById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        bannerMapper.updateById(bannerDO);
    }

    @Override
    public void deleteById(Long id) {
        BannerDO bannerDO = bannerMapper.selectById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        bannerMapper.deleteById(id);
    }

    @Override
    public BannerWithItemsBO getWithItems(Long id) {
        BannerDO bannerDO = bannerMapper.selectById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        List<BannerItemDO> bannerItems = new LambdaQueryChainWrapper<>(bannerItemMapper)
                .eq(BannerItemDO::getBannerId, id)
                .list();
        return new BannerWithItemsBO(bannerDO, bannerItems);
    }
}
