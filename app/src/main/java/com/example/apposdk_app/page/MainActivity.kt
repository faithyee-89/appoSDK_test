package com.example.apposdk_app.page

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSONObject
import com.appotronics.appo_lib.AppoSDK
import com.appotronics.appo_lib.callback.*
import com.appotronics.appo_lib.engine.MqttLogUtils
import com.appotronics.appo_lib.engine.QoS
import com.example.apposdk_app.R
import com.example.apposdk_app.bean.RequestBean
import com.example.apposdk_app.bean.ResponseBean

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appoResponse(null)
    }

    fun online(view: View?) {
        AppoSDK.clientOnline(object : ClientOnlineCallback {
            override fun onlineSuccess(gsn: String) {
                MqttLogUtils.i("客户端上线成功，获取到gsn == $gsn")
            }
        })
    }

    fun offline(view: View?) {
        AppoSDK.clientOffline(object : ClientOfflineCallback {
            override fun offlineSuccess() {
                MqttLogUtils.i("客户端下线成功")
            }
        })
    }

    fun appoSubscribe(view: View?) {
        AppoSDK.appoSubscribe("", QoS.AtLeastOnce, object : AppoSubscribeCallback {
            override fun response(json: String) {
                MqttLogUtils.i("tv_subscribe 客户端获取到json == $json")
            }
        })
    }

    fun appoResponse(view: View?) {
        AppoSDK.appoResponse(object : AppoResponseCallback {
            override fun response(json: String) {
                MqttLogUtils.i("tv_appoResponse 客户端获取到json == $json")
                val parseObject = JSONObject.parseObject(json, ResponseBean::class.java)
                if (parseObject != null) {
                    startApp(parseObject.type, parseObject.url, parseObject.contentName, parseObject.downUrl)
                }
            }
        })
    }

    fun cancelAppoSubscribe(view: View?) {
        AppoSDK.cancelAppoSubscribe("", object : AppoUnSubscribeCallback {
            override fun onSuccess() {
                MqttLogUtils.i("cancelAppoSubscribe subject success")
            }

            override fun onFail() {
                MqttLogUtils.i("cancelAppoSubscribe subject fail")
            }
        })
    }

    fun appoRequest(view: View?) {
        val toJSONString = JSONObject.toJSONString(RequestBean().apply {
            name = "翅膀唯美背景翅膀背景"
            url = "http://imgs.appoaiot.cn/video/20230322/16794701368582583"
            type = "0"
        })

        // toJSONString 内容为(示例)
        //        {
        //            "name": "翅膀唯美背景翅膀背景",
        //            "type": "0",
        //            "url": "http://imgs.appoaiot.cn/video/20230322/16794701368582583"
        //        }
        AppoSDK.appoRequest(toJSONString, object : AppoRequestCallback {
            override fun onSuccess() {
                MqttLogUtils.i("appoRequest onSuccess")
            }

            override fun onFail() {
                MqttLogUtils.i("appoRequest onFail")
            }
        })


    }

    private fun startApp(type: String, url: String, contentName: String, downUrl: String) {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("type", type)
        intent.putExtra("content", url)
        intent.putExtra("contentName", contentName)
        intent.putExtra("downUrl", downUrl)
        val componentName = ComponentName(
            "com.appotronics.appoplayer",
            "com.appotronics.appoplayer.activity.FullScreenActivity"
        )
        intent.component = componentName
        applicationContext.startActivity(intent)
    }
}