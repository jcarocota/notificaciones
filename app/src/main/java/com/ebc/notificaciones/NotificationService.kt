package com.ebc.notificaciones

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.core.app.NotificationCompat
import kotlin.random.Random
import kotlin.random.nextInt

class NotificationService(private val context: Context) {

    private val notificationManager = context.getSystemService(
        NotificationManager::class.java)

    fun showBasicNotification() {
        val notification = NotificationCompat.Builder(
            context, "321"
        ).setContentTitle("Soy básica")
            .setContentText("Yo soy una notificación básica")
            .setSmallIcon(R.drawable.noti)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showLargeNotificacion() {
        val notification = NotificationCompat.Builder(
            context, "321"
        ).setContentTitle("Soy Grande")
            .setContentText("Yo soy una notificación grande")
            .setSmallIcon(R.drawable.noti)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat
                    .BigTextStyle()
                    .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc luctus tellus mi, et porta eros ornare ut. Phasellus ornare semper enim in posuere. Donec convallis magna erat, tincidunt posuere urna molestie feugiat. Nam tristique ut justo et gravida. Donec posuere, lacus vel mollis elementum, sem erat ultricies libero, non lobortis sapien ex ut urna. Mauris quis quam tempor, dictum elit sit amet, auctor lectus. Aenean ultricies nulla elementum porta venenatis. Curabitur bibendum porttitor eleifend. Aliquam vel lectus dolor. Mauris consectetur tempor diam. Integer laoreet nisl est, at ullamcorper nunc pretium eu. ")
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showInboxNotification() {
        val notification =
            NotificationCompat.Builder(context, "321")
                .setContentTitle("Inbox")
                .setContentText("Soy una notificación Inbox")
                .setSmallIcon(R.drawable.noti)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("Línea 1")
                        .addLine("Línea 2")
                        .addLine("Maxi")
                )
                .setAutoCancel(true)
                .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )

    }

    fun showImageNotificacion() {
        val image = context.bitmapFromResource(R.drawable.emoji)

        val notification =
            NotificationCompat.Builder(context, "321")
                .setContentTitle("Noti imagen")
                .setContentText("Notificación de imagen")
                .setSmallIcon(R.drawable.noti)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setLargeIcon(image)
                .setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(image)
                        .bigLargeIcon(null as Bitmap?)
                )
                .setAutoCancel(true)
                .build()
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )

}