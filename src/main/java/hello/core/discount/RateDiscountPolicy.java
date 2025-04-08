package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      int discountRate = 10;
      return price * discountRate / 100;
    } else {
      return 0;
    }
  }
}
