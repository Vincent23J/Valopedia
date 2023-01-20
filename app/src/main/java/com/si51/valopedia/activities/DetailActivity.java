package com.si51.valopedia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.si51.valopedia.R;
import com.si51.valopedia.models.ValorantData;
import com.si51.valopedia.models.ValorantDetail;
import com.si51.valopedia.services.APIRequestData;
import com.si51.valopedia.services.RetroServer;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private String TAG = "agent";
    public TextView tvName, tvDescription,tvRole, tvAbility1, tvAbility2, tvGrenade, tvUltimate;
    public ImageView imgRole, imgChar, imgAbility1, imgAbility2, imgGrenade, imgUltimate;
    private ValorantDetail valorantDetail;
    private RelativeLayout RLDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_description);
        tvRole = findViewById(R.id.tv_role);
        tvAbility1 = findViewById(R.id.tv_ability1);
        tvAbility2 = findViewById(R.id.tv_ability2);
        tvGrenade = findViewById(R.id.tv_grenade);
        tvUltimate = findViewById(R.id.tv_ultimate);
        imgRole = findViewById(R.id.img_role);
        imgChar = findViewById(R.id.img_char);
        RLDetail = findViewById(R.id.RL_Detail);
        imgAbility1 = findViewById(R.id.img_ability1);
        imgAbility2 = findViewById(R.id.img_ability2);
        imgGrenade = findViewById(R.id.img_gren);
        imgUltimate = findViewById(R.id.img_ulti);
        tvName = findViewById(R.id.tv_name);

        getDetailAgent();

    }

    private void getDetailAgent(){
        String id = getIntent().getStringExtra(RetroServer.EXTRA_AGENT_UUID);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetroServer.EXTRA_AGENT_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        APIRequestData api = retrofit.create(APIRequestData.class);
        api.VALORANT_DETAIL_CALL(id).enqueue(new Callback<ValorantDetail>() {
            @Override
            public void onResponse(Call<ValorantDetail> call, Response<ValorantDetail> response) {
                if(response.code() == 200){
                    valorantDetail = response.body();

                    tvName.setText(valorantDetail.getDisplayName());
                    tvDescription.setText(valorantDetail.getDescription());
                    tvRole.setText(valorantDetail.getRole().get(0).getDisplayName());
                    tvAbility1.setText(valorantDetail.getAbilities().get(0).getAbility().get(0).getDisplayName());
                    tvAbility2.setText(valorantDetail.getAbilities().get(0).getAbility().get(1).getDisplayName());
                    tvGrenade.setText(valorantDetail.getAbilities().get(0).getAbility().get(2).getDisplayName());
                    tvUltimate.setText(valorantDetail.getAbilities().get(0).getAbility().get(3).getDisplayName());

                    Picasso.get().load(valorantDetail.getFullPortrait()).into(imgChar);
//                    Picasso.get().load(valorantDetail.getBackground()).into(RLDetail);
                    Picasso.get().load(valorantDetail.getRole().get(0).getDisplayIcon()).into(imgRole);
                    Picasso.get().load(valorantDetail.getAbilities().get(0).getAbility().get(0).getDisplayIcon()).into(imgAbility1);
                    Picasso.get().load(valorantDetail.getAbilities().get(0).getAbility().get(1).getDisplayIcon()).into(imgAbility2);
                    Picasso.get().load(valorantDetail.getAbilities().get(0).getAbility().get(2).getDisplayIcon()).into(imgGrenade);
                    Picasso.get().load(valorantDetail.getAbilities().get(0).getAbility().get(3).getDisplayIcon()).into(imgUltimate);


                }
            }

            @Override
            public void onFailure(Call<ValorantDetail> call, Throwable t) {

            }
        });
    }
}