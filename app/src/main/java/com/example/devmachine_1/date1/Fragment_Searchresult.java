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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Fragment_Searchresult extends Fragment {

    String fromDate_String = "", toDate_String,hotelJSONtype_String,hotelDetails_String;

    // String loc;
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

                Log.d("Process-3", "GET_result _from_server_sucessfully");


                //  Response response = client.newCall(request).execute();
                try {
                    result = response.body().string();

                    Log.d("process-4", result);

                   if(result.isEmpty()) {

                       Log.d("process-4", "inComplete with empty result");
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

                    String rating = basic_info.optString("hotel-info:star-rating");




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




