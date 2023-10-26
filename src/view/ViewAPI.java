package view;

public class ViewAPI {
	
	public static ViewAPI instance;
	
	private ViewAPI() {
		TelaPrincipal t = new TelaPrincipal();
		t.setTitle("WAR");
		t.setVisible(true);
	}
	
	public static ViewAPI getViewAPI() {
		if (instance == null)
			instance = new ViewAPI();
		return instance;
	}
}
