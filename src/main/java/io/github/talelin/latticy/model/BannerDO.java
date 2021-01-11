package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gelong
 * @date 2020/12/27 21:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "banner")
public class BannerDO extends BaseModel {

    @TableField(value = "name")
    private String name;

    @TableField(value = "description")
    private String description;

    @TableField(value = "title")
    private String title;

    /**
     * 部分banner可能有标题图片
     */
    @TableField(value = "img")
    private String img;
}