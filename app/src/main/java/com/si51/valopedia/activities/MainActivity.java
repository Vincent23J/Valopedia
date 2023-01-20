package com.si51.valopedia.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import android.widget.Toast;

import com.si51.valopedia.R;
import com.si51.valopedia.adapter.ViewAdapter;
import com.si51.valopedia.models.ValorantData;
import com.si51.valopedia.models.ValorantDetail;
import com.si51.valopedia.models.ValorantModel;
import com.si51.valopedia.services.APIRequestData;
import com.si51.valopedia.services.ItemClickListener;
import com.si51.valopedia.services.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private ViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_listagent);
        viewAdapter = new ViewAdapter((ItemClickListener<ValorantModel>) this::onAgentItemClick);
        rvData.setLayoutManager(new GridLayoutManager(this,1));
        getAgent();
    }

    private void onAgentItemClick(ValorantModel valorantModel, int i) {
        Intent intent = new Intent(this, ValorantDetail.class);
        intent.putExtra(RetroServer.EXTRA_AGENT_UUID, ValorantModel.getUuid());
        startActivity(intent);
    }

    private void getAgent() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetroServer.EXTRA_AGENT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIRequestData api = retrofit.create(APIRequestData.class);
        api.VALORANT_DATA_CALL(0, 10000).enqueue(new Callback <ValorantData>() {

            @Override
            public void onResponse(Call<ValorantData> call, Response<ValorantData> response) {
                if (response.code() == 200) {
                    viewAdapter.setData(response.body());
                    rvData.setAdapter(viewAdapter);

                    Toast.makeText(MainActivity.this, "Response Success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Response code: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValorantData> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }


}