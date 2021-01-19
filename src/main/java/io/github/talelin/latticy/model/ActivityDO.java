package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author generator@TaleLin
 * @since 2021-01-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("activity")
public class ActivityDO extends BaseModel {


    private String title;

    private String description;

    private Date startTime;

    private Date endTime;

    private String remark;

    private Integer online;

    private String entranceImg;

    private String internalTopImg;

    private String name;

}
