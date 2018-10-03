package com.example.devmachine_1.date1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devmachine_1.date1.Adaptor.MyPageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Fragment_hotel_Details extends Fragment implements View.OnClickListener {

    String hotelID_String = "", hotelRate_String;
    String requestJson_String, search_criteria_String, booking_Code;
    //   ArrayList<HashMap<String, String>> contactList;
    private ViewPager mPager;
    int room_price_INT = 0;
    String[] amenties_Array ;
    JSONArray hotelDAta_Array;
    TextView more_Room_cardView ;
    StringBuilder PostItems = new StringBuilder();
    Button hotelBooking_Button;
    String[] items_StringArray;

    LinearLayout mobileCall,amenties_list;
    RatingBar ratingBar;
    int pressed =0;
    String roomType_code,roomType_Name,room_Prices,room_TAXs;
    CirclePageIndicator indicator;
    TextView hotelName2, total_Amount, city,showMore_TextView, chckin, room_TAX, chekout, rooms, number_of_nights, number_of_room_nights, area, addresss, desc, room_Price, hotelservice, hotelname, hotelInfo, inclutions, room_Type, languag,languag_Title;
    LinearLayout hotelinfo, websiteURL, direction;
    String locality_latitude_String, locality_longitude_String, hotel_name_String;
   private ArrayList<String> hotel_ImagesArray = new ArrayList<>();
    private String websites_String;
    String JSONtype ="";
    int pos_int=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotel_details, container, false);


        // https://images-eu.ssl-images-amazon.com/images/I/41qepi7gKyL.jpg, https://images-eu.ssl-images-amazon.com/images/I/31saU2ypudL.jpg, https://images-eu.ssl-images-amazon.com/images/I/51O2kbNfhkL.jpg, null];

        websiteURL = view.findViewById(R.id.websites);
        mobileCall = view.findViewById(R.id.mobile);
        city = view.findViewById(R.id.city);
        amenties_list=view.findViewById(R.id.amenties_list);
        chckin = view.findViewById(R.id.checkin);
        chekout = view.findViewById(R.id.checkout);
        rooms = view.findViewById(R.id.numberofrooms);
        number_of_nights = view.findViewById(R.id.number_of_nights);
        number_of_room_nights = view.findViewById(R.id.number_of_room_nights);
        languag = view.findViewById(R.id.languages);
        languag_Title = view.findViewById(R.id.languages_title);
        area = view.findViewById(R.id.area2);
        more_Room_cardView =view.findViewById(R.id.Avail_more_room_ID);
        total_Amount = view.findViewById(R.id.total_amount);
        addresss = view.findViewById(R.id.address);
        desc = view.findViewById(R.id.desc);
        showMore_TextView = view.findViewById(R.id.show_more);
        mPager = view.findViewById(R.id.pager);
        inclutions = view.findViewById(R.id.mob);
        room_Type = view.findViewById(R.id.room_type);
        room_Price = view.findViewById(R.id.room_Price);
        hotelName2 = view.findViewById(R.id.hotelName);
        indicator = view.
                findViewById(R.id.indicator);
        direction = view.findViewById(R.id.location);
        ratingBar = view.findViewById(R.id.ratingBar);
        hotelInfo = view.findViewById(R.id.hotelinfo);
        room_TAX = view.findViewById(R.id.room_TAX);
        hotelinfo = view.findViewById(R.id.hotelinfo2);
        hotelservice = view.findViewById(R.id.hotelservice);
        hotelBooking_Button = view.findViewById(R.id.hotelBooking_Button);



        more_Room_cardView.setVisibility(View.GONE);
        try {

            Bundle bundle = this.getArguments();

            assert bundle != null;
            hotelID_String = bundle.getString("hotel_id");
            hotelRate_String = bundle.getString("hotel_rate");
            search_criteria_String = bundle.getString("search_criteria_String");
            Log.d("Process-8", hotelRate_String);
            assert hotelID_String != null;

            if (!hotelID_String.equals("")) {

                Object json = new JSONTokener(hotelRate_String).nextValue();
                if (json instanceof JSONObject) {
                    JSONtype ="JSONObject";
                }
                else{
                    JSONtype ="JSONArray";

                    more_Room_cardView.setVisibility(View.VISIBLE);
                }

                new parse().execute("getHotelinfo");
                //  Log.d("",hotelRate_String);
            }


        } catch (Exception e) {
            e.printStackTrace();
           Log.d("Process-8", String.valueOf(e));
        }


        hotelInfo.setOnClickListener(this);
        more_Room_cardView.setOnClickListener(this);
        mobileCall.setOnClickListener(this);
        websiteURL.setOnClickListener(this);
        direction.setOnClickListener(this);
        amenties_list.setOnClickListener(this);
        showMore_TextView.setOnClickListener(this);
        hotelBooking_Button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.hotelinfo:
                if (hotelinfo.getVisibility() == View.VISIBLE) {
                    hotelinfo.setVisibility(View.GONE);
                } else {
                    hotelinfo.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.location:
                String uri = "http://maps.google.com/maps?q=loc:" + locality_latitude_String + "," + locality_longitude_String + " (" + hotel_name_String + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

                break;
            case R.id.show_more:



                if(pressed ==0){

                    desc.setMaxLines(Integer.MAX_VALUE); //As in the android sourcecode
                    desc.setEllipsize(null);
                    showMore_TextView.setText("Show less");
                 pressed =1;
                }
                else{
                    desc.setMaxLines(2);
                    pressed=0;
                    showMore_TextView.setText("Show More");
                    desc.setEllipsize(TextUtils.TruncateAt.END);
                }



                break;

            case R.id.amenties_list:


                AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setTitle("Amenties");
                builder3.setItems(amenties_Array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        String s = amenties_Array[item];
                     /*   String number = s.replaceAll("[^0-9]", "");*/
                        Log.d("Amenties", s);
                    /*    Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + s));
                        startActivity(callIntent);*/

                        //   Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
                    }
                });
                builder3.show();


                break;

            case R.id.mobile:

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Mobile Number");
                builder.setItems(items_StringArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        String s = items_StringArray[item];
                        String number = s.replaceAll("[^0-9]", "");
                        Log.d("mobile num", number);
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + number));
                        startActivity(callIntent);

                        //   Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();

                break;

            case R.id.websites:
                if (websites_String.isEmpty()) {
                    Toast.makeText(getActivity(), "No website Avail", Toast.LENGTH_LONG).show();
                } else {
                    Uri uri2 = Uri.parse("http://" + websites_String); // missing 'http://' will cause crashed
                    Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                    startActivity(intent2);
                }
                break;

            case R.id.hotelBooking_Button:

                new parse().execute("hotelBooking");
                break;

            case R.id.Avail_more_room_ID:

                int pos = hotelDAta_Array.length();
                 String[] items = new String[pos];
                for(int i=0;i<pos ;i++ ){
                    
                   items[i] = String.valueOf(i);
                   
                }

              

                AlertDialog.Builder builders = new AlertDialog.Builder(getActivity());
                builders.setTitle("Select");
                builders.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                       // dialog.dismiss();

                        new parse().execute("Multiple_Rooms");
                        pos_int =item;
                        Toast.makeText(getContext(),String.valueOf(item),Toast.LENGTH_SHORT).show();
                    }
                });
                builders.show();

                break;


        }
    }


    private class parse extends AsyncTask<String, Object, String> {

        String resultValue_String;
        private ProgressDialog pDialog;
        String  chechINdate, checkOUTdate, numberOFrooms, numberOF_roomNights, numberOF_nights, cityName;
        ArrayList amenties = new ArrayList();

        JSONObject jsonObj = new JSONObject();
        String hotelid, locality, location, star_rating, min_price, address, description, facilities, mobnumber;
        private String email, number_of_room;
        private String resultString_switch, hotelJSONtype_String;
        JSONObject hotelData_Object;




        StringBuilder languages = new StringBuilder();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected String doInBackground(String... strings) {


            String s = String.valueOf(strings[0]);



            switch (s) {

                case "getHotelinfo":

                    try {

                        OkHttpClient client = new OkHttpClient();

                        Request request = new Request.Builder()
                                .url("http://www.cleartrip.com/places/hotels/info/" + hotelID_String)
                                .get()
                                .addHeader("x-ct-api-key", "8d1687878487dfca44dbe79c3e2ccdb2")
                                .addHeader("x-ct-sourcetype", "API")
                                .addHeader("accept-encoding", "application/gzip")
                                .addHeader("Cache-Control", "no-cache")
                                .addHeader("Postman-Token", "7e8f29da-1072-446c-850b-4ef482bbeed4")
                                .build();

                        Response response = client.newCall(request).execute();


                        try {
                            resultValue_String = response.body().string();

                            jsonObj = XML.toJSONObject(resultValue_String);

                            resultValue_String = String.valueOf(jsonObj);

                            //  Log.d("JsonResponse",ss);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        try {

                            JSONObject reslt = new JSONObject(resultValue_String);

                            JSONObject reslts = reslt.getJSONObject("hotel-info");

                            Log.d("JsonResponse", String.valueOf(reslts));

                            hotelid = reslts.optString("hotel-id");

                            JSONObject basic_info = reslts.getJSONObject("basic-info");

                            if (basic_info.has("hotel-name")) {
                                hotel_name_String = basic_info.optString("hotel-name");

                                Log.d("manivannaaaaa", hotel_name_String);
                                // hotelName2.setText(basic_info.optString("hotel-name"));
                            }
                            if (basic_info.has("locality")) {

                                locality = basic_info.optString("locality");
                            }

                            if (basic_info.has("address")) {
                                address = basic_info.optString("address");
                            }
                            if (basic_info.has("star-rating")) {
                                star_rating = basic_info.optString("star-rating");


                            }
/*
                            if (basic_info.has("hotel-amenities")) {
                                star_rating = basic_info.optString("hotel-amenities");



                            }*/

                            locality_latitude_String = basic_info.optString("locality-latitude");
                            locality_longitude_String = basic_info.optString("locality-longitude");

                            JSONObject communication_info = basic_info.getJSONObject("communication-info");
                            mobnumber = communication_info.optString("phone");
                            email = communication_info.optString("email");
                            websites_String = communication_info.optString("website");

                            JSONObject hotel_amenties = basic_info.getJSONObject("hotel-amenities");

                            JSONArray hotel_amentie = hotel_amenties.getJSONArray("hotel-amenity");



                            for(int ii =0; ii < hotel_amentie.length() ; ii++){



                                Log.d("amenties__",String.valueOf(hotel_amentie.length()));

                                JSONObject  amenities_Object = hotel_amentie.getJSONObject(ii);

                                JSONObject amenities =amenities_Object.getJSONObject("amenities");

                                Log.d("JSONObject_amenties", String.valueOf(amenities));

                                String json_amenties =amenities.optString("amenity");

                                Object json = new JSONTokener(json_amenties).nextValue();

                                 if (json instanceof JSONArray) {
                                    JSONArray amenity = amenities.getJSONArray("amenity");

                                    for (int i2 = 0; i2 < amenity.length(); i2++) {


                                        amenties.add(amenity.getString(i2));

                                        Log.d("amenties__", String.valueOf(amenties));


                                    }

                                }

                                 else if (json instanceof JSONObject) {
                                    JSONObject amenity =amenities.getJSONObject("amenity");

                                    amenties.add(String.valueOf(amenity));
                                    Log.d("JSONObject_amenties", String.valueOf(amenity));
                                }

                            }

                            amenties_Array = new String[amenties.size()];
                            amenties_Array = (String[]) amenties.toArray(amenties_Array);



                            JSONObject rate = basic_info.getJSONObject("rate-info");
                            min_price = rate.optString("low-rate");


                            JSONObject other_info = reslts.getJSONObject("other-info");
                            description = other_info.optString("description");
                            facilities = other_info.optString("facilities");
                            number_of_room = other_info.optString("number-of-rooms");

                            if (other_info.has("staff-speaks")) {
                                JSONObject staff_speaks = other_info.getJSONObject("staff-speaks");
                                JSONObject language = staff_speaks.getJSONObject("languages");

                                JSONArray lang = language.getJSONArray("language");

                                String arr[] = new String[lang.length()];

                                for (int i = 0; i < lang.length(); i++) {

                                    arr[i] = lang.getString(i);

                                    languages.append("\n\u29BF ");
                                    languages.append(arr[i]);
                                    languages.append("\n");

                                }

                            }else{
                                languages.append("NA");

                            }

                            JSONObject img = other_info.getJSONObject("image-info");

                            JSONArray imgs = img.getJSONArray("image");

                            //   Log.d("arrayarray", String.valueOf(imgs));


                            for (int i = 0; i < imgs.length(); i++) {


                                JSONObject c = imgs.getJSONObject(i);

                                //     Log.d("array2", String.valueOf(c));
                                hotel_ImagesArray.add("http://ui.cltpstatic.com/places/hotels" + c.optString("wide-angle-image-url"));
                                Log.d("image_Array", String.valueOf(hotel_ImagesArray));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    //search criteria details

                    try {

                        JSONObject search_criteria = new JSONObject(search_criteria_String);

                        cityName = search_criteria.optString("city");
                        chechINdate = search_criteria.optString("check-in-date");
                        checkOUTdate = search_criteria.optString("check-out-date");
                        numberOFrooms = search_criteria.optString("number-of-rooms");
                        numberOF_nights = search_criteria.optString("number-of-nights");
                        numberOF_roomNights = search_criteria.optString("number-of-room-nights");


                        Log.d("search_criteria_String", String.valueOf(search_criteria));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    //room rates based on object or array

                    try {


                        if (JSONtype.equals("JSONObject")) {

                            hotelData_Object = new JSONObject(hotelRate_String);

                            Log.d("JsonObject", String.valueOf(hotelData_Object));


                            JSONObject room_type = hotelData_Object.optJSONObject("room-type");
                            roomType_code = room_type.optString("room-type-code");
                            String room_Description = room_type.optString("room-description");
                            roomType_Name = room_type.optString("room-type-name");
                            booking_Code = hotelData_Object.optString("booking-code");
                            JSONObject rate_breakDown = hotelData_Object.optJSONObject("rate-breakdown");
                            JSONObject common_rate = rate_breakDown.optJSONObject("common:rate");
                            JSONObject common_pricing_elements = common_rate.optJSONObject("common:pricing-elements");
                            JSONArray common_pricing_element = common_pricing_elements.optJSONArray("common:pricing-element");

                            JSONObject c1 = common_pricing_element.getJSONObject(0);

                            room_Prices = c1.optString("common:amount");

                            JSONObject c2 = common_pricing_element.getJSONObject(1);

                            room_TAXs = c2.optString("common:amount");


                            //calculating total monet with tax

                            for (int i = 0; i < common_pricing_element.length(); i++) {

                                JSONObject c = common_pricing_element.getJSONObject(i);

                                int price = c.optInt("common:amount");

                                room_price_INT = room_price_INT + price;

                            }


                            Log.d("room_price_INT2", String.valueOf(room_price_INT));


                            //getting inclution list of the hotel

                            JSONObject inclusions = hotelData_Object.optJSONObject("inclusions");

                           // Log.d("arrayvalue-1", String.valueOf(inclusions));

                            String inclu = inclusions.optString("inclusion");

                           // Log.d("arrayvalue-2", String.valueOf(inclu));

                            Object json2 = new JSONTokener(inclu).nextValue();
                            if (json2 instanceof JSONArray) {

                                JSONArray inclusion_array = new JSONArray(inclu);


                              //  Log.d("arrayvalue-3", "jsonArray");

                                int length =inclusion_array.length();

                                String s2[] = new String[length];


                                for (int i = 0; i < length; i++) {

                                    s2[i] = inclusion_array.getString(i);
                                    Log.d("arrayvalue", s2[i]);
                                    Log.d("arrayvalue", String.valueOf(inclusion_array.length()));

                                    PostItems.append("\n\u29BF ");
                                    PostItems.append(s2[i]);
                                    PostItems.append("\n");


                                }

                            } else {
                                PostItems.append(inclu);
                            }


                        }

                        //price details in array


                        else if (JSONtype.equals("JSONArray")) {

                            hotelDAta_Array = new JSONArray(hotelRate_String);

                            int num =hotelDAta_Array.length();

                            for (int i = 0; i <num ; i++){

                                JSONObject hotelData_Object = hotelDAta_Array.getJSONObject(i);

                            }



                            array_Price_selection(0);
                            // for single data temporary


                            // for single data


                            Log.d("JsonARRAY", String.valueOf(hotelDAta_Array));

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    resultString_switch = "hotelDetailsSearch";
                    break;


                case "hotelBooking":

                    json();

                    try {
                        OkHttpClient client = new OkHttpClient();

                        MediaType mediaType = MediaType.parse("application/xml");
                        RequestBody body = RequestBody.create(mediaType, requestJson_String);
                        Request request = new Request.Builder()
                                .url("https://apistaging.cleartrip.com/hotels/1.0/book")
                                .post(body)
                                .addHeader("x-ct-api-key", "8d1687878487dfca44dbe79c3e2ccdb2")
                                .addHeader("x-ct-sourcetype", "API")
                                .addHeader("accept-encoding", "application/gzip")
                                .addHeader("Content-Type", "application/xml")
                                .addHeader("Cache-Control", "no-cache")
                                .addHeader("Postman-Token", "d2f2e7c7-26e0-4252-b14a-c9ba39d0f604")
                                .build();

                        Response response = client.newCall(request).execute();

                        try {
                            resultValue_String = response.body().string();

                            jsonObj = XML.toJSONObject(resultValue_String);

                            resultValue_String = String.valueOf(jsonObj);

                            //  Log.d("JsonResponse",ss);
                            Log.d("final_output", resultValue_String);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    resultString_switch = "bookingStatus";
                    break;

                case "Multiple_Rooms":


                    try {

                        array_Price_selection(pos_int);
                        resultString_switch = "Multiple_Rooms";
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

            }


            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pDialog.isShowing())
                pDialog.dismiss();


            switch (resultString_switch) {

                case "hotelDetailsSearch":


                    hotelName2.setText(hotel_name_String);
                    city.setText(cityName);
                    rooms.setText(numberOFrooms);
                    area.setText(locality);
                    addresss.setText(address);
                    chckin.setText(chechINdate);
                    chekout.setText(checkOUTdate);
                    number_of_nights.setText(numberOF_nights);

                    if(String.valueOf(languages).equals("NA")){
                        languag.setVisibility(View.GONE);
                        languag_Title.setVisibility(View.GONE);
                    }else {
                        languag.setText(languages);
                    }

                    room_Price.setText(room_Prices);
                    desc.setText(description);


                    room_Type.setText(roomType_Name);
                    number_of_room_nights.setText(numberOF_roomNights);
                    hotelservice.setText(facilities);
                    inclutions.setText(PostItems);
                    if (!mobnumber.equals("")) {
                        String data = mobnumber;
                        items_StringArray = data.split(",");
                        for (String item : items_StringArray) {
                          

                            Log.d("item=== ", item);
                        }
                    }
                    total_Amount.setText(String.valueOf(room_price_INT));


                    try {
                        Float rating = Float.parseFloat(star_rating.trim());

                        ratingBar.setRating(rating);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    room_TAX.setText(room_TAXs);

                    Log.d("image_Array_new", String.valueOf(hotel_ImagesArray));
                    pagerinit();

                    break;

                case "bookingStatus":


                    Toast.makeText(getActivity(), resultValue_String, Toast.LENGTH_LONG).show();

                    break;

               case "Multiple_Rooms":

                   // array_Price_selection(pos_int);




                   room_Price.setText(room_Prices);
                  // desc.setText(description);
                   room_Type.setText(roomType_Name);
                 //  number_of_room_nights.setText(numberOF_roomNights);
                 //  hotelservice.setText(facilities);
                   inclutions.setText(PostItems);

                   total_Amount.setText(String.valueOf(room_price_INT));


                   room_TAX.setText(room_TAXs);
                  // pagerinit();


                    break;


            }
        }
    }


    private void pagerinit() {


        mPager.setAdapter(new MyPageAdapter(getActivity(), hotel_ImagesArray));


        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);

        //  int NUM_PAGES = IMAGES_StringArray.length;

        // Auto start of viewpager
   /*     final Handler handler = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);*/

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                //  int currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    public void json() {

        try {
            JSONObject book = new JSONObject();
            book.put("affiliate-txn-id", "123456");
            book.put("nri", "false");
            book.put("hotel-id", hotelID_String);
            book.put("check-in-date", chckin.getText().toString());
            book.put("check-out-date", chekout.getText().toString());
            book.put("number-of-rooms", rooms.getText().toString());

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


            book.put("booking-code", booking_Code);
            book.put("room-type-code", roomType_code);
            book.put("customer-ip-address", "127.0.0.1");
            book.put("booking-amount", room_price_INT);

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

            //   book.put("@_xmlns","http://www.cleartrip.com/hotel/book-request");


            JSONObject book_request = new JSONObject();
            book_request.put("book-request", book);

            Log.d("BeforeJSON", String.valueOf(book_request));

            String xml = XML.toString(book_request);


            String name = "<book-request xmlns=\"http://www.cleartrip.com/hotel/book-request\">";
            requestJson_String = xml.replaceAll("<book-request>", name);

            Log.d("AfterJSON", requestJson_String);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void array_Price_selection(int pos) {

        try {


            JSONObject hotelData_Object = hotelDAta_Array.getJSONObject(pos);
            JSONObject room_type = hotelData_Object.optJSONObject("room-type");
            roomType_code = room_type.optString("room-type-code");
            String room_Description = room_type.optString("room-description");
            roomType_Name = room_type.optString("room-type-name");
            booking_Code = hotelData_Object.optString("booking-code");
            JSONObject rate_breakDown = hotelData_Object.optJSONObject("rate-breakdown");
            JSONObject common_rate = rate_breakDown.optJSONObject("common:rate");
            JSONObject common_pricing_elements = common_rate.optJSONObject("common:pricing-elements");
            JSONArray common_pricing_element = common_pricing_elements.optJSONArray("common:pricing-element");

            JSONObject c1 = common_pricing_element.getJSONObject(0);

            room_Prices = c1.optString("common:amount");

            JSONObject c2 = common_pricing_element.getJSONObject(1);

            room_TAXs = c2.optString("common:amount");

            for (int i = 0; i < common_pricing_element.length(); i++) {

                JSONObject c = common_pricing_element.getJSONObject(i);

                int price = c.optInt("common:amount");

                room_price_INT = room_price_INT + price;


            }
            Log.d("room_price_INT2", String.valueOf(room_price_INT));

            JSONObject inclusions = hotelData_Object.optJSONObject("inclusions");

            Log.d("arrayvalue-1", String.valueOf(inclusions));

            String inclu = inclusions.optString("inclusion");

            Log.d("arrayvalue-2", String.valueOf(inclu));

            Object json2 = new JSONTokener(inclu).nextValue();

            if (json2 instanceof JSONArray) {

                JSONArray inclusion_array = new JSONArray(inclu);


                Log.d("arrayvalue-3", "jsonArray");
                String s2[] = new String[inclusion_array.length()];


                for (int i = 0; i < inclusion_array.length(); i++) {

                    s2[i] = inclusion_array.getString(i);
                    Log.d("arrayvalue", s2[i]);
                    Log.d("arrayvalue", String.valueOf(inclusion_array.length()));

                    PostItems.append("\n\u29BF ");
                    PostItems.append(s2[i]);
                    PostItems.append("\n");


                }

            } else {
                PostItems.append(inclu);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

