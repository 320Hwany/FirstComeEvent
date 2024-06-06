package firstcome_event.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "coupon")
@Entity
public class CouponJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    private Long memberId;

    private String couponName;

    protected CouponJpaEntity() {
    }

    @Builder
    private CouponJpaEntity(final long memberId, final String couponName) {
        this.memberId = memberId;
        this.couponName = couponName;
    }

    public static CouponJpaEntity toEntity(final long memberId, final String couponName) {
        return CouponJpaEntity.builder()
                .memberId(memberId)
                .couponName(couponName)
                .build();
    }

    public void updateCouponStatus(final long memberId) {
        this.memberId = memberId;
    }
}
