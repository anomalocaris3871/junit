package me.dongguen.junit;

import me.dongguen.junit.annotation.FastTest;
import me.dongguen.junit.annotation.SlowTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @DisplayName("")
    @EnabledOnOs(OS.WINDOWS)
    @FastTest
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


    @SlowTest
    void create_new_study_again() {
        System.out.println("create1");
    }

    @DisplayName("make study")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeat_test(RepetitionInfo repetitionInfo) {
        System.out.println("test" + repetitionInfo.getCurrentRepetition()+ "/" + repetitionInfo.getTotalRepetitions())  ;
    }

    @DisplayName("make study")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void parameterizedTest(String message) {
        System.out.println(message);
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