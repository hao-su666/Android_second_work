package cn.edu.sicnu.cs.sjh.second_work

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // MVC模型实例
    private lateinit var model: ProgramModel
    // 动态TextView计数器
    private var tvCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化MVC模型
        model = ProgramModel()

        // ========== 功能区1：动态添加TextView ==========
        val llContainer: LinearLayout = findViewById(R.id.LinearLayout)
        val btnAddTv: Button = findViewById(R.id.Button1)

        btnAddTv.setOnClickListener {
            tvCount++
            val newTv = TextView(this)
            val content = getString(R.string.new_tv_prefix) + tvCount
            newTv.text = content
            newTv.textSize = 18f
            llContainer.addView(newTv)
        }

        // ========== 功能区2：MVC ProgramAdviser ==========
        val spLangSelect: Spinner = findViewById(R.id.Spinner)
        val btnQuery: Button = findViewById(R.id.Button2)
        val tvResult: TextView = findViewById(R.id.tvResult)

        // 下拉选项，全部从字符串资源读取
        val langList = arrayOf(
            getString(R.string.lang_apple),
            getString(R.string.lang_banana),
            getString(R.string.lang_panappl)
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, langList)
        spLangSelect.adapter = adapter

        btnQuery.setOnClickListener {
            val selectedLang = spLangSelect.selectedItem.toString()
            val result = model.getAdvise(selectedLang)
            tvResult.text = result
        }
    }
}
