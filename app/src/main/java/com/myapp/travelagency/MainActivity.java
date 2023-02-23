package com.myapp.travelagency;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    public static MyDB myAppDatabase;
    public static FragmentManager fragmentManager;
    public static FirebaseFirestore firestoreDB;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private SharedPreferenceConfig sharedPreferencesConf;
    TextInputEditText agencyLoginId, agencyLoginName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        /*  Local DataBase */
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),
                        MyDB.class, "local_DataBase").
                fallbackToDestructiveMigration().allowMainThreadQueries().build();

        /*  Remote DataBase  */
        firestoreDB = FirebaseFirestore.getInstance();

        /*  Navigation tool bar */
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                //For delete or create a new activity with Login in toolbar
                case R.id.exit:
                    menuItem.setChecked(true);
                    displayMessage("Close app");
                    drawerLayout.closeDrawers();
                    createNotification("TNTeam", "Just Finish All Activity");
                    finishAffinity();
                    return true;
            }
            return false;
        });

        sharedPreferencesConf = new SharedPreferenceConfig(getApplicationContext());
        agencyLoginId = findViewById((R.id.agency_login_id));
        agencyLoginName = findViewById(R.id.agency_login_name);
        if (sharedPreferencesConf.readLoginStatus()) {
            startActivity(new Intent(this, AgencyActivity.class));
            finish();
        }
    }

    public void loginAgency(View view) {
        String varId = agencyLoginId.getText().toString();
        String varName = agencyLoginName.getText().toString();
        if (varId.equals(getResources().getString(R.string.agency_id)) && varName.equals(getResources().getString(R.string.agency_name))) {
            createNotification("TNTeam", "Login success");
            startActivity(new Intent(this, AgencyActivity.class));
            sharedPreferencesConf.writeLoginStatus(true);
            finish();
        } else {
            Toast.makeText(this,
                    "Loging Failed! Check input data and Try again ", Toast.LENGTH_LONG).show();
            agencyLoginId.setText("");
            agencyLoginName.setText("");
        }
    }

    void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_LONG).show();
    }

    private void createNotification(String title, String description) {

        String id = "my_apk";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null) {
                channel = new NotificationChannel(id, "Channel Title", NotificationManager.IMPORTANCE_HIGH);
                //config notification channel
                channel.setDescription("[Channel description]");
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{100, 1000, 200, 340});
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                manager.createNotificationChannel(channel);
            }
        }
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.ihu_mini)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_mini))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_large))
                        .bigLargeIcon(null))
                .setContentTitle(title)
                .setContentText(description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100, 1000, 200, 340})
                .setAutoCancel(false) //true touch on notification menu dismissed, but swipe to dismiss
                .setTicker("Notification");
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(getApplicationContext());
        //id o generate new notification in tList notification
        m.notify(5, builder.build());
    }
}
