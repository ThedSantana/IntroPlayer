package com.galadar.introplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class VideoSelector extends AppCompatActivity implements ListView.OnItemClickListener {

    int[] ids = new int[2];
    CheckBox clickExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_selector);
        setTitle("VidSelector");


        ArrayList<String> names = new ArrayList<String>();
        names.add(0, "Video 1");
        names.add(1, "Video 2");


        ids[0] = R.raw.aweow_460sv;
        ids[1] = R.raw.sdsfea;



        clickExit = (CheckBox)findViewById(R.id.clickBox);


        ListView lv = (ListView)findViewById(R.id.list0);

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names));

        lv.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video_selector, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, VideoPlayer.class);
        Bundle data = new Bundle();
        data.putInt("ID", ids[position]);
        data.putBoolean("Click", clickExit.isChecked() );
        intent.putExtras(data);
        startActivity(intent);
    }
}
