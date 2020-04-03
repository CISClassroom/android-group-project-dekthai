package th.ac.kku.cis.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main5.*

class Main5Activity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        mDatabase = FirebaseDatabase.getInstance().reference
        mDatabase.orderByKey().addListenerForSingleValueEvent(itemListener)
    }
    var itemListener: ValueEventListener = object : ValueEventListener {

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // call function
            addDataToList(dataSnapshot.child("event"))
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Item failed, display log a message
            Log.w("MainActivity", "loadItem:onCancelled", databaseError.toException())
        }
    }
    fun addDataToList(dataSnapshot: DataSnapshot) {
        val id = getIntent().getExtras()!!.getString("id")
        val items = dataSnapshot.children.iterator()
        while (items.hasNext()) {
            val currentItem = items.next()
            val map = currentItem.getValue() as HashMap<String, Any>
            if(map.get("id")as String == id){
                textView18.text = "ชื่อ : "+map.get("name") as String?
                textView19.text = "รหัสนักศึกษา : "+map.get("id") as String?
                textView20.text = "กิจกรรม : "+map.get("event") as String?
                textView21.text = "จำนวนหน่วยกิจ : "+map.get("unit") as String?
                textView22.text = "ด้านที่ : "+map.get("side") as String?
            }
        }
    }
}
