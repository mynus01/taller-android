package com.matheussnd.taller

import android.app.Activity
import android.os.Bundle
import com.matheussnd.taller.databinding.ActivityWelcomeBinding

class WelcomeActivity : Activity() {
    private val binding: ActivityWelcomeBinding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
