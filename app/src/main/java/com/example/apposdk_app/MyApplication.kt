package com.example.apposdk_app

import android.app.Application
import com.appotronics.appo_lib.AppoSDK
import com.appotronics.appo_lib.AuthResult
import com.appotronics.appo_lib.MessageResult
import com.appotronics.appo_lib.callback.AuthResponseCallback
import com.appotronics.appo_lib.engine.MqttLogUtils
import com.example.apposdk_app.utils.Utils

/**
 * @desc:
 * @author: yewei
 * @data: 2023/3/29 14:59
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        //f56d3bdd-a082-4852-89ec-6f3229e8df27  APPO-000007
//        APPO-000009 ----- e2f31628-d673-4fab-9b4b-7527e749ddf8
        AppoSDK.init(this, "admin", "public", "APPO-000009", "", object : AuthResponseCallback {
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