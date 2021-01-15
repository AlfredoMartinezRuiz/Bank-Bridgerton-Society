
package geometria;

public class Geometria {

    public static void main(String[] args) {
       
        Punto A1 = new Punto("A1",3,2);
        Punto A2 = new Punto("A2",7,4);
        Punto B1 = new Punto("B1",5,3);
        Punto B2 = new Punto("B2",10,7);
        Punto C1 = new Punto("C1",3,2);
        Punto C2 = new Punto("C2",7,4);
        Punto D1 = new Punto("D1",5,3);
        Punto D2 = new Punto("D2",10,7);
        Punto E1 = new Punto("E1",3,2);
        Punto E2 = new Punto("E2",7,4);
        Punto F1 = new Punto("F1",5,3);
        Punto F2 = new Punto("F2",10,7);
        Punto G1 = new Punto("G1",3,2);
        Punto G2 = new Punto("G2",7,4);
        Punto H1 = new Punto("H1",5,3);
        Punto H2 = new Punto("H2",10,7);
        
        Punto P = new Punto(4,3);
        Punto origen = new Punto("Origen");
        
        //Métodos de la clase Punto
        float d1 = A1.distancia(A2);
        System.out.println("Distancia entre el punto " + A1 + " al punto " + A2 + " = " + d1);
        
        float d2 = E2.distancia();
        System.out.println("Distancia del punto " + E2 + " al origen = " + d2);
        
        int c = G1.cuadrante();
        System.out.println("El punto " + D2 + " se encuentra en el caudrante " + c);
        
        Rectangulo R1 = new Rectangulo("R1",A1,A2);
        Rectangulo R2 = new Rectangulo("R2",B1,B2);
        Rectangulo R3 = new Rectangulo("R3",C1,C2);
        Rectangulo R4 = new Rectangulo("R4",D1,D2);
        Rectangulo R5 = new Rectangulo("R5",E1,E2);
        Rectangulo R6 = new Rectangulo("R6",F1,F2);
        Rectangulo R7 = new Rectangulo("R7",G1,G2);
        Rectangulo R8 = new Rectangulo("R8",H1,H2);
        
        
    }
    
}
