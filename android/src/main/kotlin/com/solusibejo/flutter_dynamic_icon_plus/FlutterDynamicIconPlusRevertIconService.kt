package com.solusibejo.flutter_dynamic_icon_plus

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class FlutterDynamicIconPlusRevertIconService: Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("IconRevertService", "Service started")
        return START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("IconRevertService", "Service created")
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.d("IconRevertService", "Task removed - reverting icon")
        ComponentUtil.revertToDefaultIcon(this, packageManager)

        super.onTaskRemoved(rootIntent)
        stopSelf()
    }

    override fun onDestroy() {
        Log.d("IconRevertService", "Service being destroyed - reverting icon")
        ComponentUtil.revertToDefaultIcon(this, packageManager)

        super.onDestroy()
        stopSelf()
    }
}