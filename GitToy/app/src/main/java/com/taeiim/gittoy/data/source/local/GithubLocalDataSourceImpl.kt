package com.taeiim.gittoy.data.source.local

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.model.SearchRepoHistory

class GithubLocalDataSourceImpl(
    private val historyDao: SearchRepoHistoryDao
) : GithubDataSource.Local {

    override fun getRepoHistoryList(): List<GithubRepo> =
        historyDao.getRepoHistoryList()

    override fun saveClickRepo(repo: GithubRepo) =
        historyDao.saveClickRepo(SearchRepoHistory(repo))

    override fun deleteRepoHistory(repo: GithubRepo) =
        historyDao.deleteRepoHistory(SearchRepoHistory(repo))

}