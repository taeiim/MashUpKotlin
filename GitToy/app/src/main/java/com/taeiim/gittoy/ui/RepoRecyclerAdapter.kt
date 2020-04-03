package com.taeiim.gittoy.ui

import android.content.Context
import androidx.databinding.ViewDataBinding
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseRecyclerAdapter
import com.taeiim.gittoy.base.BaseRecyclerViewHolder
import com.taeiim.gittoy.ext.start
import com.taeiim.gittoy.ui.detail.DetailActivity

class RepoRecyclerAdapter<ITEM : Any, B : ViewDataBinding>(
    private val context: Context,
    private val isSaveClickHistory: Boolean,
    layout: Int,
    bindingVariableId: Int
) : BaseRecyclerAdapter<ITEM, B>(layout, bindingVariableId) {


    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<B>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.itemView.setOnClickListener {
            context.start(DetailActivity::class) {
                putString("userName", (getItem(position) as GithubRepo).owner.name)
                putString("repoName", (getItem(position) as GithubRepo).name)
                putBoolean("isSaveClickHistory", isSaveClickHistory)
            }
        }
    }

}