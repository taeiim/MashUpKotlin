package com.taeiim.gittoy.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseViewModel
import com.taeiim.gittoy.data.GithubRepository

class SearchViewModel(private val githubRepository: GithubRepository) : BaseViewModel() {

    private val _searchResultList = MutableLiveData<List<GithubRepo>>()
    val searchResultList: LiveData<List<GithubRepo>>
        get() = _searchResultList

    private val _errorFailSearch = MutableLiveData<Throwable>()
    val errorFailSearch: LiveData<Throwable>
        get() = _errorFailSearch

    fun searchRepo(query: String) {
        githubRepository.searchRepository(query, success = {
            _searchResultList.value = it.items
        }, fail = {
            _errorFailSearch.value = Throwable()
        })
    }

}