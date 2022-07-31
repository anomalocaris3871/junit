package me.dongguen.member;

import me.dongguen.domain.Member;
import me.dongguen.domain.Study;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long memberId);

    void validate(Long MemberId);

    void notify(Study study);
}
