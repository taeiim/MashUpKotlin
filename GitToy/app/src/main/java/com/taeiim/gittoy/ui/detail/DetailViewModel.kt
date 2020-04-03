package com.taeiim.gittoy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.base.BaseViewModel
import com.taeiim.gittoy.data.GithubRepository

class DetailViewModel(private val githubRepository: GithubRepository) : BaseViewModel() {

    private val _user = MutableLiveData<GithubUser>()
    val user: LiveData<GithubUser>
        get() = _user

    private val _repo = MutableLiveData<GithubRepo>()
    val repo: LiveData<GithubRepo>
        get() = _repo


    fun getRepoData(userName: String, repoName: String) {
        githubRepository.getRepoInfo(userName, repoName, success = {
            _repo.value = it
        }, fail = {
        })
    }

    fun getUserData(userName: String) {
        githubRepository.getUserInfo(userName, success = {
            _user.value = it
        }, fail = {
        })
    }

    fun saveRepoHistory() {
        repo.value?.let { githubRepository.saveClickRepo(it) }
    }
}