package com.matheussnd.taller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.matheussnd.taller.databinding.ActivityLoginBinding

class LoginActivity : Activity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setComponentsBehaviour()
    }

    private fun setComponentsBehaviour() {
        binding.apply {
            tilUsername.editText?.doOnTextChanged { _, _, _, _ ->
                checkFieldLength()
            }

            tilPassword.editText?.doOnTextChanged { _, _, _, _ ->
                checkFieldLength()
            }

            mbLogin.setOnClickListener {
                if (areCredentialsOk()) {
                    startActivity(
                        Intent(this@LoginActivity, WelcomeActivity::class.java).apply {
                            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }
                    )
                } else {
                    Toast.makeText(this@LoginActivity, getString(R.string.toast_login_error), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun isUsernameValid(): Boolean {
        val usernameField = binding.tilUsername.editText
        return usernameField != null && usernameField.text.equals(HARDCODED_USERNAME)
    }

    private fun isPasswordValid(): Boolean {
        val passwordField = binding.tilPassword.editText
        return passwordField != null && passwordField.text.equals(HARDCODED_PASSWORD)
    }

    private fun checkFieldLength() {
        binding.apply {
            val usernameField = tilUsername.editText
            val passwordField = tilPassword.editText

            val isUsernameOK = usernameField != null && usernameField.text.length > MIN_FIELD_SIZE
            val isPasswordOK = passwordField != null && passwordField.text.length > MIN_FIELD_SIZE

            mbLogin.isEnabled = isUsernameOK && isPasswordOK
        }
    }

    private fun areCredentialsOk() = isUsernameValid() && isPasswordValid()

    private companion object {
        const val HARDCODED_USERNAME = "username"
        const val HARDCODED_PASSWORD = "password"
        const val MIN_FIELD_SIZE = 0
    }
}
