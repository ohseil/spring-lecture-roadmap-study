package seil.springroadmap1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seil.springroadmap1.repository.JdbcMemberRepository;
import seil.springroadmap1.repository.JdbcTemplateMemberRepository;
import seil.springroadmap1.repository.MemberRepository;
import seil.springroadmap1.repository.MemoryMemberRepository;
import seil.springroadmap1.service.MemberService;

import javax.sql.DataSource;

/**
 * Java 코드로 빈을 등록하는 방법
 */
@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
