package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원이 제대로 저장되었는지 확인
        Member findMember = memberService.findMember(memberId);
        System.out.println("Member found: " + findMember);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // null 체크 추가
        if (order != null) {
            System.out.println("order = " + order);
            System.out.println("order.calculateDiscountPrice = " + order.calculateDiscountPrice());
        } else {
            System.out.println("Order creation failed");
        }
    }
}