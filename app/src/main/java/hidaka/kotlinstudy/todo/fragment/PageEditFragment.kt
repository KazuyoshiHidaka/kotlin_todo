package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.pagesList
import hidaka.kotlinstudy.todo.ui_component.PageFormComponent
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageEditFragment : Fragment() {

    private val args by navArgs<PageEditFragmentArgs>()

    private lateinit var pageForm: PageFormComponent
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val page = pagesList.find { page -> page.id == args.pageId }

        pageForm = view.findViewById(R.id.page_form_component_host)
        page?.let {
            pageForm.title = it.title
            pageForm.content = it.content
        }

        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_new_floating_action_button).also {
                it.setOnClickListener { handleClickFAB() }
            }
    }

    private fun handleClickFAB() {
        val isTitleValidate = pageForm.isFormValidate()
        if (isTitleValidate) {
            updatePage()
            pageForm.clearFocus()
            findNavController().navigateUp()
        }
    }

    // TODO: PageオブジェクトをUpdateする
    private fun updatePage() {
        val title = pageForm.title
        val content = pageForm.content
        val date = Date()
    }

}
