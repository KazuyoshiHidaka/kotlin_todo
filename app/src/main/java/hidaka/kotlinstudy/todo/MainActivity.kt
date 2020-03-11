package hidaka.kotlinstudy.todo

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import hidaka.kotlinstudy.todo.model.Page
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/// サンプルデータ
val pagesList: Array<Page> = arrayOf(
    Page(1, "あかさたな", "あいうえおかきくけこさしすせそたちつてとなにぬねの", Date()),
    Page(2, "はまやらわ", "はひふえほまみむめもやゆよらりるれろわをん", Date()),
    Page(3, "やゆよ", "よ", Date())
)

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navController = findNavController(R.id.main_fragment_host).also {
            addCustomDestinationChangedListener()
        }
        appBarConfiguration = AppBarConfiguration(navController.graph)
        // NOTE: setSupportActionBarでToolbarをセットした後に呼ぶ
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_fragment_host)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar, menu)

        // NOTE:
        // 最初のロードでは、showDeleteIconOnOnlyPageDetailによるMenuItemの非表示ができないため、
        // 代わりにここで非表示にする
        val deleteIcon = menu.findItem(R.id.page_detail_toolbar_action_delete)
        deleteIcon.isVisible = false

        return true
    }

    private fun addCustomDestinationChangedListener() {
        findNavController(R.id.main_fragment_host).also {
            it.addOnDestinationChangedListener { _, destination, _ ->
                showDeleteIconOnOnlyPageDetail(destination)
            }
        }
    }

    private fun showDeleteIconOnOnlyPageDetail(destination: NavDestination) {
        val item = toolbar.menu.findItem(R.id.page_detail_toolbar_action_delete)

        item.isVisible = destination.id == R.id.pageDetailFragment
    }

}