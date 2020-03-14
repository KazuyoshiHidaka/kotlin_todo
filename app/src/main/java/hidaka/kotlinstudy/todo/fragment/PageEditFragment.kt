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
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hidaka.kotlinstudy.todo.R
import hidaka.kotlinstudy.todo.pagesList
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PageEditFragment : Fragment() {

    private val args by navArgs<PageEditFragmentArgs>()

    private lateinit var titleForm: EditText
    private lateinit var contentForm: EditText
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val page = pagesList.find { page -> page.id == args.pageId }

        titleForm = view.findViewById<EditText>(R.id.component_page_form_title).also {
            it.addTextChangedListener(titleWatcher)
        }
        contentForm = view.findViewById(R.id.component_page_form_content)

        page?.let {
            titleForm.setText(it.title)
            contentForm.setText(it.content)
        }

        floatingActionButton =
            view.findViewById<FloatingActionButton>(R.id.page_edit_floating_action_button).also {
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
            updatePage()
            clearFocus()
            findNavController().navigateUp()
        }
    }

    // TODO: PageオブジェクトをUpdateする
    private fun updatePage() {
        val text = titleForm.editableText.toString()
        val content = contentForm.editableText.toString()
        val date = Date()
    }

    private fun clearFocus() {
        titleForm.clearFocus()
        contentForm.clearFocus()
    }


}
