import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Berkeley {

    static class Server {

        // Método para calcular el tiempo promedio de los clientes
        public static long calculateAverageTime(List<Long> clientTimes) {
            long total = 0;
            for (Long time : clientTimes) {
                total += time;
            }
            return total / clientTimes.size();
        }

        // Método para calcular la diferencia de tiempo entre el tiempo promedio y el tiempo de cada cliente
        public static List<Long> calculateTimeDifferences(List<Long> clientTimes, long averageTime) {
            List<Long> differences = new ArrayList<>();
            for (Long time : clientTimes) {
                differences.add(averageTime - time);
            }
            return differences;
        }
    }

    static class Client implements Runnable {
        private long clientTime;
        private long timeDifference;

        public Client(long clientTime, long timeDifference) {
            this.clientTime = clientTime;
            this.timeDifference = timeDifference;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " time difference: " + timeDifference);
            long adjustedTime = clientTime + timeDifference;
            System.out.println(Thread.currentThread().getName() + " adjusted time: " + adjustedTime);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Simulación de tiempos de los clientes
        List<Long> clientTimes = new ArrayList<>();
        clientTimes.add(5000L); // Cliente 1
        clientTimes.add(5100L); // Cliente 2
        clientTimes.add(4900L); // Cliente 3

        // Calcular el tiempo promedio de los clientes
        long averageTime = Server.calculateAverageTime(clientTimes);
        System.out.println("Average time: " + averageTime);

        // Calcular la diferencia de tiempo para cada cliente
        List<Long> timeDifferences = Server.calculateTimeDifferences(clientTimes, averageTime);

        // Mostrar la diferencia de tiempos y ajustar los tiempos de los clientes
        ExecutorService executorService = Executors.newFixedThreadPool(clientTimes.size());
        for (int i = 0; i < clientTimes.size(); i++) {
            long clientTime = clientTimes.get(i);
            long timeDifference = timeDifferences.get(i);
            System.out.println("Client " + (i + 1) + " time difference: " + timeDifference);
            Runnable clientTask = new Client(clientTime, timeDifference);
            executorService.execute(clientTask);
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}