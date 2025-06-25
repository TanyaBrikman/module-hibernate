package brikman.dev.entity

import dto.CourseDTO
import jakarta.persistence.*

@Entity
@Table(name = "courses")
class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column
    val name: String,

    @Column
    val type: String,

    @ManyToMany(mappedBy = "courseList")
    val studentList: MutableList<Student> = mutableListOf()
) {

    fun toDTO(): CourseDTO {
        return CourseDTO(
            id = this.id,
            name = this.name,
            type = this.type
        )
    }

}