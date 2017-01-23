package util;


public class MyLogger {
	public static enum DebugLevel { 
		CONSTRUCTOR,
		THREAD,
		RESULT,
		DATA_STRUCTURE,
		OUTPUT
	   };

	   private static DebugLevel debugLevel;

	   /**
	    * Set the debug values using enum
	    * @param levelIn
	    */
	   public static void setDebugValue (int levelIn) {
		   switch (levelIn) {
		   		case 4: debugLevel = DebugLevel.CONSTRUCTOR;
		   			break;
		   		case 3: debugLevel = DebugLevel.THREAD;
		   			break;
		   		case 2: debugLevel = DebugLevel.RESULT;
		   			break;
		   		case 1: debugLevel = DebugLevel.DATA_STRUCTURE;
		   			break;
		   		case 0: debugLevel = DebugLevel.OUTPUT;
		   			break;
		   		default: 
		   			break;
		   }
	   }

	   /**
	    * Set the debug value as per the user
	    * @param levelIn
	    */
	   public static void  writeOuput(){
		   //System.out.println(" "+);
	   }
	   public static void setDebugValue (DebugLevel levelIn) {
		   debugLevel = levelIn;
	   }
	   
	   /**
	    * retrieve the debug value 
	    * @return
	    */
	   public static DebugLevel getDebugLevel() {
		   return debugLevel;
	   }

	   /**
	    * print 
	    * @param message
	    * @param levelIn
	    */
	   public static void writeMessage (String message, DebugLevel levelIn) {
		   if (levelIn.equals(debugLevel))
			   System.out.println(message);
	   }

	  
	   /**
	    * 
	    */
	   public String toString() {
		   return "Debug Level is " + debugLevel;
	   }
}
