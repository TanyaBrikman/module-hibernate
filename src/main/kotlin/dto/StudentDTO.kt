package dto


data class StudentDTO(
    var id: Long,
    var name: String,
    var age: Int,
    val profile: ProfileDTO?,
    val courses: List<CourseDTO>,
    val group: GroupDTO?
)