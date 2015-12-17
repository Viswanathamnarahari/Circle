package com.mycompany.myapp2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.ViewDebug.*;

public class MainActivity extends Activity
{
	int arraySize      =999;
	int arraySize_bak;
	int[] subjects     = new int[arraySize+1] ;
	int[] tempSubjects = new int[arraySize+1] ;
	String data = "";
	//char NEW_LINE = "\n";
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		
    }
	
	public void onStartClick(View main){
		
		arraySize = 0;
		String instring;
		
		EditText editText = (EditText)findViewById(R.id.editText);
		instring = editText.getText().toString();
		if(instring.length() < 1) return;
		
		arraySize = arraySize + Integer.valueOf(editText.getText().toString());
		
		if ((arraySize > 999)||(arraySize < 1))
		{ 
		return ;
		}
		else
		{
		TextView roundsData = (TextView)findViewById(R.id.roundsView);
		data="";
		method(roundsData);}
	}

	private void method(TextView roundsData)
	{
		
		//initialize subjects

		for (int i = 0; i < arraySize; i++) {
			subjects[i] = i+1;
			}
		getData();
		roundsData.setText(data);
		
			while(arraySize != 1)
			{
			kill();
			
			getData();
			roundsData.setText(data);
			}
		TextView winner = (TextView)findViewById(R.id.winner);
		
		winner.setText(Integer.toString(subjects[0]));
		
	}

	private void getData()
	{
		
		data = data + "\n";
		data = data  + Integer.toString(arraySize)+ ":";
		int i =0;
		while(subjects[i] != 0) {
			data = data + Integer.toString(subjects[i]) + " ";
			i = i+1;
		}
	}
	public boolean oddSubjects(){
		Boolean oddSubjects = true;
		
		if (arraySize % 2 == 0)
			oddSubjects = false;
		else
			oddSubjects = true;
		return oddSubjects;
		
	}
	
	
	public boolean evenSubject(int number){
		Boolean evenSubject = false;

		if (number % 2 == 0)
			evenSubject = true;
		
		return evenSubject;

	}
	public void kill(){
		int t =0;
		int i =0;
		while(subjects[i] != 0) {
			if( oddObjectsFirst(i)){
				i=i+1; 
				continue;
				}
			if(evenSubject(i)){
				tempSubjects[t] = subjects[i];
				t = t +1;
			}
			i= i + 1;
		}
		cleanArray(subjects);
		copyTempToSubjects();
		cleanArray(tempSubjects);
	}

	private boolean oddObjectsFirst(int i)
	{
		boolean oddObjectsFirst = false;
		if((i == 0) && (arraySize%2==1)){
			oddObjectsFirst = true;
		}
		// TODO: Implement this method
		return oddObjectsFirst;
	}

	private void copyTempToSubjects()
	{
		int i =0;
		while(tempSubjects[i] != 0) {
				subjects[i] =tempSubjects[i] ;
				i= i + 1;
			}
			arraySize = i;
	}
	public void cleanTemp(){
		for (int i = 0; i < tempSubjects.length; i++) {
		tempSubjects[i] = 0;
		}
	}
	public void cleanArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}	
	
	
}
