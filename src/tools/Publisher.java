package src.tools;

import java.util.HashSet;
import java.util.Set;
public class Publisher {
    Set<Subscriber> subs = new HashSet<>();
    public void notifySubscribers() {
        for (Subscriber s : subs) {
            s.update();
        }
    }

    public void subscribe(Subscriber s) {
        subs.add(s);
    }

    public void unSubscribe(Subscriber s) {
        subs.remove(s);
    }
}
