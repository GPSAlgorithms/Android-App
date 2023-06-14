package net.daum.android.map.openapi.sampleapp;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent로 화면 넘기기
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

}
