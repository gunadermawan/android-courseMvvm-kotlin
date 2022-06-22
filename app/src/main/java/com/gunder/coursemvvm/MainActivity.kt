package com.gunder.coursemvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gunder.coursemvvm.databinding.ActivityMainBinding
import com.gunder.coursemvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        supportActionBar?.hide()
        activityMainBinding.btnPlusScoreTeamA.setOnClickListener(this)
        activityMainBinding.btnMinusScoreTeamA.setOnClickListener(this)
        activityMainBinding.btnPlusScoreTeamB.setOnClickListener(this)
        activityMainBinding.btnMinusScoreTeamB.setOnClickListener(this)
        activityMainBinding.btnReset.setOnClickListener(this)
//        init viewModel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initView()
    }

    private fun initView() {
//        used to observe value in variable
        mainViewModel.getScoreA().observe(this) {
//            when value was changed, it will be implenets to textView
            if (it != null) {
                activityMainBinding.tvCardTeamA.text = it.toString()
            }
        }
        mainViewModel.getScoreB().observe(this) {
            if (it != null) {
                activityMainBinding.tvCardTeamB.text = it.toString()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_plus_score_team_a -> {
                mainViewModel.addScoreA()
            }
            R.id.btn_minus_score_team_a -> {
                mainViewModel.minScoreA()
            }
            R.id.btn_plus_score_team_b -> {
                mainViewModel.addScoreB()
            }
            R.id.btn_minus_score_team_b -> {
                mainViewModel.minScoreB()
            }
            R.id.btn_reset -> {
                mainViewModel.resetScore()
            }
        }
    }
}