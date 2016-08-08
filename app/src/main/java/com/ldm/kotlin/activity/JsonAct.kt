package com.ldm.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.webkit.URLUtil
import com.google.gson.Gson
import com.ldm.kotlin.R
import com.ldm.kotlin.adapter.ResultBean
import org.jetbrains.anko.*
import java.net.URL

/**
 * Kotlin中解析Json数据及转换成对应实体类
 *记得在AndroidManifest.xml中添加INTENT权限
 * @author ldm
 * @description：
 * @date 2016-8-6 上午10:12:16
 */
class JsonAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //仍然通过代码实现布局
        val verticalLayout = verticalLayout {
            padding = dip(16)
            //定义一个TextView，仅仅提供文字说明
            val textview = textView() {
                textResource = R.string.json_tips
                setTextSize(16f)
            }.lparams {
                width = wrapContent
                height = wrapContent
                topMargin = dip(10)
            }
            //再定义一个EditText
            var editText = editText() {
                //设置EditText的输入提示
                hintResource = R.string.edit_hint;
            }.lparams(width = matchParent) {
                height = wrapContent
                topMargin = dip(10)
            }
            //定义一个Button,来发起json数据请求
            button("点击试试") {
                onClick {
                    val url = editText.text;
                    //判断是不是Http格式的url
                    if (!TextUtils.isEmpty(url.toString()) && URLUtil.isHttpUrl(url.toString())) {//这个if是java代码
                        //获取到对应数据的实体Bean
                        val bean = execute(url.toString())
                        Log.d("json_test", bean.toString())
                    }
                }
            }.lparams(width = matchParent) {
                height = wrapContent
                topMargin = dip(10)
            }.setTextSize(16f)
            //定义一个TextView,需要的时候可以把请求的json展示出来
            var result_tv = textView() {
                //把解析的数据放在TextView中
//                text = getJson(editText.text.toString())
//                Log.d("json_test", text)
            }.lparams() {
                width = wrapContent
                height = wrapContent
                topMargin = dip(10)
            }
        }

    }

    /**
     * 网络请求获取到json数据
     */
    fun getJson(url: String): String {
        //通过URL(url).readText()一句代码即可获取到url中对应的json数据
        val forecastJsonStr = URL(url).readText()
        //通过Gson解析json数据到对应实体类中
        return forecastJsonStr.toString();
    }
    //**使用Gjson需要在build.gradle中增加你需要的Gson相关依赖，比如：
    // compile "com.google.code.gson:gson:2.4"
    /**
     * 网络请求获取到json数据并转换成对应实体数据
     */
    fun execute(url: String): ResultBean {
        //通过URL(url).readText()一句代码即可获取到url中对应的json数据
        val forecastJsonStr = URL(url).readText()
        //通过Gson解析json数据到对应实体类中,实体类中的字段必须和json返回的对应字段一致
        return Gson().fromJson(forecastJsonStr, ResultBean::class.java)
    }
    //**使用Gjson需要在build.gradle中增加你需要的Gson相关依赖，比如：
    // compile "com.google.code.gson:gson:2.4"
}
