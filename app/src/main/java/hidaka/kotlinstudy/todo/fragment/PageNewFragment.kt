package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import hidaka.kotlinstudy.todo.ui_component.PageFormComponent
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageNewFragment : Fragment() {
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

        pageForm = view.findViewById(R.id.page_form_component_host)
        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_new_floating_action_button).also {
                it.setOnClickListener { handleClickFAB() }
            }
    }

    private fun handleClickFAB() {
        val isTitleValidate = pageForm.isFormValidate()
        if (isTitleValidate) {
            createPage()
            pageForm.clearFocus()
            findNavController().navigateUp()
        }
    }

    // TODO: Pageオブジェクトをデータに追加する
    private fun createPage() {
        val title = pageForm.title
        val content = pageForm.content
        val date = Date()
        // HACK: 一意なIDの生成について
        val id = (title + content + date.toString()).hashCode().toLong()

        val page = Page(id, title, content, date)
    }

}
