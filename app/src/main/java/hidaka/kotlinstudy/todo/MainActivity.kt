package hidaka.kotlinstudy.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val pagesList: Array<String> = arrayOf(
    "私は時間すでにこうした増減学に対してものの後にありたあり。",
    "何しろ今を病気界はじっととんだ尊重ましたほどに行くているあるがは意味聞えるなたて、多少には死んなですでです。",
    "分子がしです訳はちゃんと今におもにべきたでしょ。"
)

class MainActivity : AppCompatActivity() {
    lateinit var tracker: SelectionTracker<*>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(pagesList)

        recyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        tracker = SelectionTracker.Builder(
            "pages-selection-id",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            MyAdapter.MyDetailsLookup(recyclerView),
            StorageStrategy.createLongStorage()
        )
            .withOnItemActivatedListener(MyAdapter.MyItemActivatedListener())
            .build()
    }

    private class MyAdapter(private val data: Array<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.main_vh_view,
                parent,
                false
            )
            return MyViewHolder(view)
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.title.text = data[position]
            holder.itemView.isActivated = !holder.itemView.isActivated
        }

        class MyDetailsLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {
            override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
                val view: View = recyclerView.findChildViewUnder(e.x, e.y) ?: return null

                val viewHolder = recyclerView.getChildViewHolder(view)
                return if (viewHolder is MyViewHolder) {
                    viewHolder.getItemDetails()
                } else null
            }
        }

        class MyViewHolder(
            itemView: View
        ) : RecyclerView.ViewHolder(itemView) {
            val title: TextView = itemView.findViewById(R.id.main_vh_title)

            fun getItemDetails() = object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getSelectionKey() = itemId
                override fun getPosition() = adapterPosition
            }
        }

        class MyItemActivatedListener : OnItemActivatedListener<Long> {
            override fun onItemActivated(
                item: ItemDetailsLookup.ItemDetails<Long>,
                e: MotionEvent
            ): Boolean {
                return true
            }

        }

    }

}
