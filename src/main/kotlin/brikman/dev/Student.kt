package brikman.dev

import jakarta.persistence.*

@Entity
@Table(name = "students")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(unique = true, nullable = false)
    var name: String,
    var age: Int,

    @OneToOne(mappedBy = "student")
    val profile: Profile?,

    @ManyToOne
    @JoinColumn(name = "group_id")
    val group: Group?
) {
    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age)"
    }
}