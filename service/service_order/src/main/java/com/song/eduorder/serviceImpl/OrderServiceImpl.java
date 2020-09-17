package com.song.eduorder.serviceImpl;

import com.song.commonutils.JwtUtils;
import com.song.eduorder.entity.Order;
import com.song.eduorder.mapper.OrderMapper;
import com.song.eduorder.rmt.CourseRmt;
import com.song.eduorder.rmt.UcenterRmt;
import com.song.eduorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.eduorder.utils.OrderNoUtil;
import com.song.servicebase.entity.CourseWebOrder;
import com.song.servicebase.entity.UcenterMemberOrder;
import com.song.servicebase.exception.GuLiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private UcenterRmt ucenterRmt;
    @Resource
    private CourseRmt courseRmt;

    @Override
    public String saveOrderInfo(String courseId, HttpServletRequest request) {

        // 根据 课程id查询 课程信息
        CourseWebOrder courseWebOrder = courseRmt.getCourseWebOrderInfo(courseId);

        // 获取用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        // 根据 用户id查询 用户信息
        UcenterMemberOrder memberOrder = ucenterRmt.getMemberOrderByUcenterId(memberId);


        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());
        order.setCourseId(courseId);
        order.setCourseTitle(courseWebOrder.getTitle());
        order.setCourseCover(courseWebOrder.getCover());
        order.setTeacherName(courseWebOrder.getTeacherName());
        order.setTotalFee(courseWebOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(memberOrder.getMobile());
        order.setNickname(memberOrder.getNickname());
        order.setStatus(0);
        order.setPayType(1);
        int count = baseMapper.insert(order);
        if (count == 0) {
            throw new GuLiException(20001, "创建订单失败");
        }
        return order.getOrderNo();
    }
}
