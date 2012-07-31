To run the desktop version:

* clone the project
* run ant on the command line

To run the applet:

* clone the project
* run keytool -genkey -alias javapong, when asked for password, type antjavapong
* run ant sign on the command line
* put the jar file on a web server
* use the following html sample:

    <html>
        <head>
            <title>Pong</title>
        </head>
        <body>
            <applet
                    code="com.github.inside.PongApplet.class"
                    archive="java-pong.jar"
                    width="700" height="450">
                Your browser is completely ignoring the applet tag!
            </applet>
        </body>
    </html>
