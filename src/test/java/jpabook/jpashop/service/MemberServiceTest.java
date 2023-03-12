package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepository;
    @Autowired EntityManager em;


    @Test
    public void 회원가입() throws Exception {
        //given 주어진것
        Member member = new Member();
        member.setName("kim");

        //when 실행하면
        Long saveId = memberService.join(member);

        //then 결과는 이렇게
        em.flush();
        Assert.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        //when

        memberService.join(member1);
        memberService.join(member2);
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            return;
//        }

        //then

        Assert.fail("예외 발생");


    }

}