package com.shenkar.todolistskeleton;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends Activity {
	
	private Button btnAddTask;
	private ListView taskList;
	private String tag;
	private List<String> tasks;
	private TaskList listData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		tag = "TaskListActivity";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAddTask = (Button) findViewById(R.id.btnAddTask);
		btnAddTask.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i(tag, "Button clicked!");
				Intent i = new Intent(TaskListActivity.this, com.shenkar.todolistskeleton.CreateTaskActivity.class);
				startActivityForResult(i, 1);
			}
		});
		
		tasks = new ArrayList<String>();
		listData = new TaskList(TaskListActivity.this, tasks);
		taskList=(ListView)findViewById(R.id.listView);
		taskList.setAdapter(listData);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
	        if(resultCode == RESULT_OK){
	            String result=data.getStringExtra("result");
	            if (result.compareTo("") == 0) {
	            	Toast.makeText(this, "Empty task!", Toast.LENGTH_LONG).show();
	            } else {
	            	tasks.add(result);
	            	listData.notifyDataSetChanged();
	            }
	        }
	        if (resultCode == RESULT_CANCELED) {
	            //Write your code if there's no result
	        }
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
