package tech.ada.testes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AngulosTest {
    private final Angulos angulos = new Angulos();

    @Test
    void testNaoFormaTriangulo() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(10d,10d,20d));
    }

    @Test
    void testTodosLadosZero() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(0d,0d,0d));
    }

    @Test
    void testDoisLadosZero() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(10d,0d,0d));
    }

    @Test
    void testUmLadoZero() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(10d,10d,0d));
    }

    @Test
    void testTodosLadosNegativos() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(-10d,-10d,-10d));
    }

    @Test
    void testDoisLadosNegativos() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(10d,-10d,-10d));
    }

    @Test
    void testUmLadoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> angulos.calcula(10d,10d,-10d));
    }

    @Test
    void testTodosLadosDecimais() {
        List<Double> angulosList = angulos.calcula(7.2d,3.5d,7.2d);

        assertEquals(75.94, angulosList.get(0));
        assertEquals(28.13, angulosList.get(1));
        assertEquals(75.94, angulosList.get(2));
    }
    @Test
    void testEquilatero() {
        List<Double> angulosList = angulos.calcula(10d,10d,10d);

        angulosList.forEach(angulo -> {
            assertEquals(60, angulo);
        });
    }

    @Test
    void testIsosceles() {
        List<Double> angulosList = angulos.calcula(10d,10d,12d);

        assertEquals(53.13, angulosList.get(0));
        assertEquals(53.13, angulosList.get(1));
        assertEquals(73.74, angulosList.get(2));
    }

    @Test
    void testEscaleno() {
        List<Double> angulosList = angulos.calcula(10d,11d,12d);

        assertEquals(51.32, angulosList.get(0));
        assertEquals(59.17, angulosList.get(1));
        assertEquals(69.51, angulosList.get(2));
    }

    @Test
    void testRetangulo() {
        var angulosList = angulos.calcula(8d,15d,17d);

        boolean angulo90 = angulosList.stream().anyMatch(angulo -> angulo == 90d);

        assertTrue(angulo90);
    }

    @Test
    void testObtusangulo() {
        var angulosList = angulos.calcula(9d,8d,1d);

        boolean anguloMaiorQue90 = angulosList.stream().anyMatch(angulo -> angulo > 90d);

        assertTrue(anguloMaiorQue90);
    }

    @Test
    void testAcutangulo() {
        var angulosList = angulos.calcula(9d,8d,6d);

        boolean angulosMenoresQue90 = angulosList.stream().noneMatch(angulo -> angulo >= 90d);

        assertTrue(angulosMenoresQue90);
    }
}