package com.example.mpping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProviderDetails extends AppCompatActivity {
    ImageView provider_profile_image2;
    TextView provider_name2, provider_status2, provider_career2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_details);

        provider_name2 = findViewById(R.id.provider_name2);
        provider_status2 = findViewById(R.id.provider_status2);
        provider_career2 = findViewById(R.id.provider_career2);
        provider_profile_image2 = findViewById(R.id.provider_profile_image2);

        Intent providerDetails = getIntent();
        String providerName = providerDetails.getStringExtra("Name");
        String providerImage = providerDetails.getStringExtra("ProfImage");
        String providerStatus = providerDetails.getStringExtra("Status");
        String providerJob = providerDetails.getStringExtra("Job");

        provider_name2.setText(providerName);
        provider_status2.setText(providerStatus);
        provider_career2.setText(providerJob);
//        provider_profile_image2.setImageResource(Integer.parseInt(providerImage));
    }
}
