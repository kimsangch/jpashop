package jpabook.jpashop;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TmpMemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(tmpMember member){
        em.persist(member);
        return member.getId();
    }

    public tmpMember find(Long id) {
        return em.find(tmpMember.class, id);
    }

}
