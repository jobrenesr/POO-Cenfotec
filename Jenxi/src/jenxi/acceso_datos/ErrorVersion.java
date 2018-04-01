
package jenxi.acceso_datos;

import java.time.LocalDate;

public class ErrorVersion extends CaracteristicaVersion
{
    private LocalDate fechaReporte;

    public ErrorVersion(String descripcion,
                        LocalDate pfechaReporte)
    {
        super(descripcion);
        fechaReporte = pfechaReporte;
    }

    public ErrorVersion() {
        super();
    }

    public ErrorVersion(String descripcion) {
        super(descripcion);
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate pfechaReporte) {
        fechaReporte = pfechaReporte;
    }
}
