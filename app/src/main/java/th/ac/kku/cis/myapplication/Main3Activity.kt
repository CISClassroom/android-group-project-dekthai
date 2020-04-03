package th.ac.kku.cis.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        mDatabase = FirebaseDatabase.getInstance().reference

        button4.setOnClickListener {
            val name = name.text.toString()
            val id = id.text.toString()
            val event = event.text.toString()
            val unit = unit.text.toString()
            val side = side.text.toString()

            val eventmodel = eventmodel.create()
            val newItem = mDatabase.child("event").push()
            eventmodel.name=name
            eventmodel.id=id
            eventmodel.event = event
            eventmodel.unit = unit
            eventmodel.side = side
            newItem.setValue(eventmodel)
            Toast.makeText(this@Main3Activity,"เพิ่มเรียบร้อย", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
