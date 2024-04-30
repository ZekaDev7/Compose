package com.example.composelesson.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import com.example.composelesson.R
import com.example.composelesson.workmanager.MyWorker
import java.util.concurrent.TimeUnit

@Composable
fun NotificationMainPage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            createNotification(context)
        }) {
            Text(text = "Create notification")
        }

        Button(onClick = {
            //WorkManager
            val workCondition = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val request = OneTimeWorkRequestBuilder<MyWorker>()
                    .setInitialDelay(10, TimeUnit.SECONDS)
                .setConstraints(workCondition)
                    .build()
        }) {
            Text(text = "Do")
        }
    }
}

fun createNotification(context: Context) {
    val builder: NotificationCompat.Builder
    val managerNotification =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        val channelId = "channelId"
        val channelName = "channelName"
        val channelIntroducing = "channelIntroducing"
        val channelPriority = NotificationManager.IMPORTANCE_HIGH

        var channel: NotificationChannel? = managerNotification.getNotificationChannel(channelId)

        if (channel == null) {
            channel = NotificationChannel(channelId, channelName, channelPriority)
            channel.description = channelIntroducing
            managerNotification.createNotificationChannel(channel)
        }

        builder = NotificationCompat.Builder(context, channelId)
        builder.setContentTitle("Header")
            .setContentText("Content")
            .setSmallIcon(R.drawable.notifications)
            .setAutoCancel(true)

    } else {
        builder = NotificationCompat.Builder(context)
        builder.setContentTitle("Header")
            .setContentText("Content")
            .setSmallIcon(R.drawable.notifications)
            .setAutoCancel(true)
            .priority = Notification.PRIORITY_HIGH
    }

    managerNotification.notify(1, builder.build())
}