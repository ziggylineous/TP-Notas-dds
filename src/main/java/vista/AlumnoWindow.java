package vista;

import modelo.Alumno;
import modelo.AsignacionTarea;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

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

        List<AsignacionTarea> listaAsignaciones = new List<AsignacionTarea>(panelTareas);

        // esto bindea el seleccinado
        listaAsignaciones.bindValueToProperty("asignacionSeleccionada");

        // esto bindea la lista
        Binding<AsignacionTarea, Selector<AsignacionTarea>, ListBuilder<AsignacionTarea>> bindingItems = listaAsignaciones.bindItems(
                new ObservableProperty<AsignacionTarea>("alumno.asignacionesDeTareas"));

        PropertyAdapter adaptadorAsignacionTarea = new PropertyAdapter(AsignacionTarea.class, "tarea");
        bindingItems.setAdapter(adaptadorAsignacionTarea);

        // listaAsignaciones.setWidth(220);
        //listaAsignaciones.setHeight(220);

    }
}
