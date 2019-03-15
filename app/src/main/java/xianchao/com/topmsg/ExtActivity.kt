package xianchao.com.basiclib.extension

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager

public inline fun Activity.extStartActivity(activity: Class<out Activity>) {
    val intent = Intent(this, activity)
    this.startActivity(intent)
}

public inline fun Activity.extStartActivity(activity: Class<out Activity>, bundle: Bundle) {
    val intent = Intent(this, activity)
    intent.putExtras(bundle)
    this.startActivity(intent)
}

public inline fun Activity.extFullStatusBar() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}