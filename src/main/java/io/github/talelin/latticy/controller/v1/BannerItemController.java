package io.github.talelin.latticy.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.core.annotation.Required;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.banneritem.BannerItemDTO;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.service.BannerItemService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 * @author generator@TaleLin
 * @since 2021-01-19
 */
@Api(tags = "banner-item")
@PermissionModule(value = "banner-item管理")
@RestController
@RequestMapping("/v1/banner-item")
public class BannerItemController {

    @Resource
    private BannerItemService bannerItemService;

    @ApiOperation(value = "创建banner_item")
    @PermissionMeta(value = "创建banner_item")
    @GroupRequired
    @PostMapping
    public CreatedVO<BannerItemDO> create(@RequestBody @Validated BannerItemDTO bannerItemDTO) {
        BannerItemDO bannerItemDO = new BannerItemDO();
        BeanUtils.copyProperties(bannerItemDTO, bannerItemDO);
        bannerItemService.save(bannerItemDO);
        return new CreatedVO<>();
    }

    @ApiOperation(value = "更新banner_item")
    @PermissionMeta(value = "更新banner_item")
    @GroupRequired
    @PutMapping("/{id}")
    public UpdatedVO<BannerItemDO> update(@PathVariable @Positive(message = "{id.positive}") Long id,
                                           @RequestBody @Validated BannerItemDTO bannerItemDTO) {
        bannerItemService.updateById(id, bannerItemDTO);
        return new UpdatedVO<>();
    }

    @ApiOperation(value = "删除banner_item")
    @PermissionMeta(value = "删除banner_item")
    @GroupRequired
    @DeleteMapping("/{id}")
    public DeletedVO<BannerItemDO> delete(@PathVariable @Positive(message = "{id.positive}") Long id) {
        bannerItemService.deleteById(id);
        return new DeletedVO<>();
    }

    @ApiOperation(value = "查询banner_item")
    @PermissionMeta(value = "查询banner_item")
    @Required
    @GetMapping("/{id}")
    public BannerItemDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Long id) {
        return bannerItemService.getById(id);
    }

    @ApiOperation(value = "分页查询banner_item")
    @PermissionMeta(value = "分页查询banner_item")
    @Required
    @GetMapping("/page")
    public PageResponseVO<BannerItemDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Long page
    ) {
        IPage<BannerItemDO> pager = new Page<>(page, count);
        IPage<BannerItemDO> paging = bannerItemService.page(pager);
        return PageUtil.build(paging);
    }

}
