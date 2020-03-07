package hidaka.kotlinstudy.todo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hidaka.kotlinstudy.todo.fragment.PageDetailFragment
import hidaka.kotlinstudy.todo.R

class PageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_detail)

        if (savedInstanceState == null) {
            val fragment = PageDetailFragment()

            // Intent extras and Fragment Args are both of type android.os.Bundle.
            fragment.arguments = intent.extras

            supportFragmentManager
                .beginTransaction()
                .add(R.id.page_detail_fragment_host, fragment)
                .commit()
        }
    }

    fun navigateToPageEdit() {
        val intent = Intent(this, PageEditActivity::class.java)
        startActivity(intent)
    }
}
