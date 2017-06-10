package com.example.conscience.myapplication;

import android.app.Service;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by conscience on 02.06.2017.
 */

public class MyInstanceIdService extends FirebaseInstanceIdService {

    //private static final String CHAT_ENGAGE_TOPIC = "chat_engage";

    public void onTokenRefresh(){
        String token = FirebaseInstanceId.getInstance().getToken();

        /*Log.d(TAG, "Ref token: " + token);

        sendRegistrationToServer(token);*/
    }

    private void sendRegistrationToServer(String refreshedToken) {
    }
}
