package com.appifie.digitalbank;

import java.io.File;

public class RootCheck {
	 /**
	   * Checks if the device is rooted.
	   *
	   * @return <code>true</code> if the device is rooted, <code>false</code> otherwise.
	   */
	  public static boolean isRooted() {

	    // get from build info
	    String buildTags = android.os.Build.TAGS;
	    if (buildTags != null && buildTags.contains("test-keys")) {
	      return true;
	    }

	    // check if /system/app/Superuser.apk is present
	    try {
	      File file = new File("/system/app/Superuser.apk");
	      if (file.exists()) {
	        return true;
	      }
	    } catch (Exception e1) {
	      // ignore
	    }

	    // try executing commands
	    return canExecuteCommand("/system/xbin/which su")
	        || canExecuteCommand("/system/bin/which su") || canExecuteCommand("which su");
	  }

	  // executes a command on the system
	  private static boolean canExecuteCommand(String command) {
	    boolean executedSuccesfully;
	    try {
	      Runtime.getRuntime().exec(command);
	      executedSuccesfully = true;
	    } catch (Exception e) {
	      executedSuccesfully = false;
	    }

	    return executedSuccesfully;
	  }
	

}
