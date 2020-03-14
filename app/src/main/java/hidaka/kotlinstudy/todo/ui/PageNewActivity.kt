package hidaka.kotlinstudy.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.fragment.PageNewFragment

class PageNewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_new)

        if (savedInstanceState == null) {
            val fragment = PageNewFragment()

            // Intent extras and Fragment Args are both of type android.os.Bundle.
            fragment.arguments = intent.extras

            supportFragmentManager
                .beginTransaction()
                .add(R.id.page_new_fragment_host, fragment)
                .commit()
        }
    }
}
