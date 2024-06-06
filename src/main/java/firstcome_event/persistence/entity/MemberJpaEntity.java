package firstcome_event.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "member")
@Entity
public class MemberJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    protected MemberJpaEntity() {
    }

    @Builder
    private MemberJpaEntity(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
}
