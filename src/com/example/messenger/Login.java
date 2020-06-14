package com.example.messenger;


import com.example.messenger.R;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Login extends CustomActivity {
	
	private EditText u;				// username edittext
	private EditText p;				// password edittext 
	static int a=0;					//variable for Parse Initialize
	final Context context = this;	//Context for Alert Dialog
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);//set the layout view
		//Connect with Parse 
		if(a==0){
			Parse.initialize(this, "put your keys here", "put your keys here");
		
			a=1;
		}
		
		setTouchNClick(R.id.btnLogin);
		setTouchNClick(R.id.btnReg);
		u = (EditText) findViewById(R.id.user);//insert  username edittext
		p = (EditText) findViewById(R.id.pwd);//insert password edittext
	}

	@Override
	public void onClick(View v)
	{
		super.onClick(v);
		if (v.getId() == R.id.btnReg)//when press btn register
		{
			startActivityForResult(new Intent(this, Register.class), 10);//redirect to class Register
		}
		else
		{
			if (u.length() !=0 && p.length() !=0)
			{
			String username = u.getText().toString();//get text from edittext
			String password = p.getText().toString();/
			ParseUser.logInInBackground(username, password, new LogInCallback() {
				  public void done(ParseUser user, ParseException e) {
				    if (user != null) {
				      // Hooray! The user is logged in.
				    	UserList.user = user;//insert user to UserList
				    	Const.EXTRA_DATA2 = u.getText().toString();
				    	Intent i = new Intent(Login.this,UserList.class);
		                startActivity(i);
				    } else {
				      // Signup failed. Look at the ParseException to see what happened.

				    			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				    				context);
				    			// set title
				    			alertDialogBuilder.setTitle("Wrong Credential");
				    			// set dialog message
				    			alertDialogBuilder
				    				.setMessage("The username or password you entered is incorrect !")
				    				.setCancelable(false)
				    				.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
				    					public void onClick(DialogInterface dialog,int id) {
				    						// if this button is clicked, close	
				    					}
				    				  });
				    				// create alert dialog
				    				AlertDialog alertDialog = alertDialogBuilder.create();

				    				// show it
				    			alertDialog.show();
				    }
				  }
				});
			
			}
		}
	}
}