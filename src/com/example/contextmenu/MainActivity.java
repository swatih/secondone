package com.example.contextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView listView1;  
    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView1=(ListView)findViewById(R.id.listView1);  
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);  
        listView1.setAdapter(adapter);  
        // Register the ListView  for Context menu  
        registerForContextMenu(listView1); 
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Select The Action");    
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title   
        menu.add(0, v.getId(), 0, "SMS");   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
        if(item.getTitle()=="Call"){  
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();  
        }    
        else if(item.getTitle()=="SMS"){  
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();  
        }else{  
           return false;  
        }    
      return true;    
		
	}

}
