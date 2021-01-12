package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gelong
 * @date 2021/1/11 20:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "banner_item")
public class BannerItemDO extends BaseModel {

    @TableField(value = "img")
    private String img;

    @TableField(value = "keyword")
    private String keyword;

    @TableField(value = "type")
    private Short type;

    @TableField(value = "banner_id")
    private Long bannerId;

    @TableField(value = "name")
    private String name;
}