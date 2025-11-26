package com.example.myapplicationdashboard;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class FeesActivity extends AppCompatActivity {

    private TextView totalFeesText, paidAmountText, dueAmountText, paymentHistoryText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees); // Correct layout file

        // Top App Bar Back Button
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        toolbar.setTitle("Fees");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the activity on back button click
                finish();
            }
        });

        // Initialize TextViews
        totalFeesText = findViewById(R.id.totalFeesText);
        paidAmountText = findViewById(R.id.paidAmountText);
        dueAmountText = findViewById(R.id.dueAmountText);
        paymentHistoryText = findViewById(R.id.paymentHistoryText);



        // Example Fee Data (Replace with database values later)
        int totalFees = 50000;
        int paidAmount = 30000;
        int dueAmount = totalFees - paidAmount;
        String paymentHistory = "01-Apr-2025: ₹15,000\n10-Jan-2025: ₹15,000";

        // Set data to TextViews
        totalFeesText.setText("₹" + totalFees);
        paidAmountText.setText("₹" + paidAmount);
        dueAmountText.setText("₹" + dueAmount);
        paymentHistoryText.setText(paymentHistory);
    }
}
