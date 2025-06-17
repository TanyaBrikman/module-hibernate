package brikman.dev

import jakarta.persistence.*

@Entity
@Table(name = "student_group")
class Group(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "number")
    val number: String,
    @Column(name= "grad_year")
    val graduationYear: Long,

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    val studentList: MutableList<Student>? = mutableListOf()
) {

}