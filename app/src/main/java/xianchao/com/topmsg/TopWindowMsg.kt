package xianchao.com.topmsg

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import xianchao.com.topmsg.other.OnDestroyObserver

object TopWindowMsg {

    var window: PopupWindow? = null

    @Synchronized
    private fun getPopupWindow(context: Context): PopupWindow {
        if (window == null) {
            var contentView = LayoutInflater.from(context).inflate(R.layout.toast_layout, null)
            contentView.setBackgroundColor(Color.parseColor("#00FF00"))
            window = PopupWindow()
            window!!.contentView = contentView
            window!!.width = ViewGroup.LayoutParams.MATCH_PARENT
            window!!.height = ViewGroup.LayoutParams.WRAP_CONTENT
            window!!.isClippingEnabled = false
        }
        return window!!
    }

    fun show(activity: AppCompatActivity) {
        activity.lifecycle.addObserver(OnDestroyObserver {
            Log.e("addObserver", "OnDestroyObserver")
            window!!.dismiss()
        })
        getPopupWindow(activity.applicationContext).showAtLocation(activity.window.decorView, Gravity.NO_GRAVITY, 0, 0)

    }

    fun show(activity: AppCompatActivity, msg: String) {
        activity.lifecycle.addObserver(OnDestroyObserver {
            Log.e("addObserver", "OnDestroyObserver")
            getPopupWindow(activity).dismiss()
        })
        getPopupWindow(activity).contentView.findViewById<TextView>(R.id.text).text = msg
        getPopupWindow(activity.applicationContext).showAtLocation(activity.window.decorView, Gravity.NO_GRAVITY, 0, 0)

    }

    fun dismiss() {
        window!!.dismiss()
    }
}