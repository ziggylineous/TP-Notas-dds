package vista;

import modelo.Alumno;
import modelo.AsignacionTarea;
import modelo.Nota;
import modelo.NotaNumerica;
import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.bindings.ValueTransformer;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.PanelBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import org.uqbar.lacar.ui.model.bindings.Observable;

import java.awt.*;


//import java.util.List;


public class AlumnoWindow extends MainWindow<AlumnoViewModel> {
    public AlumnoWindow(Alumno[] listaAlumnos) {
        super(new AlumnoViewModel(listaAlumnos));
    }

    @Override
    public void createContents(Panel mainPanel) {
        setTitle("Vista Alumno");

        mainPanel.setLayout(new ColumnLayout(3));

        armarPanelDatos(mainPanel);
        armarPanelAsignaciones(mainPanel);
        armarPanelAsignacionActual(mainPanel);
    }
    
    private void armarPanelDatos(Panel mainPanel) {
    	Panel panelDatos = new Panel(mainPanel);
        panelDatos.setWidth(200);
        panelDatos.setLayout(new VerticalLayout());

        new Label(panelDatos).setText("Alumno ingresado: ").setBackground(Color.orange);
        new Label(panelDatos).setBackground(Color.orange).bindValueToProperty("alumno.nombre");

        new Label(panelDatos).setText("Nombre: ");
        new TextBox(panelDatos).bindValueToProperty("nombre");

        new Label(panelDatos).setText("Apellido: ");
        new TextBox(panelDatos).bindValueToProperty("apellido");

        new Button(panelDatos).setCaption("Ingresar")
                .onClick(()-> this.getModelObject().obtenerAlumnoPorDatos());

        new Label(panelDatos).setForeground(Color.red).bindValueToProperty("advertencia");

    }

    private void armarPanelAsignaciones(Panel mainPanel) {
    	Panel panelAsignaciones = new Panel(mainPanel);
    	panelAsignaciones.setWidth(200);

        new Label(panelAsignaciones).setText("Asignaciones: ");

        List<AsignacionTarea> listaAsignaciones = new List<AsignacionTarea>(panelAsignaciones);

        // esto bindea el seleccionado
        listaAsignaciones.bindValueToProperty("asignacionSeleccionada");

        // esto bindea la lista
        Binding<AsignacionTarea, Selector<AsignacionTarea>, ListBuilder<AsignacionTarea>> bindingItems = listaAsignaciones.bindItems(
                new ObservableProperty<AsignacionTarea>("alumno.asignacionesDeTareas"));

        PropertyAdapter adaptadorAsignacionTarea = new PropertyAdapter(AsignacionTarea.class, "tarea");
        bindingItems.setAdapter(adaptadorAsignacionTarea);

        listaAsignaciones.setWidth(100);
        listaAsignaciones.setHeight(160);
    }

    public final class AprobadoBoolToStrTransformer implements Transformer<AsignacionTarea, String> {
        @Override
        public String transform(AsignacionTarea asignacionTarea) {
            return asignacionTarea.getAprobada() ? "Aprobaste!" : "Todavía no aprobaste";
        }
    }

    private void armarPanelAsignacionActual(Panel mainPanel) {
        Panel panelTarea = new Panel(mainPanel);
        panelTarea.setWidth(200);

        Label encabezamiento = new Label(panelTarea);
        encabezamiento.bindValueToProperty("asignacionSeleccionada.tarea");

        List<Nota> tablaNotas = new List<>(panelTarea);
        tablaNotas.bindItemsToProperty("asignacionSeleccionada.notas");

        tablaNotas.setWidth(50);
        tablaNotas.setHeight(100);

        new Label(panelTarea)
                .bindValue(new ObservableProperty<AsignacionTarea>("asignacionSeleccionada"))
                .setModelToView(new AprobadoBoolToStrTransformer());
    }
}
