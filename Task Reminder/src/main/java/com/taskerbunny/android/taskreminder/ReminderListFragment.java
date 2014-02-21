package com.taskerbunny.android.taskreminder;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;

/**
 * Created by Chicken on 2/20/14.
 */
public class ReminderListFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //
        setEmptyText(getResources().getString(R.string.no_reminders));
    }

}
