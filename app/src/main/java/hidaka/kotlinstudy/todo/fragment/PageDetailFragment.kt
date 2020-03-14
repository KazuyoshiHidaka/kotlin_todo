package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.pagesList
import java.text.DateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageDetailFragment : Fragment() {

    private val args by navArgs<PageDetailFragmentArgs>()

    private lateinit var pageTitle: TextView
    private lateinit var pageUpdatedAt: TextView
    private lateinit var pageContent: TextView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val page: Page? = pagesList.find { page -> page.id == args.pageId }

        pageTitle = view.findViewById<TextView>(R.id.page_detail_title).also {
            it.text = page?.title
        }
        pageUpdatedAt = view.findViewById<TextView>(R.id.page_detail_updated_at).also {
            it.text = getString(
                R.string.page_detail_updated_at_label,
                DateFormat.getDateInstance(DateFormat.LONG).format(page?.updatedAt ?: Date())
            )
        }
        pageContent = view.findViewById<TextView>(R.id.page_detail_fragment_host).also {
            it.text = page?.content
        }
        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_detail_floating_action_button).also {
                it.setOnClickListener {
                    navigateToPageEdit()
                }
            }
    }

    private fun navigateToPageEdit() {
        val pageId = args.pageId
        val directions =
            PageDetailFragmentDirections.actionPageDetailFragmentToPageEditFragment(pageId)

        findNavController().navigate(directions)
    }

}
