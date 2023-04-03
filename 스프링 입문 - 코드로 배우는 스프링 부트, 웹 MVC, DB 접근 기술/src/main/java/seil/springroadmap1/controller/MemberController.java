package seil.springroadmap1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seil.springroadmap1.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }
}
