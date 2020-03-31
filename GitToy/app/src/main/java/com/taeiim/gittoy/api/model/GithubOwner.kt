package com.taeiim.gittoy.api.model


import com.google.gson.annotations.SerializedName

data class GithubOwner(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("login")
    val name: String = "",
    @SerializedName("avatar_url")
    val profileImgUrl: String = ""
)