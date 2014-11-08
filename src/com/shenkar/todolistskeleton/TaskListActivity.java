package com.shenkar.todolistskeleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends Activity {
	
	private Button btnAddTask;
	private ListView taskList;
	
	private ArrayAdapter<String> listData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAddTask = (Button) findViewById(R.id.btnAddTask);
		btnAddTask.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), com.shenkar.todolistskeleton.CreateTaskActivity.class);
				startActivity(i);
			}
		});
		
		taskList = (ListView) findViewById(R.id.listView);
		listData = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
		taskList.setAdapter(listData);
		
		String str[] = new String[20];
		str[0] = "Do homework";
		str[1] = "Buy socks";
		str[2] = "Call Mom";
		str[3] = "Watch the movie";
		str[4] = "Learn how to be good";
		str[5] = "End with this App";
		for (int i=0; i<20; i++) {
			int j = (int) (Math.random()* 5);
			listData.add(str[j]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
