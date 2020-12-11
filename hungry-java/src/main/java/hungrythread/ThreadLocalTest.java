package hungrythread;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.ws.util.CompletedFuture;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

class AskThread implements Runnable {
    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re) {
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();

        } catch (Exception e) {
            System.out.println(myRe);
        }
    }

}


public class ThreadLocalTest {
    static  Integer clac (Integer para){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return para / 0;

    }
    public static void main(String[] args) {

//        final CompletableFuture<Integer> future = new CompletableFuture<>();
//        new Thread(new AskThread(future)).start();
//        Thread.sleep(1000);
//        System.out.println(future.complete(60)
//        );
//        final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> clac(40));
//        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> clac(10)).exceptionally(ex-> {System.out.print(ex);return 0;}).thenApply( i -> Integer.toString(i)).thenAccept(System.out::print);
//        System.out.println(fu.get());
//        System.out.println("finish");
//        ServerSocketChannel serverSocketChannel =  ServerSocketChannel.open();
//        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
//        serverSocketChannel.bind(address);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        List<AskThread> list = new ArrayList<>();
//        final CompletableFuture<Integer> future = new CompletableFuture<>();
//        while (true) {
////            SocketChannel socketChannel = serverSocketChannel.accept();
////            while (socketChannel.read(byteBuffer) != -1) {
////                System.out.println(byteBuffer.array());
////                byteBuffer.clear();
////            }
//            list.add(new AskThread(future));
//        }
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e-> e.getClass().getName())
                .forEach(System.out::println);

    }
}




