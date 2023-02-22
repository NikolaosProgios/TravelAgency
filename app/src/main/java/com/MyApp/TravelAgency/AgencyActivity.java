
package com.MyApp.TravelAgency;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class AgencyActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;    public static MyDB myAppDatabase;
    Toolbar toolbar;    DrawerLayout drawerLayout;    NavigationView navigationView;
    private sharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);

        sharedPreferenceConfig=new sharedPreferenceConfig(getApplicationContext());

        //Navigation tool bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profil:
                        menuItem.setChecked(true);
                        displayMessage("Profil");
                        drawerLayout.closeDrawers();
                        fragmentManager.beginTransaction().
                                replace(R.id.fragment_container, new AgencyFragment()).addToBackStack(null).commit();
                        createNotif("Profil","Here You Can Seen Your Info");
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
                        //displayMessage("Edit Agencys");
                        drawerLayout.closeDrawers();
                        fragmentManager.beginTransaction().
                                replace(R.id.fragment_container, new menuFragment()).addToBackStack(null).commit();
                        createNotif("DataBase","Here You Can Edit Local Data Base");
                        return true;
                    case R.id.logout:
                        menuItem.setChecked(true);
                        //displayMessage("logout");
                        drawerLayout.closeDrawers();
                        sharedPreferenceConfig.writeLoginStatus(false);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        createNotif("TNTeam","Just LogOut, Login Again");
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
                        //displayMessage("Close app");
                        drawerLayout.closeDrawers();
                        createNotif("TNTeam","Just Finish All Activity, Have a nice day!");
                        finishAffinity();
                        return true;
                }
                return false;
            }
        });
        // Data Base
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class,"reservesBD").allowMainThreadQueries().build();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().
                    add(R.id.fragment_container, new AgencyFragment()).commit();
        }
    }

    void displayMessage(String message) { Toast.makeText(this, message, Toast.LENGTH_LONG).show(); }

    private void createNotif(String Title, String Description) {

        String id = "my_apk";
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
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
        Intent notificationIntent = new Intent(this, NoficationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.ihu_mini)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_mini))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_large))
                        .bigLargeIcon(null))
                .setContentTitle(Title)
                .setContentText(Description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100, 1000, 200, 340})
                .setAutoCancel(false) //true touch on notificaiton menu dismissed, but swipe to dismiss
                .setTicker("Notification");
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(getApplicationContext());
        //id o generate new notification in tlist notification
        m.notify(5, builder.build());
    }
}