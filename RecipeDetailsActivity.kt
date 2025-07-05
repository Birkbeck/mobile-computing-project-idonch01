package co.uk.bbk.ivaylodonchev

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailsActivity : AppCompatActivity() {

    private val viewModel: RecipeViewModel by viewModels()
    private var currentRecipe: Recipe? = null

    private lateinit var titleInput: EditText
    private lateinit var ingredientsInput: EditText
    private lateinit var instructionsInput: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        titleInput = findViewById(R.id.recipeTitleInput)
        ingredientsInput = findViewById(R.id.recipeIngredientsInput)
        instructionsInput = findViewById(R.id.recipeInstructionsInput)
        categorySpinner = findViewById(R.id.recipeCategorySpinner)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)
        deleteButton = findViewById(R.id.deleteButton) // Make sure you add this button in XML!

        val categories = arrayOf("Breakfast", "Brunch", "Lunch", "Dinner", "Desserts", "Other")
        categorySpinner.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, categories
        )

        val recipeId = intent.getIntExtra("recipeId", -1)
        if (recipeId != -1) {
            viewModel.allRecipes.observe(this) { recipes ->
                currentRecipe = recipes.find { it.id == recipeId }
                currentRecipe?.let { recipe ->
                    titleInput.setText(recipe.title)
                    ingredientsInput.setText(recipe.ingredients)
                    instructionsInput.setText(recipe.instructions)
                    val pos = categories.indexOf(recipe.category)
                    if (pos >= 0) categorySpinner.setSelection(pos)
                }
            }
        }

        saveButton.setOnClickListener {
            val title = titleInput.text.toString()
            val ingredients = ingredientsInput.text.toString()
            val instructions = instructionsInput.text.toString()
            val category = categorySpinner.selectedItem.toString()

            if (title.isBlank() || ingredients.isBlank() || instructions.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (currentRecipe != null) {
                val updated = currentRecipe!!.copy(
                    title = title,
                    ingredients = ingredients,
                    instructions = instructions,
                    category = category
                )
                viewModel.update(updated)
                Toast.makeText(this, "Recipe updated", Toast.LENGTH_SHORT).show()
            } else {
                val newRecipe = Recipe(
                    title = title,
                    ingredients = ingredients,
                    instructions = instructions,
                    category = category
                )
                viewModel.insert(newRecipe)
                Toast.makeText(this, "Recipe saved", Toast.LENGTH_SHORT).show()
            }

            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }

        deleteButton.setOnClickListener {
            currentRecipe?.let {
                viewModel.delete(it)
                Toast.makeText(this, "Recipe deleted", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}
