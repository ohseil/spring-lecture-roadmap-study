package seil.springroadmap1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seil.springroadmap1.repository.MemberRepository;
import seil.springroadmap1.repository.MemoryMemberRepository;
import seil.springroadmap1.service.MemberService;

/**
 * Java 코드로 빈을 등록하는 방법
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
