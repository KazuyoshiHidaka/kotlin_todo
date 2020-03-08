package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.pagesList
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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagesRecyclerView = view.findViewById<RecyclerView>(R.id.main_recycler_view).also {
            pagesRecyclerViewComponent =
                PagesRecyclerViewComponent(pagesList, it.context, ::navigateToPageDetail)

            it.setHasFixedSize(true)
            it.layoutManager = pagesRecyclerViewComponent.viewManager
            it.adapter = pagesRecyclerViewComponent.viewAdapter
        }
        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.main_floating_action_button).also { it ->
                it.setOnClickListener {
                    navigateToPageNew()
                }
            }
    }

    private fun navigateToPageNew() {
        val directions = MainFragmentDirections.actionMainFragmentToPageNewFragment()
        findNavController().navigate(directions)
    }

    private fun navigateToPageDetail(pageId: Long) {
        val directions = MainFragmentDirections.actionMainFragmentToPageDetailFragment(pageId)
        findNavController().navigate(directions)
    }

}
