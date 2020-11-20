   package com.example.covid19tracler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


   public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private ArrayList<CoronaItem> coronaItemArrayList;
     private RequestQueue requestQueue;
     private TextView confirm, active, newCases, recover, hospital, deaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = findViewById(R.id.totalConfirm);
        active = findViewById(R.id.totalActive);
        newCases = findViewById(R.id.totalNewCases);
        recover = findViewById(R.id.totalRecover);
        hospital = findViewById(R.id.totalHospital);
        deaths = findViewById(R.id.totalDeaths);

        coronaItemArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        jsonParse();

    }

       private void jsonParse() {
        String url ="https://api.covid19india.org/raw_data.json";

         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String message = response.getString("message");
                    //JSONArray todayAndTotalDataArray = response.getJSONArray("Sample Data");
                    //JSONObject todayAndTotalDataJsonObject = todayAndTotalDataArray.getJSONObject(2);

                    /*String dailyConfirmed = todayAndTotalDataJsonObject.getString("deltaconfirmed");
                    String dailyDeath = todayAndTotalDataJsonObject.getString("deltadeaths");
                    String dailyRec = todayAndTotalDataJsonObject.getString("deltarecovered");
                    String dataHeader = todayAndTotalDataJsonObject.getString("lastupdatetime").substring(0, 5);
                    dataHeader = getFormattedDate(dataHeader);
                    //method implemented successully

                    dailyConfirm.setText(dailyConfirmed);
                    dailyReco.setText(dailyRec);
                    dailyDeaths.setText(dailyDeath);
                    dateHeaders.setText(dataHeader);

                    //for total details
                    //totalAndTotalDataArray holds data of all the states
                    //at index 0 of the todayAndTotalArray "total details" is sorted
                    String totalDeathsFetched = todayAndTotalDataJsonObject.getString("deaths");
                    String totalRecoveredFetched = todayAndTotalDataJsonObject.getString("recovered");
                    String totalConfirmedFetched = todayAndTotalDataJsonObject.getString("confirmed");

                    totalConfirm.setText(totalConfirmedFetched);
                    totalDeath.setText(totalDeathsFetched);
                    totalRecovered.setText(totalRecoveredFetched);*/


                    //now fetch and display the data all the states
                    //this data is also presente in the todayAndTotalDataArray from idex
                    /*for (int i = 1; i < todayAndTotalDataArray.length(); i++) {
                        JSONObject stateWiseArrayJSONObject = todayAndTotalDataArray.getJSONObject(i);
                        //String date = stateWiseArrayJSONObject.getString("update_date_time");
                        int local_new_cases = stateWiseArrayJSONObject.getInt("local_new_cases");
                        int local_total_cases = stateWiseArrayJSONObject.getInt("local_total_cases");
                        int hospital = stateWiseArrayJSONObject.getInt("local_total_number_of_individuals_in_hospitals");
                        int local_deaths = stateWiseArrayJSONObject.getInt("local_deaths");
                        int local_new_deaths = stateWiseArrayJSONObject.getInt("local_new_deaths");
                        int local_recovered = stateWiseArrayJSONObject.getInt("local_recovered");
                        int local_active_cases = stateWiseArrayJSONObject.getInt("local_active_cases");
                        int global_new_cases = stateWiseArrayJSONObject.getInt("global_new_cases");
                        int global_total_cases = stateWiseArrayJSONObject.getInt("local_new_cases");
                        int global_deaths = stateWiseArrayJSONObject.getInt("global_deaths");
                        int global_new_deaths = stateWiseArrayJSONObject.getInt("global_new_deaths");
                        int global_recovered = stateWiseArrayJSONObject.getInt("global_recovered");




                        //noe pass the all details to the corona items class
                        CoronaItem coronaItem = new CoronaItem(local_new_cases, local_active_cases, local_total_cases, local_deaths, local_recovered, hospital, local_new_deaths, global_new_cases, global_total_cases, global_deaths, global_new_deaths, global_recovered);
                        coronaItemArrayList.add(coronaItem);

                    }*/
                    //now we just have to set up the recyclerView to display the content or data
                    confirm.setText(message);
                    //RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, coronaItemArrayList);
                }
                //try statement must have the catch statement. so we will add the catch steatement here
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

         requestQueue.add(request);


       }
   }