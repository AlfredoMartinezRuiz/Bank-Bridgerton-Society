
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
    
        //Comparación de dos rectángulos
        int comp1 = R1.comparar(R2);
        switch (comp1) {
            case -1:
                System.out.println("El rectangulo"+R1+" es menor que el rectangulo "+R2);
                break;
            case 1:
                System.out.println("El rectangulo"+R1+" es mayor que el rectangulo "+R2);
                break;
            default:
                System.out.println("El rectangulo"+R1+" es igual al rectangulo "+R2);
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
      
        Punto V13 = new Punto("V13",-8,-2);
        Punto V14 = new Punto("V14",-12,-8);
        Punto V15 = new Punto("V15",-4,-8);
        Punto V16 = new Punto("V16",-12,-1);
        Punto V17 = new Punto("V17",-16,-6);
        Punto V18 = new Punto("V18",-8,-6);
        Triangulo T5 = new Triangulo("T5",V13,V14,V15);
        Triangulo T6 = new Triangulo("T6",V16,V17,V18);
        System.out.println(T5);
        System.out.println(T6.interseccion(T5));
        

    }
    
}
