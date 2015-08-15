package com.appifie.digitalbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AccountInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accountinfo);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent main = new Intent(AccountInfo.this,
				DigitalHome.class);
		startActivity(main);
	}

	

}
