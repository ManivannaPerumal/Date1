package com.example.devmachine_1.date1;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String message = "<mani> is inviting you. </mani>";
        String name = "Diana";
        String result = message.replaceAll("<mani>", name);

        Log.d("output_mani_android",result);

        try {
            loadFragment(new FragmentHome());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private boolean loadFragment(FragmentHome fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_SHORT).show();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
