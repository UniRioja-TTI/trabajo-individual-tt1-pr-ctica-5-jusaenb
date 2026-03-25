package com.tt1.trabajo;

import modelo.Destinatario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import servicios.ServicioEmail;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

class ServicioEmailTest {

    @Test
    void testEnviarEmailBasico() {
        Logger mockLogger = Mockito.mock(Logger.class);
        ServicioEmail servicio = new ServicioEmail(mockLogger);

        boolean resultado = servicio.enviarEmail(new Destinatario(), "test");

        assertTrue(resultado);

        Mockito.verify(mockLogger, Mockito.atLeastOnce()).info(anyString(), Optional.ofNullable(any()));
    }
}