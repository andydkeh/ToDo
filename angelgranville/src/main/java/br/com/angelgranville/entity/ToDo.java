package br.com.angelgranville.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private boolean realizado;
    @Min(0)
    @Max(10)
    private int prioridade;

    public ToDo(String nome, String descricao, boolean realizado, int prioridade){
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Boolean getRealizado(){
        return realizado;
    }

    public void setRealizado(Boolean realizado){
        this.realizado = realizado;
    }

    public int getPrioridade(){
        return prioridade;
    }

    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }

}
