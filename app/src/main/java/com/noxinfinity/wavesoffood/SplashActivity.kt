package com.noxinfinity.wavesoffood

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.noxinfinity.wavesoffood.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.logo.setImageResource(R.drawable.logo)

        val nameGradient = LinearGradient(
            0f, 0f, binding.name.paint.measureText(binding.name.text.toString()), 0f,
            intArrayOf(
                Color.parseColor("#E85353"),
                Color.parseColor("#BE1515"),
            ),
            null, Shader.TileMode.CLAMP,
        )

        binding.name.paint.shader = nameGradient
        binding.watermark.paint.shader = LinearGradient(
            0f, 0f, binding.watermark.paint.measureText(binding.watermark.text.toString()), 0f,
            intArrayOf(
                Color.parseColor("#E85353"),
                Color.parseColor("#BE1515"),
            ),
            null, Shader.TileMode.CLAMP,
        )

        lifecycleScope.launch {
            delay(2000)

            val intent = Intent(this@SplashActivity, StartActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}