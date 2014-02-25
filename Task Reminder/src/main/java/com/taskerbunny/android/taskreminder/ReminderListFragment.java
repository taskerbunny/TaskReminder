package com.taskerbunny.android.taskreminder;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

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

    
    private ListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make static data
        String[] items = new String[] { "Foo", "Bar", "Fizz", "Bin" };
        mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.reminder_row, R.id.text1, items);
        setListAdapter(mAdapter);
    }

}
