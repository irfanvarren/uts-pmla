package com.irfanvarren.belajarandroidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.irfanvarren.belajarandroidapi.service.ApiClient;
import com.irfanvarren.belajarandroidapi.service.GetService;
import com.irfanvarren.belajarandroidapi.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private List<User> dataList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    dataList = new ArrayList<User>();
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        /**Buat Handler Retrofit*/
        GetService service = ApiClient.getRetrofitInstance().create(GetService.class);
        Call<List<User>> call = service.getUsersList();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDialog.dismiss();
                if(response.body() != null) {
                    generateDataList(response.body());
                }else{
                    User contohUser = new User(1,"irfan-varren","Irfan Varren","irfanvarren7@gmail.com");
                    dataList.add(contohUser);
                    generateDataList(dataList);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**generate data list method()
     */
    private void generateDataList(List<User> userList){
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}