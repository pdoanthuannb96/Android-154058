package id20210822.class154058.bai1_20241031

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edtNumber: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnShow: Button
    private lateinit var listViewResult: ListView
    private lateinit var tvError: TextView
    private lateinit var resultAdapter: ArrayAdapter<String>
    private val resultList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber = findViewById(R.id.edtNumber)
        radioGroup = findViewById(R.id.radioGroup)
        btnShow = findViewById(R.id.btnShow)
        listViewResult = findViewById(R.id.listViewResult)
        tvError = findViewById(R.id.tvError)

        resultAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
        listViewResult.adapter = resultAdapter

        btnShow.setOnClickListener {
            val input = edtNumber.text.toString()
            tvError.visibility = View.GONE
            resultList.clear()

            if (input.isEmpty()) {
                tvError.visibility = View.VISIBLE
                tvError.text = "Vui lòng nhập số n"
                return@setOnClickListener
            }

            val n = input.toIntOrNull()
            if (n == null || n < 0) {
                tvError.visibility = View.VISIBLE
                tvError.text = "Số n không hợp lệ"
                return@setOnClickListener
            }

            when (radioGroup.checkedRadioButtonId) {
                R.id.radioOption1 -> {
                    for (i in 0..n step 2) {
                        resultList.add(i.toString())
                    }
                }
                R.id.radioOption2 -> {
                    for (i in 1..n step 2) {
                        resultList.add(i.toString())
                    }
                }
                R.id.radioOption3 -> {
                    var i = 0
                    while (i * i <= n) {
                        resultList.add((i * i).toString())
                        i++
                    }
                }
                else -> {
                    tvError.visibility = View.VISIBLE
                    tvError.text = "Vui lòng chọn một tùy chọn"
                }
            }
            resultAdapter.notifyDataSetChanged()
        }
    }
}
