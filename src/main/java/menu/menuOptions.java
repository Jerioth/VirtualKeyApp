package menu;
import menu.Menu; 
import menu.FileOptions;

import menu.Index;
public class menuOptions  {

	public static Index Index = new Index();
    public static FileOptions FileOptions = new FileOptions();



    public static Menu SelectedMenu = Index;

    public static Menu getSelectedMenu() {
        return SelectedMenu;
    }

    public static void setSelectedMenu(Menu selectedMenu) {
        SelectedMenu = selectedMenu;
    }

}
