package brikman.dev

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "profiles")
class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "bio")
    val bio: String,
    @Column(name = "last seen time")
    var lastSeenTime: LocalDateTime,

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    val student: Student,
) {


}