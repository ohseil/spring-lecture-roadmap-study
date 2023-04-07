package seil.springroadmap2.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seil.springroadmap2.AppConfig;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationConextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회")
    @Test
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(DefaultMemberService.class);
    }

    @DisplayName("이름 없이 빈 타입으로만 조회")
    @Test
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(DefaultMemberService.class);
    }

    @DisplayName("구체 타입으로 조회")
    @Test
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", DefaultMemberService.class);
        assertThat(memberService).isInstanceOf(DefaultMemberService.class);
    }

    @DisplayName("빈 이름으로 조회X")
    @Test
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
    }
}
