package com.taskerbunny.android.taskreminder;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class ReminderEditActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        setContentView(R.layout.reminder_edit_activity);
        Fragment fragment = getFragmentManager().findFragmentByTag(ReminderEditFragment.DEFAULT_EDIT_FRAGMENT_TAG);

        //
        if (fragment == null) {
            fragment = new ReminderEditFragment();

            Bundle args = new Bundle();
            //args.putExtra(ReminderProvider.COLUMN_ROWID, getIntent().getLongExtra(ReminderProvider.COLUMN_ROWID, 0L));

            fragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.edit_container, fragment, ReminderEditFragment.DEFAULT_EDIT_FRAGMENT_TAG);
            transaction.commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.reminder_edit_fragment, container, false);
            return rootView;
        }
    }

}
