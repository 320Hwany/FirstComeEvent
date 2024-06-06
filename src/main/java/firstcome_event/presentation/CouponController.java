package firstcome_event.presentation;

import firstcome_event.application.CouponService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private final CouponService couponService;

    public CouponController(final CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/issue")
    public void issueCoupon() {
        couponService.issueCoupon("쿠폰 이름");
    }

    @PostMapping("/register/{memberId}")
    public void registerCoupon(@PathVariable final long memberId) {
        couponService.registerCoupon(memberId);
    }
}
