package com.appifie.digitalbank;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DigitalHome extends Activity implements OnClickListener {
	ActionBar ab;
	EditText code;
	String CODE = "1234";
	String getcode;
	int flag;

	@SuppressWarnings("static-access")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		getActionBar().hide();

		setContentView(R.layout.activity_digital_home);

		RootCheck root = new RootCheck();
		if (root.isRooted() == true) {
			Button exit, website;
			LayoutInflater inflater = getLayoutInflater();
			getWindow().addContentView(
					inflater.inflate(R.layout.rootcheck, null),
					new ViewGroup.LayoutParams(
							ViewGroup.LayoutParams.FILL_PARENT,
							ViewGroup.LayoutParams.FILL_PARENT));
			exit = (Button) findViewById(R.id.exit);
			website = (Button) findViewById(R.id.website);
			exit.setOnClickListener(this);
			website.setOnClickListener(this);
			/*
			 * Toast.makeText(getApplicationContext(), "Rooted",
			 * Toast.LENGTH_LONG) .show();
			 */} else {
			Button account, care, transfer;
			account = (Button) findViewById(R.id.account);
			care = (Button) findViewById(R.id.care);
			transfer = (Button) findViewById(R.id.mtransfer);
			account.setOnClickListener(this);
			care.setOnClickListener(this);
			transfer.setOnClickListener(this);
			/*
			 * Toast.makeText(getApplicationContext(), "not Rooted",
			 * Toast.LENGTH_LONG).show();
			 */
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.digital_home, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.exit:
			finish();
			break;
		case R.id.clr:
			code.setText(null);

			break;
		case R.id.ok:
			getcode = code.getText().toString();
			
			if (getcode.equals(CODE)&& flag == 0) {
				finish();
				account();
			}
			else if(getcode.equals(CODE)&& flag == 1) {
				finish();
				mtransfer();
			}else{
				Toast.makeText(this, "Wrong input", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.account:
			passCode(0);
			

			break;
		case R.id.mtransfer:
			passCode(1);
			break;
		}

	}

	public int passCode(int a) {
		flag = a;
		Button ok, clear;

		LayoutInflater inflater = getLayoutInflater();
		getWindow().addContentView(
				inflater.inflate(R.layout.password, null),
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
						ViewGroup.LayoutParams.FILL_PARENT));
		ok = (Button) findViewById(R.id.ok);
		clear = (Button) findViewById(R.id.clr);
		code = (EditText) findViewById(R.id.passcode);
		ok.setOnClickListener(this);
		clear.setOnClickListener(this);

		return flag;
	}

	public void account() {
		Intent accounts = new Intent(DigitalHome.this,
				AccountInfo.class);
		startActivity(accounts);
	}

	public void mtransfer() {
		Intent mtransfer = new Intent(DigitalHome.this, MoneyTransfer.class);
		startActivity(mtransfer);
	}
}
