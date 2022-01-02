package com.example.noteexample.ui;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.noteexample.data.model.Note;
import com.example.noteexample.data.NoteRepository;

import java.util.List;

public class NoteViewMode extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;
    public NoteViewMode(@NonNull Application application){
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }
    public void insert(Note note){
        repository.insert(note);
    }
    private void update (Note note){
        repository.update(note);
    }
    public void delete (Note note){
        repository.delete(note);
    }
    private void deleteAllNotes(){
        repository.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}