interface FormatoAudio {
    void reproduzir(String arquivo);
}

class MP3 implements FormatoAudio {
    @Override
    public void reproduzir(String arquivo) {
        System.out.println("Reproduzindo MP3: " + arquivo);
    }
}

class WAV implements FormatoAudio {
    @Override
    public void reproduzir(String arquivo) {
        System.out.println("Reproduzindo WAV: " + arquivo);
    }
}

class FLAC implements FormatoAudio {
    @Override
    public void reproduzir(String arquivo) {
        System.out.println("Reproduzindo FLAC: " + arquivo);
    }
}

abstract class Player {
    protected FormatoAudio formato;

    public Player(FormatoAudio formato) {
        this.formato = formato;
    }

    public abstract void tocar(String arquivo);
}

class PlayerSimples extends Player {

    public PlayerSimples(FormatoAudio formato) {
        super(formato);
    }

    @Override
    public void tocar(String arquivo) {
        formato.reproduzir(arquivo);
    }
}

class PlayerAvancado extends Player {

    public PlayerAvancado(FormatoAudio formato) {
        super(formato);
    }

    @Override
    public void tocar(String arquivo) {
        System.out.println("Player avançado iniciando...");
        formato.reproduzir(arquivo);
    }

    public void pausar() {
        System.out.println("Música pausada");
    }
}

public class Main {
    public static void main(String[] args) {

        Player player1 = new PlayerSimples(new MP3());
        player1.tocar("musica1.mp3");

        System.out.println();

        PlayerAvancado player2 = new PlayerAvancado(new WAV());
        player2.tocar("musica2.wav");
        player2.pausar();

        System.out.println();

        Player player3 = new PlayerSimples(new FLAC());
        player3.tocar("musica3.flac");
    }
}