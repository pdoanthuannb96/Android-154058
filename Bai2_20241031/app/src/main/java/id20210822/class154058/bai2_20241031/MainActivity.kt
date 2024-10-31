package id20210822.class154058.bai2_20241031

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView

class MainActivity : ComponentActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var fullStudentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val listView: ListView = findViewById(R.id.listView)

        fullStudentList = listOf(
            Student("Từ Văn An", "20215522"),
            Student("Phạm Công An", "20215521"),
            Student("Lê Minh Việt Anh", "20210037"),
            Student("Trần Quang Anh", "20200047"),
            Student("Hoàng Anh", "20200015"),
            Student("Nguyễn Việt Anh", "20215308"),
            Student("Trương Đức Bình", "20215531"),
            Student("Phan Đình Can", "20210108"),
            Student("Bùi Mạnh Chiến", "20210118")
        )

        studentAdapter = StudentAdapter(this, fullStudentList)
        listView.adapter = studentAdapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.length > 2) {
                    val filteredList = fullStudentList.filter {
                        it.name.contains(query, ignoreCase = true) || it.studentId.contains(query, ignoreCase = true)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(fullStudentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
