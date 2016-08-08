package com.ldm.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ldm.kotlin.R
import com.ldm.kotlin.adapter.FirstKotlinAdapter

/**
 * Kotlin中使用RecycleView
 *
 * @author ldm
 * @description：
 * @date 2016-8-4 下午16:54:29
 */
class RecycleViewAct : AppCompatActivity() {
    //定义一个集合变量，并赋值
    private val items = listOf("Kotlin DEMO数据1",
            "Kotlin DEMO数据21/8", "Kotlin DEMO数据17",
            "Kotlin DEMO数据111", "Kotlin DEMO数据1",
            "Kotlin DEMO数据1", "Kotlin DEMO数据17")

    //实现onCreate(）方法，关键字“fun”
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyle)
        //	findViewByid()的方式初始化RecyclerView
        val recycle_view = findViewById(R.id.recycle_view) as RecyclerView;
        //实例化LinearLayoutManager对象，LinearLayoutManager(this)创建了一个对象的实例
        //对象实例化也是与Java中有些不同。如你所见，我们去掉了	new	关键 字。
        recycle_view.layoutManager = LinearLayoutManager(this);
        //初始化Adapter并设置数据
        recycle_view.adapter = FirstKotlinAdapter(items);
    }
}
