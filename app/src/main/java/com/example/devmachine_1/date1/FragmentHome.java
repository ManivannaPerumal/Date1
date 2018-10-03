package com.example.devmachine_1.date1;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentHome extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    int adultCountRoom1 = 1,childCountRoom1 = 0,adultCountRoom2 = 1,childCountRoom2 = 0,adultCountRoom3 = 1,childCountRoom3 = 0,adultCountRoom4 = 1,childCountRoom4 = 0;
    FragmentTransaction fragmentTransaction ;
    TextView adultRoom1_displayText,childRoom1_displayText,adultRoom2_displayText,childRoom2_displayText,adultRoom3_displayText,childRoom3_displayText,adultRoom4_displayText,childRoom4_displayText,roomCount_textview;
    ImageButton increaseAdultCount1,decreaseAdultCount1,increaseChildCount1,decreaseChildCount1,increaseAdultCount2,decreaseAdultCount2,increaseChildCount2,decreaseChildCount2,
            increaseAdultCount3,decreaseAdultCount3,increaseChildCount3,decreaseChildCount3,increaseAdultCount4,decreaseAdultCount4,increaseChildCount4,decreaseChildCount4;
    Spinner roomCount_Spinner;
    EditText cityName_Edittext,fromDate_EditText,toDate_EditText;
    LinearLayout room1View_Layout,room2View_Layout,room3View_Layout,room4View_Layout;
    String  dateValue_String;
    LinearLayout childAgeLayout_Room_1x1,childAgeLayout_Room_1x2,childAgeLayout_Room_1x3,childAgeLayout_Room_1x4,childAgeLayout_Room_2x1,childAgeLayout_Room_2x2,childAgeLayout_Room_2x3,
            childAgeLayout_Room_2x4,childAgeLayout_Room_3x1,childAgeLayout_Room_3x2,childAgeLayout_Room_3x3,childAgeLayout_Room_3x4,
            childAgeLayout_Room_4x1,childAgeLayout_Room_4x2,childAgeLayout_Room_4x3,childAgeLayout_Room_4x4;
    Button searchHotel_Buttom;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        adultRoom1_displayText = view.findViewById(R.id.integer1);
         childRoom1_displayText = view.findViewById(R.id.integer_number2);
         adultRoom2_displayText = view.findViewById(R.id.integer3);
         childRoom2_displayText = view.findViewById(R.id.integer_number4);
         adultRoom3_displayText = view.findViewById(R.id.integer5);
         childRoom3_displayText = view.findViewById(R.id.integer_number6);
        adultRoom4_displayText = view.findViewById(R.id.integer7);
        childRoom4_displayText = view.findViewById(R.id.integer_number8);

        roomCount_Spinner =view.findViewById(R.id.roomspinner);
        roomCount_textview =view.findViewById(R.id.spinneritem);
        cityName_Edittext =view.findViewById(R.id.city);
        fromDate_EditText =view.findViewById(R.id.fromdate);
        toDate_EditText =view.findViewById(R.id.todate);

        childAgeLayout_Room_1x1 =view.findViewById(R.id.child11);
        childAgeLayout_Room_1x2 =view.findViewById(R.id.child12);
        childAgeLayout_Room_1x3 =view.findViewById(R.id.child13);
        childAgeLayout_Room_1x4 =view.findViewById(R.id.child14);
        searchHotel_Buttom =view.findViewById(R.id.submit);

        childAgeLayout_Room_2x1 =view.findViewById(R.id.child21);
        childAgeLayout_Room_2x2 =view.findViewById(R.id.child22);
        childAgeLayout_Room_2x3 =view.findViewById(R.id.child23);
        childAgeLayout_Room_2x4 =view.findViewById(R.id.child24);

        childAgeLayout_Room_3x1 =view.findViewById(R.id.child31);
        childAgeLayout_Room_3x2 =view.findViewById(R.id.child32);
        childAgeLayout_Room_3x3 =view.findViewById(R.id.child33);
        childAgeLayout_Room_3x4 =view.findViewById(R.id.child34);

        childAgeLayout_Room_4x1 =view.findViewById(R.id.child41);
        childAgeLayout_Room_4x2 =view.findViewById(R.id.child42);
        childAgeLayout_Room_4x3 =view.findViewById(R.id.child43);
        childAgeLayout_Room_4x4 =view.findViewById(R.id.child44);


        increaseAdultCount1 =view.findViewById(R.id.increase1);
        decreaseAdultCount1 =view.findViewById(R.id.decrease1);
        increaseChildCount1 =view.findViewById(R.id.increase2);
        decreaseChildCount1 =view.findViewById(R.id.decrease2);
        increaseAdultCount2 =view.findViewById(R.id.increase3);
        decreaseAdultCount2 =view.findViewById(R.id.decrease3);
        increaseChildCount2 =view.findViewById(R.id.increase4);
        decreaseChildCount2 =view.findViewById(R.id.decrease4);
        increaseChildCount3 =view.findViewById(R.id.increase6);
        decreaseChildCount3 =view.findViewById(R.id.decrease6);
        increaseAdultCount3 =view.findViewById(R.id.increase5);
        decreaseAdultCount3 =view.findViewById(R.id.decrease5);
        increaseAdultCount4 =view.findViewById(R.id.increase7);
        decreaseAdultCount4 =view.findViewById(R.id.decrease7);
        increaseChildCount4 =view.findViewById(R.id.increase8);
        decreaseChildCount4 =view.findViewById(R.id.decrease8);

        room1View_Layout =view.findViewById(R.id.room1);
        room2View_Layout =view.findViewById(R.id.room2);
        room3View_Layout =view.findViewById(R.id.room3);
        room4View_Layout =view.findViewById(R.id.room4);

        fragmentTransaction = this.getFragmentManager().beginTransaction();

        increaseAdultCount1.setOnClickListener(this);
        decreaseAdultCount1.setOnClickListener(this);
        increaseChildCount1.setOnClickListener(this);
        decreaseChildCount1.setOnClickListener(this);
        increaseAdultCount2.setOnClickListener(this);
        decreaseAdultCount2.setOnClickListener(this);
        increaseChildCount2.setOnClickListener(this);
        decreaseChildCount2.setOnClickListener(this);
        increaseChildCount3.setOnClickListener(this);
        decreaseChildCount3.setOnClickListener(this);
        increaseAdultCount3.setOnClickListener(this);
        decreaseAdultCount3.setOnClickListener(this);
        increaseAdultCount4.setOnClickListener(this);
        decreaseAdultCount4 .setOnClickListener(this);
        increaseChildCount4.setOnClickListener(this);
        decreaseChildCount4.setOnClickListener(this);
        fromDate_EditText.setOnClickListener(this);
        toDate_EditText.setOnClickListener(this);
        searchHotel_Buttom.setOnClickListener(this);
        cityName_Edittext.setOnClickListener(this);
        roomCount_Spinner.setOnItemSelectedListener(this);
        childRoom1_displayText.addTextChangedListener(generalTextWatcher1);
        childRoom2_displayText.addTextChangedListener(generalTextWatcher1);
        childRoom3_displayText.addTextChangedListener(generalTextWatcher1);
        childRoom4_displayText.addTextChangedListener(generalTextWatcher1);
        roomCount_textview.addTextChangedListener(generalTextWatcher2);


        return view;
    }

    private TextWatcher generalTextWatcher1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            if(adultCountRoom1 <=4 && adultCountRoom1 >=1) {
                increaseAdultCount1.setClickable(true);
                decreaseAdultCount1.setClickable(true);
            }
             if(childCountRoom1 <=4 && childCountRoom1 >=0){
                 increaseChildCount1.setClickable(true);
                 decreaseChildCount1.setClickable(true);

                if(childCountRoom1 ==1){
                    childAgeLayout_Room_1x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x2.setVisibility(View.GONE);
                    childAgeLayout_Room_1x3.setVisibility(View.GONE);
                    childAgeLayout_Room_1x4.setVisibility(View.GONE) ;

                }
                else if(childCountRoom1 ==2){
                    childAgeLayout_Room_1x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x3.setVisibility(View.GONE);
                    childAgeLayout_Room_1x4.setVisibility(View.GONE) ;
                }
                  else if(childCountRoom1 ==3){
                    childAgeLayout_Room_1x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom1 ==4){
                    childAgeLayout_Room_1x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_1x4.setVisibility(View.VISIBLE) ;
                }
                else if(childCountRoom1 ==0){
                    childAgeLayout_Room_1x1.setVisibility(View.GONE);
                    childAgeLayout_Room_1x2.setVisibility(View.GONE);
                    childAgeLayout_Room_1x3.setVisibility(View.GONE);
                    childAgeLayout_Room_1x4.setVisibility(View.GONE) ;
                }

            }
            if(adultCountRoom2 <=4 && adultCountRoom2 >=1){
                increaseAdultCount2.setClickable(true);
                decreaseAdultCount2.setClickable(true);

            }
            if(childCountRoom2 <=4 && childCountRoom2 >=0){
                increaseChildCount2.setClickable(true);
                decreaseChildCount2.setClickable(true);


                if(childCountRoom2 ==1){
                    childAgeLayout_Room_2x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x2.setVisibility(View.GONE);
                    childAgeLayout_Room_2x3.setVisibility(View.GONE);
                    childAgeLayout_Room_2x4.setVisibility(View.GONE) ;

                }
                else if(childCountRoom2 ==2){
                    childAgeLayout_Room_2x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x3.setVisibility(View.GONE);
                    childAgeLayout_Room_2x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom2 ==3){
                    childAgeLayout_Room_2x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom2 ==4){
                    childAgeLayout_Room_2x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_2x4.setVisibility(View.VISIBLE) ;
                }
                else if(childCountRoom2 ==0){
                    childAgeLayout_Room_2x1.setVisibility(View.GONE);
                    childAgeLayout_Room_2x2.setVisibility(View.GONE);
                    childAgeLayout_Room_2x3.setVisibility(View.GONE);
                    childAgeLayout_Room_2x4.setVisibility(View.GONE) ;
                }



            }

            if(adultCountRoom3 <=4 && adultCountRoom3 >=1){
                increaseChildCount3.setClickable(true);
                decreaseChildCount3.setClickable(true);
            }
            if(childCountRoom3 <=4 && childCountRoom3 >=0){
                increaseAdultCount3.setClickable(true);
                decreaseAdultCount3.setClickable(true);

                if(childCountRoom3 ==1){
                    childAgeLayout_Room_3x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x2.setVisibility(View.GONE);
                    childAgeLayout_Room_3x3.setVisibility(View.GONE);
                    childAgeLayout_Room_3x4.setVisibility(View.GONE) ;

                }
                else if(childCountRoom3 ==2){
                    childAgeLayout_Room_3x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x3.setVisibility(View.GONE);
                    childAgeLayout_Room_3x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom3 ==3){
                    childAgeLayout_Room_3x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom3 ==4){
                    childAgeLayout_Room_3x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_3x4.setVisibility(View.VISIBLE) ;
                }
                else if(childCountRoom3 ==0){
                    childAgeLayout_Room_3x1.setVisibility(View.GONE);
                    childAgeLayout_Room_3x3.setVisibility(View.GONE);
                    childAgeLayout_Room_3x3.setVisibility(View.GONE);
                    childAgeLayout_Room_3x4.setVisibility(View.GONE) ;
                }

            }

            if(adultCountRoom4 <=4 && adultCountRoom4 >=1){
                increaseAdultCount4.setClickable(true);
                decreaseAdultCount4.setClickable(true);
            }
            if(childCountRoom4 <=4 && childCountRoom4 >=0){
                increaseChildCount4.setClickable(true);
                decreaseChildCount4.setClickable(true);

                if(childCountRoom4 ==1){
                    childAgeLayout_Room_4x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x2.setVisibility(View.GONE);
                    childAgeLayout_Room_4x3.setVisibility(View.GONE);
                    childAgeLayout_Room_4x4.setVisibility(View.GONE) ;

                }
                else if(childCountRoom4 ==2){
                    childAgeLayout_Room_4x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x3.setVisibility(View.GONE);
                    childAgeLayout_Room_4x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom4 ==3){
                    childAgeLayout_Room_4x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x4.setVisibility(View.GONE) ;
                }
                else if(childCountRoom4 ==4){
                    childAgeLayout_Room_4x1.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x2.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x3.setVisibility(View.VISIBLE);
                    childAgeLayout_Room_4x4.setVisibility(View.VISIBLE) ;
                }
                else if(childCountRoom4 ==0){
                    childAgeLayout_Room_4x1.setVisibility(View.GONE);
                    childAgeLayout_Room_4x2.setVisibility(View.GONE);
                    childAgeLayout_Room_4x3.setVisibility(View.GONE);
                    childAgeLayout_Room_4x4.setVisibility(View.GONE) ;
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {



        }
    };

    private TextWatcher generalTextWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String ss =roomCount_textview.getText().toString();

            switch (ss) {
                case "1":
                    room2View_Layout.setVisibility(View.GONE);
                    room3View_Layout.setVisibility(View.GONE);
                    room4View_Layout.setVisibility(View.GONE);
                    break;
                case "2":
                    room2View_Layout.setVisibility(View.VISIBLE);
                    room3View_Layout.setVisibility(View.GONE);
                    room4View_Layout.setVisibility(View.GONE);

                    break;
                case "3":

                    room2View_Layout.setVisibility(View.VISIBLE);
                    room3View_Layout.setVisibility(View.VISIBLE);
                    room4View_Layout.setVisibility(View.GONE);


                    break;
                case "4":
                    room2View_Layout.setVisibility(View.VISIBLE);
                    room3View_Layout.setVisibility(View.VISIBLE);
                    room4View_Layout.setVisibility(View.VISIBLE);
                    break;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {



        }
    };


/*    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }*/



    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.increase1 :
                if(adultCountRoom1 ==4){
                    increaseAdultCount1.setClickable(false);
                    decreaseAdultCount1.setClickable(true);
                }
                else{

                    int mintegerr = adultCountRoom1 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    adultCountRoom1 =mintegerr;
                    adultRoom1_displayText.setText(s);
                }
                break;

            case R.id.decrease1 :

                if(adultCountRoom1==1){
                    decreaseAdultCount1.setClickable(false);
                    increaseAdultCount1.setClickable(true);
                }
                else {
                    int mintegerr = adultCountRoom1 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    adultCountRoom1 =mintegerr;
                    adultRoom1_displayText.setText(s);


                }
                break;
            case R.id.increase2 :

                if(childCountRoom1 ==4){
                    increaseChildCount1.setClickable(false);
                    decreaseChildCount1.setClickable(true);
                }
                else{

                    int mintegerr = childCountRoom1 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    childCountRoom1 =mintegerr;
                    childRoom1_displayText.setText(s);
                }
                break;

            case R.id.decrease2:

                if(childCountRoom1==0){
                    decreaseChildCount1.setClickable(false);
                    increaseChildCount1.setClickable(true);
                }
                else {
                    int mintegerr = childCountRoom1 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    childCountRoom1 =mintegerr;
                    childRoom1_displayText.setText(s);


                }
                break;
                //Row 2

            case R.id.increase3:

                if(adultCountRoom2 ==4){
                    increaseAdultCount2.setClickable(false);
                    decreaseAdultCount2.setClickable(true);
                }
                else{

                    int mintegerr = adultCountRoom2 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    adultCountRoom2 =mintegerr;
                    adultRoom2_displayText.setText(s);
                }
                break;

            case R.id.decrease3:

                    if(adultCountRoom2==1){
                        decreaseAdultCount2.setClickable(false);
                        increaseAdultCount2.setClickable(true);
                    }
                    else {
                        int mintegerr = adultCountRoom2 - 1;
                        Log.d("value", String.valueOf(mintegerr));



                        String s = String.valueOf(mintegerr);
                        adultCountRoom2 =mintegerr;
                        adultRoom2_displayText.setText(s);


                    }
                break;

            case R.id.increase4:

                if(childCountRoom2 ==4){
                    increaseChildCount2.setClickable(false);
                    decreaseChildCount2.setClickable(true);
                }
                else{

                    int mintegerr = childCountRoom2 + 1;
                    Log.d("value4", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    childCountRoom2 =mintegerr;
                    childRoom2_displayText.setText(s);
                }
                break;

            case R.id.decrease4:

                if(childCountRoom2==0){
                    decreaseChildCount2.setClickable(false);
                    increaseChildCount2.setClickable(true);
                }
                else {
                    int mintegerr = childCountRoom2 - 1;
                    Log.d("value4", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    childCountRoom2 =mintegerr;
                    childRoom2_displayText.setText(s);


                }
                break;

                //row 3

            case R.id.increase5:

                if(adultCountRoom3 ==4){
                    increaseChildCount3.setClickable(false);
                    decreaseChildCount3.setClickable(true);
                }
                else{

                    int mintegerr = adultCountRoom3 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    adultCountRoom3 =mintegerr;
                    adultRoom3_displayText.setText(s);
                }
                break;

            case R.id.decrease5:
                if(adultCountRoom3==1){
                    decreaseChildCount3.setClickable(false);
                    increaseChildCount3.setClickable(true);
                }
                else {
                    int mintegerr = adultCountRoom3 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    adultCountRoom3 =mintegerr;
                    adultRoom3_displayText.setText(s);


                }
                break;

               case R.id.increase6 :

                if(childCountRoom3 ==4){
                    increaseAdultCount3.setClickable(false);
                    decreaseAdultCount3.setClickable(true);
                }
                else{

                    int mintegerr = childCountRoom3 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    childCountRoom3 =mintegerr;
                    childRoom3_displayText.setText(s);
                }
                   break;

            case R.id.decrease6 :
                if(childCountRoom3==0){
                    decreaseAdultCount3.setClickable(false);
                    increaseAdultCount3.setClickable(true);
                }
                else {
                    int mintegerr = childCountRoom3 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    childCountRoom3 =mintegerr;
                    childRoom3_displayText.setText(s);


                }
                break;

                // row 4

            case R.id.increase7:
                if(adultCountRoom4 ==4){
                    increaseAdultCount4.setClickable(false);
                    decreaseAdultCount4.setClickable(true);
                }
                else{

                    int mintegerr = adultCountRoom4 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    adultCountRoom4 =mintegerr;
                    adultRoom4_displayText.setText(s);
                }
                break;

            case R.id.decrease7:

                if(adultCountRoom4==1){
                    decreaseAdultCount4.setClickable(false);
                    increaseAdultCount4.setClickable(true);
                }
                else {
                    int mintegerr = adultCountRoom4 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    adultCountRoom4 =mintegerr;
                    adultRoom4_displayText.setText(s);


                }
                break;

            case R.id.increase8:
                if(childCountRoom4 ==4){
                    increaseChildCount4.setClickable(false);
                    decreaseChildCount4.setClickable(true);
                }
                else{

                    int mintegerr = childCountRoom4 + 1;
                    Log.d("value", String.valueOf(mintegerr));
                    String s = String.valueOf(mintegerr);
                    childCountRoom4 =mintegerr;
                    childRoom4_displayText.setText(s);
                }
                break;

            case R.id.decrease8:

                if(childCountRoom4==0){
                    decreaseChildCount4.setClickable(false);
                    increaseChildCount4.setClickable(true);
                }
                else {
                    int mintegerr = childCountRoom4 - 1;
                    Log.d("value", String.valueOf(mintegerr));



                    String s = String.valueOf(mintegerr);
                    childCountRoom4 =mintegerr;
                    childRoom4_displayText.setText(s);


                }
                break;

            case R.id.fromdate:

                date(1);
                break;

            case R.id.todate:

                date(0);
                break;

            case R.id.city :
                Intent intent=new Intent(getActivity(),Search.class);
                startActivityForResult(intent, 2);
                break;

            case R.id.submit:
                String fd = fromDate_EditText.getText().toString();
                String td = toDate_EditText.getText().toString();

                Fragment_Searchresult mani = new Fragment_Searchresult();
                fragmentTransaction.replace(R.id.content_frame, mani);
                Bundle args = new Bundle();
                args.putString("from_date", fd);
                args.putString("to_date", td);

                mani.setArguments(args);
                FragmentHome manis = new FragmentHome();
                fragmentTransaction.addToBackStack(String.valueOf(manis));
                Log.d("1-choosing_room_details","process_complete_with"+fd+td);
                fragmentTransaction.commit();

                break;


        }








    }




    private void display(int number) {

    /*    if(number==1){
          decrease1.setClickable(false);
        }
        if(number ==4){
            increase1.setClickable(false);
        }
        if(number <=4 && number >=1) {*/

            String s = String.valueOf(number);
        adultRoom1_displayText.setText(s);
       /* }
        else{

            Toast.makeText(getContext(),"max 4 ,members",Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(parent.getContext(),
                 parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
        roomCount_textview.setText(parent.getItemAtPosition(position).toString());

        //roomcount_String = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void  date(final int i){

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout ll= (LinearLayout)inflater.inflate(R.layout.date, null, false);
        CalendarView cv = (CalendarView) ll.getChildAt(0);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                // TODO Auto-generated method stub
                initScheduleEvent(month,dayOfMonth,year);
            }
        });
        new AlertDialog.Builder(getContext())
                .setTitle("Event Calendar")
                .setMessage("Click to schedule or view events.")
                .setView(ll)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //do nothing...yet
                        if (i == 1) {
                            fromDate_EditText.setText(dateValue_String);
                        }
                        else {
                            toDate_EditText.setText(dateValue_String);
                        }
                    }

                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Do nothing.
                    }
                }
        ).show();
    }

    private void initScheduleEvent(int month,int day,int year) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            int o = month + 1;
            String newday;
            if (day < 10)
                newday = "0" + String.valueOf(day);
            else
                newday = String.valueOf(day);
            if (o < 10)
                dateValue_String = year + "-0" + o + "-" + newday;
            else
                dateValue_String = year + "-" + o + "-" + newday;



            Log.i("date_is ", dateValue_String);




        }

        else
        {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            cityName_Edittext.setText(message);
        }
    }




}

