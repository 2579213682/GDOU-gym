package com.gmy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2023-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserRepairs对象", description="")
public class UserRepairs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "报修编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "报修原因")
    private String repairReason;

    @ApiModelProperty(value = "报修状态")
    private Integer status;

    @ApiModelProperty(value = "租用编号")
    @TableField("borrowId")
    private Long borrowid;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "报修用户id")
    private Long userid;


}
