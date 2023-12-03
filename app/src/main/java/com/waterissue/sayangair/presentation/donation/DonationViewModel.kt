package com.waterissue.sayangair.presentation.donation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.waterissue.sayangair.presentation.donation.component.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class DonationViewModel @Inject constructor() : ViewModel() {
    private val _articles = mutableStateListOf(
        Article.First, Article.Second, Article.Third, Article.Fourth,
        Article.Fifth, Article.Six, Article.Seven, Article.Eight,
        Article.Nine, Article.Ten
    )
    val articles: List<Article> get() = _articles

    private val _searchResult = mutableStateListOf<Article>()
    val searchResult: List<Article> get() = _searchResult

    private val _query = mutableStateOf("")

    val query: State<String> get() = _query

    init {
        performSearch()
    }

    fun setSearchQuery(query: String) {
        _query.value = query
        performSearch()
    }

    private fun performSearch() {
        val query = _query.value.lowercase(Locale.ROOT).trim()

        _searchResult.clear()

        if (query.isEmpty()) {
            _searchResult.addAll(_articles)
        } else {
            _searchResult.addAll(_articles.filter { article ->
                article.title.lowercase(Locale.ROOT)
                    .contains(query) || article.description.lowercase(Locale.ROOT)
                    .contains(query)
            })
        }
    }
}
