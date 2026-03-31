package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {
    private String capturarSaida(Runnable acao) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));
        acao.run();
        System.setOut(original);
        return output.toString();
    }

    @Test
    void ReproduzirMP3() {
        Player player = new PlayerSimples(new MP3());
        String saida = capturarSaida(() -> player.tocar("teste.mp3"));
        assertTrue(saida.contains("MP3"));
    }

    @Test
    void ReproduzirWAV() {
        Player player = new PlayerSimples(new WAV());
        String saida = capturarSaida(() -> player.tocar("teste.wav"));
        assertTrue(saida.contains("WAV"));
    }

    @Test
    void ReproduzirFLAC() {
        Player player = new PlayerSimples(new FLAC());
        String saida = capturarSaida(() -> player.tocar("teste.flac"));
        assertTrue(saida.contains("FLAC"));
    }

    @Test
    void playerAvancadoMensagemExtra() {
        PlayerAvancado player = new PlayerAvancado(new MP3());
        String saida = capturarSaida(() -> player.tocar("teste.mp3"));
        assertTrue(saida.contains("Player avançado iniciando"));
    }

    @Test
    void PausarMusica() {
        PlayerAvancado player = new PlayerAvancado(new MP3());
        String saida = capturarSaida(player::pausar);
        assertTrue(saida.contains("Música pausada"));
    }
}