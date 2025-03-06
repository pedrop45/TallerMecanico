package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.Controlador;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;

public class Vista {
    private Controlador controlador;

    public Vista() {
    }

    public void setControlador(Controlador controlador) throws TallerMecanicoExcepcion {
        if (controlador == null) {
            throw new TallerMecanicoExcepcion("El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    public void comenzar() throws TallerMecanicoExcepcion {
        Opcion opcion;
        do {
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
    }

    public void terminar() {
        System.out.println("Gracias por utilizar el sistema de gestión del taller mecánico. ¡Hasta pronto!");
    }

    private void mostrarMenu() {
        System.out.println("\nSistema de Gestión del Taller Mecánico");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    private Opcion elegirOpcion() {
        int numeroOpcion;
        do {
            System.out.print("\nElige una opción: ");
            numeroOpcion = Entrada.entero();
        } while (!Opcion.esValida(numeroOpcion));
        return Opcion.get(numeroOpcion);
    }

    private void ejecutar(Opcion opcion) throws TallerMecanicoExcepcion {
        switch (opcion) {
            case INSERTAR_CLIENTE:
                insertarCliente();
                break;
            case INSERTAR_VEHICULO:
                insertarVehiculo();
                break;
            case INSERTAR_REVISION:
                insertarRevision();
                break;
            case MODIFICAR_CLIENTE:
                modificarCliente();
                break;
            case BORRAR_CLIENTE:
                borrarCliente();
                break;
            case BORRAR_VEHICULO:
                borrarVehiculo();
                break;
            case BORRAR_REVISION:
                borrarRevision();
                break;
            case LISTAR_CLIENTES:
                listarClientes();
                break;
            case LISTAR_VEHICULOS:
                listarVehiculos();
                break;
            case LISTAR_REVISIONES:
                listarRevisiones();
                break;
            case SALIR:
                terminar();
                break;
        }
    }

    private void insertarCliente() throws TallerMecanicoExcepcion {
        System.out.println("\nInsertar Cliente");
        System.out.print("Nombre: ");
        String nombre = Entrada.cadena();
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        System.out.print("Teléfono: ");
        String telefono = Entrada.cadena();
        Cliente cliente = new Cliente(nombre, dni, telefono);
        controlador.insertar(cliente);
    }

    private void insertarVehiculo() throws TallerMecanicoExcepcion {
        System.out.println("\nInsertar Vehículo");
        System.out.print("Marca: ");
        String marca = Entrada.cadena();
        System.out.print("Modelo: ");
        String modelo = Entrada.cadena();
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula);
        controlador.insertar(vehiculo);
    }

    private void insertarRevision() throws TallerMecanicoExcepcion {
        System.out.println("\nInsertar Revisión");
        System.out.print("DNI del Cliente: ");
        String dni = Entrada.cadena();
        Cliente cliente = controlador.buscar(Cliente.get(dni));
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Matrícula del Vehículo: ");
        String matricula = Entrada.cadena();
        Vehiculo vehiculo = controlador.buscar(Vehiculo.get(matricula));
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
        System.out.print("Fecha de inicio (AAAA-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(Entrada.cadena());
        Revision revision = new Revision(cliente, vehiculo, fechaInicio);
        controlador.insertar(revision);
    }

    private void modificarCliente() throws TallerMecanicoExcepcion {
        System.out.println("\nModificar Cliente");
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        Cliente cliente = controlador.buscar(Cliente.get(dni));
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre (dejar en blanco para no modificar): ");
        String nombre = Entrada.cadena();
        System.out.print("Nuevo teléfono (dejar en blanco para no modificar): ");
        String telefono = Entrada.cadena();
        controlador.modificar(cliente, nombre, telefono);
    }

    private void borrarCliente() throws TallerMecanicoExcepcion {
        System.out.println("\nBorrar Cliente");
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        Cliente cliente = controlador.buscar(Cliente.get(dni));
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        controlador.borrar(cliente);
    }

    private void borrarVehiculo() throws TallerMecanicoExcepcion {
        System.out.println("\nBorrar Vehículo");
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        Vehiculo vehiculo = controlador.buscar(Vehiculo.get(matricula));
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
        controlador.borrar(vehiculo);
    }

    private void borrarRevision() throws TallerMecanicoExcepcion {
        System.out.println("\nBorrar Revisión");
        System.out.print("DNI del Cliente: ");
        String dni = Entrada.cadena();
        Cliente cliente = controlador.buscar(Cliente.get(dni));
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Matrícula del Vehículo: ");
        String matricula = Entrada.cadena();
        Vehiculo vehiculo = controlador.buscar(Vehiculo.get(matricula));
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
        System.out.print("Fecha de inicio (AAAA-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(Entrada.cadena());
        Revision revision = new Revision(cliente, vehiculo, fechaInicio);
        if (revision == null) {
            System.out.println("Revisión no encontrada.");
            return;
        }
        controlador.borrar(revision);
    }

    private void listarClientes() {
        System.out.println("\nLista de Clientes");
        for (Cliente cliente : controlador.getClientes()) {
            System.out.println(cliente);
        }
    }

    private void listarVehiculos() {
        System.out.println("\nLista de Vehículos");
        for (Vehiculo vehiculo : controlador.getVehiculos()) {
            System.out.println(vehiculo);
        }
    }

    private void listarRevisiones() {
        System.out.println("\nLista de Revisiones");
        for (Revision revision : controlador.getRevisiones()) {
            System.out.println(revision);
        }
    }
}