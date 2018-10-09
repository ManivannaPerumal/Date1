package com.example.devmachine_1.date1;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Fragment_Searchresult extends Fragment {

    String fromDate_String = "", toDate_String,hotelJSONtype_String,hotelDetails_String;

    // String loc;

    String jsons ="{\n" +
            "\t\"hotel-search-response\": {\n" +
            "\t\t\"search-criteria\": {\n" +
            "\t\t\t\"booking-date\": \"2018-09-19+05:30\",\n" +
            "\t\t\t\"check-in-date\": \"2018-09-20+05:30\",\n" +
            "\t\t\t\"check-out-date\": \"2018-09-21+05:30\",\n" +
            "\t\t\t\"number-of-rooms\": \"2\",\n" +
            "\t\t\t\"number-of-nights\": \"1\",\n" +
            "\t\t\t\"number-of-room-nights\": \"2\",\n" +
            "\t\t\t\"city\": \"Mumbai\",\n" +
            "\t\t\t\"state\": \"Maharashtra\",\n" +
            "\t\t\t\"country\": \"IN\"\n" +
            "\t\t},\n" +
            "\t\t\"currency\": \"INR\",\n" +
            "\t\t\"base-url\": \"/places/hotels\",\n" +
            "\t\t\"hotels\": {\n" +
            "\t\t\t\"hotel\": [\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"hotel-id\": \"41045\",\n" +
            "\t\t\t\t\t\"basic-info\": {\n" +
            "\t\t\t\t\t\t\"hotel-info-copyright\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"trust, trust, trust, trust, trust\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-name\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"The Lalit Mumbai\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"address\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Sahar Airport Road, Andheri East\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Andheri East-International Airport\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-id\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"425694\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-latitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"19.105343\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-longitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"72.875878\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"city\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Mumbai\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Maharashtra\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"India\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"IN\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"zip\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"400059\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"rate-info\": {\n" +
            "\t\t\t\t\t\t\t\"high-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"10336.25\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"low-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"9086.25\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"currency\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"INR\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"rate-disclaimer\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"communication-info\": {\n" +
            "\t\t\t\t\t\t\t\"phone\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"2266992222-Switch,2230673301-Switch,9004496910-Mobile\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"fax\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"+91 22 66998888\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"email\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"mumresv@thelalit.com-Work,mumdm@thelalit.com-Work,rahul.nair@cleartrip.com-Work,gnautiyal@thelalit.com-Work,npanvalkar@thelalit.com-Work,moak@thelalit.com-Work,paritoshs@thelalit.com-Work,soniag@thelalit.com-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"website\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"http://www.thelalit.com/the-lalit-mumbai-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"owner-name\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"chain\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"The Lalit Group\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"overview\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"thumb-nail-image\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-amenities\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-amenity\": [\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"General\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Front Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Security\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Air Conditioning\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doctor on Call\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doorman\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Housekeeping\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Internet\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Laundry\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"detailed-amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"name\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Laundry\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"chargeable\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"true\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"price-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"unit-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"misc-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Food & Beverage\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Banquet Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Bar\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Coffee Shop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Patisserie\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Restaurant\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"detailed-amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"name\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Banquet Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"chargeable\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"true\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"price-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"unit-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"misc-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Audio Visual Equipment\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Board Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Conference Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Convention Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Fax\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"LCD/Projector\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Meeting Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Photocopy\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"detailed-amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"chargeable\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"true\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"price-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"unit-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"misc-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Meeting Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"chargeable\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"true\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"price-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"unit-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"misc-info\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Front Desk Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Concierge\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Parking\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Pick & Drop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Porter\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Recreation\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Fitness Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Massage Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Nightclub\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Spa\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Babysitting\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-veg\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Unknown\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-on-hold\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-ratings\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-rating\": {\n" +
            "\t\t\t\t\t\t\t\t\"rating-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"STAR\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rating\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"5.0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"total-ratings\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"star-rating\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"5\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommendation\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-usp\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"notice\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommended\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"getaway-property\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"lth-hotel\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"faqs\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"restrictions\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-activities\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"view-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"supplier-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"4dea\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"27AAACB1298E1ZV\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"N\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_rate\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"0.0\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"room-rates\": {\n" +
            "\t\t\t\t\t\t\"room-rate\": {\n" +
            "\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\"room-type-code\": \"5255554:29942865318\",\n" +
            "\t\t\t\t\t\t\t\t\"room-description\": \"Lalit Premier Twin Bed Room Only\",\n" +
            "\t\t\t\t\t\t\t\t\"room-type-name\": \"Lalit Premier Room Twin Bed\",\n" +
            "\t\t\t\t\t\t\t\t\"room-type-id\": \"29942865318\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"31500.0\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"8820.0\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"booking-code\": \"5:33719:5255554|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-18+05:30\",\n" +
            "\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\"Breakfast\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Complimentary Two-Way Transfers Airport\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Complimentary stay for children under 10 without extra bed\",\n" +
            "\t\t\t\t\t\t\t\t\t\"All Applicable Taxes\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Inr 500 spa voucher per room per stay\",\n" +
            "\t\t\t\t\t\t\t\t\t\"No restaurants will be serving a la cart in the hotel on 31st dec 16\"\n" +
            "\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\"merged-rate-ids\": \"5255554\",\n" +
            "\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\"max-children\": \"2\",\n" +
            "\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"opaque\": \"false\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"hotel-id\": \"707594\",\n" +
            "\t\t\t\t\t\"basic-info\": {\n" +
            "\t\t\t\t\t\t\"hotel-info-copyright\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"expedia\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-name\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Holiday Inn Mumbai International Airport\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"address\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Near Sakinaka Metro Station, Sakinaka Junction, Andheri Kurla Road, Andheri East, Mumbai\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Andheri East-International Airport\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-id\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"425694\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-latitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"19.103089\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-longitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"72.887342\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"city\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Mumbai\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Maharashtra\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"India\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"IN\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"zip\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"400072\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"rate-info\": {\n" +
            "\t\t\t\t\t\t\t\"high-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"6760.23\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"low-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"6760.23\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"currency\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"INR\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"rate-disclaimer\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"communication-info\": {\n" +
            "\t\t\t\t\t\t\t\"phone\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"2240851800-Work,2261161800-Work,9004617753-Mobile\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"fax\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"email\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"reservations@himia.in-Work,sarvesh.yadav@ihg.com-Work,reservations.himia@ihg.com-Work,dm@himia.in-Work,team.mumbai@cleartrip.com-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"website\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"www.holidayinn.com-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"owner-name\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"chain\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Holiday Inn\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"overview\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"thumb-nail-image\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-amenities\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-amenity\": [\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"General\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Front Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Security\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Air Conditioning\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doctor on Call\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doorman\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Dry Cleaning\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Elevator\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Facilities for Differently Abled\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Housekeeping\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Interconnecting Rooms\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Internet\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Laundry\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Telephone Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Wake-up Call Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Food & Beverage\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Banquet Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Bar\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Coffee Shop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Lounge\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Restaurant\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Audio Visual Equipment\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Board Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Conference Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"LCD/Projector\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Meeting Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Photocopy\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Printer\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Front Desk Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Concierge\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Parking\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Pick & Drop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Porter\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Valet Parking\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Recreation\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Fitness Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Garden\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Gift Shop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Massage Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Sauna\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Spa\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Babysitting\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-veg\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Unknown\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-on-hold\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-ratings\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-rating\": {\n" +
            "\t\t\t\t\t\t\t\t\"rating-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"STAR\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rating\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"4.0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"total-ratings\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"star-rating\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"4\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommendation\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-usp\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"notice\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommended\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"getaway-property\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"lth-hotel\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"faqs\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"restrictions\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-activities\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"view-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"supplier-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"4dea\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"27AAACS5912L1Z6\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"N\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_rate\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"room-rates\": {\n" +
            "\t\t\t\t\t\t\"room-rate\": {\n" +
            "\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\"room-type-code\": \"5396526:358551\",\n" +
            "\t\t\t\t\t\t\t\t\"room-description\": \"Superior Room Room Only\",\n" +
            "\t\t\t\t\t\t\t\t\"room-type-name\": \"Superior Room\",\n" +
            "\t\t\t\t\t\t\t\t\"room-type-id\": \"358551\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"13711.111111111111\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"3839.1111111111113\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"booking-code\": \"5:33719:5396526|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-17+05:30\",\n" +
            "\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\"Breakfast\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\"Complimentary stay for children under 5 without extra bed\"\n" +
            "\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\"merged-rate-ids\": \"5396526\",\n" +
            "\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\"max-children\": \"1\",\n" +
            "\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"opaque\": \"false\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"hotel-id\": \"41003\",\n" +
            "\t\t\t\t\t\"basic-info\": {\n" +
            "\t\t\t\t\t\t\"hotel-info-copyright\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"chmm\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-name\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"The Orchid\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"address\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"70/C, Near Domestic Airport, Nehru road, Vile Parle (East)\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Domestic Airport\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-id\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"293787\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-latitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"19.0969741\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"locality-longitude\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"72.8548827\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"city\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Mumbai\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Maharashtra\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"state-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"India\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"country-code\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"IN\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"zip\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"400099\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"rate-info\": {\n" +
            "\t\t\t\t\t\t\t\"high-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"12624.35\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"low-rate\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"5959.83\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"currency\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"INR\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"rate-disclaimer\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"communication-info\": {\n" +
            "\t\t\t\t\t\t\t\"phone\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"2226164040-Work,9987573878-Mobile\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"fax\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"+91 22 26164141\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"email\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"resota@orchidhotel.com-Work,theo1237@staah.net-Work,resmgr@orchidhotel.com-Work,dm@orchidhotel.com-Work,cm@orchidhotel.com-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"website\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\"__text\": \"www.orchidhotel.com-Work\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"owner-name\": {\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"chain\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Kamat\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"overview\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"The Orchid is strategically located adjacent to the Domestic Airport and 3km from the International Airport. The hotel offers complimentary coach transfers to and from both the airports.\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"thumb-nail-image\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-amenities\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-amenity\": [\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"General\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Front Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Security\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Air Conditioning\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doctor on Call\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Doorman\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Dry Cleaning\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Elevator\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Housekeeping\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Interconnecting Rooms\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Internet\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Laundry\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Telephone Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Wake-up Call Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Food & Beverage\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"24 Hour Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Banquet Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Bar\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Coffee Shop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Lounge\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Patisserie\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Restaurant\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Room Service\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Audio Visual Equipment\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Board Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Business Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Conference Hall\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"LCD/Projector\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Meeting Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Front Desk Services\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Concierge\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Parking\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Pick & Drop\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Porter\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Travel Desk\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Valet Parking\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Recreation\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Fitness Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Jacuzzi\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Massage Centre\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Sauna\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Shopping Arcade\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Spa\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Steam Room\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"amenities\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"amenity\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"Kids Swimming Pool\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-veg\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Unknown\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"is-on-hold\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-ratings\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-rating\": {\n" +
            "\t\t\t\t\t\t\t\t\"rating-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"STAR\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rating\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"5.0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"total-ratings\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"0\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"star-rating\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"5\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommendation\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-usp\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"One of the pioneers of the eco-friendly initiative in the country, this hotel offers spacious interiors, aesthetically decked with elegant wooden d�cor. Being a stone's throw away from the airport, it is apt for busy corporate travellers and transit passengers.\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"notice\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Property Does Not Accept American Express Credit Card\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"ct-recommended\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"getaway-property\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"lth-hotel\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"false\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-themes\": {\n" +
            "\t\t\t\t\t\t\t\"hotel-theme\": {\n" +
            "\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"l\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"name\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\t\t\"__text\": \"Luxury\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"faqs\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"restrictions\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"hotel-activities\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"view-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"supplier-360\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"4dea\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"Y\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"gstin\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"27AAACK2912L1ZK\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_enabled\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"N\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"tds_rate\": {\n" +
            "\t\t\t\t\t\t\t\"__prefix\": \"hotel-info\",\n" +
            "\t\t\t\t\t\t\t\"__text\": \"0.0\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"room-rates\": {\n" +
            "\t\t\t\t\t\t\"room-rate\": [\n" +
            "\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-code\": \"155244:131984\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-description\": \"Deluxe Room (Room Only)\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-name\": \"Deluxe Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-id\": \"131984\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-282.3300000000001\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUPMKP\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-1599.87\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"19884.5\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"5040.644\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"booking-code\": \"5:33719:155244|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-18+05:30\",\n" +
            "\t\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"All Applicable Taxes\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Outside food, liquor and beverages will not be permitted in the hotel premises\"\n" +
            "\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"offers\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"offer\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"id\": \"-7456564\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"offer-message\": \"Book 72 hours before check-in and save 10%\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"merged-rate-ids\": \"155244\",\n" +
            "\t\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\t\"max-children\": \"2\",\n" +
            "\t\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-code\": \"76317:131984\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-description\": \"Deluxe Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-name\": \"Deluxe Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-id\": \"131984\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-411.72\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUPMKP\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-1646.88\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"21648.5\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"5485.172\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"booking-code\": \"5:33719:76317|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-18+05:30\",\n" +
            "\t\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Breakfast\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Complimentary Two-Way Transfers Domestic Airport Only for terminal 1A and 1B\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"All Applicable Taxes\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Outside food, liquor and beverages will not be permitted in the hotel premises\"\n" +
            "\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"offers\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"offer\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"id\": \"-7456564\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"offer-message\": \"Book 72 hours before check-in and save 10%\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"merged-rate-ids\": \"76317\",\n" +
            "\t\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\t\"max-children\": \"2\",\n" +
            "\t\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-code\": \"76319:327600\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-description\": \"ExecutiveRoom-CP\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-name\": \"Executive Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-id\": \"327600\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-326.43000000000006\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUPMKP\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-1849.77\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"22824.5\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"5781.524\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"booking-code\": \"5:33719:76319|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-18+05:30\",\n" +
            "\t\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Breakfast\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Complimentary Two-Way Transfers Domestic Airport Only for terminal 1A and 1B\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"All Applicable Taxes\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Outside food, liquor and beverages will not be permitted in the hotel premises\"\n" +
            "\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"offers\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"offer\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"id\": \"-7456564\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"offer-message\": \"Book 72 hours before check-in and save 10%\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"merged-rate-ids\": \"76319\",\n" +
            "\t\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\t\"max-children\": \"2\",\n" +
            "\t\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\"room-type\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-code\": \"80320:2679748\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-description\": \"Orchid Club Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-name\": \"Orchid Club Room\",\n" +
            "\t\t\t\t\t\t\t\t\t\"room-type-id\": \"2679748\"\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"rate-breakdown\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"rate\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"date\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"2018-09-20+05:30\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"pricing-elements\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"pricing-element\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-383.79\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUPMKP\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"DIS\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"-2174.81\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"BF\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"26648.5\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"category\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"TAX\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"amount\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"6745.1720000000005\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"code\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"__text\": \"SUP_IGST\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t\t\t\t],\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\t\t\"__prefix\": \"common\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"booking-code\": \"5:33719:80320|si-cbc23d4c-c317-4bdc-a5b6-591b381fa92b\",\n" +
            "\t\t\t\t\t\t\t\t\"provisional-booking-required\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"rate-type\": \"SELL\",\n" +
            "\t\t\t\t\t\t\t\t\"cancellation-start-time\": \"2018-09-18+05:30\",\n" +
            "\t\t\t\t\t\t\t\t\"inclusions\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"inclusion\": [\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Breakfast\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Complimentary Two-Way Transfers Domestic & International Airport\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Free Wi-Fi\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"All Applicable Taxes\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"Outside food, liquor and beverages will not be permitted in the hotel premises\"\n" +
            "\t\t\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"offers\": {\n" +
            "\t\t\t\t\t\t\t\t\t\"offer\": {\n" +
            "\t\t\t\t\t\t\t\t\t\t\"id\": \"-7456564\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\"offer-message\": \"Book 72 hours before check-in and save 10%\"\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\t\"currency_code\": \"INR\",\n" +
            "\t\t\t\t\t\t\t\t\"is-package\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"package-savings\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"post-pay\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"pah-cc\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"base-pkg-diff\": \"0.0\",\n" +
            "\t\t\t\t\t\t\t\t\"merged-rate-ids\": \"80320\",\n" +
            "\t\t\t\t\t\t\t\t\"base-rate-id\": \"0\",\n" +
            "\t\t\t\t\t\t\t\t\"is-special-rate\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"deal-of-the-day\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"opaque\": \"false\",\n" +
            "\t\t\t\t\t\t\t\t\"max-adults\": \"3\",\n" +
            "\t\t\t\t\t\t\t\t\"max-children\": \"2\",\n" +
            "\t\t\t\t\t\t\t\t\"max-gst-slab\": \"28.0\"\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"promo-offers\": {\n" +
            "\t\t\t\t\t\t\"promo-offer\": {\n" +
            "\t\t\t\t\t\t\t\"promo-id\": \"-7456564\",\n" +
            "\t\t\t\t\t\t\t\"offer-key\": \"chmm-offer\",\n" +
            "\t\t\t\t\t\t\t\"offer-value\": \"{\\\"hd\\\":\\\"Book 72 hours before check-in and save 10%\\\"}\",\n" +
            "\t\t\t\t\t\t\t\"desc\": \"Book 72 hours before check-in and save 10%\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"opaque\": \"false\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t\t\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"_xmlns\": \"http://www.cleartrip.com/hotel/hotel-search-response\",\n" +
            "\t\t\"_xmlns:hotel-info\": \"http://www.cleartrip.com/places/hotel-info\",\n" +
            "\t\t\"_xmlns:common\": \"http://www.cleartrip.com/hotel/common\"\n" +
            "\t}\n" +
            "}";
    ArrayList<HashMap<String, String>> contactList;
    FragmentTransaction fragmentTransaction;
    Fragment_hotel_Details mani;
    private ArrayList<HashMap<String, String>> history_list = new ArrayList<>();
    private RecyclerView hotelResult_recyclerview;
    String search_criteria_String ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_search_result, container, false);

        hotelResult_recyclerview = view.findViewById(R.id.ls);

         mani = new Fragment_hotel_Details();
        contactList = new ArrayList<>();
        assert this.getFragmentManager() != null;

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        hotelResult_recyclerview.setLayoutManager(mLayoutManager);

        try {

            Bundle bundle = this.getArguments();

            assert bundle != null;
            fromDate_String = bundle.getString("from_date");
            toDate_String = bundle.getString("to_date");

            if (!fromDate_String.equals("") && !toDate_String.equals("")) {

                Log.d("Process-2", "data_recived_throung_bundle_COMPLETE"+fromDate_String + toDate_String);
                new parse().execute("");

            } else {
                Log.d("Process-2", "data_recived_throung_bundle_EMPTY"+fromDate_String + toDate_String);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }


    private class parse extends AsyncTask<String, String, String> {

        JSONObject jsonObj = null;

        private ProgressDialog pDialog;
        String result, minRate_String, currencyType_String, baseUrl_String;
        String number_of_rooms, number_of_nights, number_of_room_nights, city ;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                OkHttpClient client = new OkHttpClient();

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.connectTimeout(5, TimeUnit.MINUTES)
                        .writeTimeout(5, TimeUnit.MINUTES)
                        .readTimeout(5, TimeUnit.MINUTES);

                client = builder.build();
              /*  client.setConnectTimeout(30, TimeUnit.SECONDS); // connect timeout
                clclient.setReadTimeout(30, TimeUnit.SECONDS);*/

                Request request = new Request.Builder()
                        .url("https://apistaging.cleartrip.com/hotels/1.0/search?check-in=" + fromDate_String + "&check-out=" + toDate_String + "&no-of-rooms=2&adults-per-room=2,1&children-per-room=1,0&city=Mumbai&state=Maharashtra&country=IN&scr=INR")
                        .get()
                        .addHeader("x-ct-api-key", "8d1687878487dfca44dbe79c3e2ccdb2")
                        .addHeader("x-ct-sourcetype", "API")
                        .addHeader("accept-encoding", "application/gzip")
                        .addHeader("Cache-Control", "no-cache")
                        .addHeader("Postman-Token", "1b283219-c8b4-4d70-803a-31d95d4793d1")
                        .build();




                Response response = client.newCall(request).execute();
                int code = response.code();
                Log.d("process-3","Service code"+String.valueOf(code));
                Log.d("Process-3", "GET_result _from_server_sucessfully");


                //  Response response = client.newCall(request).execute();
                try {
                    result = response.body().string();

                    Log.d("process-4", result);

                   if(code != 200) {




                       result = jsons;
                       Log.d("process-4", "inComplete with empty result"+result);

                   }
                   else{



                       jsonObj = XML.toJSONObject(result);

                       result = String.valueOf(jsonObj);


                       Log.d("process-4", "converting XML into JSON Complete");
                   }
                    //   String xml = XML.toString(jsonObj);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                JSONObject jo = new JSONObject(result);

              //  Log.d("manivanna11", String.valueOf(jo));


                JSONObject aA = jo.getJSONObject("hotel-search-response");

             //   Log.d("manivanna12", String.valueOf(aA));

                JSONObject sc = aA.getJSONObject("search-criteria");

                //   Log.d("manivanna13",String.valueOf(sc));

                search_criteria_String =String.valueOf(sc);

               /* booking_date = sc.optString("booking-date");
                check_in_date = sc.optString("check-in-date");
                check_out_date = sc.optString("check-out-date");
                number_of_rooms = sc.optString("number-of-rooms");
                number_of_nights = sc.optString("number-of-nights");
                number_of_room_nights = sc.optString("number-of-room-nights");
                city = sc.optString("city");
                state = sc.optString("state");
                country = sc.optString("country");*/

                currencyType_String = aA.optString("currency");
                baseUrl_String = aA.optString("base-url");


                JSONObject hotelz = aA.getJSONObject("hotels");


                JSONArray ja = hotelz.getJSONArray("hotel");


              //  JSONObject d = ja.getJSONObject(0);

              //  Log.d("firstjsonmani",String.valueOf(d));
              //  Log.d("firstjsonmani","mani");
//print logcat in large amount
              /*  int maxLogSize = 1000;
                for(int i = 0; i <= String.valueOf(d).length() / maxLogSize; i++) {
                    int start = i * maxLogSize;
                    int end = (i+1) * maxLogSize;
                    end = end > String.valueOf(d).length() ? String.valueOf(d).length() : end;
                    Log.v(TAG, String.valueOf(d).substring(start, end));
                }
*/

                for (int i = 0; i < ja.length(); i++) {

                    JSONObject c = ja.getJSONObject(i);


                    String hotel_id = c.optString("hotel-id");

                    JSONObject basic_info = c.getJSONObject("basic-info");


                    String hotel_name = basic_info.optString("hotel-info:hotel-name");
                    String locality = basic_info.optString("hotel-info:locality");


                    if (basic_info.has("hotel-info:rate-info")) {

                        JSONObject lowrate_ = basic_info.getJSONObject("hotel-info:rate-info");

                        minRate_String = lowrate_.optString("hotel-info:low-rate");
                    } else {
                        minRate_String = "0.00";
                    }
                    String rating;

                    if (basic_info.has("hotel-info:star-rating")) {

                         rating = basic_info.optString("hotel-info:star-rating");
                    } else {
                        rating = "0.00";
                    }




                    JSONObject room_rates =c.getJSONObject("room-rates");



                    String room_rate = room_rates.optString("room-rate");


                    //to find given data is josn object or array
                 /*   Object json = new JSONTokener(room_rate).nextValue();
                    if (json instanceof JSONObject){

                        hotelJSONtype_String ="JSONobject";

                        hotelDetails_String =room_rates.optString("room-rate");




                    }
                    //you have an object
                   else if (json instanceof JSONArray){

                JSONArray room_array =room_rates.getJSONArray("room-rate");


                        hotelDetails_String =String.valueOf(room_array);


                    }*/




                    HashMap<String, String> map_historydata = new HashMap<>();

                    map_historydata.put("name", hotel_name);
                    map_historydata.put("area", locality);
                    map_historydata.put("min_price", minRate_String);
                    map_historydata.put("rating", rating);
                    map_historydata.put("hotelid", hotel_id);
                     map_historydata.put("room_rates", room_rate);

                    history_list.add(map_historydata);


                    HashMap<String, String> contact = new HashMap<>();
                    contactList.add(contact);


                }

                Log.d("process-5", "data Addes to Arraylist-Completed");

            } catch (final JSONException e) {
                Log.d("error", String.valueOf(e));
                e.printStackTrace();
                // Log.e(TAG, "Json parsing error: " + e.getMessage());
               /* getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });*/
            }


            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pDialog.isShowing())
                pDialog.dismiss();

            tickets_adapter h_adapter = new tickets_adapter(getActivity(), history_list);

            hotelResult_recyclerview.setAdapter(h_adapter);
            Log.d("process-6","data addes to adapter from array_list --Complete");
        }
    }

    public class tickets_adapter extends RecyclerView.Adapter<tickets_adapter.ViewHolder> {
        public tickets_adapter(Context context, ArrayList<HashMap<String, String>> feedItemList) {


            history_list = feedItemList;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singledata, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            ViewCompat.setAlpha(viewHolder.itemView, 1);
            viewHolder.i = i;

            viewHolder.hotel_area.setText(history_list.get(i).get("area"));
            viewHolder.hotel_name.setText(history_list.get(i).get("name"));
            viewHolder.price.setText(history_list.get(i).get("min_price"));

            float rating = Float.parseFloat(history_list.get(i).get("rating"));
            viewHolder.star.setRating(rating);

            viewHolder.hotel_id.setText(history_list.get(i).get("hotelid"));
            viewHolder.hotel_rates.setText(history_list.get(i).get("room_rates"));


        }

        @Override
        public int getItemCount() {
            return history_list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
                implements View.OnCreateContextMenuListener, View.OnClickListener {

            final TextView hotel_area;
            final TextView hotel_name;
            final TextView hotel_id;
            final TextView price;
            final TextView hotel_rates;
            //  final ImageView image;
            final RatingBar star;
            public int i;
            String hotel_id_String;


            public ViewHolder(View itemView) {
                super(itemView);

                itemView.setOnClickListener(this);
                itemView.setOnCreateContextMenuListener(this);
                // image = itemView.findViewById(R.id.imageView);
                hotel_area = itemView.findViewById(R.id.hotel_area);
                hotel_name = itemView.findViewById(R.id.hotel_name);
                hotel_id = itemView.findViewById(R.id.hotel_data);
                hotel_rates = itemView.findViewById(R.id.hotel_rates);
                price = itemView.findViewById(R.id.price);
                star = itemView.findViewById(R.id.ratingBar);

            }


            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


            }


            @Override
            public void onClick(View v) {

                hotel_id_String = hotel_id.getText().toString();
                String hotel_rate = hotel_rates.getText().toString();

                Toast.makeText(getContext(), hotel_id_String, Toast.LENGTH_LONG).show();
               /* fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.hide(getFragmentManager().findFragmentByTag("searchFragment"));
                fragmentTransaction.add(R.id.content_frame, mani);*/
                Bundle args = new Bundle();
                args.putString("hotel_id", hotel_id_String);
                args.putString("hotel_rate", hotel_rate);
                args.putString("search_criteria_String", search_criteria_String);
                Log.d("Process-7",hotel_rate);


                mani.setArguments(args);

                ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.content_frame, mani)
                        .hide(new Fragment_Searchresult())
                        .addToBackStack(null)
                        .commit();

              /*  fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                Log.d("Process-7","Process complete and select hotel id and rate details were passed"+hotel_id_String);
                fragmentTransaction.commit();
*/



            }
        }
    }

    public void json() {

        try {
            JSONObject book = new JSONObject();
            book.put("affiliate-txn-id", "123456");
            book.put("nri", "false");
            book.put("hotel-id", "41045");
            book.put("check-in-date", "2018-09-06+05:30");
            book.put("check-out-date", "2018-09-07+05:30");
            book.put("number-of-rooms", "2");

            JSONArray adultNumber = new JSONArray();
            //  int numberOfRooms =String.valueOf(roomcount);
            adultNumber.put(2);
            adultNumber.put(1);
            book.put("adults-per-room", adultNumber);

            JSONArray childNumber = new JSONArray();
            //  int numberOfRooms =String.valueOf(roomcount);
            childNumber.put(1);
            childNumber.put(0);
            book.put("children-per-room", childNumber);


            book.put("booking-code", "5:33719:5255554|si-3f692ecc-6270-44f6-af10-42143b93a283");
            book.put("room-type-code", "5255554:29942865318");
            book.put("customer-ip-address", "127.0.0.1");
            book.put("booking-amount", "40320.0");

            JSONObject customerDetails = new JSONObject();
            customerDetails.put("title", "Mr");
            customerDetails.put("first-name", "Test");
            customerDetails.put("last-name", "User");
            customerDetails.put("street-address-1", "Main Road");
            customerDetails.put("city", "Bangalore");
            customerDetails.put("state", "Karnataka");
            customerDetails.put("country", "India");
            customerDetails.put("postal-code", "560078");
            customerDetails.put("mobile", "9000000009");
            customerDetails.put("email", "user@test.com");

            book.put("customer", customerDetails);

            JSONObject payment = new JSONObject();
            payment.put("payment-type", "DA");

            JSONObject accdetails = new JSONObject();
            accdetails.put("id", "44637404");
            accdetails.put("password", "");


            payment.put("deposit-account-detail", accdetails);


            book.put("payment", payment);

            JSONObject book_request = new JSONObject();
            book_request.put("book-request", book);

            String ss = String.valueOf(book_request);

            Log.d("manimanimani", ss);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}




