package hidaka.kotlinstudy.todo.ui_component

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import hidaka.kotlinstudy.todo.R

class PageFormComponent(
    context: Context, attrs: AttributeSet
) : ConstraintLayout(context, attrs) {

    init {
        // NOTE: findViewByIdの前に実行する
        LayoutInflater.from(context).inflate(R.layout.component_page_form, this, true)
    }

    // NOTE: titleFormのaddTextChangedListenerで使う前に初期化
    private val titleWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            validateTitle(p0.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    private val titleForm: EditText = findViewById<EditText>(R.id.component_page_form_title).also {
        it.addTextChangedListener(titleWatcher)
    }
    private val contentForm: EditText = findViewById(R.id.component_page_form_content)

    var title: String
        get() = titleForm.text.toString()
        set(value) {
            titleForm.setText(value)
        }
    var content: String
        get() = contentForm.text.toString()
        set(value) {
            contentForm.setText(value)
        }

    fun isFormValidate(): Boolean {
        validateTitle(title)
        return titleForm.error == null
    }

    private fun validateTitle(text: String) {
        titleForm.error = errorTextValidateTitle(text)
    }

    private fun errorTextValidateTitle(text: String): String? {
        return if (text.isEmpty()) {
            resources.getString(R.string.component_page_form_title_validator_label)
        } else {
            null
        }
    }
}