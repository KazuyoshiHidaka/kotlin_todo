package hidaka.kotlinstudy.todo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.MainActivity
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.pagesList
import hidaka.kotlinstudy.todo.ui.PageNewActivity
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var pagesRecyclerView: RecyclerView
    private lateinit var pagesRecyclerViewComponent: PagesRecyclerViewComponent
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagesRecyclerView = view.findViewById<RecyclerView>(R.id.main_recycler_view).also {
            pagesRecyclerViewComponent =
                PagesRecyclerViewComponent(pagesList, it.context, ::startActivity)

            it.setHasFixedSize(true)
            it.layoutManager = pagesRecyclerViewComponent.viewManager
            it.adapter = pagesRecyclerViewComponent.viewAdapter
        }
        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.main_floating_action_button).also { it ->
                it.setOnClickListener {
                    fabClickCallback()
                }
            }
    }

    private fun fabClickCallback() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            (requireActivity() as MainActivity).navigateToPageNew()
        }
    }

}
