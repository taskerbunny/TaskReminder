package com.taskerbunny.android.taskreminder;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Chicken on 2/20/14.
 */
public class ReminderListFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //
        setEmptyText(getResources().getString(R.string.no_reminders));

        //
        //registerForContextMenu(getListView());

    }

    
    private ListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make static data
        String[] items = new String[] { "Foo", "Bar", "Fizz", "Bin" };

        //
        mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.reminder_row, R.id.text1, items);
        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Log.w("myApp", "item clicked - " + position);

        //
        Intent i = new Intent(getActivity(), ReminderEditActivity.class);
        //i.putExtra(ReminderProvider.COLUMN_ROWID, id);
        i.putExtra(Intent.EXTRA_TEXT, id);
        startActivity(i);

        /*
        // Android chooser
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Hey Everybody!");
        i.putExtra(Intent.EXTRA_SUBJECT, "My Subject");
        Intent chooser = Intent.createChooser(i, "Who Should Handle this?");
        startActivity(chooser);
        */
    }

    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //
        Log.w("myApp", "item long clicked");
    }
    */

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        setEmptyText(getResources().getString(R.string.no_reminders));

        registerForContextMenu(getListView());

        setHasOptionsMenu(true);
    }

    /* or put it on the activity */
    /* OptionsMenu */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        //
        inflater.inflate(R.menu.reminder_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        switch (item.getItemId()) {
            case R.id.menu_insert:
                editReminder(0);
                Log.w("myApp", "menu_insert selected!");
                return true;
        }

        //
        return super.onOptionsItemSelected(item);
    }

    public void editReminder(long id) {
        Intent i = new Intent(getActivity(), ReminderEditActivity.class);
        //i.putExtra(ReminderProvider.COLUMN_ROWID, id);
        startActivity(i);
    }

    /* Context Menu */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //
        Log.w("myApp", "item long clicked");

        //
        MenuInflater mi = getActivity().getMenuInflater();
        mi.inflate(R.menu.list_menu_item_longpress, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_delete:
                // Delete the task
                Log.w("myApp", "menu_delete clicked");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
