package util;


public class Logger{
	private static DebugLevel debugLevel;

    public static enum DebugLevel { OUTPUT,DATASTRUCTURE,RESULT,THREAD,CONSTRUCTOR };


    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 0: 
    			debugLevel = DebugLevel.OUTPUT; 
    			break;
    		case 1: 
    			debugLevel = DebugLevel.DATASTRUCTURE; 
    			break;
    		case 2: 
    			debugLevel = DebugLevel.RESULT; 
    			break;
    		case 3: 
    			debugLevel = DebugLevel.THREAD; 
    			break;
    		case 4: 
    			debugLevel = DebugLevel.CONSTRUCTOR; 
    			break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }
    /**
     * Writing corresponding message according to the set debug value
     * @param message
     * @param levelIn
     */
    // @return None
    public static void writeMessage (String message,DebugLevel levelIn ) {
    	
    	if (levelIn==debugLevel){
    		System.out.println(message);
    	}
    }
    public static void writeOutput(){
    	System.out.println(debugLevel);
    }
    
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}
