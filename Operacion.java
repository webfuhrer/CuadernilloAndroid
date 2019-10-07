package com.example.cuadernillo2;

public class Operacion {
    private int operando1, operando2, resultado;
    private char simbolo;

    public Operacion(int operando1, int operando2, int resultado, char simbolo) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
        this.simbolo = simbolo;
    }
    public static Operacion pedirOperacion(int codigo_operacion)
    {
        int op1=(int)(Math.random()*10);
        int op2=(int)(Math.random()*10);
        int resultado=0;
        char simbolo=0;
        switch(codigo_operacion)
        {
            case 1:
                resultado=op1+op2;
                simbolo='+';
                break;
            case 2:
                int aux=op1;
                resultado=op1-op2;
                if(resultado<0){
                    aux=op2;
                    op2=op1;
                    op1=aux;
                }

                simbolo='-';
                break;
            case 3:
                resultado=op1*op2;
                simbolo='x';
                break;
        }
    Operacion op=new Operacion(op1, op2, resultado, simbolo);
    return  op;
    }
    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
