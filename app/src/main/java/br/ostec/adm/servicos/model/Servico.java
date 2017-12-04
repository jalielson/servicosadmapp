package br.ostec.adm.servicos.model;



import java.io.Serializable;

public class Servico implements Serializable {

    private Integer id;
    private String cliente;
    private String endereco;
    private String fone;
    private String dispositivo;
    private String obsdisp;
    private String servico;
    private String valor;

    public Servico() {

    }

    public Servico(Integer id, String cliente, String endereco, String fone, String dispositivo, String obsdisp, String servico, String valor) {
        this.id = id;
        this.cliente = cliente;
        this.endereco = endereco;
        this.fone = fone;
        this.dispositivo = dispositivo;
        this.obsdisp = obsdisp;
        this.servico = servico;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getFone() {
        return fone;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getObsdisp() {
        return obsdisp;
    }

    public String getServico() {
        return servico;
    }

    public String getValor() {
        return valor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setObsdisp(String obsdisp) {
        this.obsdisp = obsdisp;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        return id.equals(servico.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Servico{" +
                "cliente='" + cliente + '\'' +
                '}';
    }
}

