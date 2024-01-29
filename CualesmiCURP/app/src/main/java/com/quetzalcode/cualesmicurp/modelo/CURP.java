package com.quetzalcode.cualesmicurp.modelo;

public class CURP {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer diaDeNacimiento;
    private Integer mesDeNacimiento;
    private Integer añoDeNacimiento;
    private String sexo;
    private String estado;
    private String curp;

    public CURP() {
    }
    public CURP(String nombre, String primerApellido, String segundoApellido, Integer diaDeNacimiento, Integer mesDeNacimiento, Integer añoDeNacimiento, String sexo, String estado) {
        this.setNombre(nombre);
        this.setPrimerApellido(primerApellido);
        this.setSegundoApellido(segundoApellido);
        this.setDiaDeNacimiento(diaDeNacimiento);
        this.setMesDeNacimiento(mesDeNacimiento);
        this.setAñoDeNacimiento(añoDeNacimiento);
        this.setSexo(sexo);
        this.setEstado(estado);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getDiaDeNacimiento() {
        return diaDeNacimiento;
    }

    public void setDiaDeNacimiento(Integer diaDeNacimiento) {
        this.diaDeNacimiento = diaDeNacimiento;
    }

    public Integer getMesDeNacimiento() {
        return mesDeNacimiento;
    }

    public void setMesDeNacimiento(Integer mesDeNacimiento) {
        this.mesDeNacimiento = mesDeNacimiento;
    }

    public Integer getAñoDeNacimiento() {
        return añoDeNacimiento;
    }

    public void setAñoDeNacimiento(Integer añoDeNacimiento) {
        this.añoDeNacimiento = añoDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
