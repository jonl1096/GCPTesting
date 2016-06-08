package com.example.jliu.gcp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.plus.Plus;

import java.io.IOException;

/**
 * Created by jliu on 6/7/2016.
 */
public class GcpManager {

    private Context context;

    private static final String TAG = "RetrieveAccessToken";

    private static final int REQUEST_CODE_PICK_ACCOUNT = 1000;
    private static final int REQ_SIGN_IN_REQUIRED = 55664;
    private String mAccountName;

    public GcpManager(Context pContext, String pEmail, String pPassword) {
        this.context = pContext;

//         Manual integration? Pop an account chooser to get this:
//        mAccountName = "jliu@newsamerica.com";
//         Or if you have a GoogleApiClient connected:
//        mAccountName = Plus.AccountApi.getAccountName(mGoogleApiClient);
//        mAccountName = GoogleSignInOptions.Builder.requestServerAuthCode
//
//        RetrieveTokenTask retriever = new RetrieveTokenTask();
//
//        retriever.execute(mAccountName);

    }


//    private void pickUserAccount() {
//        String[] accountTypes = new String[]{"com.google"};
//        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
//                accountTypes, false, null, null, null, null);
//        this.context.startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_retrieve_access_token);
//        findViewById(R.id.button_token).setOnClickListener(this);
//
//        // Manual integration? Pop an account chooser to get this:
//        mAccountName = "jliu@newsamerica.com";
//        // Or if you have a GoogleApiClient connected:
//        mAccountName = Plus.AccountApi.getAccountName(mGoogleApiClient);
//    }

//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.button_token) {
//            new RetrieveTokenTask().execute(mAccountName);
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQ_SIGN_IN_REQUIRED && resultCode == RESULT_OK) {
//            // We had to sign in - now we can finish off the token request.
//            new RetrieveTokenTask().execute(mAccountName);
//        }
//    }

//    private class RetrieveTokenTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            String accountName = params[0];
//            String scopes = "oauth2:profile email";
//            String token = null;
//            try {
//                token = GoogleAuthUtil.getToken(getApplicationContext(), accountName, scopes);
//            } catch (IOException e) {
//                Log.e(TAG, e.getMessage());
//            } catch (UserRecoverableAuthException e) {
//                this.context.startActivityForResult(e.getIntent(), REQ_SIGN_IN_REQUIRED);
//            } catch (GoogleAuthException e) {
//                Log.e(TAG, e.getMessage());
//            }
//            return token;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
////            ((TextView) findViewById(R.id.token_value)).setText("Token Value: " + s);
//        }
//    }

}
