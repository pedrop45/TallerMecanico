package org.iesalandalus.programacion.tallermecanico.vista.eventos;

import java.util.HashMap;
import java.util.Map;

public enum Evento {
    INSERTAR_CLIENTE(11, "Insertar cliente"),
    BUSCAR_CLIENTE(21, "Buscar cliente"),
    BORRAR_CLIENTE(31, "Borrar cliente"),
    LISTAR_CLIENTES(41, "Listar clientes"),
    MODIFICAR_CLIENTE(60, "Modificar cliente"),
    INSERTAR_VEHICULO(12, "Insertar vehiculo"),
    BUSCAR_VEHICULO(22, "Buscar vehiculo"),
    BORRAR_VEHICULO(32, "Borrar vehiculo"),
    LISTAR_VEHICULOS(42, "Listar vehículos"),
    INSERTAR_REVISION(13, "Insertar revision"),
    INSERTAR_MECANICO(14, "Insertar trabajo mecanico."),
    BUSCAR_TRABAJO(15, "Buscar trabajo."),
    BORRAR_TRABAJO(33, "Borrar trabajo"),
    LISTAR_TRABAJOS(35, "Listar trabajos"),
    LISTAR_TRABAJOS_CLIENTE(36, "Listar trabajos de un cliente"),
    LISTAR_TRABAJOS_VEHICULO(45, "Listar trabajos de un vehiculo"),
    ANADIR_HORAS_TRABAJO(38, "Añadir horas a un trabajo."),
    ANADIR_PRECIO_MATERIAL_TRABAJO(52, "Añadir precio deL material a un trabajo."),
    CERRAR_TRABAJO(70, "Cerrar trabajo."),
    MOSTRAR_ESTADISTICAS_MENSUALES(41, "Mostrar estadisticas mensuales."),
    SALIR(0, "Salir.");

    private final int codigo;
    private final String mensaje;
    private static final Map<Integer, Evento> eventos = new HashMap<>();

    static {
        for (Evento evento : Evento.values()) {
            eventos.put(evento.codigo, evento);
        }
    }

    private Evento(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public static boolean esValido(int codigo) {
        return eventos.containsKey(codigo);
    }

    public static Evento get(int codigo) {
       if (!esValido(codigo)) {
           throw new IllegalArgumentException("El código no es correcto.");
       }
       return eventos.get(codigo);
    }

    @Override
    public String toString() {
        return mensaje;
    }
}