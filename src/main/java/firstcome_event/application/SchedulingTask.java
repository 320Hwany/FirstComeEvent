package firstcome_event.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulingTask {

    private final SchedulingQueue schedulingQueue;
    private final CouponService couponService;

    public SchedulingTask(final SchedulingQueue schedulingQueue, final CouponService couponService) {
        this.schedulingQueue = schedulingQueue;
        this.couponService = couponService;
    }

    @Scheduled(fixedRate = 500)
    public void processSchedulingTasks() {
        for (int i = 0; i < 100 && !schedulingQueue.isEmpty(); i++) {
            long memberId = schedulingQueue.peek();
            boolean success = false;

            try {
                couponService.registerCoupon1(memberId);
                success = true;
            } catch (NullPointerException e) {
                log.error("선착순 실패!");
            } finally {
                if (success) {
                    schedulingQueue.poll();
                }
            }
        }
    }
}
