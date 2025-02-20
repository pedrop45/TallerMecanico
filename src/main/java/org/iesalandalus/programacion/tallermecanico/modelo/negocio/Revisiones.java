package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {

    private List<Revision> revisiones;

    public Revisiones() {
        revisiones = new ArrayList<>();
    }
    public List<Revision> get() {
        return new ArrayList<>(revisiones);
    }


    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede borrar una revision nula.");

        if (!revisiones.contains(revision)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revision ");
        }
    }








}
