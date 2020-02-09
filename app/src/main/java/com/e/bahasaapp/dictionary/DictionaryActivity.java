package com.e.bahasaapp.dictionary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.bahasaapp.R;
import com.e.bahasaapp.adapter.DictionaryAdapter;
import com.e.bahasaapp.model.DictionaryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DictionaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<DictionaryModel>> {
    ArrayList<DictionaryModel> dictionary =new ArrayList<>();
    private DictionaryAdapter dictionaryAdapter;
    private RecyclerView rvDictionary;
    //   private TextInputEditText search;
    private SearchView search;
    private int position = 0;
    private String language = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        //  search = findViewById(R.id.textInputEditTextSearch);
        search = findViewById(R.id.svDictionary);
        rvDictionary = findViewById(R.id.rv_listDictionary);
        rvDictionary.setLayoutManager(new LinearLayoutManager(this));

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            position = extras.getInt("position");
        }

        getDictionaryResponse();

        search.setQueryHint("Start typing to search...");

        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("Filter", newText);
                dictionaryAdapter.getFilter().filter(newText.toString().toLowerCase());
                return false;
            }
        });

        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener()
        {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

    }

    private void getDictionaryResponse() {
        String url = "";
        if(position == 0){
            url = "https://gist.githubusercontent.com/ferysuyatna/f0cf0fda937019cbb14642a65652410a/raw/0479be7c126a986c69deeb05902f85e614404301/";
        } else if(position == 1){
            url = "https://gist.githubusercontent.com/ferysuyatna/47122090632649687780dcca5b5ce8c7/raw/726b81c137c822a027f8463c783773045d08ab98/";
        } else if(position == 2){
            url = "https://gist.githubusercontent.com/ferysuyatna/232e6c3c9685890c1dd6a365c159d1d4/raw/0c7e2a4f2c56e5375953bb8e950c4e28675563f3/";
        }


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInteface requestInteface=retrofit.create(RequestInteface.class);
        Call<List<DictionaryModel>> call = null;

        if (position == 0){
            call = requestInteface.getSundaJson();
            language = "Sunda";
        } else if (position == 1){
            call = requestInteface.getBaliJson();
            language = "Bali";
        } else if (position == 2){
            call = requestInteface.getBugisJson();
            language = "Bugis";
        }

        setTitle("Kamus Bahasa " + language);

        call.enqueue(new Callback<List<DictionaryModel>>() {
            @Override
            public void onResponse(Call<List<DictionaryModel>> requestInteface, Response<List<DictionaryModel>> response) {
                dictionary=new ArrayList<>(response.body());
                dictionaryAdapter=new DictionaryAdapter(DictionaryActivity.this, dictionary);
                rvDictionary.setAdapter(dictionaryAdapter);
                Toast.makeText(DictionaryActivity.this,"Kamus Bahasa "+ language +"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<DictionaryModel>> call, Throwable t) {
                Toast.makeText(DictionaryActivity.this,"Tidak ada koneksi internet",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public Loader<List<DictionaryModel>> onCreateLoader(int id, @Nullable Bundle args) {
        getDictionaryResponse();
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<DictionaryModel>> loader, List<DictionaryModel> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<DictionaryModel>> loader) {

    }
}
