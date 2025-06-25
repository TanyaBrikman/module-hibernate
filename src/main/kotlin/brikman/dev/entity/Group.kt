package brikman.dev.entity

import dto.GroupDTO
import jakarta.persistence.*

@Entity
@Table(name = "student_group")
data class Group(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "number")
    val number: String,

    @Column(name = "grad_year")
    val graduationYear: Long,

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE], orphanRemoval = true)
    val studentList: MutableList<Student> = mutableListOf()
) {
    fun toDTO(): GroupDTO {
        return GroupDTO(
            id = this.id,
            number = this.number,
            graduationYear = this.graduationYear,
        )
    }
}
