package com.ryanharter.android.compoundviews.app;

import com.ryanharter.android.compoundviews.app.views.FriendNameView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private NumberPicker mFriendCountPicker;
    private FriendNameView mFriendNameView;
    private Button mCountFriendsButton;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFriendCountPicker = (NumberPicker) findViewById(R.id.friend_count);
        mFriendNameView = (FriendNameView) findViewById(R.id.friend_names);
        mCountFriendsButton = (Button) findViewById(R.id.count_friends_button);

        mFriendCountPicker.setMaxValue(10);
        mFriendCountPicker.setOnValueChangedListener(new OnValueChangeListener() {
            @Override public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mFriendNameView.setFriendCount(newVal);
            }
        });

        mCountFriendsButton.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                List<String> names = mFriendNameView.getFriendNames();
                Intent i = new Intent(MainActivity.this, FriendCountActivity.class);
                i.putStringArrayListExtra("names", new ArrayList<String>(names));
                startActivity(i);
            }
        });
    }
}
