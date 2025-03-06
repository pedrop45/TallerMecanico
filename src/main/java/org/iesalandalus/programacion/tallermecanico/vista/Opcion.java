package org.iesalandalus.programacion.tallermecanico.vista;

import java.util.HashMap;
import java.util.Map;

enum Opcion {
    INSERTAR_CLIENTE(1, "1 Insertar Cliente"),
    BUSCAR_CLIENTE(2, "2 Buscar Cliente"),
    BORRAR_CLIENTE(3, "3 Borrar Cliente"),
    LISTAR_CLIENTES(4, "4 Listar Clientes"),
    MODIFICAR_CLIENTE(5, "5 Modificar Cliente"),
    INSERTAR_VEHICULO(6, "6 Insertar Vehículo"),
    BUSCAR_VEHICULO(7, "7 Buscar Vehículo"),
    BORRAR_VEHICULO(8, "8 Borrar Vehículo"),
    LISTAR_VEHICULOS(9, "9 Listar Vehículos"),
    INSERTAR_REVISION(10, "10 Insertar Revisión"),
    BUSCAR_REVISION(11, "11 Buscar Revisión"),
    BORRAR_REVISION(12, "12 Borrar Revisión"),
    LISTAR_REVISIONES(13, "13 Listar Revisiones"),
    LISTAR_REVISIONES_CLIENTE(14, "14 Listar Revisiones por Cliente"),
    LISTAR_REVISIONES_VEHICULO(15, "15 Listar Revisiones por Vehículo"),
    ANADIR_HORAS_REVISION(16, "16 Añadir Horas a Revisión"),
    ANADIR_PRECIO_MATERIAL_REVISION(17, "17 Añadir Precio de Material a Revisión"),
    CERRAR_REVISION(18, "18 Cerrar Revisión"),
    SALIR(19, "19 Salir");

    private static final Map<Integer, Opcion> opciones = new HashMap<>();
    private int numeroOpcion;
    private String mensaje;

    static {
        for (Opcion opcion : values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }

    Opcion(int numeroOpcion, String mensaje) {
        this.numeroOpcion = numeroOpcion;
        this.mensaje = mensaje;
    }

    public static boolean esValida(int numeroOpcion) {
        return opciones.containsKey(numeroOpcion);
    }

    public static Opcion get(int numeroOpcion) {
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return mensaje;
    }
}