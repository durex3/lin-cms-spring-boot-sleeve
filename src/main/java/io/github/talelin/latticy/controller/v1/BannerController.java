package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.banner.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(value = "/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(defaultValue = "0")
                                               @Min(value = 0, message = "{page.number.min}") Integer page,
                                               @RequestParam(defaultValue = "10")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        IPage<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.page(pager);
        return new PageResponseVO<>(
                paging.getTotal(),
                paging.getRecords(),
                paging.getCurrent(),
                paging.getSize()
        );
    }

    @ApiOperation(value = "更新banner")
    @PutMapping(value = "/{id}")
    public UpdatedVO<Object> update(@PathVariable(value = "id") @Positive Long id,
                       @RequestBody @Validated BannerDTO bannerDTO) {
        bannerService.updateById(id, bannerDTO);
        return new UpdatedVO<>();
    }

    @ApiOperation(value = "删除banner")
    @DeleteMapping(value = "/{id}")
    public DeletedVO<Object> delete(@PathVariable(value = "id") @Positive Long id) {
        bannerService.deleteById(id);
        return new DeletedVO<>();
    }
}
