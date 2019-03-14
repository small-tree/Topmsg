package xianchao.com.topmsg

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import xianchao.com.topmsg.other.Utils

class TopStyleToast(activity: Context, msg: String) {

    companion object {
        fun make(context: Context): TopStyleToast {
            return TopStyleToast(context, "test")
        }

        fun make(context: Context, msg: String): TopStyleToast {
            return TopStyleToast(context, msg)
        }
    }

    var toast: Toast

    init {
        toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.view = LayoutInflater.from(activity).inflate(R.layout.toast_layout, null)
        toast.view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;//设置Toast可以布局到系统状态栏的下面

        var mTN = Utils.getField(toast, "mTN")
        if (mTN != null) {
            var mParams = Utils.getField(mTN, "mParams")
            if (mParams != null
                    && mParams is WindowManager.LayoutParams) {
                var params = mParams
                //显示与隐藏动画
//                    params.windowAnimations = R.style.ClickToast;

                //设置viewgroup宽高
                params.width = WindowManager.LayoutParams.MATCH_PARENT; //设置Toast宽度为屏幕宽度
                params.height = WindowManager.LayoutParams.WRAP_CONTENT; //设置高度
            }
        }

    }

    fun show() {

        toast.show()
    }


}