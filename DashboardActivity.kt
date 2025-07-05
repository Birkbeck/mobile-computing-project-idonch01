package co.uk.bbk.ivaylodonchev

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardActivity : AppCompatActivity() {

    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recipeRecyclerView)
        adapter = RecipeAdapter(
            onItemClicked = { recipe ->
                // Open details to edit the recipe
                val intent = Intent(this, RecipeDetailsActivity::class.java)
                intent.putExtra("recipeId", recipe.id)
                startActivity(intent)
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.allRecipes.observe(this) { recipes ->
            adapter.submitList(recipes)
        }

        val fab: FloatingActionButton = findViewById(R.id.fabAddRecipe)
        fab.setOnClickListener {
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
