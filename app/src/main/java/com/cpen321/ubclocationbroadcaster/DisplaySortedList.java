package com.cpen321.ubclocationbroadcaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**This Activity class serves the purpose of displaying the suggested activties based on the input parameters entered by the user.
 * The Activities that are most highly suggested are displayed at the top of the list and as we traverse the
 * list downwards, we see lesser suggested activities as compared to the ones above them. The user can click on any
 * one of the activity to see more details and either join it.*/
public class DisplaySortedList extends AppCompatActivity {

    private int images [] = {R.drawable.check , R.drawable.cross,R.drawable.check , R.drawable.cross, R.drawable.check};
    private int check = (R.drawable.check);
    private int cross = (R.drawable.cross);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sorted_list);

        recyclerView = findViewById(R.id.recycleView);

        MyAdapter myAdapter = new MyAdapter(this,SortedlistclassUtil.aids,SortedlistclassUtil.anames);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}