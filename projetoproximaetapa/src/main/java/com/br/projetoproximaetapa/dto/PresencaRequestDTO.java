package com.br.projetoproximaetapa.dto;
import lombok.Data;

@Data
public class PresencaRequestDTO {
    private String qrCode;      // Opcional (preenchido se for leitura por câmera/QR)
    private String cpfAluno;    // Usado caso o QR Code venha vazio
    private String idEncontro;  // Usado caso o QR Code venha vazio
    private String cpfProfessor;

    // Getters e Setters
    public String getQrCode() { return qrCode; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }
    public String getCpfAluno() { return cpfAluno; }
    public void setCpfAluno(String cpfAluno) { this.cpfAluno = cpfAluno; }
    public String getIdEncontro() { return idEncontro; }
    public void setIdEncontro(String idEncontro) { this.idEncontro = idEncontro; }
    public String getCpfProfessor() { return cpfProfessor; }
    public void setCpfProfessor(String cpfProfessor) { this.cpfProfessor = cpfProfessor; }
}
