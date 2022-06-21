package com.byteapps.monopolycasher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //integer
    int mNewUserOneMoney;
    int mNewUserTwoMoney;
    int mNewUserThreeMoney;
    int mNewUserFourMoney;
    int mNewUserFiveMoney;
    int mNewUserSixMoney;

    int mUserOneMoney;
    int mUserTwoMoney;
    int mUserThreeMoney;
    int mUserFourMoney;
    int mUserFiveMoney;
    int mUserSixMoney;
    int mNewMoneyOfUser;
    //String
    String mUserId;
    //Read/Write
    File path = this.getFilesDir();
    File file = new File(path, "MoneyValues.txt");
    private void writeData(String data, int numbers) {
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(data.getBytes(), numbers, data.length());
        } catch (IOException e) {
            Toast FileErrorToast = Toast.makeText(this, "Error writing to file", Toast.LENGTH_SHORT);
            FileErrorToast.show();
            e.printStackTrace();
        }
    }
    private String readData() {
        StringBuilder data = new StringBuilder();
        try {
            FileInputStream stream = new FileInputStream(file);
            int i;
            while ((i = stream.read()) != -1) {
                data.append((char) i);
            }
        } catch (IOException e) {
            Toast FileErrorToast = Toast.makeText(this, "Error reading from file", Toast.LENGTH_SHORT);
            FileErrorToast.show();
            e.printStackTrace();
        }
        return data.toString();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Element linking
        Intent MainUserActivity = new Intent(this, MainUserActivity.class);
        //TextView
        TextView userOneText = findViewById(R.id.UserOneDescriptionText);
        TextView userTwoText = findViewById(R.id.UserTwoDescriptionText);
        TextView userThreeText = findViewById(R.id.UserThreeDescriptionText);
        TextView userFourText = findViewById(R.id.UserFourDescriptionText);
        TextView userFiveText = findViewById(R.id.UserFiveDescriptionText);
        TextView userSixText = findViewById(R.id.UserSixDescriptionText);
        //ImageView
        ImageView defaultUserAvatar = findViewById(R.id.DefaultUserAvatar);
        ImageView UserAvatar2 = findViewById(R.id.UserAvatar2);
        ImageView UserAvatar3 = findViewById(R.id.UserAvatar3);
        ImageView UserAvatar4 = findViewById(R.id.UserAvatar4);
        ImageView UserAvatar5 = findViewById(R.id.UserAvatar5);
        ImageView UserAvatar6 = findViewById(R.id.UserAvatar6);
        //String
        String testString = userOneText.getText().toString();
        //intent
        Intent intent = getIntent();
        mNewMoneyOfUser = intent.getIntExtra("Money", 0);
        mUserId = intent.getStringExtra("User Id");

        if (Objects.equals(mUserId, "Player 1")) {
            mUserOneMoney = mNewUserOneMoney;
            writeData("User one Money: ", mUserOneMoney);
        } else if (Objects.equals(mUserId, "Player2")) {
            mUserTwoMoney = mNewUserTwoMoney;
            writeData("User two Money: ", mUserTwoMoney);
        } else if (Objects.equals(mUserId, "Player3")) {
            mUserThreeMoney = mNewUserThreeMoney;
            writeData("User three Money: ", mUserThreeMoney);
        } else if (Objects.equals(mUserId, "Player4")) {
            mUserFourMoney = mNewUserFourMoney;
            writeData("User four Money: ", mUserFourMoney);
        } else if (Objects.equals(mUserId, "Player5")) {
            mUserFiveMoney = mNewUserFiveMoney;
            writeData("User five Money: ", mUserFiveMoney);
        } else if (Objects.equals(mUserId, "Player6")) {
            mUserSixMoney = mNewUserSixMoney;
            writeData("User six Money: ", mUserSixMoney);
        }

        //first avatar Image click listener
        defaultUserAvatar.setOnClickListener(v -> {
            Log.d("debug info: ", "Image Clicked");
            MainUserActivity.putExtra("userId", testString);
            for (String line : readData().split("\n")) {
                if (line.contains("User one Money:")) {
                    mUserOneMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserOneMoney);
            startActivity(MainUserActivity);
        });
        //second avatar Image click listener
        UserAvatar2.setOnClickListener(v -> {
            Log.d("debug info: ", "Image 2 Clicked");
            MainUserActivity.putExtra("userId", userTwoText.getText().toString());
            for (String line : readData().split("\n")) {
                if (line.contains("User two Money:")) {
                    mUserTwoMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserTwoMoney);
            startActivity(MainUserActivity);
        });
        //third avatar Image click listener
        UserAvatar3.setOnClickListener(v -> {
            Log.d("debug info: ", "Image 3 Clicked");
            MainUserActivity.putExtra("userId", userThreeText.getText().toString());
            for (String line : readData().split("\n")) {
                if (line.contains("User three Money:")) {
                    mUserThreeMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserThreeMoney);
            startActivity(MainUserActivity);
        });
        //fourth avatar Image click listener
        UserAvatar4.setOnClickListener(v -> {
            Log.d("debug info: ", "Image 4 Clicked");
            MainUserActivity.putExtra("userId", userFourText.getText().toString());
            for (String line : readData().split("\n")) {
                if (line.contains("User four Money:")) {
                    mUserFourMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserFourMoney);
            startActivity(MainUserActivity);
        });
        //fifth avatar Image click listener
        UserAvatar5.setOnClickListener(v -> {
            Log.d("debug info: ", "Image 5 Clicked");
            MainUserActivity.putExtra("userId", userFiveText.getText().toString());
            for (String line : readData().split("\n")) {
                if (line.contains("User five Money:")) {
                    mUserFiveMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserFiveMoney);
            startActivity(MainUserActivity);
        });
        //sixth avatar Image click listener
        UserAvatar6.setOnClickListener(v -> {
            Log.d("debug info: ", "Image 6 Clicked");
            MainUserActivity.putExtra("userId", userSixText.getText().toString());
            for (String line : readData().split("\n")) {
                if (line.contains("User six Money:")) {
                    mUserSixMoney = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
            MainUserActivity.putExtra("Money", mUserSixMoney);
            startActivity(MainUserActivity);
        });
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("PlayerOneMoney", mUserOneMoney);
        outState.putInt("PlayerTwoMoney", mUserTwoMoney);
        outState.putInt("PlayerThreeMoney", mUserThreeMoney);
        outState.putInt("PlayerFourMoney", mUserFourMoney);
        outState.putInt("PlayerFiveMoney", mUserFiveMoney);
        outState.putInt("PlayerSixMoney", mUserSixMoney);
    }
}