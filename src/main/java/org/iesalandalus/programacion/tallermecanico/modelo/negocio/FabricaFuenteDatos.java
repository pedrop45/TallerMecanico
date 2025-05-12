package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.negocio.ficheros.FuenteDatosFicheros;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.ficheros.IFuenteDatos;

public enum FabricaFuenteDatos {
    MEMORIA {
        public IFuenteDatos crear() {
            return new FuenteDatosFicheros();
        }
    };
    public abstract IFuenteDatos crear();
}
