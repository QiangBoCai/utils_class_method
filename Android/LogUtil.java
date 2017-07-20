/******************************************************************************
 @file    LogUtil.java
---------------------------------------------------------------------------
   
 ---------------------------------------------------------------------------
 ******************************************************************************/


package com.xxx.util;

public class LogUtil
{
	
    
    protected static final String TAG = "XXXPackageName";
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    
    public static final int LEVEL = INFO;
    public static boolean LOG_SWITCH=true;
    
    /**
     * Print different levels log
     * @param msg The message you would like logged.
     * @param thr An exception to log
     * */
    public static void print(String msg)
    {
    	if(!LOG_SWITCH)
    	{
    		return;
    	}
        switch(LEVEL)
        {

        case VERBOSE:
        {
        	v(buildMessage(msg));
        }
        break;
        case DEBUG:
        {
        	 d(buildMessage(msg));
        }
        break;
        case INFO:
        {
        	 i(buildMessage(msg));
        }
        break;
        case WARN:
        {
        	 w(buildMessage(msg));
        }
        break;
        case ERROR:
        {
        	 e(msg);
        }
        break;
        case NOTHING:

        	break;
        
        }
    	
    	
    }
    

    /**
     * Print different levels log
     * @param msg The message you would like logged.
     * @param thr An exception to log
     * */
    public static void print(String msg, Throwable thr) 
    {
    	if(!LOG_SWITCH)
    	{
    		return;
    	}
        switch(LEVEL)
        {        

        case VERBOSE:
        {
        	 v(msg , thr);
        }
        break;
        case DEBUG:
        {
        	 d(msg , thr);
        }
        break;
        case INFO:
        {
        	 i(msg , thr);
        }
        break;
        case WARN:
        {
        	 w(msg , thr);
        }
        break;
        case ERROR:
        {
        	 e(msg , thr);
        }
        break;
        case NOTHING:

        break;        
        }
    		
    }
    /**
     * Send a VERBOSE log message.
     * @param msg The message you would like logged.
     */
    public static void v(String msg)
    {
        android.util.Log.v(TAG, (msg));
    }

    /**
     * Send a VERBOSE log message and log the exception.
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void v(String msg, Throwable thr)
    {
        android.util.Log.v(TAG, buildMessage(msg), thr);
    }

    /**
     * Send a DEBUG log message.
     * @param msg
     */
    public static void d(String msg)
    {
        android.util.Log.d(TAG, (msg));
    }

    /**
     * Send a DEBUG log message and log the exception.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void d(String msg, Throwable thr)
    {
        android.util.Log.d(TAG, buildMessage(msg), thr);
    }

    /**
     * Send an INFO log message.
     * @param msg The message you would like logged.
     */
    public static void i(String msg)
    {
        android.util.Log.i(TAG, /*buildMessage*/(msg));
    }

    /**
     * Send a INFO log message and log the exception.
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void i(String msg, Throwable thr) 
    {
        android.util.Log.i(TAG, buildMessage(msg), thr);
    }



    /**
     * Send a WARN log message
     * @param msg The message you would like logged.
     */
    public static void w(String msg) 
    {
        android.util.Log.w(TAG, (msg));
    }

    /**
     * Send a WARN log message and log the exception.
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void w(String msg, Throwable thr) 
    {
        android.util.Log.w(TAG, buildMessage(msg), thr);
    }

    /**
     * Send an empty WARN log message and log the exception.
     * @param thr An exception to log
     */
    public static void w(Throwable thr)
    {
        android.util.Log.w(TAG, buildMessage(""), thr);
    }
    
    /**
     * Send an ERROR log message.
     * @param msg The message you would like logged.
     */
    public static void e(String msg)
    {
        android.util.Log.e(TAG, msg);
    }
    
    /**
     * Send an ERROR log message and log the exception.
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void e(String msg, Throwable thr)
    {
        android.util.Log.e(TAG, buildMessage(msg), thr);
    }

    /**
     * Building Message
     * @param msg The message you would like logged.
     * @return Message String
     */
    protected static String buildMessage(String msg) 
    {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];

         return new StringBuilder()
                .append(caller.getClassName().substring(20))
                .append(".")
                .append(caller.getMethodName())
                .append("(): ")
                .append(msg).toString();
    }
    
}