package com.example.remotecoders;
//
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class DAOPet {
//    private DatabaseReference databaseReference;
//
//    public DAOPet()
//    {
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        databaseReference = db.getReference(PetIn.class.getSimpleName());
//    }
//    public Task<Void> add(PetIn pet){
//        return databaseReference.push().setValue(pet);
//    }
//}
