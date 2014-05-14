package com.ryanharter.android.compoundviews.app.views;

import com.ryanharter.android.compoundviews.app.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom compound view that displays an arbitrary
 * number of text views to enter your friends names.
 *
 * Created by rharter on 5/14/14.
 */
public class FriendNameView extends LinearLayout {

    private int mFriendCount;
    private int mEditTextResId;

    public FriendNameView(Context context) {
        this(context, null);
    }

    public FriendNameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FriendNameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOrientation(VERTICAL);
    }

    public int getFriendCount() {
        return mFriendCount;
    }

    public void setFriendCount(int friendCount) {
        if (friendCount != mFriendCount) {
            mFriendCount = friendCount;

            removeAllViews();
            for (int i = 0; i < mFriendCount; i++) {
                addView(createEditText());
            }
        }
    }

    private View createEditText() {
        View v;
        if (mEditTextResId > 0) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(mEditTextResId, this, true);
        } else {
            EditText et = new EditText(getContext());
            et.setHint(R.string.friend_name);
            v = et;
        }
        return v;
    }

    public int getEditTextResId() {
        return mEditTextResId;
    }

    public void setEditTextResId(int editTextResId) {
        mEditTextResId = editTextResId;
    }

    /**
     * Returns a list of entered friend names.
     */
    public List<String> getFriendNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if (v instanceof EditText) {
                EditText et = (EditText) v;
                names.add(et.getText().toString());
            }
        }
        return names;
    }
}
