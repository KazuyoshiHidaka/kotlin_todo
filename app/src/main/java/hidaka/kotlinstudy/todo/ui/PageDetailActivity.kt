package hidaka.kotlinstudy.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent

class PageDetailActivity : AppCompatActivity() {
    private lateinit var pageTitle: TextView
    private lateinit var pageContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_detail)

        val page: Page? =
            intent.getParcelableExtra<Page?>(PagesRecyclerViewComponent.PUT_EXTRA_KEY_PAGE_DETAIL)

        pageTitle = findViewById<TextView>(R.id.page_detail_title).also {
            it.text = page?.title
        }
        pageContent = findViewById<TextView>(R.id.page_detail_content).also {
            it.text = page?.content
        }
    }
}
