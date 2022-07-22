package me.dongguen.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("")
    @EnabledOnOs(OS.WINDOWS)
    @Tag("fast")
    void create_new_study() {
        System.out.println(System.getenv("USERNAME"));
        //특정 환경변수에서만 실행
        assumeTrue("anoma".equalsIgnoreCase(System.getenv("USERNAME")));
        assertThrows(IllegalArgumentException.class, ()-> new Study(-10));


        assumingThat("LOCAL".equalsIgnoreCase(System.getenv("USERNAME")), () -> {
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
        });

        assumingThat("anoma".equalsIgnoreCase(System.getenv("USERNAME")), () -> {
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(5);
        });


/*        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });*//*        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });*/


/*
        Study study = new Study(-10);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () ->
                    "스터디를 처음 만들면" + StudyStatus.DRAFT + "상태이다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
*/

    }


    @Test
    @Tag("slow")
    void create_new_study_again() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all" );
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }


}