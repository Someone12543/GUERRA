package observer;

public interface Subject {
	public void obsAdd(Observer o);
	public void obsRemove(Observer o);
	public Object obsGet(int i);
}
