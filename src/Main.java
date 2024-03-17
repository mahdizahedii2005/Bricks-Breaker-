import Appliction.Application;

public class Main {
    public static void main(String[] args) {
        new Application().run();
//        try {
//            InputStream in = new FileInputStream(new File("Pic\\song\\warning.wav"));
//            AudioStream as = new AudioStream(in);
//            AudioPlayer.player.start(as);
//            try {
//                // توقف برنامه به مدت 3 ثانیه (3000 میلی‌ثانیه)
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // مدیریت خطایی که ممکن است در صورت وقوع ایجاد شود
//                e.printStackTrace();
//            }
//            AudioPlayer.player.stop(in);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
