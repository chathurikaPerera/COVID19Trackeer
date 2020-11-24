   package com.example.covid19tracler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.xml.transform.ErrorListener;


   public class MainActivity extends AppCompatActivity {
       private RequestQueue requestQueue;
       private TextView totalCases, avtiveCases, newCases, recoveredCases, deaths;
       public FloatingActionButton floatingActionButton;
       ArrayList<String> booo = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCases = findViewById(R.id.totalCases);
        avtiveCases = findViewById(R.id.activeCases);
        newCases = findViewById(R.id.newCases);
        recoveredCases =findViewById(R.id.recoverCases);
        deaths = findViewById(R.id.deathCases);
        floatingActionButton = findViewById(R.id.floatbutton);

        requestQueue = Volley.newRequestQueue(this);
        jsonParse();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class );
                intent.putExtra("booolist", booo);
                startActivity(intent);
            }
        });

    }

       private void jsonParse() {
           String url ="https://hpb.health.gov.lk/api/get-current-statistical";
           JsonObjectRequest object = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
               @Override
               public void onResponse(JSONObject response) {
                   try {
                       JSONObject obj = response.getJSONObject("data");
                       String tcases = obj.getString("local_total_cases");
                       String acases = obj.getString("local_active_cases");
                       String ncases = obj.getString("local_new_cases");
                       String rcaces = obj.getString("local_recovered");
                       String death = obj.getString("local_deaths");
                       String gncases = obj.getString("global_new_cases");
                       String gtcases = obj.getString("global_total_cases");
                       String gdeaths = obj.getString("global_deaths");
                       String grecovered = obj.getString("global_recovered");
                       booo.add(gncases);
                       booo.add(gtcases);
                       booo.add(gdeaths);
                       booo.add(grecovered);

                       totalCases.setText(tcases);
                       avtiveCases.setText(acases);
                       newCases.setText(ncases);
                       recoveredCases.setText(rcaces);
                       deaths.setText(death);


                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   error.printStackTrace();
               }

       });
           requestQueue.add(object);
       }

   }