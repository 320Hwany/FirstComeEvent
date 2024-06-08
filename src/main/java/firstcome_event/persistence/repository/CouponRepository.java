package firstcome_event.persistence.repository;

import firstcome_event.persistence.entity.CouponJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<CouponJpaEntity, Long> {

    @Query(value = "SELECT * FROM coupon WHERE member_id = 0 LIMIT 1 FOR UPDATE SKIP LOCKED", nativeQuery = true)
    CouponJpaEntity findFirstCouponWithLock();
}
