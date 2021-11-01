package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener {
    private SearchView searchView;
    private ListView listView;
    private final String[] mStrings = new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FDU", "onCreate: what is the log ??? have you some msg\n");
        for(int i=0; i<100; i = i+1){
            mStrings[i] = String.format("这是第%d行",i);
        }
        setContentView(R.layout.activity_main);
        searchView = (SearchView) findViewById(R.id.search_view);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));

        searchView.setIconifiedByDefault(true);

        searchView.setOnQueryTextListener(this);

        searchView.setSubmitButtonEnabled(true);

        searchView.setQueryHint("Search");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchView.setQuery(mStrings[position], false);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        } else {
            ArrayList<String> str = new ArrayList<String>();
            for(int i=0;i<100;i++){
                if(mStrings[i].indexOf(newText) != -1){
                    str.add(mStrings[i]);
                }
            }
            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));
        }
        return true;
    }
}