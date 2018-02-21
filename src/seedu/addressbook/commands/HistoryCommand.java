package seedu.addressbook.commands;

/**
 * Show command history in current session.
 */
public class HistoryCommand extends Command {

    public static final String COMMAND_WORD = "history";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Show command history in current session.\n"
            + "Example: " + COMMAND_WORD;

    public HistoryCommand() {}

    @Override
    public CommandResult execute() {
        return new CommandResult(historyList.getHistories());
    }
}
