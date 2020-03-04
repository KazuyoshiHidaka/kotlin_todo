package hidaka.kotlinstudy.todo.ui_component

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui.PageDetailActivity

class PagesRecyclerViewComponent(
    data: Array<Page>,
    context: Context,
    handleClickVH: (Intent) -> Unit
) {
    companion object {
        const val PUT_EXTRA_KEY_PAGE_DETAIL = "PageDetail"
    }

    val viewManager: LinearLayoutManager = LinearLayoutManager(context)
    val viewAdapter: MyAdapter = MyAdapter(data, context, handleClickVH)

    class MyAdapter(
        private val data: Array<Page>,
        private val context: Context,
        private val handleClickVH: (Intent) -> Unit
    ) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(
            itemView: View
        ) : RecyclerView.ViewHolder(itemView) {
            val card: CardView = itemView.findViewById(R.id.pages_recycler_view_vh_card_view)
            val title: TextView = itemView.findViewById(R.id.pages_recycler_view_vh_title)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.pages_recycler_view_vh,
                parent,
                false
            )
            return MyViewHolder(view)
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val page = data[position]
            holder.card.setOnClickListener {
                val intent = Intent(context, PageDetailActivity::class.java).also {
                    it.putExtra(PUT_EXTRA_KEY_PAGE_DETAIL, page)
                }
                handleClickVH(intent)
            }
            holder.title.text = page.title
        }
    }
}