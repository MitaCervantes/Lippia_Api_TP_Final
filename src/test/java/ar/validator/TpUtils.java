package ar.validator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TpUtils {
    public static String horaInicio() {
        ZonedDateTime horaActual = obtenerHoraFormateada();
        return horaActual.toString();
    }

    public static String horaFin() {
        ZonedDateTime horaActual = obtenerHoraFormateada();
        ZonedDateTime horaEnd = horaActual.plusHours(8);
        return horaEnd.toString();
    }

    private static ZonedDateTime obtenerHoraFormateada() {
        ZonedDateTime horaActual = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Z"));
        return horaActual.withNano(0);
    }
}
