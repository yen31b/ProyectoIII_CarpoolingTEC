package com.example.yen.androidlinkedinlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;

import org.json.JSONObject;

public class Home extends AppCompatActivity {

    private static final String host = "api.linkedin.com";
    private static final String url = "https://" + host + "/v1/people/~:" + "(email-address, firnatted-name, phone-numbers, picture-urls::(original))" ;

    private TextView username, useremail, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = (TextView)findViewById(R.id.name);
        useremail = (TextView)findViewById(R.id.email);
        token = (TextView)findViewById(R.id.printToken);

        Bundle bundle = getIntent().getExtras();
        String getoken = bundle.getString("value");

        token.setText(getoken);

        linkedinHelperApi();

    }

    public void linkedinHelperApi(){
        APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(Home.this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {

                try{
                    finalResult(apiResponse.getResponseDataAsJson());

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onApiError(LIApiError LIApiError) {

            }
        });
    }

    public void finalResult(JSONObject jsonObject){
        try{
            username.setText("Full Name: " + jsonObject.get("formattedName").toString());
            useremail.setText("Email Address: " + jsonObject.get("emailAddress").toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
