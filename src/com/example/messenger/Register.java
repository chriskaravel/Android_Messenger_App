package com.example.messenger;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.messenger.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


 /**
 * H Class Register einai h Activity class thats shows the user registration screen
 * and allows the user to register to Parse Server.
 */
public class Register extends CustomActivity
{
	
	private EditText u;
	private EditText p;
	private EditText e;
	
	//function show message
	void show(String x){
		AlertDialog.Builder alertDialog=new AlertDialog.Builder(Register.this);
		alertDialog.setTitle("Message");
		alertDialog.setMessage(x);
		alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		alertDialog.show();
	}
	
	// validating email id
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	// validating password with retype password
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() > 5) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);//set the layout view
		setTouchNClick(R.id.btnReg);
		u = (EditText) findViewById(R.id.user);
		p = (EditText) findViewById(R.id.pwd);
		e = (EditText) findViewById(R.id.email);
	}
	public void onClick(View v)
	{
		super.onClick(v);
		
		if (u.length() == 0 || p.length() == 0 || e.length() == 0)
		{
			show("you havent filled all the fields");
		}	
		final String email = e.getText().toString();
		final String pass = p.getText().toString();
		if (!isValidEmail(email)) {
			e.setError("Invalid Type of Email");
		}
		//epali8eysi mhkos kwdikou
		if (!isValidPassword(pass)) {
			p.setError("Invalid Length of Password");
		}
		if (u.length() !=0 && p.length() !=0 && e.length() !=0 && isValidEmail(email) && isValidPassword(pass))
		{
		String a = u.getText().toString();
		String b = p.getText().toString();
		String c = e.getText().toString();
		final ParseUser user = new ParseUser();//create Parse User
		user.setUsername(a);
		user.setPassword(b);
		user.setEmail(c);
		// other fields can be set just like with ParseObject
		user.put("phone", "650-555-0000");
	    
		user.signUpInBackground(new SignUpCallback() {
		    public void done(ParseException e) {
		      if (e == null) {
		        // Hooray! Let them use the app now.
				Intent i = new Intent(Register.this,Login.class);
		        startActivity(i);

		      } else {
		        // Sign up didn't succeed. Look at the ParseException
		        // to figure out what went wrong
		      }
		    }
		  });
		}
	}
}
