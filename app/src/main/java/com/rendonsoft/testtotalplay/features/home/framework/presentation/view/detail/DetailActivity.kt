package com.rendonsoft.testtotalplay.features.home.framework.presentation.view.detail

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rendonsoft.testtotalplay.databinding.ActivityDetailBinding
import com.rendonsoft.testtotalplay.utils.extensions.loadUrl

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initView() {
        setSupportActionBar(binding.mtToobar)
        val support = supportActionBar
        support?.setDisplayHomeAsUpEnabled(true)

        val nameCountry = intent.getStringExtra("nameCountry")
        val urlFlag = intent.getStringExtra("flag")

        binding.apply {
            ivFlag.loadUrl(urlFlag ?: "")
            tvNameCountry.text = nameCountry
        }
    }
}