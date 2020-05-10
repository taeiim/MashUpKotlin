package com.taeiim.gittoy.ui.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.taeiim.gittoy.R
import com.taeiim.gittoy.base.BaseActivity
import com.taeiim.gittoy.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val vm: DetailViewModel by viewModel()

    private val userName by lazy { intent?.getStringExtra("userName") ?: "" }
    private val repoName by lazy { intent?.getStringExtra("repoName") ?: "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
    }

    private fun setUp() {
        vm.setObserves()
        getDetailData()
    }

    private fun DetailViewModel.setObserves() {
        repo.observe(this@DetailActivity, Observer {
            binding.repo = it
            if (intent.getBooleanExtra("isSaveClickHistory", false))
                vm.saveRepoHistory()
        })
        user.observe(this@DetailActivity, Observer { binding.user = it })
    }

    private fun getDetailData() {
        vm.getRepoData(userName, repoName)
        vm.getUserData(userName)
    }

}