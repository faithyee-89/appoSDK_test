package com.example.apposdk_app

import android.app.Application
import com.appotronics.appo_lib.AppoSDK
import com.appotronics.appo_lib.AuthResult
import com.appotronics.appo_lib.MessageResult
import com.appotronics.appo_lib.callback.AuthResponseCallback
import com.appotronics.appo_lib.engine.MqttLogUtils

/**
 * @desc:
 * @author: yewei
 * @data: 2023/3/29 14:59
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppoSDK.init(this, "admin", "public", "APPO-000006", "", object : AuthResponseCallback {
            override fun authRes(result: AuthResult, message: MessageResult, gsn: String) {
                when (result) {
                    AuthResult.AuthSuccess -> {
                        MqttLogUtils.i("deviceGsn = $gsn")
                        MqttLogUtils.i("connect success,MessageResult is ${message}")
                    }
                    AuthResult.AuthFail -> {
                        MqttLogUtils.e("connect fail,MessageResult is ${message}")
                    }
                }
            }
        })
    }
}