package hidaka.kotlinstudy.todo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Page(
    val id: Long,
    val title: String,
    val content: String,
    val updatedAt: Date
) : Parcelable