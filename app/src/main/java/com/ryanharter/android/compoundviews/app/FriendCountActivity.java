package com.ryanharter.android.compoundviews.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rharter on 5/14/14.
 */
public class FriendCountActivity extends Activity {

    private TextView mTextView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_count);

        mTextView = (TextView) findViewById(R.id.friend_text);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            List<String> names = extras.getStringArrayList("names");
            setFriendText(names);
        }
    }

    private void setFriendText(List<String> names) {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.you_have_friends, names.size()));
        builder.append('\n');
        for (String name : names) {
            builder.append(name).append('\n');
        }
        mTextView.setText(builder.toString());
    }
}
