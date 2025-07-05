package co.uk.bbk.ivaylodonchev

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = RecipeDatabase.getDatabase(application).recipeDao()
    val allRecipes: LiveData<List<Recipe>> = dao.getAllRecipes()

    fun insert(recipe: Recipe) = viewModelScope.launch {
        dao.insert(recipe)
    }

    fun update(recipe: Recipe) = viewModelScope.launch {
        dao.update(recipe)
    }

    fun delete(recipe: Recipe) = viewModelScope.launch {
        dao.delete(recipe)
    }
}
