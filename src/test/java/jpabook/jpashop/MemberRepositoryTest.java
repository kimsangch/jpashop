package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    TmpMemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        tmpMember member = new tmpMember();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        tmpMember findMemeber = memberRepository.find(saveId);
        //then
        Assertions.assertThat(findMemeber.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMemeber.getUsername()).isEqualTo(member.getUsername());



    }
}