package vista;

import modelo.Alumno;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

public class AlumnoWindow extends MainWindow<AlumnoViewModel> {
    public AlumnoWindow(Alumno alumno) {
        super(new AlumnoViewModel(alumno));
    }

    @Override
    public void createContents(Panel mainPanel) {
        setTitle("Vista Alumno");
        
        armarPanelDatos(mainPanel);
        armarPanelTareas(mainPanel);
    }
    
    private void armarPanelDatos(Panel mainPanel) {
    	Panel panelDatos = new Panel(mainPanel);
        panelDatos.setLayout(new VerticalLayout());
        
        new Label(panelDatos).setText("Nombre: ");
        new TextBox(panelDatos).bindValueToProperty("alumno.nombre");

        new Label(panelDatos).setText("Apellido: ");
        new TextBox(panelDatos).bindValueToProperty("alumno.apellido");
    }
    
    private void armarPanelTareas(Panel mainPanel) {
    	Panel panelTareas = new Panel(mainPanel);
    	panelTareas.setLayout(new VerticalLayout());
        
        new Label(panelTareas).setText("Asignaciones: ");
        
    }
}
