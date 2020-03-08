package hidaka.kotlinstudy.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hidaka.kotlinstudy.todo.model.Page
import java.util.*

/// サンプルデータ
val pagesList: Array<Page> = arrayOf(
    Page(1, "あかさたな", "あいうえおかきくけこさしすせそたちつてとなにぬねの", Date()),
    Page(2, "はまやらわ", "はひふえほまみむめもやゆよらりるれろわをん", Date()),
    Page(3, "やゆよ", "よ", Date())
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (savedInstanceState == null) {
//            val fragment = MainFragment()
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.main_fragment_host, fragment)
//                .commit()
//        }
    }

//    fun navigateToPageNew() {
//        val intent = Intent(this, PageNewActivity::class.java)
//        startActivity(intent)
//    }

}