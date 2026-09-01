package seminarie2;

import jdk.jshell.spi.ExecutionControl;

public class Uppgift3 {
    interface ByteSource {
        boolean hasNext(); // true om det finns fler bytes att hämta

        byte next(); // ger nästa byte
    }

    interface StreamProcessor {
        void handle(byte b); // hanterar en byte (skickar den på något sätt)
    }

    final class Streamer {

        public void run(ByteSource source, StreamProcessor processor) {
            while (source.hasNext()) {
                processor.handle(source.next());
            }
        }
    }

    class LoggingStreamProcessor implements StreamProcessor {
        StreamProcessor sp;

        public LoggingStreamProcessor(StreamProcessor sp) {
            this.sp = sp;
        }

        public void handle(byte b) {
            System.out.println(b);
            sp.handle(b);
        }
    }

    class Check127 implements StreamProcessor {
        StreamProcessor sp;
        int count = 0;

        public Check127(StreamProcessor sp) {
            this.sp = sp;
        }

        public void handle(byte b) {
            if (b == 127) {
                count++;

                if (count == 3) {
                    throw new IllegalSequence();
                }
            } else {
                count = 0;
            }

            sp.handle(b);
        }
    }

    class MainProgram {

        public void start(ByteSource source) {
            var processor = new Check127(new LoggingStreamProcessor(new AcmeStreamProcessor()));

            new newStreamer().run(source, processor);
        }
    }

}
