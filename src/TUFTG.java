import java.util.Date;

public class TUFTG {
    public static int delay = 1000;

    public static void main(String[] args) {
    Thread violin = new Thread(new Violin(StringStore.playingUpperCase));
    violin.start();
    }

    public static void sleepNSeconds(int n) {
        try{
            Thread.sleep(n*delay);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPLaying();
        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument{
        public void run(){
            Date start = startPLaying();
            sleepNSeconds(1);
            Date stop = stopPlaying();

            System.out.println(StringStore.playingUpperCase + (stop.getTime() - start.getTime()) + StringStore.ms);
        }

        private final String owner;

        public Violin(String owner) {this.owner = owner;}

        public Date startPlaying(){
            System.out.println(this.owner + StringStore.is + StringStore.starting + StringStore.to + StringStore.play);
            return  new Date();
        }

        public Date stopPLaying(){
            System.out.println(this.owner + StringStore.is + StringStore.stoping + StringStore.getPlayingLowerCase);
            return new Date();
        }

        @Override
        public Date startPLaying() {
            return null;
        }

        @Override
        public Date stopPlaying() {
            return null;
        }
    }
}
