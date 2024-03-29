package jpabook.jpashop.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {

        return em.createQuery(
                "select o from Order o" +
                        " join o.member m" +
                        " join o.delivery d" , OrderSimpleQueryDto.class
        ).getResultList();
    }
}
