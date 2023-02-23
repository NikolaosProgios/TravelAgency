package com.myapp.travelagency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class AgencyActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyDB myAppDatabase;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        //Navigation tool bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.profil:
                    menuItem.setChecked(true);
                    displayMessage("Profile");
                    drawerLayout.closeDrawers();
                    fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new AgencyFragment()).addToBackStack(null).commit();
                    createNotification("Profile", "Here You Can Seen Your Info");
                    return true;
                case R.id.location:
                    menuItem.setChecked(true);
                    displayMessage("Map");
                    drawerLayout.closeDrawers();
                    fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new MapsFragment()).addToBackStack(null).commit();
                    return true;
                case R.id.edit:
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new MenuFragment()).addToBackStack(null).commit();
                    createNotification("DataBase", "Here You Can Edit Local Data Base");
                    return true;
                case R.id.logout:
                    menuItem.setChecked(true);
                    displayMessage("logout");
                    drawerLayout.closeDrawers();
                    sharedPreferenceConfig.writeLoginStatus(false);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    createNotification("TNTeam", "Just LogOut, Login Again");
                    finish();
                    return true;
                case R.id.about:
                    menuItem.setChecked(true);
                    displayMessage("About");
                    drawerLayout.closeDrawers();
                    fragmentManager.beginTransaction().
                            replace(R.id.fragment_container, new AboutFragment()).addToBackStack(null).commit();
                    return true;
                case R.id.exit:
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    createNotification("TNTeam", "Just Finish All Activity, Have a nice day!");
                    finishAffinity();
                    return true;
            }
            return false;
        });

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class, "reservesBD").allowMainThreadQueries().build();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().
                    add(R.id.fragment_container, new AgencyFragment()).commit();
        }
    }

    void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void createNotification(String title, String description) {

        String id = "my_apk";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null) {
                channel = new NotificationChannel(id, "Channel Title", NotificationManager.IMPORTANCE_HIGH);
                //config nofication channel
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