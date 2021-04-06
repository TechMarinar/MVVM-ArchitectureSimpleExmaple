package com.example.notebymvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notebymvvm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NotesViewModel notesViewModel;

    @BindView(R.id.notetextView)
    TextView noteTView;
    @BindView(R.id.noteBTN)
    Button noteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //set button click listener
        noteButton.setOnClickListener(this);

        //init the View Modell
        notesViewModel= new ViewModelProvider(this).get(NotesViewModel.class);

        //set the observer
        notesViewModel.noteNameMutable.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String noteName) {
               //set the TextView with noteName
                noteTView.setText(noteName);
            }
        });

    }

    @Override
    public void onClick(View v) {
        notesViewModel.getNoteDetails();
    }
}