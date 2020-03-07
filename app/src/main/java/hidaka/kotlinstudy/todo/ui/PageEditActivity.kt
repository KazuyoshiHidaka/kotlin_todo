package hidaka.kotlinstudy.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.fragment.PageEditFragment

class PageEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_edit)

        if (savedInstanceState == null) {
            val fragment = PageEditFragment()

            // Intent extras and Fragment Args are both of type android.os.Bundle.
            fragment.arguments = intent.extras

            supportFragmentManager
                .beginTransaction()
                .add(R.id.page_edit_fragment_host, fragment)
                .commit()
        }
    }
}
