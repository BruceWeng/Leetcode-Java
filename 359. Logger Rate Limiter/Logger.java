import java.util.*;
class Logger {
    private HashMap<String, Integer> wordLog; //<Message, Timestamp>
    private int duration;
    /** Initialize your data structure here. */
    public Logger() {
        duration = 10;
        wordLog = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!wordLog.containsKey(message) || timestamp - wordLog.get(message) >= duration) {
            wordLog.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
