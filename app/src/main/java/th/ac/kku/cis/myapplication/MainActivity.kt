package th.ac.kku.cis.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabase = FirebaseDatabase.getInstance().getReference("admin")

        button.setOnClickListener {
            val id = this.editText.text.toString()
            val password = this.editText2.text.toString()
            mDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val user = dataSnapshot.children.iterator()
                    if(user.hasNext()){
                        while (user.hasNext()){
                            val user = user.next().getValue() as HashMap<String, Any>
                            if (user.get("id") == id && user.get("pass") == password){
                                val intent = Intent(this@MainActivity, Main2Activity::class.java)
                                intent.putExtra("name",user.get("name") as String)
                                startActivity(intent)
                                editText.text=null
                                editText2.text=null
                            }
                        }
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                }
            })
        }
//        button.setOnClickListener {
//            startActivity(
//                    Intent(
//                            this, Main2Activity::class.java
//                    )
//            )
//        }

    }
}