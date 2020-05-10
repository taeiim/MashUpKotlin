package com.taeiim.gittoy.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taeiim.gittoy.api.model.GithubRepo

@Entity(tableName = "search_repo_history")
data class SearchRepoHistory(
    val repo: GithubRepo,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)