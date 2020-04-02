package com.taeiim.gittoy.data.source.remote

import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.api.model.RepoSearchResponse
import com.taeiim.gittoy.data.source.GithubDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRemoteDataSourceImpl(private val githubApi: GithubApi) : GithubDataSource.Remote {

    override fun searchRepository(
        query: String,
        success: (results: RepoSearchResponse) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubApi.searchRepository(query)
            .enqueue(object : Callback<RepoSearchResponse> {
                override fun onResponse(
                    call: Call<RepoSearchResponse>,
                    response: Response<RepoSearchResponse>
                ) {
                    response.body()?.let {
                        success(it)
                    } ?: fail(IllegalStateException())
                }

                override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                    fail(t)
                }
            })
    }

    override fun getRepoInfo(
        userName: String,
        repoName: String,
        success: (repo: GithubRepo) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubApi.getRepoInfo(userName, repoName)
            .enqueue(object : Callback<GithubRepo> {
                override fun onResponse(call: Call<GithubRepo>, response: Response<GithubRepo>) {
                    response.body()?.let {
                        success(it)
                    } ?: fail(IllegalStateException())
                }

                override fun onFailure(call: Call<GithubRepo>, t: Throwable) {
                    fail(t)
                }
            })
    }

    override fun getUserInfo(
        userName: String,
        success: (user: GithubUser) -> Unit,
        fail: (t: Throwable) -> Unit
    ) {
        githubApi.getUserInfo(userName)
            .enqueue(object : Callback<GithubUser> {
                override fun onResponse(call: Call<GithubUser>, response: Response<GithubUser>) {
                    response.body()?.let {
                        success(it)
                    } ?: fail(IllegalStateException())
                }

                override fun onFailure(call: Call<GithubUser>, t: Throwable) {
                    fail(t)
                }
            })
    }

}