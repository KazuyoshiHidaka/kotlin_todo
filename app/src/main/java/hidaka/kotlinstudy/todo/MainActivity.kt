package hidaka.kotlinstudy.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import hidaka.kotlinstudy.todo.model.Page
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

        val navController = findNavController(R.id.main_fragment_host)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_fragment_host)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}