package brikman.dev.entity

import dto.StudentDTO
import jakarta.persistence.*

@Entity
@Table(name = "students")
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "name", unique = true, nullable = false)
    var name: String,

    @Column(name = "age")
    var age: Int,

    @OneToOne(mappedBy = "student", cascade = [CascadeType.REMOVE])
    val profile: Profile?,

    @ManyToOne(cascade = [CascadeType.REMOVE, CascadeType.MERGE])
    @JoinColumn(name = "group_id")
    val group: Group?,

    @ManyToMany(cascade = [CascadeType.REMOVE, CascadeType.MERGE])
    @JoinTable(
        name = "student_courses",
        joinColumns =  [JoinColumn(name = "student_id", referencedColumnName = "id")],
        inverseJoinColumns =  [JoinColumn(name = "course_id", referencedColumnName = "id")]
    )
    val courseList: MutableList<Course> = mutableListOf()
) {

    fun toDTO(): StudentDTO {
        return StudentDTO(
            id = this.id,
            name = this.name,
            age = this.age,
            profile = profile?.toDTO(),
            courses = courseList.map { it.toDTO() },
            group = group?.toDTO()
        )
    }

    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age)"
    }
}