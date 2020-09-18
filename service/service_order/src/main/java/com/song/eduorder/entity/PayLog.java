package com.song.eduorder.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付日志表
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_pay_log")
public class PayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 订单号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 支付完成时间
     */
    @TableField("pay_time")
    private Date payTime;

    /**
     * 支付金额（分）
     */
    @TableField("total_fee")
    private BigDecimal totalFee;

    /**
     * 交易流水号
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 交易状态
     */
    @TableField("trade_state")
    private String tradeState;

    /**
     * 支付类型（1：微信 2：支付宝）
     */
    @TableField("pay_type")
    private Integer payType;

    /**
     * 其他属性
     */
    @TableField("attr")
    private String attr;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
