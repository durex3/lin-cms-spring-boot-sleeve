package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.core.annotation.PermissionModule;
import io.github.talelin.core.annotation.Required;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @author gelong
 * @date 2020/12/27 19:01
 */
@Api(tags = "banner")
@PermissionModule(value = "banner管理")
@RequestMapping(value = "/v1/banner")
@RestController
@Validated
public class BannerController {

    @Resource
    private BannerService bannerService;

    @ApiOperation(value = "分页查询banner")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页"),
            @ApiImplicitParam(name = "count", value = "每页大小")
    })
    @PermissionMeta(value = "分页查询banner")
    @Required
    @GetMapping(value = "/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(defaultValue = "0")
                                               @Min(value = 0, message = "{page.number.min}") Integer page,
                                               @RequestParam(defaultValue = "10")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        IPage<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.page(pager);
        return PageUtil.build(paging);
    }

    @ApiOperation(value = "更新banner")
    @PermissionMeta(value = "更新banner")
    @GroupRequired
    @PutMapping(value = "/{id}")
    public UpdatedVO<BannerDTO> update(@PathVariable(value = "id") @Positive Long id,
                                    @RequestBody @Validated BannerDTO bannerDTO) {
        bannerService.updateById(id, bannerDTO);
        return new UpdatedVO<>();
    }

    @ApiOperation(value = "删除banner")
    @PermissionMeta(value = "删除banner")
    @GroupRequired
    @DeleteMapping(value = "/{id}")
    public DeletedVO<BannerDTO> delete(@PathVariable(value = "id") @Positive Long id) {
        bannerService.deleteById(id);
        return new DeletedVO<>();
    }

    @ApiOperation(value = "查询banner以及items")
    @PermissionMeta(value = "查询banner详情")
    @Required
    @GetMapping(value = "/{id}")
    public BannerWithItemsBO getWithItems(@PathVariable(value = "id") @Positive Long id) {
        return bannerService.getWithItems(id);
    }

    @ApiOperation(value = "创建banner")
    @PermissionMeta(value = "创建banner")
    @GroupRequired
    @PostMapping
    public CreatedVO<BannerDTO> create(@RequestBody @Validated BannerDTO bannerDTO) {
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        bannerService.save(bannerDO);
        return new CreatedVO<>();
    }
}
