package th.ac.kku.cis.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = getIntent().getExtras()!!.getString("name")
        textView5.text = "ADMIN : " + name

        button2.setOnClickListener {
            val intent = Intent(this@Main2Activity, Main3Activity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@Main2Activity, Main4Activity::class.java)
            startActivity(intent)
        }
    }
}
