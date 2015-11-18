package com.example.pull;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
ListView list;
CustomAdapter adapter;
ArrayList<Person>dataArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list=(ListView) findViewById(R.id.listView1);
        list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void pull(View v){
    	
    	String url="http://10.0.2.2/pull/fetch.php";
    	
    AsyncHttpClient client= new AsyncHttpClient()	;
    client.get(url, new AsyncHttpResponseHandler() {
		
		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] response) {
			// TODO Auto-generated method stub
			String data=new String(response);
			try {
				JSONArray array=new JSONArray(data);
			for(int x=0;x<array.length();x++){
				
				JSONObject obj=array.getJSONObject(x);
				String id=obj.getString("id");
			    String names=obj.getString("names");
			    String email=obj.getString("email");
			    String city=obj.getString("city");
			    Person p= new Person(id,names,email,city);
			    dataArray.add(p);
			    Log.d("DATA",id+":"+names+":"+email+":"+city);
			}
			adapter.notifyDataSetChanged();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.e("DATA","Error with JSON");
			}
		}
		
		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			// TODO Auto-generated method stub
			Log.e("DATA","Failed To fetch");
		}
	});
    	
    }
}
