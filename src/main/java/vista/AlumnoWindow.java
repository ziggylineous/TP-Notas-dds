package vista;

import modelo.Alumno;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

public class AlumnoWindow extends MainWindow<Alumno> {
    public AlumnoWindow() {
        super(new Alumno("ignacio", "ferrari", "140-970-0"));
    }

    @Override
    public void createContents(Panel mainPanel) {
        setTitle("Vista Alumno");
        mainPanel.setLayout(new VerticalLayout());

        new Label(mainPanel).setText("Nombre: ");
        new TextBox(mainPanel).bindValueToProperty("nombre");

        new Label(mainPanel).setText("Apellido: ");
        new TextBox(mainPanel).bindValueToProperty("apellido");
    }
}
