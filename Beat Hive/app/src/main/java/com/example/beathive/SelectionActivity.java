package com.example.beathive;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.beathive.rhythmDB.RhythmEntity;
import com.example.beathive.rhythmDB.RhythmListAdapter;
import com.example.beathive.rhythmDB.RhythmViewModel;

import java.util.List;

public class SelectionActivity extends AppCompatActivity {
    private RhythmViewModel mRhythmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        RecyclerView recyclerView = findViewById(R.id.recyclerviewrhythms);
        final RhythmListAdapter adapter = new RhythmListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRhythmViewModel = ViewModelProviders.of(this).get(RhythmViewModel.class);

        mRhythmViewModel.getAllRhythms().observe(this, new Observer<List<RhythmEntity>>() {
            @Override
            public void onChanged(@Nullable final List<RhythmEntity> rhythmEntities) {
                // Update the cached copy of the rhythmEntities in the adapter.
                adapter.setRhythms(rhythmEntities);
            }
        });
    }
}

