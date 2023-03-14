package tools;
import java.util.Set;
import java.util.HashSet;
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
