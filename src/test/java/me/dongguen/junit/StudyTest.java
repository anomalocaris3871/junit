package me.dongguen.junit;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("")
    void create_new_study() {


        assertThrows(IllegalArgumentException.class, ()-> new Study(-10));


        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });


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