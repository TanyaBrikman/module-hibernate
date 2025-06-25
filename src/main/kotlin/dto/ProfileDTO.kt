package dto

import java.time.LocalDateTime

data class ProfileDTO(
    var id: Long,
    val bio: String,
    var lastSeenTime: LocalDateTime
) {
}