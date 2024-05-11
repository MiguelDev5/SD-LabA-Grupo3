import java.util.ArrayList;
import java.util.List;

public class LamportClock {
    private int clock; // Tiempo del reloj de Lamport

    // Constructor: inicializa el reloj en 0
    public LamportClock() {
        this.clock = 0;
    }

    // Método para incrementar el tiempo del reloj en 1 y devolver el nuevo valor
    public synchronized int tick() {
        this.clock++;
        return this.clock;
    }

    // Método para actualizar el tiempo del reloj
    public synchronized void update(int receivedTime) {
        // Actualiza el tiempo del reloj tomando el máximo entre su tiempo actual y el tiempo recibido más 1
        this.clock = Math.max(this.clock, receivedTime) + 1;
    }

    // Método para obtener el tiempo actual del reloj
    public int getTime() {
        return this.clock;
    }

    // Método principal
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(); // Lista de hilos

        LamportClock clock = new LamportClock(); // Instancia del reloj de Lamport

        // Bucle para crear y comenzar 5 hilos
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int time = clock.tick(); // Crea un evento y obtiene su tiempo de Lamport

                    // Muestra el identificador del hilo y el tiempo de Lamport del evento creado
                    System.out.println("Thread " + Thread.currentThread().getId() + " created event with Lamport time " + time);

                    try {
                        // Simula la ejecución de alguna tarea esperando 1 segundo
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int receivedTime = clock.tick(); // Recibe el evento y obtiene su tiempo de Lamport
                    // Muestra el identificador del hilo y el tiempo de Lamport del evento recibido
                    System.out.println("Thread " + Thread.currentThread().getId() + " received event with Lamport time " + receivedTime);

                    // Actualiza el tiempo del reloj con el tiempo recibido
                    clock.update(receivedTime);
                }
            });

            threads.add(thread); // Agrega el hilo a la lista
            thread.start(); // Comienza la ejecución del hilo
        }

        // Espera a que todos los hilos terminen su ejecución
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprime el tiempo final del reloj de Lamport
        System.out.println("Final Lamport time: " + clock.getTime());
    }
}