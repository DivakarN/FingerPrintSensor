package com.sysaxiom.fingerprintsensor

import android.app.Activity
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import java.util.concurrent.Executors

fun Activity.ApiLevel29(){
    val executor = Executors.newSingleThreadExecutor()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
        val biometricPrompt =  BiometricPrompt.Builder(this)
            .setTitle("Unlock FingerPrintSensor")
            .setDescription("Confirm your screen lock pattern, PIN or password")
            .setDeviceCredentialAllowed(true)
            .build()

        biometricPrompt.authenticate(CancellationSignal(),executor,object: BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }
        })

    }
    else {
        TODO("VERSION.SDK_INT < Q")
    }

}