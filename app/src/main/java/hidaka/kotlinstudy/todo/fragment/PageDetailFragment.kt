package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui.PageDetailActivity
import hidaka.kotlinstudy.todo.ui_component.PagesRecyclerViewComponent
import java.text.DateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageDetailFragment : Fragment() {

    private lateinit var pageTitle: TextView
    private lateinit var pageUpdatedAt: TextView
    private lateinit var pageContent: TextView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val page: Page? =
            arguments?.getParcelable(PagesRecyclerViewComponent.PUT_EXTRA_KEY_PAGE_DETAIL)

        pageTitle = view.findViewById<TextView>(R.id.page_detail_title).also {
            it.text = page?.title
        }
        pageUpdatedAt = view.findViewById<TextView>(R.id.page_detail_updated_at).also {
            it.text = getString(
                R.string.page_detail_activity_updated_at_label,
                DateFormat.getDateInstance(DateFormat.LONG).format(page?.updatedAt ?: Date())
            )
        }
        pageContent = view.findViewById<TextView>(R.id.page_detail_fragment_host).also {
            it.text = page?.content
        }
        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_detail_floating_action_button).also {
                it.setOnClickListener {
                    fabClickCallback()
                }
            }
    }

    private fun fabClickCallback() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            (requireActivity() as PageDetailActivity).navigateToPageEdit()
        }
    }

}
