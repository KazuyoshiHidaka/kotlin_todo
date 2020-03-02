package hidaka.kotlinstudy.todo.ui_component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.pagesList

class PagesRecyclerViewComponent(context: Context) {
    val viewManager: LinearLayoutManager = LinearLayoutManager(context)
    val viewAdapter: MyAdapter = MyAdapter(pagesList)

    class MyAdapter(private val data: Array<String>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(
            private val itemView: View,
            val title: TextView = itemView.findViewById(R.id.main_vh_title)
        ) : RecyclerView.ViewHolder(itemView)

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
        }
    }
}