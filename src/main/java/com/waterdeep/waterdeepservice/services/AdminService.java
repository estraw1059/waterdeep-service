package com.waterdeep.waterdeepservice.services;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

import java.io.IOException;

public class AdminService {

    public AdminService() {
    }

    public void checkAuthToken(String uid) throws FirebaseAuthException, IOException {
        FirebaseInitializer.initialize();
        FirebaseToken firebaseToken =  FirebaseAuth.getInstance().verifySessionCookie(uid);
        System.out.println(firebaseToken.getUid() + " Is the user id ");
    }
}
