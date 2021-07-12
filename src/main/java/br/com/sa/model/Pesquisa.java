package br.com.sa.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "pesquisa")
public class Pesquisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autor", length = 100, nullable = false)
    private String author;

    @Column(name = "titulo", length = 100, nullable = false)
    private String title;

    @Column(name = "paragrafos", columnDefinition = "TEXT", nullable = false)
    private String paragraphs;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image", nullable = true)
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(String paragraphs) {
        this.paragraphs = paragraphs;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Pesquisa{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", paragraphs='" + paragraphs + '\'' +
                '}';
    }
}
