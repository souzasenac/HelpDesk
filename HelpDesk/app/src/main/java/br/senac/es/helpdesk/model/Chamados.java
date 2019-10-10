package br.senac.es.helpdesk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Chamados {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("dataAbertura")
    @Expose
    private Date dataAbertura;
    private String status;
    private String solucao;
    @SerializedName("descricao")
    @Expose
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getDecricao() {
        return descricao;
    }

    public void setDecricao(String decricao) {
        this.descricao = decricao;
    }


    @Override
    public String toString() {
        return " status = " + status + '\n' +
                " solucao = " + solucao + '\n' +
                "decricao = " + descricao + '\n' +
                        "dataAbertura=" + dataAbertura;
    }

    public Chamados (int id , Date dataAbetura , String status , String solucao , String decricao ){
        this.id= id;
        this.dataAbertura=dataAbetura;
        this.status=status;
        this.solucao=solucao;
        this.descricao=decricao;
    }
    public Chamados(){

    }
}
