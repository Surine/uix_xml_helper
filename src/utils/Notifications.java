package utils;

import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.awt.event.ActionEvent;

public class Notifications {
    public static void showNotification(AnActionEvent event, String displayId, String title, String message) {
        NotificationGroup noti = new NotificationGroup(displayId, NotificationDisplayType.BALLOON, true);
        noti.createNotification(
                title,
                message,
                NotificationType.INFORMATION,
                null
        ).notify(event.getProject());
    }
}
