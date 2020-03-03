package hidaka.kotlinstudy.todo.ui_component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page

class PagesRecyclerViewComponent(data: Array<Page>, context: Context) {
    val viewManager: LinearLayoutManager = LinearLayoutManager(context)
    val viewAdapter: MyAdapter = MyAdapter(data)

    class MyAdapter(private val data: Array<Page>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(
            itemView: View
        ) : RecyclerView.ViewHolder(itemView) {
            val title: TextView = itemView.findViewById(R.id.main_vh_title)
        }

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
            val page = data[position]
            holder.title.text = page.title
        }
    }
}