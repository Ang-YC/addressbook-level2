package seedu.addressbook.data.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Store list of {@link History}, wrapper of `List<History>`
 */
public class HistoryList {
    private List<History> histories = new ArrayList<History>();

    public HistoryList() { }

    public void addHistory(String rawCommand) {
        histories.add(new History(rawCommand));
    }

    public String getHistories() {
        List<String> output = new ArrayList<String>();
        for (History h : histories) {
            output.add(h.getFormattedHistory());
        }
        return String.join("\n", output);
    }
}
