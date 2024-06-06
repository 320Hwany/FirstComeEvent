package firstcome_event.persistence.repository;

import firstcome_event.persistence.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberJpaEntity, Long> {
}
