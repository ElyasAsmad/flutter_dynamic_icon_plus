package com.solusibejo.flutter_dynamic_icon_plus

import android.app.Service
import android.content.Intent
import android.os.IBinder

class FlutterDynamicIconPlusRevertIconService: Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_NOT_STICKY

    override fun onTaskRemoved(rootIntent: Intent?) {
        ComponentUtil.revertToDefaultIcon(
            this,
            packageManager
        )

        super.onTaskRemoved(rootIntent)
        stopSelf()
    }

    override fun onDestroy() {
        ComponentUtil.revertToDefaultIcon(
            this,
            packageManager
        )

        super.onDestroy()
        stopSelf()
    }
}