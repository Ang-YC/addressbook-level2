package seedu.addressbook.data.history;

/**
 * Store command history
 */
public class History {
    private String rawCommand;
    private int sequenceNum;
    private static int nextSequenceNum = 0;

    History(String rawCommand) {
        this.rawCommand = rawCommand.trim();
        this.sequenceNum = ++nextSequenceNum;
    }

    String getFormattedHistory() {
        return String.format("%d. %s", sequenceNum, rawCommand);
    }
}