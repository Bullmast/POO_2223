package Ficha3;
import java.time.Period;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Video {

    private String nome;
    private int[] conteúdo;
    private LocalDateTime dataCarrega;
    private int[] resolução;
    private Period duração;
    private String[] comments;
    private int likes;
    private int dislikes;

    public String getNome() {
        return nome;
    }

    public int[] getConteúdo() {
        return Arrays.copyOf(conteúdo,conteúdo.length);
    }

    public LocalDateTime getDataCarrega() {
        return this.dataCarrega;
    }

    public int[] getResolução() {
        return Arrays.copyOf(resolução,resolução.length);
    }

    public Period getDuração() {
        return duração;
    }

    public String[] getComments() {
        return Arrays.copyOf(comments,comments.length);
    }
}
