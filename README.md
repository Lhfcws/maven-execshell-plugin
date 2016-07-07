
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
                            <exec>sh ${project.basedir}/deploy.sh</exec>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
