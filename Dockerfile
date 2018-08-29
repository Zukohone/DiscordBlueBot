FROM openjdk:8-jdk

RUN apt-get -y update && \
    apt-get -y upgrade && \
    apt-get -y install openjfx &&\
    apt-get -y install ffmpeg

COPY openjfx-monocle-1.8.0_20.jar ${JAVA_HOME}/jre/lib/ext
COPY DiscordBlueBot /DiscordBlueBot

RUN cd DiscordBlueBot && sed -i -- "s/YOURTOKENHERE/YOURTOKENHERE/g" config.blue && sed -i -- "s/YOURIDHERE/YOURIDHERE/g" config.blue && chmod -R 777 /DiscordBlueBot

WORKDIR /DiscordBlueBot

CMD ["java","-jar","-Xmx512m","-Dtestfx.robot=glass","-Dglass.platform=Monocle","-Dmonocle.platform=Headless","-Dprism.order=sw","BlueBot.jar","cmd"]
#java -jar -Xmx512m -Dtestfx.robot=glass -Dglass.platform=Monocle -Dmonocle.platform=Headless -Dprism.order=sw BlueBot.jar cmd