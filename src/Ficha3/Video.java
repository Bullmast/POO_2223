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

    public Video() {

        this.nome = "";
        this.conteúdo = new int[] {0};
        this.dataCarrega = LocalDateTime.now();
        this.resolução = new int[] {0,0};
        this.duração = Period.ZERO;
        this.comments = new String[] {""};
        this.likes = 0;
        this.dislikes = 0;

    }

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

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteúdo(int[] conteúdo) {
        this.conteúdo = Arrays.copyOf(conteúdo,conteúdo.length);
    }

    public void setComments(String[] comments) {
        this.comments = Arrays.copyOf(comments, comments.length);
    }

    public void setDataCarrega(LocalDateTime dataCarrega) {
        this.dataCarrega = dataCarrega;
    }

    public void setResolução(int[] resolução) {
        this.resolução = Arrays.copyOf(resolução, resolução.length);
    }

    public void setDuração(Period duração) {
        this.duração = duração;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass() != o.getClass() ) )
            return false ;
        Video p = ( Video ) o ;
        return ( p.getNome().compareTo(this.nome)==0 && Arrays.equals(this.conteúdo,p.getConteúdo())
                && this.likes == p.getLikes() && this.dislikes == p.getDislikes()
                && this.duração.equals(p.getDuração()) && this.dataCarrega.isEqual(p.getDataCarrega())
                && Arrays.equals(this.resolução,p.getResolução())
                && Arrays.equals(this.comments,p.getComments())
        );
    }
}
