package sg.edu.rp.c300.uniqueidauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static String uniqueID = null;
    private static final String UKEY = "uniquekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPrefs = getSharedPreferences(
                UKEY, Context.MODE_PRIVATE);

        String androidId = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.d("UKEY", androidId);

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(UKEY, uniqueID);
        editor.commit();


    }

}
