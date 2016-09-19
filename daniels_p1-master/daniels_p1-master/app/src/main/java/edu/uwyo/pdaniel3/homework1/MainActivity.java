package edu.uwyo.pdaniel3.homework1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements DrawerFragment.NavigationDrawerCallbacks {

    private DrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private ListView mListView;
    private CountryData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        mListView = (ListView) findViewById(R.id.listView);
        data = new CountryData();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }
    //this does most of my work, has multiple listeners b/c one listener didn't
    //update the countries
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.drawer1);
                ArrayAdapter<String> adapter;
                List<String> temp = data.getlist(3);
                ArrayList<String> listItems = new ArrayList<String>(temp);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listItems);
                mListView.setAdapter(adapter);

                final String[] Names = temp.toArray(new String[temp.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 2:
                mTitle = getString(R.string.drawer2);
                ArrayAdapter<String> adapter1;
                List<String> temp1 = data.getlist(5);
                ArrayList<String> listItems1 = new ArrayList<String>(temp1);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems1);
                mListView.setAdapter(adapter);

                final String[] Names1 = temp1.toArray(new String[temp1.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names1[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names1[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 3:
                mTitle = getString(R.string.drawer3);
                ArrayAdapter<String> adapter2;
                List<String> temp2 = data.getlist(6);
                ArrayList<String> listItems2 = new ArrayList<String>(temp2);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems2);
                mListView.setAdapter(adapter);

                final String[] Names2 = temp2.toArray(new String[temp2.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names2[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names2[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 4:
                mTitle = getString(R.string.drawer4);
                ArrayAdapter<String> adapter3;
                List<String> temp3 = data.getlist(1);
                ArrayList<String> listItems3 = new ArrayList<String>(temp3);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems3);
                mListView.setAdapter(adapter);

                final String[] Names3 = temp3.toArray(new String[temp3.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names3[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names3[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 5:
                mTitle = getString(R.string.drawer5);
                ArrayAdapter<String> adapter4;
                List<String> temp4 = data.getlist(4);
                ArrayList<String> listItems4 = new ArrayList<String>(temp4);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems4);
                mListView.setAdapter(adapter);

                final String[] Names4 = temp4.toArray(new String[temp4.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names4[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names4[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 6:
                mTitle = getString(R.string.drawer6);
                ArrayAdapter<String> adapter5;
                List<String> temp5 = data.getlist(2);
                ArrayList<String> listItems5 = new ArrayList<String>(temp5);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems5);
                mListView.setAdapter(adapter);

                final String[] Names5 = temp5.toArray(new String[temp5.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names5[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names5[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case 7:
                mTitle = getString(R.string.drawer7);
                ArrayAdapter<String> adapter6;
                List<String> temp6 = data.getlist(0);
                ArrayList<String> listItems6 = new ArrayList<String>(temp6);
                mListView  =(ListView)findViewById(R.id.listView);
                adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        listItems6);
                mListView.setAdapter(adapter);

                final String[] Names6 = temp6.toArray(new String[temp6.size()]);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        // For Long Duration Toast
                        Toast.makeText(getApplicationContext(), Names6[arg2], Toast.LENGTH_LONG).show();
                        // For Long Short Toast
                        Toast.makeText(getApplicationContext(), Names6[arg2], Toast.LENGTH_SHORT).show();

                    }
                });

                break;
        }

    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Only show items in the action bar relevant to this screen
        // if the drawer is not showing. Otherwise, let the drawer
        // decide what to show in the action bar.
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((edu.uwyo.pdaniel3.homework1.MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }


    }

}
