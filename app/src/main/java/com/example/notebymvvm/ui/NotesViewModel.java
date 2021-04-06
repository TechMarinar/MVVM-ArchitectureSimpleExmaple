package com.example.notebymvvm.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notebymvvm.model.NoteModel;

/**
 * Created By Mohamed A. Dahab on 4/6/2021
 **/
public class NotesViewModel extends ViewModel {

     MutableLiveData<String> noteNameMutable = new MutableLiveData<>();
//    LiveData<String> noteDiscriptions;

    //get data from DB
    private NoteModel getNotesData(){

        return new NoteModel(1,"Emails","list of cutomers Emails");
    }

    //offer data [from DB] to be used by another activity
    public void getNoteDetails(){

        String noteData= "Title : "+getNotesData().getTitle()+"\n"+
                "Discriptions : "+getNotesData().getDiscriptions();
        //set noteNameMutable value
        noteNameMutable.setValue(noteData);
    }

}
