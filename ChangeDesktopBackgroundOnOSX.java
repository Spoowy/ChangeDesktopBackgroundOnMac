import javax.swing.*;
import java.io.File;

/**
 * Changes desktop background on OS X
 *
 */
public class ChangeDesktopBackgroundOnOSX {

    public ChangeDesktopBackgroundOnOSX(final String filename) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                File file = null;
                try
                {
                    file = new File(filename);

                    String as[] = {
                            "osascript",
                            "-e", "tell application \"Finder\"",
                            "-e", "set desktop picture to POSIX file \"" + file.getAbsolutePath() + "\"",
                            "-e", "end tell"
                    };
                    Runtime runtime = Runtime.getRuntime();
                    Process process;
                    process = runtime.exec(as);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        });
    }
}
