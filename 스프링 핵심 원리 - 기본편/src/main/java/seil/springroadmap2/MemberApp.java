package seil.springroadmap2;

import seil.springroadmap2.member.DefaultMemberService;
import seil.springroadmap2.member.Grade;
import seil.springroadmap2.member.Member;
import seil.springroadmap2.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
