import java.util.concurrent.*;

public class Cristian {
    // Clase estática que simula un servidor que proporciona su tiempo actual
    static class Server implements Runnable {
        @Override
        public void run() {
            int iterations = 5; // Número máximo de iteraciones del servidor
            for (int i = 0; i < iterations; i++) {
                try {
                    Thread.sleep(2000); // Simula el procesamiento del servidor
                    long serverTime = System.currentTimeMillis();
                    System.out.println("Server time: " + serverTime); // Imprime el tiempo actual del servidor
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Clase estática que simula un cliente que solicita el tiempo al servidor y ajusta su reloj
    static class Client implements Runnable {
        private long serverTime; // Tiempo del servidor recibido por el cliente

        // Constructor que recibe el tiempo del servidor
        public Client(long serverTime) {
            this.serverTime = serverTime;
        }

        @Override
        public void run() {
            int iterations = 3; // Número máximo de iteraciones del cliente
            for (int i = 0; i < iterations; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 3000)); // Simula el tiempo de viaje de la solicitud
                    long clientSendTime = System.currentTimeMillis(); // Tiempo de envío de la solicitud por parte del cliente
                    long rtt = clientSendTime - serverTime; // Calcula el tiempo de ida y vuelta
                    long adjustedTime = serverTime + (rtt / 2); // Ajusta el tiempo del cliente en función del tiempo del servidor y el tiempo de ida y vuelta
                    System.out.println("Adjusted time: " + adjustedTime); // Imprime el tiempo ajustado del cliente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crea un hilo para el servidor
        Thread serverThread = new Thread(new Server());
        serverThread.start();

        // Crea un grupo de hilos para los clientes
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            long serverTime = System.currentTimeMillis(); // Obtiene el tiempo actual del servidor
            Runnable clientTask = new Client(serverTime); // Crea una instancia de cliente con el tiempo del servidor
            executorService.execute(clientTask); // Ejecuta el cliente en un hilo del grupo
        }
        executorService.shutdown(); // Finaliza la ejecución del grupo de hilos
    }
}