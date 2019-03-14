package xianchao.com.topmsg

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import xianchao.com.topmsg.other.extFullStatusBar


class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var context: Context? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extFullStatusBar()
        setContentView(R.layout.activity_main)
        context = applicationContext
        button.setOnClickListener(this)
        button_pop.setOnClickListener(this)

        second_page.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> {
                TopStyleToast.make(this).show()
            }
            R.id.button_pop -> {
                TopWindowMsg.show(this)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}
