package spandroid.dev.base.java.viewHolder;

public interface RVObservable {
    void registerObserver(RVObserver o);
    void notifyListenerAttached();
    void removeObserver();
}