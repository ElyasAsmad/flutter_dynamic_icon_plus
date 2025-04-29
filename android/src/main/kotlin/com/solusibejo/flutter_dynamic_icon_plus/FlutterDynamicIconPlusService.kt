package com.solusibejo.flutter_dynamic_icon_plus

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class FlutterDynamicIconPlusService: Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("IconService", "Service started")
        return START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("IconService", "Service created")
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.d("IconService", "Task removed - changing icon")
        ComponentUtil.changeAppIcon(this, packageManager, packageName)
        ComponentUtil.removeCurrentAppIcon(this)

        super.onTaskRemoved(rootIntent)
        stopSelf()
    }

    override fun onDestroy() {
        Log.d("IconService", "Service being destroyed - changing icon")
        ComponentUtil.changeAppIcon(this, packageManager, packageName)
        ComponentUtil.removeCurrentAppIcon(this)

        super.onDestroy()
        stopSelf()
    }
}