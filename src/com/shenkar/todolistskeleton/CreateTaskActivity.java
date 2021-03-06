package com.shenkar.todolistskeleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTaskActivity extends Activity {

	private Button btnCreateTask;
	private EditText txtTaskDesc; 
	private Intent resultOfCreate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_task);
		
		btnCreateTask = (Button) findViewById(R.id.btnCreateTask);
		txtTaskDesc = (EditText)findViewById(R.id.textField);
		btnCreateTask.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Editable editableStr = txtTaskDesc.getText();
				Intent returnIntent = new Intent();
				returnIntent.putExtra("result",editableStr.toString());
				setResult(RESULT_OK,returnIntent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_task, menu);
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
