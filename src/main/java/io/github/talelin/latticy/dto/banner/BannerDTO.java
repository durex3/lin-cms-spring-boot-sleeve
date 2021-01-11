package io.github.talelin.latticy.dto.banner;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author gelong
 * @date 2020/12/27 21:49
 */
@Data
public class BannerDTO {

    @NotBlank
    @Length(min = 2, max = 30)
    private String name;

    @Length(min = 2, max = 255)
    private String description;

    @NotBlank
    @Length(min = 2, max = 30)
    private String title;

    /**
     * 部分banner可能有标题图片
     */
    @Length(min = 2, max = 255)
    private String img;
}
