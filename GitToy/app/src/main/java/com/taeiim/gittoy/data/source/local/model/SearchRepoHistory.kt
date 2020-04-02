package com.taeiim.gittoy.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taeiim.gittoy.api.model.GithubRepo

@Entity(tableName = "search_repo_history")
data class SearchRepoHistory(
    @ColumnInfo(name = "repo") val repo: GithubRepo,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0
)
