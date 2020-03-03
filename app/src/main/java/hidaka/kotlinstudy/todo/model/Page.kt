package hidaka.kotlinstudy.todo.model

import java.util.*

data class Page(
    val id: Long,
    val title: String,
    val content: String,
    val updatedAt: Date
)