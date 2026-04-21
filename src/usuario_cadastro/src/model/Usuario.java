package model;

import java.util.Date;

public class Usuario {

    private int idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private String cidadeUF;
    private String senha;
    private Date dataCriacao;
    private boolean ativo;

    public Usuario() {}

    public Usuario(int idUsuario, String nome, String email, String telefone,
                   Date dataNascimento, String cidadeUF, String senha,
                   Date dataCriacao, boolean ativo) {

        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cidadeUF = cidadeUF;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Date getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getCidadeUF() { return cidadeUF; }
    public void setCidadeUF(String cidadeUF) { this.cidadeUF = cidadeUF; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        return idUsuario + " - " + nome + " - " + email + " - " + cidadeUF;
    }
}