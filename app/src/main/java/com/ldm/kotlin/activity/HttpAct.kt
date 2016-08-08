package com.ldm.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.ldm.kotlin.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.async
import org.jetbrains.anko.ctx

/**
 * Kotlin中进行网络请求
 *记得在AndroidManifest.xml中添加INTENT权限
 * @author ldm
 * @description：
 * @date 2016-8-6 下午13:56:41
 */
class HttpAct : AppCompatActivity() {
    var url_01 = "your http url";
    var url_02 = "your http url";
    var kotlin_iv_one: ImageView? = null;
    var kotlin_iv_two: ImageView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        initViews();
    }

    fun initViews() {
        kotlin_iv_one = findViewById(R.id.kotlin_iv_one) as ImageView;
        kotlin_iv_two = findViewById(R.id.kotlin_iv_two) as ImageView;
    }

    fun httpRequest() {
        async() {//async函数用于在其它线程执行代码，也可以选择通过调用uiThread的方式回到主线程。
            //通过Picasso框架加载网络图片
            Picasso.with(ctx).load(url_01).into(kotlin_iv_one);
            Picasso.with(ctx).load(url_02).into(kotlin_iv_two);
            //Volley、KJFrameForAndroid、OKHttp等开发框架，在Kotlin语言下依旧能正常运行。
        }
    }
    //TODO
    //待断续完善在Kotlin中使用Volley
}
