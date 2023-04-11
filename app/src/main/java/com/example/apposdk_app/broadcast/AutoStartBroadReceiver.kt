package com.example.apposdk_app.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.appotronics.appo_lib.engine.MqttLogUtils
import com.example.apposdk_app.page.CarShowActivity
import com.example.apposdk_app.page.MainActivity

class AutoStartBroadReceiver : BroadcastReceiver() {
    private val BOOT_COMPLETED_ACTION = "android.intent.action.BOOT_COMPLETED"

    override fun onReceive(context: Context, intent: Intent) {
        MqttLogUtils.e("接收广播 onReceive: ")
        MqttLogUtils.e("广播 ： " + intent.getAction())
        if(BOOT_COMPLETED_ACTION.equals(intent.action)) {
            MqttLogUtils.e("触发开机启动广播")
            val intent = Intent(context, CarShowActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}