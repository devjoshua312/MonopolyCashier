package com.byteapps.monopolycasher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainUserActivity extends AppCompatActivity {

//    public int mMoney;

    int mDefaultMoney;
    int mValue1;
    int mValue2;
    int mValue3;
    int mNewMoney;
    int mMoney;
    String mUserId;

    private int add(int a, int b) {
        mValue3 = a + b;
        return mValue3;
    }
    private int subtract(int a, int b) {
        mValue3 = a - b;
        return mValue3;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        TextView MoneyValue = findViewById(R.id.MoneyValue);
        TextView PlayerName = findViewById(R.id.PlayerId);
        Intent intent = getIntent();
        mMoney = intent.getIntExtra("Money", 0);
        if (mMoney == 0) {
            mDefaultMoney = 1500;
            MoneyValue.setText("$" + mDefaultMoney);
        } else {
            MoneyValue.setText("$" + mMoney);
        }
        mUserId = intent.getStringExtra("userId");
        PlayerName.setText(mUserId);

        Button AddButton = findViewById(R.id.AddButton);
        Button SubtractButton = findViewById(R.id.SubtractButton);
        Button GoHomeButton = findViewById(R.id.GoToMainMenu);
        EditText NewMoneyValue = findViewById(R.id.EditTextField);
        Toast MoneyAddedToast = Toast.makeText(this, "Money Added!", Toast.LENGTH_SHORT);
        Toast MoneySubtractedToast = Toast.makeText(this, "Money Removed!", Toast.LENGTH_SHORT);


        //Addition function
        AddButton.setOnClickListener(v -> {
            try {
                String digits = MoneyValue.toString().replaceAll("[^0-9]", "");
                mValue1 = Integer.parseInt(NewMoneyValue.getText().toString());
                Log.d("Monopoly Cashier value1", String.valueOf(mValue1));
                mValue2 = Integer.parseInt(digits);
                Log.d("Monopoly Cashier value2", digits);
                mNewMoney = add(mValue1, mValue2);
                MoneyValue.setText("Current Money: $" + mNewMoney);
                MoneyAddedToast.show();
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Monopoly CashierError: ", e.getMessage());
            }
        });
        //Subtraction function
        SubtractButton.setOnClickListener(v -> {
            mValue1 = Integer.parseInt(NewMoneyValue.getText().toString());
            mValue2 = Integer.parseInt(MoneyValue.getText().toString());
            mNewMoney = subtract(mValue1, mValue2);
            MoneyValue.setText("Current Money: $" + mNewMoney);
            MoneySubtractedToast.show();
        });
        //Go to Main Menu
        GoHomeButton.setOnClickListener(v -> {
            Intent homeScreen = new Intent(this, MainActivity.class);
            homeScreen.putExtra("User Id", mUserId);
            homeScreen.putExtra("Money", mNewMoney);
            startActivity(homeScreen);
        });
    }
}