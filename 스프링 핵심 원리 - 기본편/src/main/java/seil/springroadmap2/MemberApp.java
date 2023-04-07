package seil.springroadmap2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.Grade;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        // AppConfig.class 파일을 참조해서 Bean을 생성해서 관리해준다.
        // bean 이름은 기본적으로 bean을 만드는 method 이름이 된다.
        // @Bean에서 name 필드를 사용하면 이름을 설정해 줄 수 있다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
