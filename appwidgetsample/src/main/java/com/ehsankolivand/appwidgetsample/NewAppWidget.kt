package com.ehsankolivand.appwidgetsample

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.DateFormat
import java.util.*


/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    companion object{
         const val mSharedPrefFile = "com.example.android.appwidgetsample"
         const val COUNT_KEY = "count"
    }


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }


}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    val prefs = context.getSharedPreferences(
        "com.example.android.appwidgetsample", 0
    )
    var count = prefs.getInt("count$appWidgetId", 0)
    count++

    val dateString: String = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
     views.setTextViewText(R.id.appwidget_id, appWidgetId.toString())

    views.setTextViewText(R.id.appwidget_update,
        context.resources.getString(
            R.string.date_count_format, count, dateString));

    val prefEditor = prefs.edit()
    prefEditor.putInt("count$appWidgetId", count)
    prefEditor.apply()

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}