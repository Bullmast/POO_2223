package Ficha3;
import java.time.Period;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Video {

    private String nome;
    private byte[] conteúdo;
    private LocalDateTime dataCarrega;
    private int[] resolução;
    private Period duração;
    private String[] comments;
    private int likes;
    private int dislikes;

    public Video() {

        this.nome = "";
        this.conteúdo = new byte[] {0};
        this.dataCarrega = LocalDateTime.now();
        this.resolução = new int[] {0,0};
        this.duração = Period.ZERO;
        this.comments = new String[] {""};
        this.likes = 0;
        this.dislikes = 0;

    }

    public Video( Video teste ) {

        this.nome = teste.getNome();
        this.conteúdo = teste.getConteúdo();
        this.dataCarrega = teste.getDataCarrega();
        this.resolução = teste.getResolução();
        this.duração = teste.getDuração();
        this.comments = teste.getComments();
        this.likes = teste.getLikes();
        this.dislikes = teste.getDislikes();

    }

    public String getNome() {
        return nome;
    }

    public byte[] getConteúdo() {
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

    public void setConteúdo(byte[] conteúdo) {
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

    public void insereComentario ( String comentario ) {
        String[] tmp = Arrays.copyOf(this.comments,this.comments.length+1);
        tmp[this.comments.length] = comentario;
        this.comments = tmp;
    }

    public long qtsDiasDepois () {
        return this.dataCarrega.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }

    public void thumbsUp () {
        this.setLikes(this.likes+1);
    }

    public String processa() {
        return Arrays.toString(this.conteúdo);
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

    public String toString() {
        StringBuilder sc = new StringBuilder();
        sc.append(" - Video :\n"); sc.append("   + Nome: "+this.nome); sc.append("\n");
        sc.append("   + Conteúdo: "+Arrays.toString(this.conteúdo)); sc.append("\n");
        sc.append("   + Data de Carregamento: "+this.dataCarrega.toString()); sc.append("\n");
        sc.append("   + Duração: "+this.duração); sc.append("\n");
        sc.append("   + Likes: "+this.likes+"  + Dislikes: "+this.dislikes); sc.append("\n");
        sc.append("   + Resolução: "+Arrays.toString(this.resolução)); sc.append("\n");
        sc.append("   + Comentários: "+Arrays.toString(this.comments)); sc.append("\n");
        return sc.toString();
    }

    public Video clone() {
        return new Video(this);
    }
}
