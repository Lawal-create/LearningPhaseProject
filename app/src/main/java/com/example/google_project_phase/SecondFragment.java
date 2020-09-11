package com.example.google_project_phase;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    RecyclerView recyclerView;
    List<Name2> name;
    private static String JSON_URL="https://gadsapi.herokuapp.com/api/skilliq";
    Adapter2 adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_second, container, false);
        recyclerView=view.findViewById(R.id.name_list2);
        recyclerView.setHasFixedSize(true);
        name=new ArrayList<>();
        extractNames();
        return view;
    }
    private void extractNames() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject nameObject = response.getJSONObject(i);

                        Name2 names = new Name2();
                        names.setName(nameObject.getString("name").toString());
                        names.setScore(nameObject.getString("score").toString());
                        names.setCountry(nameObject.getString("country").toString());
                        names.setBadgeUrl(nameObject.getString("badgeUrl"));

                        name.add(names);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adapter=new Adapter2(getActivity(),name);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse: "+ error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}