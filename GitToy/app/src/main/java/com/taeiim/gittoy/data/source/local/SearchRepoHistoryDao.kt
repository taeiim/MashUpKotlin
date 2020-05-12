package com.taeiim.gittoy.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.data.source.local.model.SearchRepoHistory

@Dao
interface SearchRepoHistoryDao {

    @Query("SELECT * FROM SEARCH_REPO_HISTORY ORDER BY id DESC LIMIT 100")
    fun getRepoHistoryList(): List<GithubRepo>

    @Insert
    fun saveClickRepo(repo: SearchRepoHistory)

    @Delete
    fun deleteRepoHistory(repo: SearchRepoHistory)

}