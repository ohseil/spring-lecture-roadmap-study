package seil.springroadmap2.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seil.springroadmap2.AppConfig;
import seil.springroadmap2.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조 값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    @Test
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // same : '==' 동일성 비교
        // equal : 'equals()' 동등성 비교
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}


