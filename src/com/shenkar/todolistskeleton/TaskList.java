package com.shenkar.todolistskeleton;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskList extends ArrayAdapter<String>{
	private final Activity context;
	private final List<String> tasks;
	public TaskList(Activity context, List<String> tasks) {
			super(context, R.layout.task_row, tasks);
			this.context = context;
			this.tasks = tasks;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView= inflater.inflate(R.layout.task_row, null, true);
			TextView task = (TextView) rowView.findViewById(R.id.taskTxt);
			Button delBtn = (Button) rowView.findViewById(R.id.delBtn);
			task.setText(Integer.toString(position+1) + ". " + tasks.get(position));
			final int tmpPos = position;
			//Button hear to delete
			delBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AlertDialog.Builder adb=new AlertDialog.Builder(context);
					adb.setTitle("Delete?");
			        adb.setMessage("Are you sure you want to delete task " + Integer.toString(tmpPos+1) + "?");
			        final int positionToRemove = tmpPos;
			        adb.setNegativeButton("Cancel", null);
			        adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			            	tasks.remove(positionToRemove);
			            	notifyDataSetChanged();
			            }});
			        adb.show();
				}
			});
			return rowView;
	}
	public void add(String task) {
			tasks.add(task);
	}
}