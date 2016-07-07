
## What's this?

The `maven-execshell-plugin` is a maven plugin that can help you executing shell commands while in maven lifecycle.
It's different from the popular one `exec-maven-plugin`. `exec-maven-plugin` supports running script file (linux and windows) instead of running commands. This may lead to some permission problem with the executable file. 

It's simple but useful.

## Usage:
            <plugin>
                <artifactId>maven-execshell-plugin</artifactId>
                <groupId>com.datatub.lhfcws</groupId>
                <version>LATEST</version>
                <executions>
                    <execution>
                        <id>deploy</id>
                        <phase>package</phase>
                        <goals>
                            <goal>execsh</goal>
                        </goals>
                        <configuration>
                            <exec>${your command here}</exec>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

If you want to execute a list of commands, then you may write them into a `x.sh` file and fill in exec xml with `sh x.sh`.
