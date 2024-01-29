/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cualesmicurp.modelo;

import java.time.Year;

/**
 *
 * @author alejandro
 */
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

    public CURP(String nombre, String primerApellido, String segundoApellido, Integer diaDeNacimiento, Integer mesDeNacimiento, Integer añoDeNacimiento, String sexo, String estado) {
        this.nombre = formatear(nombre);
        this.primerApellido = formatear(primerApellido);
        this.segundoApellido = formatear(segundoApellido);
        this.diaDeNacimiento = diaDeNacimiento;
        this.mesDeNacimiento = mesDeNacimiento;
        this.añoDeNacimiento = añoDeNacimiento;
        this.sexo = formatear(sexo);
        this.estado = formatear(estado);
    }

    private String formatear(String string) {
        string = string.toUpperCase();
        string = string.replace("Á", "A");
        string = string.replace("É", "E");
        string = string.replace("Í", "I");
        string = string.replace("Ó", "O");
        string = string.replace("Ú", "U");
        string = string.replace("Ñ", "N");
        return string;
    }

    public void generar() {
        if (nombre == ""
                || primerApellido == ""
                || segundoApellido == ""
                || (diaDeNacimiento < 1 || diaDeNacimiento > 31)
                || (mesDeNacimiento < 1 || mesDeNacimiento > 12)
                || (añoDeNacimiento < 1900 || añoDeNacimiento > Year.now().getValue())
                || sexo == ""
                || estado == "") {
            this.curp = "";
        } else {
            String resultado = "";

            resultado += primerApellido.substring(0, 1);
            for (int i = 1; i < primerApellido.length(); i++) {
                if (primerApellido.charAt(i) == 'A'
                        || primerApellido.charAt(i) == 'E'
                        || primerApellido.charAt(i) == 'I'
                        || primerApellido.charAt(i) == 'O'
                        || primerApellido.charAt(i) == 'U') {
                    resultado += primerApellido.charAt(i);
                    break;
                }
            }

            resultado += segundoApellido.substring(0, 1);

            if (nombre.contains("JOSE")) {
                resultado += nombre.substring(5, 6);
            } else if (nombre.contains("MARIA")) {
                resultado += nombre.substring(6, 7);
            } else {
                resultado += nombre.substring(0, 1);
            }

            if (resultado.equals("BUEI") || resultado.equals("BUEY") || resultado.equals("CACA") || resultado.equals("CACO")
                    || resultado.equals("CAGA")
                    || resultado.equals("CAGO") || resultado.equals("CAKA") || resultado.equals("CAKO") || resultado.equals("COGE")
                    || resultado.equals("COJA")
                    || resultado.equals("COJE") || resultado.equals("COJI") || resultado.equals("COJO") || resultado.equals("CULO")
                    || resultado.equals("FETO")
                    || resultado.equals("GUEY") || resultado.equals("JOTO") || resultado.equals("KACA") || resultado.equals("KACO")
                    || resultado.equals("KAGA")
                    || resultado.equals("KAGO") || resultado.equals("KOGE") || resultado.equals("KOJO") || resultado.equals("KAKA")
                    || resultado.equals("KULO")
                    || resultado.equals("MAME") || resultado.equals("MAMO") || resultado.equals("MEAR") || resultado.equals("MEAS")
                    || resultado.equals("MEON")
                    || resultado.equals("MION") || resultado.equals("MOCO") || resultado.equals("MULA") || resultado.equals("PEDA")
                    || resultado.equals("PEDO")
                    || resultado.equals("PENE") || resultado.equals("PUTA") || resultado.equals("PUTO") || resultado.equals("QULO")
                    || resultado.equals("RATA")
                    || resultado.equals("RUIN")) {
                resultado = resultado.substring(0, 3) + "X";
            }

            resultado += añoDeNacimiento.toString().substring(2, 4);

            if (mesDeNacimiento >= 10 && mesDeNacimiento <= 12) {
                resultado += mesDeNacimiento.toString();
            } else if (mesDeNacimiento >= 1) {
                resultado += "0" + mesDeNacimiento;
            } else {
                resultado += "00";
            }

            if (diaDeNacimiento >= 10 && diaDeNacimiento <= 31) {
                resultado += diaDeNacimiento.toString();
            } else if (diaDeNacimiento >= 1) {
                resultado += "0" + mesDeNacimiento;
            } else {
                resultado += "00";
            }

            switch (sexo.substring(0)) {
                case "M":
                    resultado += "H";
                    break;
                case "F":
                    resultado += "M";
                    break;
                default:
                    resultado += sexo.substring(0,1);
                    break;
            }

            switch (estado) {
                case "AGUASCALIENTES":
                    resultado += "AS";
                    break;
                case "BAJA CALIFORNIA":
                    resultado += "BC";
                    break;
                case "BAJA CALIFORNIA SUR":
                    resultado += "BS";
                    break;
                case "CAMPECHE":
                    resultado += "CC";
                    break;
                case "COAHUILA DE ZARAGOZA":
                    resultado += "CL";
                    break;
                case "COLIMA":
                    resultado += "CM";
                    break;
                case "CHIAPAS":
                    resultado += "CS";
                    break;
                case "CHIHUAHUA":
                    resultado += "CH";
                    break;
                case "DISTRITO FEDERAL":
                    resultado += "DF";
                    break;
                case "DURANGO":
                    resultado += "DG";
                    break;
                case "GUANAJUATO":
                    resultado += "GT";
                    break;
                case "GUERRERO":
                    resultado += "GR";
                    break;
                case "HIDALGO":
                    resultado += "HG";
                    break;
                case "JALISCO":
                    resultado += "JC";
                    break;
                case "MEXICO":
                    resultado += "MC";
                    break;
                case "MICHOACÁN DE OCAMPO":
                    resultado += "MN";
                    break;
                case "MORELOS":
                    resultado += "MS";
                    break;
                case "NAYARIT":
                    resultado += "NT";
                    break;
                case "NUEVO LEON":
                    resultado += "NL";
                    break;
                case "OAXACA":
                    resultado += "OC";
                    break;
                case "PUEBLA":
                    resultado += "PL";
                    break;
                case "QUERETARO":
                    resultado += "QT";
                    break;
                case "QUINTANA ROO":
                    resultado += "QR";
                    break;
                case "SAN LUIS POTOSI":
                    resultado += "SP";
                    break;
                case "SINALOA":
                    resultado += "SL";
                    break;
                case "SONORA":
                    resultado += "SR";
                    break;
                case "TABASCO":
                    resultado += "TC";
                    break;
                case "TAMAULIPAS":
                    resultado += "TS";
                    break;
                case "TLAXCALA":
                    resultado += "TL";
                    break;
                case "VERACRUZ":
                    resultado += "VZ";
                    break;
                case "YUCATAN":
                    resultado += "YN";
                    break;
                case "ZACATECAS":
                    resultado += "ZS";
                    break;
                case "EXTRANJERO":
                    resultado += "NE";
                    break;
                default:
                    if(estado.length() < 3) resultado += estado;
                    break;
            }

            for (int i = 1; i < nombre.length(); i++) {
                if (nombre.charAt(i) != 'A'
                        && nombre.charAt(i) != 'E'
                        && nombre.charAt(i) != 'I'
                        && nombre.charAt(i) != 'O'
                        && nombre.charAt(i) != 'U') {
                    resultado += nombre.charAt(i);
                    break;
                }
            }

            for (int i = 1; i < segundoApellido.length(); i++) {
                if (segundoApellido.charAt(i) != 'A'
                        && segundoApellido.charAt(i) != 'E'
                        && segundoApellido.charAt(i) != 'I'
                        && segundoApellido.charAt(i) != 'O'
                        && segundoApellido.charAt(i) != 'U') {
                    resultado += segundoApellido.charAt(i);
                    break;
                }
            }

            for (int i = 1; i < primerApellido.length(); i++) {
                if (primerApellido.charAt(i) != 'A'
                        && primerApellido.charAt(i) != 'E'
                        && primerApellido.charAt(i) != 'I'
                        && primerApellido.charAt(i) != 'O'
                        && primerApellido.charAt(i) != 'U') {
                    resultado += primerApellido.charAt(i);
                    break;
                }
            }

            if (añoDeNacimiento < 2000) {
                resultado += Math.round(Math.random() * 9);
                resultado += Math.round(Math.random() * 9); // GENERAMOS DOS NÚMERO ALEATORIOS ENTRE EL 1 Y EL 9
            } else {
                char letra = (char) ((Math.random() * 26) + 'A'); // GENERAMOS UN NÚMERO ALEATORIO SEGÚN EL ABECEDARIO
                resultado += letra; // Y LE SUMAMOS 'A' MAYÚSCULA PARA GENERAR UNA LETRA ALEATORIA DEL ABECEDARIO
                resultado += Math.round(Math.random() * 9);
            }

            this.curp = resultado;
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CURP{");
        sb.append("nombre:").append(nombre);
        sb.append(", primerApellido:").append(primerApellido);
        sb.append(", segundoApellido:").append(segundoApellido);
        sb.append(", diaDeNacimiento:").append(diaDeNacimiento);
        sb.append(", mesDeNacimiento:").append(mesDeNacimiento);
        sb.append(", a\u00f1oDeNacimiento:").append(añoDeNacimiento);
        sb.append(", sexo:").append(sexo);
        sb.append(", estado:").append(estado);
        sb.append(", curp:").append(curp);
        sb.append('}');
        return sb.toString();
    }

    

}
