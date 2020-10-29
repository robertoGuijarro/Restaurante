package com.example.a1tutorial.providers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDatabaseProvider {

    FirebaseDatabase database;
    DatabaseReference myRef;

    public UserDatabaseProvider(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
    }

    public DatabaseReference getMyRef() {
        return myRef;
    }

}
