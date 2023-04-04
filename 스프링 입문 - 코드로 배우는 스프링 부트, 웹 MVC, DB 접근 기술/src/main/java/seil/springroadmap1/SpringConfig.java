package seil.springroadmap1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seil.springroadmap1.aop.TimeTraceAop;
import seil.springroadmap1.repository.*;
import seil.springroadmap1.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Java 코드로 빈을 등록하는 방법
 */
@Configuration
public class SpringConfig {

    /*private final DataSource dataSource;

    public SpringConfig(final DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

   /* private final EntityManager em;

    public SpringConfig(final EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    public SpringConfig(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*@Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

    /*@Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }*/
}
