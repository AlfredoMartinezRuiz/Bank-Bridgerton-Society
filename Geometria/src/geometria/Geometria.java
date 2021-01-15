
package geometria;

public class Geometria {

    public static void main(String[] args) {
        Punto A1 = new Punto("A1",3,2);
        Punto A2 = new Punto("A2",7,4);
        Punto B1 = new Punto("B1",5,3);
        Punto B2 = new Punto("B2",10,7);
        Punto C1 = new Punto("C1",-9,2);
        Punto C2 = new Punto("C2",-3,8);
        Punto D1 = new Punto("D1",-7,4);
        Punto D2 = new Punto("D2",-4,6);
        Punto E1 = new Punto("E1",-7,-5);
        Punto E2 = new Punto("E2",-3,-2);
        Punto F1 = new Punto("F1",-6,-7);
        Punto F2 = new Punto("F2",-4,-3);
        Punto G1 = new Punto("G1",2,-6);
        Punto G2 = new Punto("G2",5,-3);
        Punto H1 = new Punto("H1",4,-8);
        Punto H2 = new Punto("H2",8,-4);
              
        //distancia de puntos
        float d1 = A1.distancia(A2);
        System.out.println("Distancia entre el punto " + A1 + " al punto " + A2 + " = " + d1);
        
        float d2 = E2.distancia();
        System.out.println("Distancia del punto " + E2 + " al origen = " + d2);
        
        //cuadrante donde se encuentra un punto
        int c = F1.cuadrante();
        System.out.println("El punto " + F1 + " se encuentra en el cuadrante " + c);
        
        int c1 = D2.cuadrante();
        System.out.println("El punto " + D2 + " se encuentra en el cuadrante " + c1);
        
        
        Rectangulo R1 = new Rectangulo("R1",A1,A2);
        Rectangulo R2 = new Rectangulo("R2",B1,B2);
        Rectangulo R3 = new Rectangulo("R3",C1,C2);
        Rectangulo R4 = new Rectangulo("R4",D1,D2);
        Rectangulo R5 = new Rectangulo("R5",E1,E2);
        Rectangulo R6 = new Rectangulo("R6",F1,F2);
        Rectangulo R7 = new Rectangulo("R7",G1,G2);
        Rectangulo R8 = new Rectangulo("R8",H1,H2);
        
        //Union de rectangulos
        Rectangulo U1 = R1.union(R2);
        System.out.println("La union de los rectangulos "+R1+" y "+R2+" es "+U1);
        Rectangulo U2 = R3.union(R4);
        System.out.println("La union de los rectangulos "+R3+" y "+R4+" es "+U2);
        Rectangulo U3 = R5.union(R6);
        System.out.println("La union de los rectangulos "+R5+" y "+R6+" es "+U3);
        Rectangulo U4 = R7.union(R8);
        System.out.println("La union de los rectangulos "+R7+" y "+R8+" es "+U4);
        
        //Interseccion de rectangulos
        Rectangulo I1 = R1.interseccion(R2);
        System.out.println("La union de los rectangulos "+R3+" y "+R4+" es "+I1);
        Rectangulo I2 = R3.interseccion(R4);
        System.out.println("La union de los rectangulos "+R3+" y "+R4+" es "+I2);
        Rectangulo I3 = R5.interseccion(R6);
        System.out.println("La union de los rectangulos "+R5+" y "+R6+" es "+I3);
        Rectangulo I4 = R7.interseccion(R8);
        System.out.println("La union de los rectangulos "+R7+" y "+R8+" es "+I4);
        
        //Verifica si un punto esta dentro de un rectangulo
        Punto P1 = new Punto(-5,3);
        if(R3.estaAdentro(P1))
            System.out.println("El punto " + P1 + " está adentro de " + R3);
        else
            System.out.println("El punto " + P1 + " no está adentro de " + R3);
        Punto P2 = new Punto(2,7);
        if(R3.estaAdentro(P2))
            System.out.println("El punto " + P2 + " está adentro de " + R3);
        else
            System.out.println("El punto " + P2 + " no está adentro de " + R3);
    
        //Comparación de áreas de dos rectángulos
        int comp1 = R1.comparar(R2);
        switch (comp1) {
            case -1:
                System.out.println("El rectangulo "+R1+" es menor que el rectangulo "+R2);
                break;
            case 1:
                System.out.println("El rectangulo "+R1+" es mayor que el rectangulo "+R2);
                break;
            default:
                System.out.println("El rectangulo "+R1+" es igual al rectangulo "+R2);
                break;
        }
        
        //Desplazamiento de un rectángulo
        Rectangulo R9 = new Rectangulo("R9");
        Rectangulo R9C = new Rectangulo(R9);
        Punto H = new Punto(20, 30);
        Punto J = new Punto (30, 50);
        R9C.moverRect(H,J);
        System.out.println("El rectangulo "+R9+" se desplazo -> " + R9C);
        
        //Cuadrante donde se encuentra un rectángulo
        int c2 = R1.cuadRect();
        System.out.println("El rectangulo " + R1 + " se encuentra en el cuadrante " + c2);
        int c3 = R3.cuadRect();
        System.out.println("El rectangulo " + R3 + " se encuentra en el cuadrante " + c3);
        int c4 = R5.cuadRect();
        System.out.println("El rectangulo " + R5 + " se encuentra en el cuadrante " + c4);
        int c5 = R7.cuadRect();
        System.out.println("El rectangulo " + R7 + " se encuentra en el cuadrante " + c5);

        Punto V1 = new Punto("V1",5,7);
        Punto V2 = new Punto("V2",2,2);
        Punto V3 = new Punto("V3",8,2);
        Punto V4 = new Punto("V4",9,7);
        Punto V5 = new Punto("V5",6,3);
        Punto V6 = new Punto("V6",12,3);
        Punto V7 = new Punto("V7",-6,8);
        Punto V8 = new Punto("V8",-10,2);
        Punto V9 = new Punto("V9",-2,2);
        Punto V10 = new Punto("V10",-10,8);
        Punto V11 = new Punto("V11",-14,4);
        Punto V12 = new Punto("V12",-6,4);
        Punto V13 = new Punto("V13",-8,-2);
        Punto V14 = new Punto("V14",-12,-8);
        Punto V15 = new Punto("V15",-4,-8);
        Punto V16 = new Punto("V16",-8,-6);
        Punto V17 = new Punto("V17",-14,-16);
        Punto V18 = new Punto("V18",-2,-16);
        Punto V19 = new Punto("V19",10,-2);
        Punto V20 = new Punto("V20",2,-14);
        Punto V21 = new Punto("V21",18,-14);
        Punto V22 = new Punto("V22",10,-2);
        Punto V23 = new Punto("V23",6,-10);
        Punto V24 = new Punto("V24",14,-10);
        
        Triangulo T1 = new Triangulo("T1",V1,V2,V3);
        Triangulo T2 = new Triangulo("T2",V4,V5,V6);
        Triangulo T3 = new Triangulo("T3",V7,V8,V9);
        Triangulo T4 = new Triangulo("T4",V10,V11,V12);
        Triangulo T5 = new Triangulo("T5",V13,V14,V15);
        Triangulo T6 = new Triangulo("T6",V16,V17,V18);
        Triangulo T7 = new Triangulo("T5",V19,V20,V21);
        Triangulo T8 = new Triangulo("T6",V22,V23,V24);
        
        //Verifica si un punto esta dentro de un triangulo
        Punto P3 = new Punto(4,4);
        if(T1.estaAdentro(P3))
            System.out.println("El punto " + P3 + " está adentro de " + T1);
        else
            System.out.println("El punto " + P3 + " no está adentro de " + T1);
        
        //Comparación de áreas de dos triangulos
        int comp2 = T1.comparar(T2);
        switch (comp2) {
            case -1:
                System.out.println("El triangulo "+T1+" es menor que el triangulo "+T2);
                break;
            case 1:
                System.out.println("El triangulo "+T1+" es mayor que el triangulo "+T2);
                break;
            default:
                System.out.println("El triangulo "+T1+" es igual al triangulo "+T2);
                break;
        }
        
        //Comparación de áreas de un triangulo con un rectangulo
        int comp3 = T1.compararRec(R2);
        switch (comp2) {
            case -1:
                System.out.println("El triangulo "+T1+" es menor que el rectangulo "+R2);
                break;
            case 1:
                System.out.println("El triangulo "+T1+" es mayor que el rectangulo "+R2);
                break;
            default:
                System.out.println("El triangulo "+T1+" es igual al rectangulo "+R2);
                break;
        }
        
        //Desplazamiento de un rectángulo
        Triangulo T9 = new Triangulo("T9");
        Triangulo T9C = new Triangulo(T9);
        Punto VN1 = new Punto(22, 8);
        Punto VN2 = new Punto (16, 2);
        Punto VN3 = new Punto (28, 2);
        T9C.moverTri(VN1,VN2,VN3);
        System.out.println("El triangulo "+T9+" se desplazo -> " + T9C);
        
        //Cuadrante donde se encuentra un triangulo
        int c6 = T1.cuadTri();
        System.out.println("El triangulo " + T1 + " se encuentra en el cuadrante " + c6);
        int c7 = T3.cuadTri();
        System.out.println("El triangulo " + T3 + " se encuentra en el cuadrante " + c7);
        int c8 = T5.cuadTri();
        System.out.println("El triangulo " + T5 + " se encuentra en el cuadrante " + c8);
        int c9 = T7.cuadTri();
        System.out.println("El triangulo " + T7 + " se encuentra en el cuadrante " + c9);
    }
    
}
