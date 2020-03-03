package hidaka.kotlinstudy.todo

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import hidaka.kotlinstudy.todo.model.Page
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagesRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
            pagesRecyclerViewComponent = PagesRecyclerViewComponent(pagesList, context)

            setHasFixedSize(true)
            layoutManager = pagesRecyclerViewComponent.viewManager
            adapter = pagesRecyclerViewComponent.viewAdapter
        }
    }
}