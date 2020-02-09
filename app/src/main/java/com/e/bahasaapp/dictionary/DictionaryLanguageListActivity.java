package com.e.bahasaapp.dictionary;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.bahasaapp.R;
import com.e.bahasaapp.adapter.CourseLanguageList;
import com.e.bahasaapp.adapter.DictionaryLanguageList;
import com.e.bahasaapp.model.DictionaryLanguage;
import com.e.bahasaapp.model.DictionaryLanguageData;

import java.util.ArrayList;

public class DictionaryLanguageListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DictionaryLanguage> list;

    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_language);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("List Bahasa");
            list.addAll(DictionaryLanguageData.getListData());
            showRecyclerViewList();
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<DictionaryLanguage> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DictionaryLanguageList listAdapter = new DictionaryLanguageList(this);
        listAdapter.setListMountain(list);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
    }
}
