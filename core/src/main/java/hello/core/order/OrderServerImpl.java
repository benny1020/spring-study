package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServerImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; // 인터페이스에만 의존

    public OrderServerImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int disCountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disCountPrice);
    }
}
