package id.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title, subject, body;
    private Button btnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        subject = findViewById(R.id.subject);
        body = findViewById(R.id.body);
        btnPush = findViewById(R.id.push);

        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titlePush = title.getText().toString().trim();
                String subjectPush = subject.getText().toString().trim();
                String bodyPush = body.getText().toString().trim();

                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new Notification.Builder(getApplicationContext())
                        .setContentTitle(titlePush)
                        .setContentText(bodyPush)
                        .setContentTitle(subjectPush)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .build();

                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);

                notification.flags |= Notification.FLAG_AUTO_CANCEL;

                manager.notify(0, notification);
                ringtone.play();
            }
        });
    }
}
