package com.taeiim.gittoy.data

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.api.model.RepoSearchResponse

interface GithubRepository {

    fun searchRepository(
        query: String,
        success: (results: RepoSearchResponse) -> Unit,
        fail: (t: Throwable) -> Unit
    )

    fun getRepoInfo(
        userName: String,
        repoName: String,
        success: (repo: GithubRepo) -> Unit,
        fail: (t: Throwable) -> Unit
    )

    fun getUserInfo(
        userName: String,
        success: (user: GithubUser) -> Unit,
        fail: (t: Throwable) -> Unit
    )

    fun getRepoHistoryList(): List<GithubRepo>

    fun saveClickRepo(repo: GithubRepo)

    fun deleteRepoHistory(repo: GithubRepo)

}