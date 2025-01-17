package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrderBasicMember() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);
    }

    @Test
    void createOrderVIPMember() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
