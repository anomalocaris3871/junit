package me.dongguen.study;

import me.dongguen.domain.Member;
import me.dongguen.domain.Study;
import me.dongguen.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudy() {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);


        Member member = new Member();
        member.setId(1L);
        member.setEmail("donggeun@email.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Study study = new Study(10, "java");


        assertEquals("donggeun@email.com", memberService.findById(1L).get().getEmail());
        assertEquals("donggeun@email.com", memberService.findById(3L).get().getEmail());

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(IllegalArgumentException.class, () -> {
            memberService.validate(1L);
        });

        memberService.validate(2L);

    }

    @Test
    void createNewStudy2() {

    }

}