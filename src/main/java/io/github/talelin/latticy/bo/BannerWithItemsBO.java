package io.github.talelin.latticy.bo;

import com.google.common.collect.Lists;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author gelong
 * @date 2021/1/11 21:17
 */
@Data
public class BannerWithItemsBO {

    @ApiModelProperty(name = "id", value = "id")
    private Long id;

    @ApiModelProperty(name = "name", value = "name")
    private String name;

    @ApiModelProperty(name = "description", value = "description")
    private String description;

    @ApiModelProperty(name = "title", value = "title")
    private String title;

    /**
     * 部分banner可能有标题图片
     */
    @ApiModelProperty(name = "img", value = "部分banner可能有标题图片")
    private String img;

    /**
     * banner items
     */
    @ApiModelProperty(name = "items", value = "banner items")
    private List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemDO> items) {
        this.id = bannerDO.getId();
        this.name = bannerDO.getName();
        this.description = bannerDO.getDescription();
        this.title = bannerDO.getTitle();
        this.img = bannerDO.getImg();
        this.items = Lists.newArrayList(items);
    }
}
