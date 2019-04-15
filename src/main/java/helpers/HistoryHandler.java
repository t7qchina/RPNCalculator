package helpers;

import java.util.LinkedList;

public class HistoryHandler {
    private LinkedList<OperandStack> snapshots;
    private int index = 0;

    public HistoryHandler() {
        snapshots = new LinkedList<>();
        snapshots.addLast(new OperandStack());
    }

    public synchronized OperandStack back() {
        if (--index < 0) {
            index = 0;
        }
        return snapshots.get(index);
    }

    public synchronized OperandStack getCurrent() {
        return snapshots.get(index);
    }

    public synchronized OperandStack forward() {
        if (++index == snapshots.size()) {
            index = snapshots.size() - 1;
        }
        return snapshots.get(index);
    }

    public synchronized void addSnapshot(OperandStack snapshot) {
        if (snapshots.get(index)
                .equals(snapshot)) {
            return;
        }

        OperandStack clone = (OperandStack) snapshot.clone();
        if (++index == snapshots.size()) {
            snapshots.addLast(clone);
        } else {
            snapshots.set(index, clone);
            int next = index + 1;
            while (next < snapshots.size()) {
                snapshots.remove(next);
            }
        }
    }

    public int getCurrentIndex() {
        return index;
    }

    public int getHistorySize() {
        return snapshots.size();
    }
}
