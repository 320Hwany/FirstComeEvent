package firstcome_event.application;

import firstcome_event.persistence.entity.CouponJpaEntity;
import firstcome_event.persistence.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(final CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Transactional
    public void issueCoupon(final String couponName) {
        for (int i = 0; i < 1000; i++) {
            CouponJpaEntity couponJpaEntity = CouponJpaEntity.toEntity(0, couponName + i);
            couponRepository.save(couponJpaEntity);
        }
    }

    @Transactional
    public void registerCoupon(final long memberId) {
        try {
            CouponJpaEntity couponJpaEntity = couponRepository.findFirstCouponWithLock();
            couponJpaEntity.updateCouponStatus(memberId);
        } catch (NullPointerException e) {
            log.info("선착순 마감되었습니다!");
        }
    }
}
