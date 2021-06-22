import java.io.File;

public class SizeCalculation {
    public synchronized static long calculateFileSize(File path) {
        int size = 0;
        File[] f = path.listFiles();
        if (path != null && path.listFiles() != null) {
            for (int i = 0; i < f.length; i++) {
                if (f[i].isFile())
                    size += f[i].length();
                else
                    size += calculateFolderSize(f[i]);
                System.out.println(size / 1024 + " KB");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return size;
    }

    public static long calculateFolderSize(File dir) {
        long size = 0;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                size += file.length();
            else
                size += calculateFolderSize(file);
        }
        return size;
    }
}