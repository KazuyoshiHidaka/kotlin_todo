package hidaka.kotlinstudy.todo

import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui.PageDetailActivity
import hidaka.kotlinstudy.todo.ui.PageEditActivity
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent
import java.util.*

class MainActivity : AppCompatActivity() {
    /// サンプルデータ
    private val pagesList: Array<Page> = arrayOf(
        Page(1, "あかさたな", "あいうえおかきくけこさしすせそたちつてとなにぬねの", Date()),
        Page(2, "はまやらわ", "はひふえほまみむめもやゆよらりるれろわをん", Date()),
        Page(3, "やゆよ", "よ", Date())
    )

    private lateinit var pagesRecyclerView: RecyclerView
    private lateinit var pagesRecyclerViewComponent: PagesRecyclerViewComponent
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagesRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).also {
            pagesRecyclerViewComponent =
                PagesRecyclerViewComponent(pagesList, it.context, ::startActivity)

            it.setHasFixedSize(true)
            it.layoutManager = pagesRecyclerViewComponent.viewManager
            it.adapter = pagesRecyclerViewComponent.viewAdapter
        }
        floatingActionButton =
            findViewById<FloatingActionButton>(R.id.main_floating_action_button).also {
                it.setOnClickListener {
                    val intent = Intent(this, PageEditActivity::class.java)
                    startActivity(intent)
                }
            }

    }

}