package io.github.talelin.latticy.dto.banneritem;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author gelong
 * @date 2021/1/19 10:42
 */
@Data
public class BannerItemDTO {

    @Length(min = 2, max = 255)
    private String img;

    @NotBlank
    @Length(min = 2, max = 30)
    private String keyword;

    @NotNull
    private Short type;

    @NotNull
    private Long bannerId;

    @NotBlank
    @Length(min = 2, max = 30)
    private String name;
}
