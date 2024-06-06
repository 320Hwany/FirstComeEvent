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

    @PostMapping("/register1/{memberId}")
    public void registerCoupon1(@PathVariable final long memberId) {
        couponService.registerCoupon1(memberId);
    }

    @PostMapping("/register2/{memberId}")
    public void registerCoupon2(@PathVariable final long memberId) {
        couponService.registerCoupon2(memberId);
    }
}
