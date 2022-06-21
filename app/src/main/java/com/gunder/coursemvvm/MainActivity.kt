package com.gunder.coursemvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gunder.coursemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var scoreA = 0
    private var scoreB = 0
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
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_plus_score_team_a -> {
                addScoreA()
            }
            R.id.btn_minus_score_team_a -> {
                minScoreA()
            }
            R.id.btn_plus_score_team_b -> {
                addScoreB()
            }
            R.id.btn_minus_score_team_b -> {
                minScoreB()
            }
            R.id.btn_reset -> {
                resetScore()
            }
        }
    }

    private fun resetScore() {
        scoreA = 0
        scoreB = 0
        activityMainBinding.tvCardTeamA.text = scoreA.toString()
        activityMainBinding.tvCardTeamB.text = scoreB.toString()
    }

    private fun minScoreB() {
        scoreB -= 1
        activityMainBinding.tvCardTeamB.text = scoreB.toString()
    }

    private fun addScoreB() {
        scoreB += 1
        activityMainBinding.tvCardTeamB.text = scoreB.toString()
    }

    private fun minScoreA() {
        scoreA -= 1
        activityMainBinding.tvCardTeamA.text = scoreA.toString()
    }

    private fun addScoreA() {
        scoreA += 1
        activityMainBinding.tvCardTeamA.text = scoreA.toString()
    }
}