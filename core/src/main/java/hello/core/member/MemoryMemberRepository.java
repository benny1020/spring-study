package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 메모리에서만 하기때문에 테스트용으로만!
// concurrent hash map -> 동시성 이슈
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
