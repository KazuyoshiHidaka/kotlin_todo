package hidaka.kotlinstudy.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent

/// サンプルデータ
val pagesList: Array<String> = arrayOf(
    "私は時間すでにこうした増減学に対してものの後にありたあり。",
    "何しろ今を病気界はじっととんだ尊重ましたほどに行くているあるがは意味聞えるなたて、多少には死んなですでです。",
    "分子がしです訳はちゃんと今におもにべきたでしょ。"
)

class MainActivity : AppCompatActivity() {
    private lateinit var pagesRecyclerView: RecyclerView
    private lateinit var pagesRecyclerViewComponent: PagesRecyclerViewComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagesRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
            pagesRecyclerViewComponent = PagesRecyclerViewComponent(context)

            setHasFixedSize(true)
            layoutManager = pagesRecyclerViewComponent.viewManager
            adapter = pagesRecyclerViewComponent.viewAdapter
        }
    }
}