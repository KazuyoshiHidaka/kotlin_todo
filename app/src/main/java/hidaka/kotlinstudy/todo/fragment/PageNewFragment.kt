package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.model.Page
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageNewFragment : Fragment() {
    private lateinit var titleForm: EditText
    private lateinit var contentForm: EditText
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleForm = view.findViewById(R.id.component_page_form_title)
        titleForm.addTextChangedListener(titleWatcher)

        contentForm = view.findViewById(R.id.component_page_form_content)

        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_new_floating_action_button).also {
                it.setOnClickListener { handleClickFAB() }
            }
    }

    private val titleWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            validateTitle(p0.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    private fun validateTitle(text: String) {
        titleForm.error = errorTextValidateTitle(text)
    }

    private fun errorTextValidateTitle(text: String): String? {
        return if (text.isEmpty()) {
            getString(R.string.component_page_form_title_validator_label)
        } else {
            null
        }
    }

    private fun handleClickFAB() {
        val text = titleForm.editableText.toString()
        validateTitle(text)

        val titleError = titleForm.error
        if (titleError == null) {
            createPage()
            clearFocus()
            findNavController().navigateUp()
        }
    }

    // TODO: Pageオブジェクトをデータに追加する
    private fun createPage() {
        val text = titleForm.editableText.toString()
        val content = contentForm.editableText.toString()
        val date = Date()
        // HACK: 一意なIDの生成について
        val id = (text + content + date.toString()).hashCode().toLong()

        val page = Page(id, text, content, date)
    }

    private fun clearFocus() {
        titleForm.clearFocus()
        contentForm.clearFocus()
    }

}
