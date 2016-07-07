package com.datatub.lhfcws.maven.execshell;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.*;

/**
 * @author lhfcws
 * @since 16/7/7
 */
@Mojo( name = "execsh", threadSafe = true, requiresDependencyResolution = ResolutionScope.TEST )
public class ExecMojo extends AbstractMojo {

    @Parameter( property = "execsh.exec" )
    private String exec;

    @Parameter( property = "execsh.workingdir" )
    private File workingDirectory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if (exec != null) {
            ProcessBuilder builder = new ProcessBuilder();
            if (workingDirectory != null)
                builder.directory(workingDirectory);
            builder.command("sh", "-c", exec);
            try {
                System.out.println("[EXEC] Running shell: " + exec);
                final Process process = builder.start();
                int flag = process.waitFor();
                System.out.println("[EXEC] Process exit: " + flag);

                InputStream in = process.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                String line;
                while ((line = dis.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                throw new MojoExecutionException(e.getMessage());
            }
        }
    }
}
