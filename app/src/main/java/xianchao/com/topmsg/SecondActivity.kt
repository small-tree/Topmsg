package xianchao.com.topmsg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_second.*
import xianchao.com.topmsg.other.extFullStatusBar

class SecondActivity : AppCompatActivity() {

    companion object {
        const val PARAMETER_TYPE = "PARAMETER_TYPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extFullStatusBar()

        setContentView(R.layout.activity_second)

        toast_button.setOnClickListener {
            TopStyleToast.make(this@SecondActivity, "toast msg").show()
            finish()
        }

        popup_button.setOnClickListener {
            TopWindowMsg.show(this, "popupwindow msg")
            Handler().postDelayed({
                TopWindowMsg.dismiss()
                finish()
            }, 2000)
        }
    }
}
