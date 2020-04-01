package com.taeiim.gittoy.data

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.api.model.RepoSearchResponse
import com.taeiim.gittoy.data.source.GithubDataSource

class GithubRepositoryImpl(
    private val githubRemoteDataSource: GithubDataSource.Remote,
    private val githubLocalDataSource: GithubDataSource.Local
) : GithubRepository {

    override fun searchRepository(
        query: String,
        success: (results: RepoSearchResponse) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubRemoteDataSource.searchRepository(query, success, fail)
    }

    override fun getRepoInfo(
        userName: String,
        repoName: String,
        success: (repo: GithubRepo) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubRemoteDataSource.getRepoInfo(userName, repoName, success, fail)
    }

    override fun getUserInfo(
        userName: String,
        success: (user: GithubUser) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubRemoteDataSource.getUserInfo(userName, success, fail)
    }


    override fun getRepoHistoryList(): List<GithubRepo> {
        Thread(Runnable { githubLocalDataSource.getRepoHistoryList() }).start()
        return githubLocalDataSource.getRepoHistoryList()
    }

    override fun saveClickRepo(repo: GithubRepo) {
        githubLocalDataSource.saveClickRepo(repo)
    }

    override fun deleteRepoHistory(repo: GithubRepo) {
        githubLocalDataSource.deleteRepoHistory(repo)
    }

}