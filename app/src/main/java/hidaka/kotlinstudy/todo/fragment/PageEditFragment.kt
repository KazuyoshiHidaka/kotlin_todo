package hidaka.kotlinstudy.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hidaka.kotlinstudy.todo.R

/**
 * A simple [Fragment] subclass.
 */
class PageEditFragment : Fragment() {

    val args by navArgs<PageEditFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_edit, container, false)
    }


}
