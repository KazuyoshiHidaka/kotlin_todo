package hidaka.kotlinstudy.todo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.R.string.page_detail_activity_updated_at_label
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent
import java.text.DateFormat
import java.util.*

class PageDetailActivity : AppCompatActivity() {
    private lateinit var pageTitle: TextView
    private lateinit var pageUpdatedAt: TextView
    private lateinit var pageContent: TextView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_detail)

        val page: Page? =
            intent.getParcelableExtra<Page?>(PagesRecyclerViewComponent.PUT_EXTRA_KEY_PAGE_DETAIL)

        pageTitle = findViewById<TextView>(R.id.page_detail_title).also {
            it.text = page?.title
        }
        pageUpdatedAt = findViewById<TextView>(R.id.page_detail_updated_at).also {
            it.text = getString(
                page_detail_activity_updated_at_label,
                DateFormat.getDateInstance(DateFormat.LONG).format(page?.updatedAt ?: Date())
            )
        }
        pageContent = findViewById<TextView>(R.id.page_detail_content).also {
            it.text = page?.content
        }
        floatingActionButton =
            findViewById<FloatingActionButton>(R.id.page_detail_floating_action_button).also {
                it.setOnClickListener {
                    val intent = Intent(this, PageEditActivity::class.java)
                    startActivity(intent)
                }
            }
    }
}
