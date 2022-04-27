package com.techninja01.practical10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    FloatingActionButton fab;
    int i = 1;
    RecyclerView recyclerView;
    private WordListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (i=1;i<20;i++){
            mWordList.addLast("Word "+i);
        }
        recyclerView = findViewById(R.id.rcView);
        adapter = new WordListAdapter(this,mWordList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.additionFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                // Add a new word to the wordList.
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter that the data has changed.
                recyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}